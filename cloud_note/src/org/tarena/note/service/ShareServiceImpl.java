package org.tarena.note.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tarena.note.dao.NoteDao;
import org.tarena.note.dao.ShareDao;
import org.tarena.note.entity.Note;
import org.tarena.note.entity.Share;
import org.tarena.note.util.NoteResult;
import org.tarena.note.util.NoteUtil;
import org.tarena.note.util.Page;
@Service
@Transactional
public class ShareServiceImpl implements ShareService {
	@Resource
	private ShareDao shareDao;
	@Resource
	private NoteDao noteDao;
	
	public NoteResult share(String noteId) {
		NoteResult result=new NoteResult();
		Share has_share=shareDao.findByNoteId(noteId);
		if(has_share!=null){
			result.setStatues(1);
			result.setMesage("该笔记已分享过");
			return result;
		}
		Share share=new Share();
		//随机给share生成一个Id
		String shareId=NoteUtil.createId();
		share.setCn_share_id(shareId);
		Note note=noteDao.findByNoteId(noteId);
		String Title=note.getCn_note_title();
		String ShareBody=note.getCn_note_body();
		share.setCn_share_title(Title);
		share.setCn_share_body(ShareBody);
		share.setCn_note_id(noteId);
		int n=shareDao.share(share);
		if(n==0){
			result.setStatues(2);
			result.setMesage("分享笔记失败");
			return result;
		}
		result.setStatues(0);
		result.setMesage("分享笔记成功");
		result.setData(shareId);
		return result;
	}

	public NoteResult search(String noteTitle,int current) {
		String keyWord="";
		if(noteTitle==null||"".equals(noteTitle)){
			keyWord="%";
		}else{
			keyWord="%"+noteTitle.trim()+"%";
		}
		List<Share> list=new ArrayList<Share>();
		Page page=new Page();
		page.setCn_share_title(keyWord);
		page.setCurrent(current);
		page.setPageSize(10);
		list=shareDao.findPage(page);
		NoteResult result=new NoteResult();
		result.setStatues(0);
		result.setMesage("查询成功");
		result.setData(list);
		return result;
	}

	public NoteResult show(String shareId) {
		Share share=new Share();
		share=shareDao.findByShareId(shareId);
		NoteResult result=new NoteResult();
		result.setStatues(0);
		result.setMesage("查询分享笔记内容成功");
		result.setData(share);
		return result;
	}

}
