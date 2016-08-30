package org.tarena.note.service.test;

import org.junit.Assert;
import org.junit.Test;
import org.tarena.note.service.UserServiceImpl;
import org.tarena.note.util.NoteResult;
import org.tarena.note.util.SpringTest;

public class TestUserService extends SpringTest{
	@Test
	public void testCheckLogin(){
		UserServiceImpl service=this.getContext().getBean("userServiceImpl",UserServiceImpl.class);
		NoteResult result=service.checkLogin("scott", "1234");
		System.out.println(result.getStatues());
		System.out.println(result.getMesage());
		//断言
		Assert.assertEquals(1, result.getStatues());
		Assert.assertEquals("用户名错误",result.getMesage());
	}
	@Test
	public void checkLogin2(){
		UserServiceImpl service=this.getContext().getBean("userServiceImpl",UserServiceImpl.class);
		NoteResult result=service.checkLogin("demo", "1234");
//		System.out.println(result.getStatues());
//		System.out.println(result.getMesage());
		//断言
		Assert.assertEquals(2, result.getStatues());
		Assert.assertEquals("密码错误",result.getMesage());
	}
	@Test
	public void checkLogin3(){
		UserServiceImpl service=this.getContext().getBean("userServiceImpl",UserServiceImpl.class);
		NoteResult result=service.checkLogin("demo", "123456");
//		System.out.println(result.getStatues());
//		System.out.println(result.getMesage());
		//断言
		Assert.assertEquals(0, result.getStatues());
		Assert.assertEquals("用户名和密码正确",result.getMesage());
	}
}
