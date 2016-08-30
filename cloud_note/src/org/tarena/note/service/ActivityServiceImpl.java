package org.tarena.note.service;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tarena.note.dao.ActivityDao;
import org.tarena.note.entity.Activity;
import org.tarena.note.util.NoteResult;
import org.tarena.note.util.NoteUtil;
import org.tarena.note.vo.ActivityBean;
@Service
public class ActivityServiceImpl implements ActivityService{
	@Resource
	private ActivityDao activityDao;
	
	public NoteResult addActivity(String noteId, String noteTitle,
			String noteBody) {
		Activity activity=new Activity();
		//参加活动笔记ID
		String activityId=NoteUtil.createId();
		activity.setCn_note_activity_id(activityId);
		//活动ID(cn_activity)，因为没有活动，所以生成一个
		activity.setCn_activity_id("1");
		//笔记本ID
		activity.setCn_note_id(noteId);
		activity.setCn_note_activity_up(0);
		activity.setCn_note_activity_down(0);
		activity.setCn_note_activity_title(noteTitle);
		activity.setCn_note_activity_body(noteBody);
		activityDao.activity(activity);
		
		NoteResult result=new NoteResult();
		result.setStatues(0);
		result.setMesage("参加活动成功");
		result.setData(activity);
		
		return result;
	}

	public NoteResult showActivity(String activityId, int current,
			int pageSize) {
		ActivityBean activityBean=new ActivityBean();
		activityBean.setCn_activity_id(activityId);
		activityBean.setCurrent(current);
		activityBean.setPageSize(pageSize);
		List<Activity> list=activityDao.findActicityNotes(activityBean);
		NoteResult result=new NoteResult();
		result.setStatues(0);
		result.setMesage("查询参加活动笔记成功");
		result.setData(list);
		return result;
	}

	public NoteResult previewActivity(String activityId) {
		ActivityBean activityBean=new ActivityBean();
		activityBean.setCn_note_activity_id(activityId);
		activityBean.setCurrent(1);
		activityBean.setPageSize(1);
		List<Activity> list=activityDao.findActicityNotes(activityBean);
		NoteResult result=new NoteResult();
		result.setStatues(0);
		result.setMesage("查询参加活动笔记内容成功");
		result.setData(list);
		return result;
	}

}
