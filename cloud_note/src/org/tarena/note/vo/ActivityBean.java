package org.tarena.note.vo;

public class ActivityBean {
	private String cn_note_activity_id;
	private String cn_activity_id;
	private String cn_note_id;
	private String cn_note_activity_title;
	private int current;//第几页
	private int pageSize;//一页几条
	
	
	//SQL中用#{begin}获取
	public int getBegin(){
		int begin = (current-1)*pageSize;
		return begin;
	}
	
	public String getCn_note_activity_id() {
		return cn_note_activity_id;
	}
	public void setCn_note_activity_id(String cnNoteActivityId) {
		cn_note_activity_id = cnNoteActivityId;
	}
	public String getCn_activity_id() {
		return cn_activity_id;
	}
	public void setCn_activity_id(String cnActivityId) {
		cn_activity_id = cnActivityId;
	}
	public String getCn_note_id() {
		return cn_note_id;
	}
	public void setCn_note_id(String cnNoteId) {
		cn_note_id = cnNoteId;
	}
	public String getCn_note_activity_title() {
		return cn_note_activity_title;
	}
	public void setCn_note_activity_title(String cnNoteActivityTitle) {
		cn_note_activity_title = cnNoteActivityTitle;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
