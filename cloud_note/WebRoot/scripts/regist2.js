$(function(){
	$("#nickname").blur(function(){
			$("#warning_4 span").html("");
			var nickname=$("#nickname").val().trim();
			if(nickname==""){
			$("#warning_4 span").html("昵称为空");
			$("#warning_4").show();
		}
	});
});