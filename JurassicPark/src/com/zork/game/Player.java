package com.zork.game;

public class Player {
    private Inventory inventory;

    public Player(){
        inventory = new Inventory();
    }
    
    public Inventory getInventory(){
        return inventory;
    }


}
