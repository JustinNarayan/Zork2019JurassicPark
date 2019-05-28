package com.zork.game;

import java.util.ArrayList;
import java.util.Arrays;

public class Phrases {
	private static final ArrayList<String> LOOK = new ArrayList<String>(Arrays.asList("You take a look around.",
			"You observe your surroundings.", "You look around.", "You scan the area.",
			"You examine your surroundings.", "You observe the area.", "You take a glance at the area."));
	private static final ArrayList<String> LOOK_ENV = new ArrayList<String>(Arrays.asList("You are surrounded by ", 
			"You see ", "The area is filled with ", "Around you, you find "));
	private static final ArrayList<String> LOOK_ITEMS = new ArrayList<String>(Arrays.asList("On the ground, you spot ", "You observe on the ground ", "On the floor, you notice ", 
			"On the floor, you find ", "Upon inspection of the ground, you see "));
	private static final ArrayList<String> LOOK_NOTHING = new ArrayList<String>(Arrays.asList("There's practically nothing here.", 
			"The area is mostly empty.", "You can't find very much.", "You have found nothing.", "There isn't anything there."));
	private static final ArrayList<String> LOOK_IN_ENV = new ArrayList<String>(Arrays.asList("You observe something in the ",
			"You think you see something in the ", "You think you'll find something in the ", "You notice a glint in the "));
	private static final String TREX_FLARE = "You have drawn the dinosaur's attention with the flare! You must get rid of it quick otherwise it will catch on and eat you!";
	private static final String EVADE_TREX = "The Tyrannosaurus Rex has followed the flare. You are safe!";
	private static final String EVADE_SPINOSAURUS = "The Spinosaurus has become bored because you are now out of reach and has walked away. You are safe!";
	private static final String EVADE_PTERODACTYL = "The Pterodactyl is having trouble grabbing you. You have to keep going to stay out of reach!";
	private static final String EVADE_DILOPHOSAURUS = "The Dilophosaurus has become incapacitated by the light and moved away. You are safe!";
	
	
	
	
	public static ArrayList<String> getLook() {
		return LOOK;
	}
	public static ArrayList<String> getLookEnv() {
		return LOOK_ENV;
	}
	public static ArrayList<String> getLookItems() {
		return LOOK_ITEMS;
	}
	public static ArrayList<String> getLookNothing() {
		return LOOK_NOTHING;
	}
	public static ArrayList<String> getLookInEnv() {
		return LOOK_IN_ENV;
	}
	public static String getTrexFlare() {
		return TREX_FLARE;
	}
	public static String getEvadeTrex() {
		return EVADE_TREX;
	}
	public static String getEvadeSpinosaurus() {
		return EVADE_SPINOSAURUS;
	}
	public static String getEvadePterodactyl() {
		return EVADE_PTERODACTYL;
	}
	public static String getEvadeDilophosaurus() {
		return EVADE_DILOPHOSAURUS;
	}
}
