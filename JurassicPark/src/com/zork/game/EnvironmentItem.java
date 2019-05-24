package com.zork.game;

import java.util.ArrayList;

public class EnvironmentItem {
	private Room room;
	private String type;
	private ArrayList<Item> items;;
	
	
	public EnvironmentItem(String type, Room room) {
		this.type = type;
		this.room = room;
		this.items = new ArrayList<Item>();
		
		//DEBUG
		this.addItem(new Item());
	}
	
	public EnvironmentItem(String type, Room room, ArrayList<Item> items) {
		this.type = type;
		this.room = room;
		this.items = items;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public boolean hasItem(String s) {
		for(Item r : items) {
			if(r.toString().equalsIgnoreCase(s)) return true;
		}
		return false;
	}
	
	public void addItem(Item r) {
		items.add(r);
	}
	
	public Item removeItem(Item item) {
		if(hasItem(item.toString())) {
			for(int i = 0; i < items.size(); i++) {
				if(items.get(i).toString().equalsIgnoreCase(item.toString())) {
					return items.remove(i);
				}
			}
		}
		return null;
	}	
	
	public String toString() {
		return type;
	}
}
