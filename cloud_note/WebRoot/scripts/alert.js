function alertAddBookWindow(){
	//弹出背景色
	$(".opacity_bg").show();
	//弹出对话框
	$("#can").load("http://localhost:8080/cloud_note/alert/alert_notebook.html");
}
//弹出创建笔记本
function alertAddNoteWindow(){
//	var $a=$("#book_list li a.checked");
//	if(a.length==0){//未选中提示错误
//		alert("请选中笔记本");
//	}
	//检测笔记本是否选中
	var $bookli=$("#book_list li a.checked").parent();
	var bookId=$bookli.data("bookId");
	if(bookId==undefined){
		alert("请选择笔记本")
	}else{//选中弹出对话框
		//显示背景色div
		$(".opacity_bg").show();
		//弹出对话框
		$("#can").load("http://localhost:8080/cloud_note/alert/alert_note.html");
	}
}
//关闭对话框
function closeWindow(){
	$(".opacity_bg").hide();
	$("#can").empty();
}
//弹出确认删除笔记对话框
function alertRecycleNoteWindow(){
	$(".opacity_bg").show();
	$("#can").load("http://localhost:8080/cloud_note/alert/alert_delete_note.html");
}
//弹出移动笔记对话框
function alertRemoveNoteWindwo(){
	$(".opacity_bg").show();
	$("#can").load("http://localhost:8080/cloud_note/alert/alert_move.html");
}