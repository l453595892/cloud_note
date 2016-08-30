package org.tarena.note.dao.test;

import java.util.List;

import org.junit.Test;
import org.tarena.note.dao.ShareDao;
import org.tarena.note.entity.Share;
import org.tarena.note.util.Page;
import org.tarena.note.util.SpringTest;

public class TestFindPage extends SpringTest{
	
	@Test
	public void test1(){
		ShareDao shareDao = getContext().getBean("shareDao",ShareDao.class);
		
		Page page = new Page();
		page.setCn_share_title("%");
		page.setCurrent(1);
		page.setPageSize(10);
		List<Share> list =shareDao.findPage(page);
		for(Share share : list){
			System.out.println(share.getCn_share_title());
		}
	}
	
}