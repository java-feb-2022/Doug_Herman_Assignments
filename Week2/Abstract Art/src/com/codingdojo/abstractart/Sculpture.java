package com.codingdojo.abstractart;

public class Sculpture extends Art {
	
	private String material;

	public Sculpture(String title, String author, String description, String material) {
		this.title = title;
		this.author = author;
		this.description = description;
		this.material = material;
	}
	
	@Override
	public void viewArt() {
		System.out.printf("%s in %s by %s \n %s\n\n", this.title, this.material, this.author, this.description);

	}

}
