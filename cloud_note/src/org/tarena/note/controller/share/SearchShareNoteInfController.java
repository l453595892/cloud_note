package org.tarena.note.controller.share;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import org.springframework.stereotype.Controller;
import org.tarena.note.service.ShareService;
import org.tarena.note.util.NoteResult;

@Controller
@RequestMapping("/share")
public class SearchShareNoteInfController {
	@Resource
	private ShareService shareService;
	@RequestMapping("/showshare.do")
	@ResponseBody
	public NoteResult execute(String shareId){
		return shareService.show(shareId);
		
	}
	
}
