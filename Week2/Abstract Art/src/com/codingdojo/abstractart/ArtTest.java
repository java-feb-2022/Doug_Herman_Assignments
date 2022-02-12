package com.codingdojo.abstractart;

public class ArtTest {

	public static void main(String[] args) {
		Museum artGallary = new Museum();
		
		artGallary.addPainting("Title 1", "Painter 1", "Description of #1", "Paint type 1");
		artGallary.addPainting("Title 2", "Painter 2", "Description of #2", "Paint type 2");
		artGallary.addPainting("Title 3", "Painter 3", "Description of #3", "Paint type 3");
		
		artGallary.addSculpture("Title 1", "Sculptor 1", "Description of #1", "Material type 1");
		artGallary.addSculpture("Title 2", "Sculptor 2", "Description of #2", "Material type 2");
		
		artGallary.viewAllArt();
	}

}
