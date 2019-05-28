package com.zork.game;

import java.util.ArrayList;

import com.zork.game.dinosaurs.Dinosaur;

public class RoomInventory extends Inventory {
	private ArrayList<Dinosaur> dinosaurs = new ArrayList<Dinosaur>();
	private ArrayList<EnvironmentItem> environment;
	private ArrayList<Item> items;
	
	public RoomInventory(ArrayList<EnvironmentItem> environment, ArrayList<Item> items) {
		this.environment = environment;
		this.items = items;
	}
	
	public boolean hasDinosaurs() {
		if(dinosaurs.size()>0) return true;
		return false;
	}
	
	public Dinosaur getDinosaur() {
		if(hasDinosaurs()) return dinosaurs.get(0);
		else return null;
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
	
	public ArrayList<EnvironmentItem> getEnvironment() {
		return environment;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	
	
	public EnvironmentItem addItemEnvironment(EnvironmentItem e) {
		environment.add(e);
		return e;
	}
	
	public Item addRoomItem(Item e) {
		items.add(e);
		return e;
	}
	
	//Takes in toString() essentially
	public boolean environmentHasItem(String s) {
		for(EnvironmentItem obj : environment) {
			if(obj.toString().equalsIgnoreCase(s) || (obj.toString().length()>1 && obj.toString().substring(2).equals(s))) return true;
		}
		return false;
	}
	
	//Takes in toString() essentially
	public boolean roomHasItem(String s) {
		for(Item obj : items) {
			if(obj.toString().toLowerCase().indexOf(s.toLowerCase())>-1) {
				return true;
			}
		}
		return false;
	}
	
	//Takes in toString() essentially
	public EnvironmentItem getEnvironmentItem(String s) {
		if(environmentHasItem(s)) {
			for(EnvironmentItem obj : environment) {
				if(obj.toString().toLowerCase().indexOf(s.toLowerCase())>-1) return obj;
			}
		}
		return null;
	}
	
	//Takes in toString() essentially
	public Item getRoomItem(String s) {
		if(roomHasItem(s)) {
			for(Item obj : items) {
				if(obj.toString().toLowerCase().indexOf(s.toLowerCase())>-1) return obj;
			}
		}
		return null;
	}
	
	//Takes in toString() essentially
	public Item removeRoomItem(String s) {
		if(roomHasItem(s)) {
			for(int i = 0; i < items.size(); i++) {
				if(items.get(i).toString().equalsIgnoreCase(s) || (items.get(i).toString().substring(0,2).equalsIgnoreCase("a ") && items.get(i).toString().indexOf(" ",2)>2 && items.get(i).toString().substring(0,items.get(i).toString().indexOf(" ",2)).equalsIgnoreCase(s))) {
					return items.remove(i);
				}
			}
		}
		return null;
	}
	
	public void list() {
		for(Item obj: items) {
			System.out.println(obj);
		}
	}
}
