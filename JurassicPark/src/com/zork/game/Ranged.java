package com.zork.game;

public class Ranged extends Weapons{
	private int ammo = 5;

	public Ranged(String name, Room room) {
		super(name, room);		
	}
	
	public int checkAmmo() {
		return ammo;
	}
	public void addAmmo(int n1) {
		ammo+=n1;
	}

}
