package com.zork.game;

import java.util.ArrayList;

import com.zork.game.dinosaurs.Dinosaur;

public class RoomInventory extends Inventory {
	private ArrayList<Dinosaur> dinosaurs = new ArrayList<Dinosaur>();
	private ArrayList<Object> environment;
	private ArrayList<Object> items;
	
	public RoomInventory(ArrayList<Object> environment, ArrayList<Object> items) {
		this.environment = environment;
		this.items = items;
	}
	
	public boolean hasDinosaurs() {
		if(dinosaurs.size()>0) return true;
		return false;
	}
	
	public void addDinosaur(Dinosaur dinosaur) {
		dinosaurs.add(dinosaur);
	}
	
	public boolean removeDinosaur(Dinosaur dinosaur) {
		if(dinosaurs.contains(dinosaur)) {
			dinosaurs.remove(dinosaur);
			return true;
		} else {
			return false;
		}
	}
}
