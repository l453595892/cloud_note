package org.tarena.note.dao.test;

import org.junit.Test;
import org.tarena.note.dao.NoteDao;
import org.tarena.note.entity.Note;
import org.tarena.note.util.SpringTest;

public class TestDynamicUpdate extends SpringTest{
	@Test
	public void test1(){
		NoteDao dao=getContext().getBean("noteDao",NoteDao.class);
		Note note=new Note();
		//note.setCn_notebook_id("fa8d3d9d-2de5-4cfe-845f-951041bcc461");
		//note.setCn_note_status_id("2");
		//note.setCn_note_id("fed920a0-573c-46c8-ae4e-368397846efd");
		//dao.dynamicUpdate(note);
		String[] ids={"","",""};
		int rows=dao.deleteNotes(ids);
	}
}
