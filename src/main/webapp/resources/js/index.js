const body = document.querySelector('.contentWrap');

let currentTime = new Date();

let boardNum = 0;

const option = {
    rootMargin: '0px 0px 30px 0px',
    threshold: 0
}

let message = "";
function loginCheck(){
	$.ajax({
		url: "loginCheck",
		type: "POST",
		cache: false,
		success: function(){
			message = "success";
		},
		error: function (){
			message = "fail";
			alert("로그인이 필요한 기능입니다.")
		}
	})
	console.log(message);
	return message;
}


const observer = new IntersectionObserver((entries,observer)=>{
    console.log(entries);
    entries.forEach((entry)=>{
        if(entry.isIntersecting){	        	
        	$.ajax({
				type : 'GET',
				url : 'load',
				data : {
					page : ++boardNum,
				},
				dataType: 'json',
				success : function(data){
					addBlock(data)
					preset();
				},
				error: function(){
					observer.unobserve(target);
					alert("게시물이 끝났습니다!");
				}
			})
        } else {
			return;
		}
    })  
},option);
const target = document.querySelector('.lastSec');

observer.observe(target);

function addBlock(data){
	let main = document.createElement('div');
	main.setAttribute('class', 'cardWrapper');
	let cat = document.createElement('a');
	cat.innerText += 'Category/'+data.board_cat;
	cat.setAttribute('href','category/'+data.board_cat);
	let info = document.createElement('a');
	info.innerText += 'Title/'+data.title
	info.setAttribute('href','view?idx='+data.idx);

	let simpleInput = document.createElement('input');
	simpleInput.setAttribute('type','hidden');
	simpleInput.setAttribute('value',data.idx);
	simpleInput.setAttribute('class','simpleInput');
	main.appendChild(simpleInput);

	let time = displayedAt(data.postdate)
	let postdate = document.createElement('p');
	postdate.innerText = time;

	let writer = document.createElement('p');
	writer.innerText += "User/"+data.writer;
	writer.setAttribute('href','user='+data.writer);
	main.appendChild(info);
	main.appendChild(document.createElement("br"));
	main.appendChild(cat);
	main.appendChild(writer);
	main.appendChild(postdate);
	if (data.thumnail != null){
		let imgbox = document.createElement('div');
		imgbox.setAttribute('class', 'imageWapper');
		let img = document.createElement('img')
		img.setAttribute('class', 'thumb');
		img.setAttribute('src', data.thumnail);
		main.appendChild(imgbox);
		imgbox.appendChild(img);
	}
	let recommendCnt = document.createElement('p');
	recommendCnt.setAttribute('class','recommendCnt');
	recommendCnt.innerText = data.recommendcount;

	main.appendChild(recommendCnt);

	let recommendBtn = document.createElement('button');
	recommendBtn.setAttribute('type','button');
	recommendBtn.setAttribute('type','recommendBtn');
	recommendBtn.innerText="추천하기";
	recommendBtn.setAttribute('class','recommendBtn');

	main.appendChild(recommendBtn);

	 target.before(main);
}

function displayedAt(createdAt) {
	const milliSeconds = new Date() - createdAt;
	const seconds = milliSeconds / 1000
	if (seconds < 60) return `방금 전`
	const minutes = seconds / 60
	if (minutes < 60) return `${Math.floor(minutes)}분 전`
	const hours = minutes / 60
	if (hours < 24) return `${Math.floor(hours)}시간 전`
	const days = hours / 24
	if (days < 7) return `${Math.floor(days)}일 전`
	const weeks = days / 7
	if (weeks < 5) return `${Math.floor(weeks)}주 전`
	const months = days / 30
	if (months < 12) return `${Math.floor(months)}개월 전`
	const years = days / 365
	return `${Math.floor(years)}년 전`
}

function preset(){

	let recommendBtns = $('.recommendBtn');

	recommendBtns.off("click");

	recommendBtns.on("click",function(){
		let target = $(this);
		if (loginCheck()=="success"){
			recommendPostFunction(target);
		}
	})
}

function recommendPostFunction(target){
	let idx = target.siblings('.simpleInput').val();
	let cnt = target.siblings('.recommendCnt');
	$.ajax({
		url: "recommend/post",
		type: "POST",
		cache: false,
		data : {
			'idx' : idx
		},
		success : function(data){
			alert("추천에 성공했습니다")
			console.log(data);
			cnt.html(data);
		},
		error: function(){
			alert("추천에 실패")
		}
	})
}

