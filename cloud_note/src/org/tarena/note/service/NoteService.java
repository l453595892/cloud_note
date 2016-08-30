package org.tarena.note.service;

import org.tarena.note.util.NoteResult;
import org.tarena.note.vo.SearchBean;

public interface NoteService {
	public NoteResult loadBookNotes(String bookId);
	public NoteResult loadNotes(String noteId);
	public NoteResult addNote(String bookId,String noteTitle,String userId);
	public NoteResult updateNote(String noteTitle,String noteBody,String noteId);
	public NoteResult updatestatus(String noteId);
	public NoteResult findByStatusId();
	public NoteResult removeNote(String bookId,String noteId);
	public NoteResult deleteNote(String noteId);
	public NoteResult recoverNote(String bookId,String noteId);
	public NoteResult updatestatusCollect(String noteId);
	public NoteResult findCollectionNotes();
	//
	public NoteResult searchNotes(SearchBean params);
}
