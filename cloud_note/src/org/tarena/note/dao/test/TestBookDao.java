package org.tarena.note.dao.test;

import java.util.List;

import org.junit.Test;
import org.tarena.note.dao.BookDao;
import org.tarena.note.entity.NoteBook;
import org.tarena.note.util.SpringTest;

public class TestBookDao  extends SpringTest{
	@Test
	public void test1(){
		BookDao dao=getContext().getBean("bookDao",BookDao.class);
		List<NoteBook> list=dao.findByUserId("48595f52-b22c-4485-9244-f4004255b972");
		for(NoteBook book:list){
			System.out.println(book.getCn_notebook_name());
		}
	}
}
