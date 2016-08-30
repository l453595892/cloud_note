package org.tarena.note.dao.test;

import java.util.List;

import org.junit.Test;
import org.tarena.note.dao.NoteDao;
import org.tarena.note.entity.Note;
import org.tarena.note.util.SpringTest;
import org.tarena.note.vo.SearchBean;

public class TestSearch  extends SpringTest{
	@Test
	public void test1(){
		NoteDao dao=getContext().getBean("noteDao",NoteDao.class);
		SearchBean params=new SearchBean();
		//params.setTitle("%测试%");
		//params.setStatus("1");
		params.setBeginTime("2016-01-10");
		params.setEndTime("2016-01-18");
		List<Note> list=dao.findNotes(params);
		for(Note note:list){
			System.out.println(note.getCn_note_title());
		}
		System.out.println("结果数"+list.size());
	}
}
