//根据用户ID加载笔记本列表
function loadBooks(){
			$.ajax({
				url:"http://localhost:8080/cloud_note/notebook/loadbooks.do",
				type:"post",
				data:{"userId":userId},
				dataType:"json",
				success:function(result){
					if(result.statues==0){
						var books=result.data;//笔记本json对象数组
						//清除原有的笔记本列表
						$("#book_list").empty();
						//循环Books生成笔记本li
						for(var i=0;i<books.length;i++){
							var bookId=books[i].cn_notebook_id;
							var bookName=books[i].cn_notebook_name;
							//拼成一个li
							var sli = '<li class="online">';
								 sli +=' <a>';
								 sli +=' <i class="fa fa-book" title="online" rel="tooltip-bottom"></i>';
								 sli +=bookName;
								 sli +=' </a>';
								 sli +='</li>';
								 //添加到<ul id="book_list">中
								 var $li=$(sli);//将sli字符串转成jQuery对象
								 $li.data("bookId",bookId);//将bookId绑定到$li对象
								 //添加到<ul id="book_list">中
								 $("#book_list").append($li);
						}
					}
				},
				error:function(){
					alert("加载笔记本列表失败");
				}
			});
}
function sureAddBooks(){
				var bookName=$("#input_notebook").val().trim();
				//TODO 数据格式检查
				$.ajax({
					url:"http://localhost:8080/cloud_note/notebook/add.do",
					type:"post",
					data:{"bookName":bookName,"userId":userId},
					success:function(result){
						if(result.statues==0){
							var bookId=result.data;
							//拼一个笔记本li添加列表项
								var sli = '<li class="online">';
								 sli +=' <a >';
								 sli +=' <i class="fa fa-book" title="online" rel="tooltip-bottom"></i>';
								 sli +=bookName;
								 sli +=' </a>';
								 sli +='</li>';
								 
								 var $li=$(sli);
								 $li.data("bookId",bookId);
								 $("#book_list").append($li);
							//关闭添加笔记对话框
							closeWindow();
							//弹出提示信息
							alert(result.mesage);
							
						}
						if(result.statues==1){
							$("#creatbooks").html("已存在");
						}
					},
					error:function(){
						alert("加载笔记本列表失败");
					}
				});
			}