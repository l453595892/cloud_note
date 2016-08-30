$(function(){
	$("#password").blur(function(){
		$("#password_span").html("");
		var password=$("#password").val().trim();
		if(password==""){
			$("#password_span").html("密码为空");
		}
	});
});