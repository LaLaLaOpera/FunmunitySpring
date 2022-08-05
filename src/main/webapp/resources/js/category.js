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
				url : 'load',
				data : {
					page : ++boardNum,
					board_cat : category
				},
				dataType: 'json',
				success : function(data){
					if (data.title == null){
						observer.unobserve(target);
						return;
					}
					addBlock(data)
                    
				},
				error: function(){
					alert("request error!");
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
	info.setAttribute('href','view?idx='+data.idx);
	let cat = document.createElement('a');
	cat.innerText += 'r/'+data.board_cat
	cat.setAttribute('href','category?board_cat='+data.board_cat);


	let writer = document.createElement('p');
	writer.innerText += data.writer;
	writer.setAttribute('href','user='+data.writer);
	let imgbox = document.createElement('div');
	imgbox.setAttribute('class', 'imageWapper');
	let img = document.createElement('img')
	img.setAttribute('class', 'thumb');
	img.setAttribute('src', data.thumnail);

	 main.appendChild(info);
	 main.appendChild(document.createElement("br"));
	 main.appendChild(cat);
	 main.appendChild(writer);
	 main.appendChild(imgbox);
	 imgbox.appendChild(img);

	 target.before(main);
}

