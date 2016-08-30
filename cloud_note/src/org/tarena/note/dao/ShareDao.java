package org.tarena.note.dao;

import java.util.List;

import org.tarena.note.entity.Share;
import org.tarena.note.util.Page;

public interface ShareDao {
	public int share(Share share);
	public Share findByNoteId(String noteId);
	public List<Share> search(String title);
	public Share findByShareId(String shareId);
	public List<Share> findPage(Page page);
}
