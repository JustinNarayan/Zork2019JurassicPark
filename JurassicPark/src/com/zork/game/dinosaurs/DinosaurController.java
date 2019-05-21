package com.zork.game.dinosaurs;

import java.util.ArrayList;
import java.util.HashMap;

import com.zork.game.Game;
import com.zork.game.Room;

public class DinosaurController {
	
	//An arraylist containing all of the dinosaurs in the game
	private ArrayList<Dinosaur> dinosaurs = new ArrayList<Dinosaur>();

	public DinosaurController() {
		//Initialize all dinosaurs position in specific rooms in different enclosures
		dinosaurs.add(new Bronchiosaurus(getMap().get("BRONCHIOSAURUS_SW"), "Bronchiosaurus1"));
	
		dinosaurs.add(new Dilophosaurus(getMap().get("QUARRY_S"), "Dilophosaurus1"));
		dinosaurs.add(new Dilophosaurus(getMap().get("RIVER_1_SE"), "Dilophosaurus2"));
		
		dinosaurs.add(new Pterodactyl(getMap().get("BRIDGE_N"), "Pterodactyl1"));
		dinosaurs.add(new Pterodactyl(getMap().get("PTERODACTYL_NE"), "Pterodactyl2"));
		
		dinosaurs.add(new Spinosaurus(getMap().get("SPINOSAURUS_NE"), "Spinosaurus1"));
		dinosaurs.add(new Spinosaurus(getMap().get("BEACH_1_S"), "Spinosaurus2"));
	
		dinosaurs.add(new Stegosaurus(getMap().get("STEGOSAURUS_SE"), "Stegosaurus1"));
		dinosaurs.add(new Stegosaurus(getMap().get("RECORDS_E"), "Stegosaurus2"));
	
		dinosaurs.add(new Triceratops(getMap().get("TRICERATOPS_SE"), "Triceratops1"));
		
		dinosaurs.add(new TyrannosaurusRex(getMap().get("TREX_NE"), "TyrannosaurusRex1"));
		
		dinosaurs.add(new Velociraptor(getMap().get("VELOCIRAPTOR_NW"), "Eileen"));
		dinosaurs.add(new Velociraptor(getMap().get("CLIFF_1_SE"), "Velociraptor2"));
		dinosaurs.add(new Velociraptor(getMap().get("HILLS_NE"), "Velociraptor3"));
	}
	
	protected HashMap<String, Room> getMap() {
		return Game.getMasterRoomMap();
	}
	
	public void printAllDinosaurs() {
		for(Dinosaur d : dinosaurs) System.out.println(d.toString() + " is in " + d.getCurrentRoom().getRoomName());
	}
}
