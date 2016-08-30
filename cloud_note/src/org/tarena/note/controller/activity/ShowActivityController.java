package org.tarena.note.controller.activity;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.service.ActivityService;
import org.tarena.note.util.NoteResult;
@Controller
@RequestMapping("/activity")
public class ShowActivityController {
	@Resource
	private ActivityService service;
	
	@RequestMapping("/showactivity.do")
	@ResponseBody
	public NoteResult execute(String activityId,int current,int pageSize){
		return service.showActivity(activityId, current, pageSize);
		
	}
}
