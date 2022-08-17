const body = document.querySelector('.contentWrap');

let category = document.getElementById('category').value;
let boardNum = 0;

const option = {
    rootMargin: '0px 0px 30px 0px',
    threshold: 0
}

const observer = new IntersectionObserver((entries,observer)=>{
    console.log(entries);
    entries.forEach((entry)=>{
        if(entry.isIntersecting){
        	$.ajax({
				type : 'GET',
				url :category+'/catload',
				data : {
					page : ++boardNum
				},
				dataType: 'json',
				success : function(data){
					addBlock(data)
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
	let info = document.createElement('a');
	info.innerText += 'r/'+data.title
	info.setAttribute('href','../view?idx='+data.idx);

	let writer = document.createElement('p');
	writer.innerText += data.writer;
	writer.setAttribute('href','user='+data.writer);
	if (data.thumnail != null){
		let imgbox = document.createElement('div');
		imgbox.setAttribute('class', 'imageWapper');
		let img = document.createElement('img')
		img.setAttribute('class', 'thumb');
		img.setAttribute('src', data.thumnail);
		main.appendChild(imgbox);
		imgbox.appendChild(img);
	}

	 main.appendChild(info);
	 main.appendChild(document.createElement("br"));
	 main.appendChild(writer);


	 target.before(main);
}

