$(function(){
	$("#login").click(function(){
		//获取请求提交数据
		var name=$("#count").val().trim();
		var password=$("#password").val().trim();
		//检测数据格式
		var ok=true;//表单是否通过检测
		if(name==""){
			ok=false;
			}
		if(password==""){
			ok=false;
			}
		//发送ajax请求
		if(ok==true){
			//发送Ajax请求
			$.ajax({
			url:"http://localhost:8080/cloud_note/user/login.do",
			type:"post",
			data:{"username":name,"password":password},
			dataType:"json",
			success:function(result){
				//成功处理
				if(result.statues==0){//成功
					var userId=result.data[0];//用户ID
					var userName=result.data[1];//用户名
					var passWord=result.data[2];//密码
					
					addCookie("userId",userId,2);//写入，2小时
					addCookie("passWord",passWord,2);
					if($("#check").is(':checked')==true){
					addCookie("userName",userName,2);
					}
					window.location.href="edit.html";
				}else if(result.statues==1){//用户名错误
					$("#count_span").html(result.mesage);
				}else if(result.statues==2){//密码错误
					$("#password_span").html(result.mesage);
				}		
			},
			error:function(){
				//异常处理
				alert("登录异常");
			}	
			});
		}
	});
});