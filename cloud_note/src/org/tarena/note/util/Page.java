package org.tarena.note.util;

import java.io.Serializable;

public class Page implements Serializable{
	private String cn_share_title;
	private int current;//第几页
	private int pageSize;//一页几条
	
	//SQL中用#{begin}获取
	public int getBegin(){
		int begin = (current-1)*pageSize;
		return begin;
	}
		
	public String getCn_share_title() {
		return cn_share_title;
	}
	public void setCn_share_title(String cnShareTitle) {
		cn_share_title = cnShareTitle;
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
