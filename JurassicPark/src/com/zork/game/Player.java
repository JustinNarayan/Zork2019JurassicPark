package com.zork.game;

import java.io.BufferedInputStream;
import java.io.BufferedReader;

public class Player {
    private Inventory inventory;

    public Player(BufferedInputStream bis){
        inventory = new Inventory();

    }
    
    public Player() {
	}

	public Inventory getInventory(){
        return inventory;
    }


}
