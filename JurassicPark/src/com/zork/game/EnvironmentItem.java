package com.zork.game;

import java.util.ArrayList;

public class EnvironmentItem {
	private Room room;
	private String type;
	private ArrayList<RoomItem> items;;
	
	
	public EnvironmentItem(String type, Room room) {
		this.type = type;
		this.room = room;
		this.items = new ArrayList<RoomItem>();
		
		//DEBUG
		this.addItem(new RoomItem());
	}
	
	public EnvironmentItem(String type, Room room, ArrayList<RoomItem> items) {
		this.type = type;
		this.room = room;
		this.items = items;
	}
	
	public ArrayList<RoomItem> getItems() {
		return items;
	}
	
	public boolean hasItem(String s) {
		for(RoomItem r : items) {
			if(r.toString().equalsIgnoreCase(s)) return true;
		}
		return false;
	}
	
	public void addItem(RoomItem r) {
		items.add(r);
	}
	
	public RoomItem removeItem(RoomItem item) {
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
