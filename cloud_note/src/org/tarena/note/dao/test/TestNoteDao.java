package org.tarena.note.dao.test;

import java.util.List;

import org.junit.Test;
import org.tarena.note.dao.ActivityDao;
import org.tarena.note.dao.NoteDao;
import org.tarena.note.entity.Activity;
import org.tarena.note.entity.Note;
import org.tarena.note.util.SpringTest;
import org.tarena.note.vo.ActivityBean;

public class TestNoteDao extends SpringTest{
	@Test
	public void test1(){
		NoteDao dao=this.getContext().getBean("noteDao",NoteDao.class);
		List<Note> list=dao.findByBookId("fa8d3d9d-2de5-4cfe-845f-951041bcc461");
		for(Note note:list){
			System.out.println(note.getCn_note_title());
		}
	}
	@Test
	public void test2(){
		ActivityDao dao=this.getContext().getBean("activityDao",ActivityDao.class);
		ActivityBean bean=new ActivityBean();
		bean.setCn_note_id("53d1b3ed-59a1-4715-a7b2-9027b0d551e0");
		bean.setCurrent(1);
		bean.setPageSize(5);
		
		List<Activity> list=dao.findActicityNotes(bean);
		for(Activity ac:list){
			System.out.println(ac.getCn_note_activity_title());
		}
	}
	
}
