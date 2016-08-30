package org.tarena.note.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.service.NoteService;
import org.tarena.note.util.NoteResult;
@Controller
@RequestMapping("/note")
public class RecoverNoteController {
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/recovernotes.do")
	@ResponseBody
	public NoteResult execute(String bookId,String noteId){
		return noteService.recoverNote(bookId, noteId);
		
	}
	
}
