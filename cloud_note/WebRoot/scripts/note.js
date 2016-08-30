function loadNotes(){
					  $("#pc_part_5").hide();
				   $("#pc_part_3").show();
					$("#pc_part_2").show();//全部笔记列表
					$("#pc_part_4").hide();//回收站列表
					$("#pc_part_6").hide();//搜索结果列表
					$("#pc_part_7").hide();//收藏列表
					$("#pc_part_8").hide();//活动列表
					
					$("#input_note_title").val("");
					um.setContent("");
					//将当前点中的笔记本设置为选中状态
			 		$("#book_list li a").removeClass("checked");
			 		$(this).find("a").addClass("checked");
			 		//获取请求提交数据(获取当前点中的li的笔记本ID)
			 		var bookId=$(this).data("bookId");
			 		$.ajax({
			 			url:"http://localhost:8080/cloud_note/note/loadnotes.do",
			 			type:"post",
			 			data:{"bookId":bookId},
			 			dataType:"json",
			 			success:function(result){
			 				if(result.statues==0){
			 					var notes=result.data;//笔记json对象数组
			 					$("#note_list").empty();
			 					for(var i=0;i<notes.length;i++){
			 						var noteId=notes[i].cn_note_id;
			 						var noteTitle=notes[i].cn_note_title;
			 						//拼成笔记的li
			 					   createNoteLi(noteId,noteTitle);
			 					}
			 				}
			 			},
			 			error:function(){
			 				alert("加载笔记列表异常")
			 			}
			 		});
			 		//发送ajax请求
}
function loadNote(){	 
			
			//设置单击的笔记选中
			$("#note_list a").removeClass("checked");
			$(this).find("a").addClass("checked");
			
			var noteId=$(this).data("noteId");
			$.ajax({
				url:"http://localhost:8080/cloud_note/note/loadnotesinfo.do",
				type:"post",
				data:{"noteId":noteId},
				dataType:"json",
				success:function(result){
					var notes=result.data;
					var title=notes.cn_note_title;
					var body=notes.cn_note_body;
					
					$("#input_note_title").val(title);
					um.setContent(body);
				},
				error:function(){
					alert("加载笔记本信息失败");
				}
			});
		
}
function sureAddNotes(){
				//获取请求数据
				var noteTitle=$("#input_note").val().trim();
				var bookId=$("#book_list li a.checked").parent().data("bookId");
				//判断
				var ok=true;
				if(noteTitle==""){
					ok=false;
					$("#notes").html("不能空");
				}
				if(ok){
				$.ajax({
					url:path+"/note/add.do",
					type:"post",
					data:{"bookId":bookId,"noteTitle":noteTitle,"userId":userId},
					success:function(result){
						if(result.statues==0){
								//获取返回的笔记ID
								var noteId=result.data;
							 	createNoteLi(noteId,noteTitle);
	 							closeWindow();
	 							alert(result.mesage);
						}
						if(result.statues==1){
							$("#notes").html("已存在");
						}
					},
					error:function(){
						alert("加载笔记列表失败");
					}
				});
				}
			}
function updateNote(){
				
				var noteId=$("#note_list li a.checked").parent().data("noteId");
				var noteTitle=$("#input_note_title").val().trim();
				var noteBody=um.getContent();
				if(noteId==null){
					alert("请选择笔记本")
				}else{
				$.ajax({
					url:path+"/note/updatenote.do",
					type:"post",
					data:{"noteTitle":noteTitle,"noteBody":noteBody,"noteId":noteId},
					success:function(result){
						if(result.statues==0){
						var str='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'; 
							 str+=noteTitle;
						    str+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
							 $("#note_list li a.checked").html(str);
							 alert(result.mesage);
						}
					},
					error:function(){
						alert("更新失败");
					}
				});
				}
			}
function showNoteMenu(){
				//显示菜单的div(this指的是".btn_slide_down"元素)
					//获取当前点中的笔记li
				$li=$(this).parents("li");
				
					//将当前li的菜单显示
				var $menu=$li.find(".note_menu");
				if($menu.is(":hidden")){
					//将其他菜单隐藏
					$("#note_list .note_menu").hide();	
					$menu.slideDown(300);//下拉显示
				}else{
					$menu.slideUp(300);//动画隐藏
				}
				return false;//阻止冒泡
			}
function recycleNote(){
				
				//获取笔记本ID
				var noteId=$("#note_list li a.checked").parent().data("noteId");
				$.ajax({
					url:path+"/note/updatestatus.do",
					type:"post",
					data:{"noteId":noteId},
					dataType:"json",
					success:function(result){
						$("#note_list li a.checked").parent().remove();
						$("#input_note_title").val("");
						um.setContent("");
						//关闭对话框
						closeWindow();
						//弹出提示
						alert(result.mesage);
					},
					error:function(){
						alert("清除笔记一样")
					}
				});
			}
function recycleNoteList(){
				if($("#pc_part_4").is(":hidden")){
					$("#pc_part_4").fadeIn(300,function(){
						$("#pc_part_2").hide(200);
						$("#pc_part_3").show();
						$("#pc_part_5").hide();
						$("#pc_part_6").hide();
						$("#pc_part_7").hide();
						$("#pc_part_8").hide();
						$("#deleteNotes_list li").empty();
						$.ajax({
							url:"http://localhost:8080/cloud_note/note/deletelist.do",
							type:"post",
							dataType:"json",
							success:function(result){
								var notes=result.data;
								for(var i=0;i<notes.length;i++){
									var noteTitle=notes[i].cn_note_title;
									var noteId=notes[i].cn_note_id;
									var sli='<li class="disable">';
									    sli+='<a >'
									 	 sli+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'
									    sli+=noteTitle
									    sli+='<button type="button" class="btn btn-default btn-xs btn_position btn_delete">'
									    sli+='<i class="fa fa-times"></i>'
									    sli+='</button>';
									  	 sli+='<button type="button" class="btn btn-default btn-xs btn_position_2 btn_replay">';
									  	 sli+='<i class="fa fa-reply"></i>';
									    sli+='</button>';
									    sli+='</a>';
									    sli+='</li>'
									    var $li=$(sli);
									    $li.data("noteId",noteId);
									    $("#deleteNotes_list").append($li);
									    
								}
							},
							error:function(){
								alert("加载垃圾箱失败");
							}
						});
					});
					
				}else{
					$("#pc_part_4").fadeOut(500,function(){
						$("#pc_part_2").show();
					});
				}
			}
function shareNote(){
				//获取笔记ID
				var noteId=$(this).parents("li").data("noteId");
				//发送Ajax请求
				$.ajax({
					url:path+"/share/sharenote.do",
					type:"post",
					data:{"noteId":noteId},
					dataType:"json",
					success:function(result){
						if(result.statues==0){
							alert(result.mesage);
						}else if(result.statues==1){
							alert(result.mesage);
						}
					},
					error:function(){
						alert("分享笔记异常");
					}
				});
			}
function createNoteLi(noteId,noteTitle){
		var sli='<li class="online">';
				sli+='<a >';
				sli+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'; 
				sli+=noteTitle;
				sli+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
				sli+='</a>';
				sli+='<div class="note_menu" tabindex="-1">';
				sli+='<dl>';
				sli+='		<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
				sli+='		<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
				sli+='		<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
				sli+='</dl>';
				sli+='</div>';
				sli+='</li>';
			var $li=$(sli);
 			$li.data("noteId",noteId);
 			$("#note_list").append($li);
}