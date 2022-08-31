const subSelect = document.getElementById('subSelect');

function changeSubSelect(value){
	$.ajax({
		type: 'GET',
		url: 'subcategory',
		data : {
			category : value
		},
		dataType: 'json',
		success : function(data){
			$(subSelect).empty();
			$.each(data,function(key, value){
				let selectOption = document.createElement('option');
				option.setAttribute('value',value);
				option.innerText = value;
				subSelect.appendChild(option);
				console.log('키 : '+key + ', 값 :' + value);
			});
			},
		error: function(){
			alert("없는 카테고리?");
		}
	})
}

function uploadImage(){
	let imageData = "";
	$.ajax({
		url: 'https://api.imgur.com/3/image',
		headers: {
			'Authorization': 'Client-ID c88d329f23f4701'
		},
		type: 'POST',
		data: {
			'image': imageData
		},
		success: function(data) { console.log(data.data.link); }
	});
}
