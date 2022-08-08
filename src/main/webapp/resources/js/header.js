let AccBtn = document.getElementById("AccordionBtn");
let AccordionMenu = document.getElementById("AccordionMenu");

let AccordionToggle = false;

AccBtn.addEventListener("click", function(){
	if (AccordionToggle == false){
		AccordionMenu.classList.remove('off')
		AccordionMenu.classList.add('on');
		AccordionToggle = true;
	}
	else{
		AccordionMenu.classList.add('off')
		AccordionMenu.classList.remove('on');
		AccordionToggle = false;
	}
});

$('.loginBtn').click(function(){
    $('.modal_login').addClass('on')
    document.body.style.overflow = "hidden";
    return false
})

$('.signUpBtn').click(function(){
    $('.modal_signUp').addClass('on')
    document.body.style.overflow = "hidden";
    return false
})

$('.loginExit').click(function(){

    $('.modal_login').removeClass('on')
    document.body.style.overflow = "unset";
    return false
})

$('.signUpExit').click(function(){

    $('.modal_signUp').removeClass('on')
    document.body.style.overflow = "unset";
    return false
})

//유저 로그인 부분
$('.loginConfirm').click(function (){

    let loginData = $("#loginFrm").serialize();
    $.ajax({
        type : 'POST',
        url : 'user',
        cache: false,
        data: loginData,
        success : function(data){
            alert("통신성공");
            location.reload();
        },
        error: function(data){
            alert("아이디 비밀번호를 다시 확인해주세요");
        }
    })
});

$('.signupConfirm').click(function(){
    let signupData = $("#signupFrm").serialize();
    $.ajax({
        type : 'POST',
        url : 'register',
        cache: false,
        data: signupData,
        success : function(data){
            alert("회원가입에 성공하였습니다.");
            location.reload();
        },
        error: function(data){
            alert("다시 시도해주세요");
        }
    })
})

function logout(){
    if (confirm("로그아웃하겠습니까?")){
        $.ajax({
            type : 'GET',
            url : 'user',
            cache: false,
            success : function(){
                alert("로그아웃되었습니다.");
                location.reload();
            },
            error: function(){
                alert("로그아웃에 실패했습니다");
            }
        })
    }
};

