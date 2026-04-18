package com.ds.dto;

public class NotesResponseDto {

	private Long id;
	private String content;
	private String title;
	
	//getter and setter
	
	public Long getId() {
		return id;
		
	}
	public void setId(Long id ) {
		this.id=id;
		
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content=content;
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title=title;
	}
}
