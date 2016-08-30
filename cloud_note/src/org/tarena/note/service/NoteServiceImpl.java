package org.tarena.note.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tarena.note.dao.NoteDao;
import org.tarena.note.entity.Note;
import org.tarena.note.util.NoteResult;
import org.tarena.note.util.NoteUtil;
import org.tarena.note.vo.SearchBean;
@Service
@Transactional
public class NoteServiceImpl implements NoteService{
	@Resource
	private NoteDao noteDao;
	
	public NoteResult loadBookNotes(String bookId) {
		List<Note> notes=noteDao.findByBookId(bookId);
		NoteResult result=new NoteResult();
		result.setStatues(0);
		result.setData(notes);
		result.setMesage("查询笔记成功");
		return result;
	}

	public NoteResult loadNotes(String noteId) {
		Note notes=noteDao.findByNoteId(noteId);
		NoteResult result=new NoteResult();
		result.setStatues(0);
		result.setData(notes);
		result.setMesage("查询笔记成功");
		return result;

	}

	public NoteResult addNote(String bookId, String noteTitle, String userId) {
		NoteResult result=new NoteResult();
		List<Note> notes=noteDao.findByBookId(bookId);
		for(Note note:notes){
			if(note.getCn_note_title().equals(noteTitle)){
				result.setStatues(1);
				result.setMesage("笔记已存在");
				return result;
			}
		}
		
		Note note=new Note();
		note.setCn_notebook_id(bookId);
		note.setCn_note_title(noteTitle);
		note.setCn_user_id(userId);
		String noteId=NoteUtil.createId();
		note.setCn_note_id(noteId);
		note.setCn_note_status_id("1");
		note.setCn_note_type_id("1");
		note.setCn_note_body("");
		Long time=System.currentTimeMillis();
		note.setCn_note_create_time(time);
		note.setCn_note_last_modify_time(time);
		noteDao.save(note);//保存
		
		result.setStatues(0);
		result.setMesage("创建笔记成功");
		result.setData(noteId);
		return result;
	}

	public NoteResult updateNote(String noteTitle,String noteBody,
			String noteId) {
		
		Note note=new Note();
		note.setCn_note_body(noteBody);
		note.setCn_note_title(noteTitle);
		note.setCn_note_id(noteId);
		Long lastModifyTime=System.currentTimeMillis();
		note.setCn_note_last_modify_time(lastModifyTime);
		noteDao.update (note);
		NoteResult result=new NoteResult();
		result.setStatues(0);
		result.setMesage("修改成功");
		return result;
	}

	public NoteResult updatestatus(String noteId) {
		Note note=new Note();
		note.setCn_note_status_id("2");
		note.setCn_note_id(noteId);
		noteDao.updatestatus(note);
		
		NoteResult result=new NoteResult();
		result.setStatues(0);
		result.setMesage("成功移入垃圾箱");
		return result;
	}
	public NoteResult findByStatusId(){
		List<Note> notes=noteDao.findByStatusId();
		NoteResult result=new NoteResult();
		result.setStatues(0);
		result.setData(notes);
		result.setMesage("查询删除笔记成功");
		return result;
		
	}

	public NoteResult removeNote(String bookId, String noteId) {
		NoteResult result=new NoteResult();
		Note note=new Note();
		note.setCn_note_id(noteId);
		note.setCn_notebook_id(bookId);
		noteDao.remove(note);
		result.setStatues(0);
		result.setMesage("笔记本转移成功");
		return result;
	}

	public NoteResult deleteNote(String noteId) {
		noteDao.delete(noteId);
		NoteResult result=new NoteResult();
		result.setStatues(0);
		result.setMesage("删除成功");
		return result;
	}

	public NoteResult recoverNote(String bookId, String noteId) {
		NoteResult result=new NoteResult();
		Note note=new Note();
		note.setCn_note_id(noteId);
		note.setCn_notebook_id(bookId);
		noteDao.recover(note);
		result.setStatues(0);
		result.setMesage("笔记本恢复成功");
		return result;
	}

	public NoteResult updatestatusCollect(String noteId) {
		Note note=new Note();
		note.setCn_note_status_id("3");
		note.setCn_note_id(noteId);
		noteDao.updatestatus(note);
		
		NoteResult result=new NoteResult();
		result.setStatues(0);
		result.setMesage("成功收藏笔记");
		return result;
	}

	public NoteResult findCollectionNotes() {
		List<Note> notes=noteDao.findCollect();
		NoteResult result=new NoteResult();
		result.setStatues(0);
		result.setData(notes);
		result.setMesage("查询收藏笔记成功");
		return result;
	}
	//
	public NoteResult searchNotes(SearchBean params){
		//参数处理
		if(params.getTitle() !=null&&!"".equals(params.getTitle())){
			String title="%"+params.getTitle()+"%";
			params.setTitle(title);
		}else{
			params.setTitle(null);
		}
		//选All则设置为null
		if("0".equals(params.getStatus())){
			params.setStatus(null);
		}
		//执行搜索处理
		List<Note> list=noteDao.findNotes(params);
		NoteResult result=new NoteResult();
		result.setStatues(0);
		result.setData(list);
		result.setMesage("检索");
		return result;
	}

}
