package org.tarena.note.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.service.UserService;
import org.tarena.note.util.NoteResult;

@Controller
@RequestMapping("/user")
public class ChangePassWordController {
	@Resource
	private UserService userService;
	@RequestMapping("/changepassword.do")
	@ResponseBody
	public NoteResult execute(String userId,String passWord){
		return userService.changePassword(userId, passWord);
		
	}
}
