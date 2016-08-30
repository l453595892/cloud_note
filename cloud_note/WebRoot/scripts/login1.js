$(function(){
	$("#count").blur(function(){
		$("#count_span").html("");
		var name=$("#count").val().trim();
		if(name==""){
			$("#count_span").html("用户名为空");
		}
	});
});