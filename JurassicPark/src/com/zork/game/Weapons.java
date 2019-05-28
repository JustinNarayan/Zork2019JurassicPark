package com.zork.game;

import com.zork.game.dinosaurs.Dinosaur;
import com.zork.game.dinosaurs.TyrannosaurusRex;

public class Weapons extends Item {
    public boolean equipped;
    
    public Weapons(String name, Room room) {
    	this.name = name;
    	this.room = room;
    	this.environmentItem = null;
    	
    	state = "in room";
    }
    
    public boolean use(Dinosaur dinosaur) {
    	if(name.indexOf("flashlight")>-1) {
    		if(dinosaur != null && dinosaur.toString().equals("Dilophosaurus")) {
    			System.out.println(Formatter.blockText("You turn on the flashlight and shine "
    					+ "it into the dinosaur's eyes!", Formatter.getCutoff(), ""));
    			System.out.println(Phrases.getEvadeDilophosaurus());
    			dinosaur.evade(Game.getDinosaurController());
    			return true;
    		} else {
    			System.out.println(Formatter.blockText("You turn on the flashlight but there's not very "
    					+ "much you can do with it. You shut it off.", Formatter.getCutoff(), "")); 			
    		}
    	} else if(name.indexOf("flare")>-1) {
    		if(dinosaur != null && dinosaur.toString().equals("Tyrannosaurus Rex")) {
    			System.out.println(Formatter.blockText("You use a flare and draw the Tyrannosaurus Rex's attention! "
    					+ "You have to get rid of it quickly!", Formatter.getCutoff(), ""));
    			((TyrannosaurusRex) dinosaur).becomeStunned();
    			return true;
    		} else {
    			System.out.println(Formatter.blockText("You use the flare but there's not very "
    					+ "much you can do with it.", Formatter.getCutoff(), ""));
    		}
    	} else {
    		super.use(dinosaur);
    	}
    	return false;
   }

    //constructor needs to be done

    public boolean isEquipped(){
        return equipped;        
    }
}