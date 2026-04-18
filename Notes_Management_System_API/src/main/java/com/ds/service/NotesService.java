package com.ds.service;

import java.util.List;

import com.ds.dto.NotesRequestDto;
import com.ds.dto.NotesResponseDto;

public interface NotesService {
	/*
		Notes addNote(Notes note);
		
		List<Notes> getAllNotes();
		
		Notes getNoteById(Long id);
		
		Notes updateNote(Long id, Notes note);
		
		void deleteNote(Long id);*/
	
	NotesResponseDto addNote(NotesRequestDto dto);
	List<NotesResponseDto> getAllNotes();
	NotesResponseDto getNoteById(Long id);
	NotesResponseDto updateNote(Long id,NotesRequestDto dto);
	void deleteNote(Long id);
}
