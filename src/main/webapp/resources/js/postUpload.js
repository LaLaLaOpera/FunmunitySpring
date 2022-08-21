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

