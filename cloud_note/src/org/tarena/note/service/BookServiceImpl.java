package org.tarena.note.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tarena.note.dao.BookDao;
import org.tarena.note.entity.NoteBook;
import org.tarena.note.util.NoteResult;
import org.tarena.note.util.NoteUtil;

@Service
@Transactional
public class BookServiceImpl implements BookService{
	@Resource
	private BookDao bookDao;
	
	
	public NoteResult loadUserBooks(String userId) {
		List<NoteBook> books=bookDao.findByUserId(userId);
		NoteResult result=new NoteResult();
		result.setStatues(0);
		result.setMesage("查询成功");
		result.setData(books);
		return result;
	}

	
	public NoteResult addBook(String bookName, String userId) {
		
		NoteResult result=new NoteResult();
		//TODO 追加笔记本重名检测
//		NoteBook dbbooks=bookDao.findByBookName(bookName);
//		if(dbbooks!=null){
//			result.setStatues(1);
//			result.setMesage("笔记本存在");
//			return result;
//		}
		List<NoteBook> books=bookDao.findByUserId(userId);
		for(NoteBook book:books){
			if(book.getCn_notebook_name().equals(bookName)){
				result.setStatues(1);
				result.setMesage("笔记本存在");
				return result;
			}
		}
		
		
		NoteBook book=new NoteBook();
		book.setCn_notebook_name(bookName);//设置笔记本名称
		book.setCn_user_id(userId);//设置用户ID
		String bookId=NoteUtil.createId();
		book.setCn_notebook_id(bookId);//设置笔记本ID
		book.setCn_notebook_desc("");//设置描述
		book.setCn_notebook_type_id("5");//normal
		Timestamp time=new Timestamp(System.currentTimeMillis());
		book.setCn_notebook_createtime(time);//设置创建时间
		bookDao.save(book);
		
		result.setStatues(0);
		result.setMesage("创建笔记本成功");
		result.setData(bookId);//返回新建笔记本的BookId
		
		return result;
		
		
		
	}

}
