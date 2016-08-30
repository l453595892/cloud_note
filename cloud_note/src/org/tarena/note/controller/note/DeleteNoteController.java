package org.tarena.note.controller.note;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.service.NoteService;
import org.tarena.note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class DeleteNoteController {
	@Resource
	private NoteService noteService;
	@RequestMapping("/deletenotes.do")
	@ResponseBody
	public NoteResult execute(String noteId){
		return noteService.deleteNote(noteId);
		
	}
}
