
resetFunction();

function resetFunction(){
	$('.commentActive').off().on('click',function (){});

	$('.commentActive').click(function(){

		let d = $(this).parent().siblings('.commentInput').css('display');

		if(d=='grid'){
			$('.commentInput').removeClass('on')
		}
		else{
			$('.commentInput').removeClass('on')
			$(this).parent().next().addClass('on')
		}
		return false
	})

	$('.subCommentAreaActive').off().on('click',function (){});

	$('.subCommentAreaActive').click(function(){

		let d = $(this).parent().parent().next().css('display');

		if(d=="block"){
			$(this).parent().parent().next().removeClass('on')
			$(this).text(' 답글보기')
		}else{
			$(this).parent().parent().next().addClass('on')
			$(this).text(' 답글접기')
		}
	})
	$('#commentSubmit').off().on('click',function(){});
	$('#commentSubmit').click(function(){
		let formData = $('#commentFrm').serialize() // serialize 사용
		$.ajax({
			url: "comment",
			type: "POST",
			cache: false,
			data: formData, // data에 바로 serialze한 데이터를 넣는다.
			success: function(data){
				$('#commentContent').val('');
				console.log(data);

				commentInsert(data);
			},
			error: function (){
				alert("댓글 전송에 실패했습니다.")
			}
		})
	})
	$('.subcommentSubmit').off().on('click',function(){});
	$('.subcommentSubmit').click(function(){
		let formData = $(this).parent().serialize(); // serialize 사용
		let contentArea = $(this).siblings('.subcommentContent');
		$.ajax({
			url: "subcomment",
			type: "POST",
			cache: false,
			data: formData, // data에 바로 serialze한 데이터를 넣는다.
			success: function(data){
				console.log(data);
				contentArea.val('');
				subcommentInsert(data);
			},
			error: function (){
				alert("댓글 전송에 실패했습니다.")
			}
		})
	})
}

function commentInsert(data) {
	let commentBox = document.createElement('div');
	commentBox.setAttribute('class','commentBox');

	let commentatorInfo = document.createElement('div')
	commentBox.appendChild(commentatorInfo);
	commentatorInfo.setAttribute('class','commentatorInfo')

	let commentatorId = document.createElement('p');
	commentatorId.innerText= data.writer+" ";

	let commentDate = document.createElement('span');
	commentDate.innerText = data.postdate;
	commentatorId.appendChild(commentDate);
	commentatorInfo.appendChild(commentatorId);

	let commentcontent = document.createElement('div');
	commentcontent.setAttribute('class','commentcontent');
	commentcontent.innerText = data.content;

	commentBox.appendChild(commentcontent);

	let commentExtra = document.createElement('div');
	commentExtra.setAttribute('class','commentExtra');

	let extraInfo = document.createElement('div');

	let recommend = document.createElement('span');

	let recommendBtn = document.createElement('a');
	recommendBtn.innerText = '추천하기 ';

	recommend.appendChild(recommendBtn);

	let recommendCount = document.createElement('span');
	recommendCount.innerText = data.recommended;

	let commentActive = document.createElement('a');
	commentActive.setAttribute('class','commentActive');
	commentActive.innerText = ' reply';

	let subCommentAreaActive = document.createElement('a');
	subCommentAreaActive.setAttribute('class','subCommentAreaActive');
	subCommentAreaActive.innerText = ' 답글보기';
	extraInfo.appendChild(recommend);
	extraInfo.appendChild(recommendCount);
	extraInfo.appendChild(commentActive);
	extraInfo.appendChild(subCommentAreaActive);
	commentExtra.appendChild(extraInfo);

	let commentInput = document.createElement('div');
	commentInput.setAttribute('class','commentInput');

	let profile_pic = document.createElement('div');
	profile_pic.setAttribute('class','profile_pic');

	let profile_img = document.createElement('img');
	//if문으로 프로파일 이미지가 있는지 없는지 나중에 검사
	profile_img.setAttribute('src', 'resources/image/view/default.png');
	profile_pic.appendChild(profile_img);
	commentInput.appendChild(profile_pic);

	let input_section = document.createElement('div');
	input_section.setAttribute('class','input_section');

	let subcommentFrm = document.createElement('form');
	subcommentFrm.setAttribute('id','subcommentFrm');

	let boardidx = document.createElement('input');
	boardidx.setAttribute('type','hidden');
	boardidx.setAttribute('name','boardidx');
	boardidx.setAttribute('value',data.boardidx);

	let commentidx = document.createElement('input');
	commentidx.setAttribute('type','hidden');
	commentidx.setAttribute('name','commentidx');
	commentidx.setAttribute('value',data.idx);

	let writer = document.createElement('input');
	writer.setAttribute('type','hidden');
	writer.setAttribute('name','writer');
	writer.setAttribute('value',data.writer);

	let content = document.createElement('textarea');
	content.setAttribute('name','content');
	content.setAttribute('class','subcommentContent');

	let subcommentSubmit = document.createElement('button');
	subcommentSubmit.setAttribute('class','subcommentSubmit');
	subcommentSubmit.setAttribute('type','button');
	subcommentSubmit.innerText = '댓글전송';

	subcommentFrm.appendChild(boardidx);
	subcommentFrm.appendChild(commentidx);
	subcommentFrm.appendChild(writer);
	subcommentFrm.appendChild(content);
	subcommentFrm.appendChild(subcommentSubmit);

	input_section.appendChild(subcommentFrm);

	commentInput.appendChild(input_section);

	commentExtra.appendChild(commentInput);

	let subCommentArea = document.createElement('div');
	subCommentArea.setAttribute('class', 'subCommentArea');
	subCommentArea.setAttribute('id','commentNum'+data.idx);

	let emptyText = document.createElement('p');
	emptyText.innerText = '답글이 없습니다.';

	subCommentArea.appendChild(emptyText);

	let commentArea = document.getElementById('commentArea');

	commentArea.appendChild(commentBox);
	commentArea.appendChild(commentExtra);
	commentArea.appendChild(subCommentArea);

	let scrollY = commentArea.getBoundingClientRect().bottom;


	window.scrollTo(0,scrollY);
	resetFunction();
}



function subcommentInsert(data){
	let attach = document.getElementById('commentNum'+data.commentidx);


	let subCommentBox = document.createElement('div');
	subCommentBox.setAttribute('class','subCommentBox');

	let commentatorInfo = document.createElement('div');
	commentatorInfo.setAttribute('class', 'commentatorInfo');
	commentatorInfo.innerText = data.writer;

	let commentcontent = document.createElement('div');
	commentcontent.setAttribute('class','commentcontent');
	if(data.mention != '' && data.mention != null){
		commentcontent.innerText = '@'+data.mention+"  "+data.content;
	}else{
		commentcontent.innerText = data.content;
	}

	subCommentBox.appendChild(commentatorInfo);
	subCommentBox.appendChild(commentcontent);

	let commentExtra = document.createElement('div');
	commentExtra.setAttribute('class','commentExtra');

	let extraInfo = document.createElement('div');

	let recommend = document.createElement('span');

	let recommendBtn = document.createElement('a');
	recommendBtn.innerText = '추천하기 ';

	recommend.appendChild(recommendBtn);

	let recommendCount = document.createElement('span');
	recommendCount.innerText = data.recommended;

	let commentActive = document.createElement('a');
	commentActive.setAttribute('class','commentActive');
	commentActive.innerText = ' reply';

	extraInfo.appendChild(recommend);
	extraInfo.appendChild(recommendCount);
	extraInfo.appendChild(commentActive);

	commentExtra.appendChild(extraInfo);

	let commentInput = document.createElement('div');
	commentInput.setAttribute('class','commentInput');

	let profile_pic = document.createElement('div');
	profile_pic.setAttribute('class','profile_pic');

	let profile_img = document.createElement('img');
	//if문으로 프로파일 이미지가 있는지 없는지 나중에 검사
	profile_img.setAttribute('src', 'resources/image/view/default.png');
	profile_pic.appendChild(profile_img);
	commentInput.appendChild(profile_pic);

	let input_section = document.createElement('div');
	input_section.setAttribute('class','input_section');

	let subcommentFrm = document.createElement('form');
	subcommentFrm.setAttribute('id','subcommentFrm');

	let boardidx = document.createElement('input');
	boardidx.setAttribute('type','hidden');
	boardidx.setAttribute('name','boardidx');
	boardidx.setAttribute('value',data.boardidx);

	let commentidx = document.createElement('input');
	commentidx.setAttribute('type','hidden');
	commentidx.setAttribute('name','commentidx');
	commentidx.setAttribute('value',data.commentidx);

	let writer = document.createElement('input');
	writer.setAttribute('type','hidden');
	writer.setAttribute('name','writer');
	writer.setAttribute('value',data.writer);

	let content = document.createElement('textarea');
	content.setAttribute('name','content')
	content.setAttribute('class','subcommentContent');

	let subcommentSubmit = document.createElement('button');
	subcommentSubmit.setAttribute('class','subcommentSubmit');
	subcommentSubmit.setAttribute('type','button');
	subcommentSubmit.innerText = "댓글전송"

	subcommentFrm.appendChild(boardidx);
	subcommentFrm.appendChild(commentidx);
	subcommentFrm.appendChild(writer);
	subcommentFrm.appendChild(content);
	subcommentFrm.appendChild(subcommentSubmit);

	input_section.appendChild(subcommentFrm);

	commentInput.appendChild(input_section);

	commentExtra.appendChild(commentInput);


	attach.appendChild(subCommentBox);
	attach.appendChild(commentExtra);


	let d = $('#commentNum'+data.commentidx).css('display');

	if(d!= 'block'){
		attach.setAttribute('class','subCommentArea on');
	}

	let subcommentY = attach.getBoundingClientRect().bottom;

	window.scrollTo(0,subcommentY);

	resetFunction();
}



