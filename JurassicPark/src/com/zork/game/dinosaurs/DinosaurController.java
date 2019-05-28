package com.zork.game.dinosaurs;

import java.util.ArrayList;
import java.util.HashMap;

import com.zork.game.Game;
import com.zork.game.Room;

public class DinosaurController {
	
	//An arraylist containing all of the dinosaurs in the game
	private ArrayList<Dinosaur> dinosaurs = new ArrayList<Dinosaur>();
	
	private boolean aware;
	
	//Last updated dino and status
	private String lastStatus;
	private Dinosaur lastDinosaur;
	
	

	public DinosaurController() {
		aware = false;
		lastStatus = "";
		lastDinosaur = null;
		
		//Initialize all dinosaurs position in specific rooms in different enclosures
	
	
		dinosaurs.add(new Dilophosaurus(getMap().get("QUARRY_S"), "Dilophosaurus1"));
		dinosaurs.add(new Dilophosaurus(getMap().get("RIVER_1_SE"), "Dilophosaurus2"));
		dinosaurs.add(new Bronchiosaurus(getMap().get("BRONCHIOSAURUS_SW"), "Bronchiosaurus1"));
	
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
	
	public boolean isAware() {
		return aware;
	}
	
	protected HashMap<String, Room> getMap() {
		return Game.getMasterRoomMap();
	}
	
	public void checkDinosaurAwareness() {
		setStatus(null,"");
		
		for(Dinosaur d : dinosaurs) {
			d.determineAwareness(this);
		}
	}
	
	public void moveDinosaurs() {
		
		ArrayList<Dinosaur> temp = new ArrayList<Dinosaur>();
		for(Dinosaur d : dinosaurs) {
			//Updates the awareness for dinos already on your trail - this should be the prioritized over new dinos
			if(d.isAware()) {
				d.moveToNewRoom(this);
				d.determineAwareness(this);
			} else {
				temp.add(d);
			}
		}
		
		for(Dinosaur d : temp) {
			//Go through all other dinos
			d.moveToNewRoom(this);
			d.determineAwareness(this);
		}
	}
	
	public void setStatus(Dinosaur dino, String s) {
		System.out.println("");
		if(s.equals("unaware")) {
			System.out.println("There is a " + dino + " within view! Fortunately, it hasn't noticed you yet...");
		} else if(s.equals("aware")) {
			System.out.println("Look out! There is a " + dino + " in the room and it's spotted you!");
		} else if(s.equals("lost")) {
			System.out.println("The " + dino + " has lost your location, for now...");
		} else if(s.equals("follow")) {
			System.out.println("The " + dino + " has followed you into this new area!");
		} else if(s.equals("peace")) {
			System.out.println("There is a peaceful " + dino + " within view. It means you no harm.");
		} else if(s.equals("left")) {
			System.out.println("The " + dino + " has quietly left the area.");
		} else if(s.equals("here")) {
			System.out.println("The " + dino + " is still there in the area, preparing to attack!");
		}
		lastStatus = s;
		lastDinosaur = dino;
	}
	
	public Dinosaur getLastDinosaur() {
		return lastDinosaur;
	}
	
	public String getLastStatus() {
		return lastStatus;
	}
	
	public void removeDinosaur(Dinosaur d) {
		dinosaurs.remove(d);
	}
	
	public void printAllDinosaurs() {
		for(Dinosaur d : dinosaurs) System.out.println(d.toString() + " is in " + d.getCurrentRoom().getRoomName());
	}
}
