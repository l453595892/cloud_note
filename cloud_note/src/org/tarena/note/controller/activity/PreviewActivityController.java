package org.tarena.note.controller.activity;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.service.ActivityService;
import org.tarena.note.util.NoteResult;
@Controller
@RequestMapping("/activity")
public class PreviewActivityController {
	@Resource
	private ActivityService service;
	@RequestMapping("/previewactivity.do")
	@ResponseBody
	public NoteResult execute(String activityId){
		return service.previewActivity(activityId);
		
	}
}
