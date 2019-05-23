package com.zork.game;

import java.util.ArrayList;

public class EnvironmentItem {
	private Room room;
	private String type;
	private ArrayList<UsableItem> items;;
	
	
	public EnvironmentItem(String type, Room room) {
		this.type = type;
		this.room = room;
		this.items = new ArrayList<UsableItem>();
		
		//DEBUG
		this.addItem(new UsableItem());
	}
	
	public EnvironmentItem(String type, Room room, ArrayList<UsableItem> items) {
		this.type = type;
		this.room = room;
		this.items = items;
	}
	
	public ArrayList<UsableItem> getItems() {
		return items;
	}
	
	public boolean hasItem(String s) {
		for(UsableItem r : items) {
			if(r.toString().equalsIgnoreCase(s)) return true;
		}
		return false;
	}
	
	public void addItem(UsableItem r) {
		items.add(r);
	}
	
	public UsableItem removeItem(UsableItem item) {
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
