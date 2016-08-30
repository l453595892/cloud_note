package org.tarena.note.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.service.NoteService;
import org.tarena.note.util.NoteResult;
import org.tarena.note.vo.SearchBean;

@Controller
@RequestMapping("/note")
public class SearchNotesController {
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/highSearch.do")
	@ResponseBody
	public NoteResult execute(SearchBean params){
		return noteService.searchNotes(params);
	}
}
