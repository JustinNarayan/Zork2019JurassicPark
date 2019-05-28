package com.zork.game;

public class Artifacts extends Item {
	private int points;
	private String read;
	private static String dinosaurInfo;
	private static final String DINOSAUR_INFORMATION = Formatter.blockText(
			"There are many different dinosaurs present here in Jurassic Park. Here's some information about all of them.",Formatter.getCutoff(),"\t")
			+ "\n\n\tDilophosaurus\n"
			+ Formatter.blockText("The Dilophosaurus is a small carnivorous dinosaur which spits acid on its prey before "
			+ "eating it. Its eyesight is poor, and is extremely sensitive to light.",Formatter.getCutoff(),"\t")
			+ "\n\n\tBronchiosaurus\n"
			+ Formatter.blockText("The Bronchiosaurus is a tall herbivorous dinosaur which moves slowly and methodically. It "
			+ "primarily eats trees and bushes.",Formatter.getCutoff(),"\t")
			+ "\n\n\tPterodactyl\n"
			+ Formatter.blockText("The Pterodactyl is a flying carnivorous dinosaur which feasts on small prey. It moves quickly but "
			+ "has trouble catching a moving target.",Formatter.getCutoff(),"\t")
			+ "\n\n\tVelociraptor\n"
			+ Formatter.blockText("The Velociraptor is one of the most dangerous dinosaurs in the park. It is an extremely fast "
			+ "carnivore that is practically unstoppable.",Formatter.getCutoff(),"\t")
			+ "\n\n\tTriceratops\n"
			+ Formatter.blockText("The Triceratops is a peaceful herbivorous dinosaur with an extremely large horn. Although it "
			+ "appears threatening, it is quite docile.",Formatter.getCutoff(),"\t")
			+ "\n\n\tSpinosaurus\n"
			+ Formatter.blockText("The Spinosaurus is a large but lazy carnivorous dinosaur. It is quite short and will get bored if it "
			+ "cannot eat its prey quickly.",Formatter.getCutoff(),"\t")
			+ "\n\n\tStegosaurus\n"
			+ Formatter.blockText("The Stegosaurus is a large spiky herbivorous dinosaur which eats roots and leaves. It roams alone "
			+ "and is very peaceful.",Formatter.getCutoff(),"\t")
			+ "\n\n\tTyrannosaurus Rex\n"
			+ Formatter.blockText("The Tyrannosaurus Rex is the largest dinosaur on the island and is certainly the most threatening "
			+ "carnivore. However, it has very poor eyesight and has difficulty tracking motion.",Formatter.getCutoff(),"\t");
	
    public Artifacts(String name, String read, int points, Room room, EnvironmentItem environmentItem) {
    	this.name = name;
    	this.read = read;
    	this.points = points;
    	this.room = room;
    	this.environmentItem = environmentItem;
    	
    	if(environmentItem!=null) {
    		state="in "+environmentItem;
    		this.environmentItem.addItem(this);
    	}
    	else {
    		state="in room";
    		this.room.getRoomInventory().addRoomItem(this);
    	}
    }
    
    public String getRead() {
    	if(!read.equals(DINOSAUR_INFORMATION)) {
    		return Formatter.blockText(read, Formatter.getCutoff(),"\t");
    	} else return read;
    }
    
    public static String getDinosaurInfo() {
    	return DINOSAUR_INFORMATION;
    }
    
    public String getPoints() {
    	return " for " + points + " points";
    }
    
    public int getPointsAmount() {
    	return points;
    }
   
}