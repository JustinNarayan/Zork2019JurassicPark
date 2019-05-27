package com.zork.game;

import java.io.BufferedInputStream;
import java.io.BufferedReader;

public class Player {
	public Inventory inventory;
	public boolean inTree;
	private boolean dead;
	private boolean success;

    public Player(BufferedInputStream bis){
        inventory = new Inventory();
        dead = false;
        inTree = false;
        success = false;
    }
    
    public Player() {
    	inventory = new Inventory();
        dead = false;
        inTree = false;
	}

	public Inventory getInventory(){
        return inventory;
    }

	public void use(Consumables current) {
	}

	public void equip(Item item) {
	}

	public void unequip(String secondWord) {
	}

	public void isInTree(boolean b) {
		inTree = b;
	}
	
	public void hasDied() {
		dead = true;
	}
	
	public boolean isDead() {
		return dead;
	}

	public int calculatePoints() {
		return 0;
	}
	
	public void gainSuccess() {
		success = true;
	}
	
	public boolean hasSucceeded() {
		return success;
	}


}
