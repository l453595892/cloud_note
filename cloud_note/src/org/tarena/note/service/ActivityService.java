package org.tarena.note.service;

import org.tarena.note.util.NoteResult;

public interface ActivityService {
	public NoteResult addActivity(String noteId,String noteTitle,String noteBody);
	public NoteResult showActivity(String activityId,int current,int pageSize);
	public NoteResult previewActivity(String activityId);

}
