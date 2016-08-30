$(function(){
	$("#regist_password").blur(function(){
		var password=$("#regist_password").val().trim();
		var repassword=$("#final_password").val().trim();
		if(password==""){
			$("#warning_2 span").html("密码为空");
			$("#warning_2").show();
		}else{
			if(password<6){
			$("#warning_2 span").html("密码位数小于6");
			$("#warning_2").show();
			}
		}
		if(repassword!=password){
			$("#warning_3 span").html("密码不一致");
			$("#warning_3").show();
		}
	});
});