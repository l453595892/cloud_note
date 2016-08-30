$(function(){
	$("#regist_button").click(function(){
		//清除原有提示信息
		$("#warning_1 span").html("");
		$("#warning_2 span").html("");
		$("#warning_3 span").html("");
		$("#warning_4 span").html("");
		$("#warning_1").hide("");
		$("#warning_2").hide("");
		$("#warning_3").hide("");
		$("#warning_4").hide("");
		//获取请求提交的参数
		var username=$("#regist_username").val().trim();
		var nickname=$("#nickname").val().trim();
		var password=$("#regist_password").val().trim();
		var repassword=$("#final_password").val().trim();
		//检查参数格式
		var ok=true;
		if(username==""){
			ok=false;
		}
		if(nickname==""){
			ok=false;
		}
		if(password==""){
			ok=false;
		}else{
			if(password<6){
				ok=false;
			}
		}
		if(repassword!=password){
			ok=false;
		}
		//发送Ajax请求
		if(ok){
			$.ajax({
			url:"http://localhost:8080/cloud_note/user/regist.do",
			type:"post",
			data:{"username":username,"password":password,"nickname":nickname},
			dataType:"json",
			success:function(result){
				if(result.statues==0){//成功
					alert(result.mesage);
					$("#back").click();//调用返回按钮单击
					$("#regist_username").val("");
					$("#nickname").val("");
					$("#regist_password").val("");
					$("#final_password").val("");
				}
			},
			error:function(){
				alert("注册异常");
			}	
			});
		}
	});
});