package org.tarena.note.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tarena.note.dao.UserDao;
import org.tarena.note.entity.User;
import org.tarena.note.util.NoteResult;
import org.tarena.note.util.NoteUtil;
@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	
	/**
	 * 注册方法
	 */
	public NoteResult registUser(String username, String password,
			String nickname) {
		NoteResult result=new NoteResult();
		//检测用户名是否注册
		User dbUser=userDao.findByName(username);
		if(dbUser!=null){
			result.setStatues(1);
			result.setMesage("用户名存在");
			return result;
		}
		//注册操作
		User user=new User();
		String userId=NoteUtil.createId();
		user.setCn_user_id(userId);
		user.setCn_user_name(username);
		user.setCn_user_password(NoteUtil.md5(password));
		user.setCn_user_desc(nickname);
		user.setCn_user_token(null);
		userDao.save(user);
		result.setStatues(0);
		result.setMesage("注册成功");
		return result;
	}
	/**
	 * 登录方法
	 */
	public NoteResult checkLogin(String username, String password) {
		NoteResult result=new NoteResult();
		User user=userDao.findByName(username);
		List<String> data=new ArrayList<String>(); 
		//检测用户名
		if(user==null){
			result.setStatues(1);
			result.setMesage("用户名错误");
//			result.setData(null);
			return result;
		}
		//检测密码
		//将用户写入的密码加密
		String md5_password=NoteUtil.md5(password);
		//将加密结果和数据表中的密文对比
		if(!user.getCn_user_password().equals(md5_password)){
			result.setStatues(2);
			result.setMesage("密码错误");
			return result;
		}
		result.setStatues(0);
		result.setMesage("用户名和密码正确");
		data.add(user.getCn_user_id());
		data.add(user.getCn_user_name());
		data.add(user.getCn_user_password());
		result.setData(data);
		
		return result;
	}
	public NoteResult changePassword(String userId, String passWord) {
		User user=new User();
		user.setCn_user_id(userId);
		String Passworld=NoteUtil.md5(passWord);
		user.setCn_user_password(Passworld);
		
		userDao.chagePassword(user);
		NoteResult result=new NoteResult();
		result.setStatues(0);
		result.setMesage("修改密码成功");
		return result;
	}

	
}
