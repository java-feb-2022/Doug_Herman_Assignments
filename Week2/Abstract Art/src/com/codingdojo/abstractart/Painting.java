package com.codingdojo.abstractart;

public class Painting extends Art {

	private String paintType;

	public Painting(String title, String author, String description, String paintType) {
		this.title = title;
		this.author = author;
		this.description = description;
		this.paintType = paintType;
	}
	
	@Override
	public void viewArt() {
		System.out.printf("%s in %s by %s \n %s\n\n", this.title, this.paintType, this.author, this.description);
	}

}
