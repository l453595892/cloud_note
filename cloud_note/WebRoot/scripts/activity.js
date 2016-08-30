function showActivity(){
            		var current=1;
					$.ajax({
					url:"http://localhost:8080/cloud_note/activity/showactivity.do",
					type:"post",
					data:{"activityId":'1',"current":current,"pageSize":5},
					dataType:"json",
					success:function(result){
						var list=result.data;
						for(var i=0;i<list.length;i++){
							var listName=list[i].cn_note_activity_title;
							var activityId=list[i].cn_note_activity_id;
							var sli = '<li class="online">';
							 sli +=' <a>';
							 sli +=listName;
							 sli +=' </a>';
							 sli +='</li>';
							 //添加到<ul id="book_list">中
							 var $li=$(sli);//将sli字符串转成jQuery对象
							 $li.data("activityId",activityId);//将bookId绑定到$li对象
							 //添加到<ul id="book_list">中
							 $("#activity_list").append($li);
							}
						},
						error:function(){
							alert("加载列表失败");
						}
					});
            	}