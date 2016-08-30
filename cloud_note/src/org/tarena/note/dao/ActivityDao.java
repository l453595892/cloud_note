package org.tarena.note.dao;

import java.util.List;

import org.tarena.note.entity.Activity;
import org.tarena.note.vo.ActivityBean;

public interface ActivityDao {
	public int activity(Activity activity);
	public List<Activity> findActicityNotes(ActivityBean activityBean);
}
