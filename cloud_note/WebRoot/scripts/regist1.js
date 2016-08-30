$(function(){
	$("#regist_username").blur(function(){
			$("#warning_1 span").html("");
			var username=$("#regist_username").val().trim();
			var ok=true;
			if(username==""){
			ok=false;
			$("#warning_1 span").html("用户名为空");
			$("#warning_1").show();
		}
		if(ok){
			$.ajax({
			url:"http://localhost:8080/cloud_note/user/login.do",
			type:"post",
			data:{"username":username,"password":000},
			dataType:"json",
			success:function(result){
				if(result.statues==2){//密码错误
				$("#warning_1 span").html("用户名已被占用");
				$("#warning_1").show();
				}
			}
						
			});			
		}	
	});
});