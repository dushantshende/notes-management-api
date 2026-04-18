package com.ds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.dto.NotesRequestDto;
import com.ds.dto.NotesResponseDto;
import com.ds.entity.Notes;
import com.ds.exception.ResourceNotFoundException;
import com.ds.repository.NotesRepository;

@Service
public class NoteServiceImpl implements NotesService {

	@Autowired
	private NotesRepository notesRepository;
	
	
	
	
	// addNote method
	@Override
	public NotesResponseDto addNote(NotesRequestDto dto) {
		Notes note=new Notes();
		note.setTitle(dto.getTitle());
		note.setContent(dto.getContent());
		
		Notes savedNote= notesRepository.save(note);
		
		NotesResponseDto response =new NotesResponseDto();
		response.setId(savedNote.getId());
		response.setTitle(savedNote.getTitle());
		response.setContent(savedNote.getContent());
		
		return response;
	}

	//getAllNotes Method
	@Override
	public List<NotesResponseDto> getAllNotes() {		
		List<Notes> notesList= notesRepository.findAll();
		
		return notesList.stream().map(note-> {
			NotesResponseDto dto=new NotesResponseDto();
			dto.setId(note.getId());
			dto.setTitle(note.getTitle());
			dto.setContent(note.getContent());
			return dto;
			
		}).toList();
	}
	
	//getNoteById

	@Override
	public NotesResponseDto getNoteById(Long id) {
		
		Notes note= notesRepository.findById(id)
					.orElseThrow(()-> new ResourceNotFoundException("Note not found with id : "+id));
		
		NotesResponseDto dto= new NotesResponseDto();
		dto.setId(note.getId());
		dto.setTitle(note.getTitle());
		dto.setContent(note.getContent());
		
		return dto;
	}

	
	
	//updateNote
	@Override
	public NotesResponseDto updateNote(Long id, NotesRequestDto dto) {
		Notes existing=notesRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Note not found with id : "+id));
		
		
			existing.setContent(dto.getContent());
			existing.setTitle(dto.getTitle());
			
			Notes updateNote= notesRepository.save(existing);
			
			NotesResponseDto response=new NotesResponseDto();
			response.setId(updateNote.getId());
			response.setContent(updateNote.getContent());
			response.setTitle(updateNote.getTitle());
			
			return response;
		}
		
		
	//deleteNote

	@Override
	public void deleteNote(Long id) {
		Notes existing=notesRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Note not found with id : "+id));
		notesRepository.delete(existing);
	}

}
