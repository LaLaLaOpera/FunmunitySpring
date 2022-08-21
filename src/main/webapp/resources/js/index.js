const body = document.querySelector('.contentWrap');

let currentTime = new Date();

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
				url : 'load',
				data : {
					page : ++boardNum,
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
	let cat = document.createElement('a');
	cat.innerText += 'Category/'+data.board_cat;
	cat.setAttribute('href','category/'+data.board_cat);
	let info = document.createElement('a');
	info.innerText += 'Title/'+data.title
	info.setAttribute('href','view?idx='+data.idx);

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

