package org.tarena.note.util;

import java.io.Serializable;
/**
 * 作为服务器返回JSON格式的结果对象
 * @author soft01
 *
 */
public class NoteResult implements Serializable{
	private int statues;//处理状态
	private String mesage;//返回的消息
	private Object data;//返回的数据
	public int getStatues() {
		return statues;
	}
	public void setStatues(int statues) {
		this.statues = statues;
	}
	public String getMesage() {
		return mesage;
	}
	public void setMesage(String mesage) {
		this.mesage = mesage;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	

}
