package com.codingdojo.abstractart;

import java.util.ArrayList;

public class Museum {
	private ArrayList<Painting> paintings;
	private ArrayList<Sculpture> sculptures;
	
	public Museum() {
		paintings = new ArrayList<Painting>();
		sculptures = new ArrayList<Sculpture>();
	}
	
	public void addPainting(String title, String author, String description, String paintType) {
		paintings.add(new Painting(title, author, description, paintType));
	}
	
	public void addSculpture(String title, String author, String description, String material) {
		sculptures.add(new Sculpture(title, author, description, material));
	}
	
	public void viewAllArt() {
		for(Painting painting : paintings)
			painting.viewArt();
		
		for (Sculpture sculpture : sculptures)
			sculpture.viewArt();
	}
}
