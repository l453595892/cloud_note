package org.tarena.note.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.service.NoteService;
import org.tarena.note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class updatestatusCollectController {
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/collect.do")
	@ResponseBody
	public NoteResult execute(String noteId){
		return noteService.updatestatusCollect(noteId);
		
	}
}
