package com.zork.game;

import java.util.ArrayList;

public class RoomInventory extends Inventory {
	private ArrayList<Dinosaurs> dinosaurs = new ArrayList<Dinosaurs>();
	
	public boolean hasDinosaurs() {
		if(dinosaurs.size()>0) return true;
		return false;
	}
}
