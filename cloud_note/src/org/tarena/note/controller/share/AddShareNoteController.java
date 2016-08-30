package org.tarena.note.controller.share;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.service.ShareService;
import org.tarena.note.util.NoteResult;
@Controller
@RequestMapping("/share")
public class AddShareNoteController {
	@Resource
	private ShareService shareService;
	
	@RequestMapping("/sharenote.do")
	@ResponseBody
	public NoteResult execute(String noteId){
				return shareService.share(noteId);
		
	}
}
