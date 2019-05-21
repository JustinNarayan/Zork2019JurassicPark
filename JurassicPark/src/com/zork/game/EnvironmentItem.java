package com.zork.game;

public class EnvironmentItem {
	private Room room;
	private String type;
	
	public EnvironmentItem(String type, Room room) {
		this.type = type;
		this.room = room;
	}
	
	public String toString() {
		return type;
	}
}
