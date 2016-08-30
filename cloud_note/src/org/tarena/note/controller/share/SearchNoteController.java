package org.tarena.note.controller.share;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.service.ShareService;
import org.tarena.note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class SearchNoteController {
	@Resource
	private ShareService shareService;
	@RequestMapping("/search.do")
	@ResponseBody
	public NoteResult execute(String noteTitle,int current){
		return shareService.search(noteTitle,current);
		
	}
}
