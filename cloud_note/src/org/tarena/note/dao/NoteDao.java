package org.tarena.note.dao;

import java.util.List;

import org.tarena.note.entity.Note;
import org.tarena.note.vo.SearchBean;

public interface NoteDao {
	
	public List<Note> findByBookId(String bookId);
	public Note findByNoteId(String noteId);
	public int save(Note note);
	public int update(Note note);
	public int updatestatus(Note note);
	public List<Note> findByStatusId();
	public int remove(Note note);
	public int delete(String noteId);
	public int recover(Note note);
	public List<Note> findCollect();
	/**
	 * 组合查询
	 */
	public List<Note> findNotes(SearchBean params);
	/**
	 * 动态更新方法；属性不为null的参与更新
	 * @param note
	 * @return
	 */
	public int dynamicUpdate(Note note);
	/**
	 * 多组noteId删除
	 * @param notes
	 * @return
	 */
	public int deleteNotes(String[] notes);
}
