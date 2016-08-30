package org.tarena.note.service;

import org.tarena.note.util.NoteResult;

public interface ShareService {
	public NoteResult share(String noteId);
	public NoteResult search(String noteTitle,int current);
	public NoteResult show(String shareId);
}
