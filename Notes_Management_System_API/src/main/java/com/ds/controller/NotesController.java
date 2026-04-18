package com.ds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ds.dto.NotesRequestDto;
import com.ds.dto.NotesResponseDto;
import com.ds.service.NotesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/notes")
public class NotesController {


	
	@Autowired
	private NotesService noteService;
	
	//Create Note
	@PostMapping
	public NotesResponseDto createNote(@Valid @RequestBody NotesRequestDto dto) {
		return noteService.addNote(dto);
	}
	
	//Get All Notes
	@GetMapping()
	public List<NotesResponseDto> getAllNotes(){
		return noteService.getAllNotes();
	}
	
	// Get Note by Id
	@GetMapping("/{id}")
	public NotesResponseDto getNoteById(@PathVariable long id) {
		return noteService.getNoteById(id);
	}
		
	
	
	//Update Note
	@PutMapping("/{id}")
	public NotesResponseDto updateNote(@PathVariable Long id , @Valid @RequestBody NotesRequestDto dto) {
		return noteService.updateNote(id, dto);
	}
	@DeleteMapping("/{id}")
	public String delteNote(@PathVariable Long id) {
		noteService.deleteNote(id);
		return "Note deleted successfully";
	}
	
}
