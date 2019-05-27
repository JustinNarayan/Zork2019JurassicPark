package com.zork.game;

import java.util.ArrayList;
import java.util.Arrays;

public class Phrases {
	private static final ArrayList<String> LOOK = new ArrayList<String>(Arrays.asList("You take a look around.",
			"You observe your surroundings.", "You look around.", "You scan the area.",
			"You examine your surroundings.", "You observe the area.", "You take a glance at the area."));
	private static final ArrayList<String> LOOK_ENV = new ArrayList<String>(Arrays.asList("You are surrounded by ", 
			"You see ", "The area is filled with ", "Around you, you find "));
	private static final ArrayList<String> LOOK_ITEMS = new ArrayList<String>(Arrays.asList("You spot ", "You observe ", "You notice ", 
			"You find ", "Upon inspection, you see "));
	private static final ArrayList<String> LOOK_NOTHING = new ArrayList<String>(Arrays.asList("There's practically nothing here.", 
			"The area is mostly empty.", "You can't find very much.", "You have found nothing.", "There isn't anything there."));
	private static final ArrayList<String> LOOK_IN_ENV = new ArrayList<String>(Arrays.asList("You observe something in the ",
			"You think you see something in the ", "You think you'll find something in the ", "You notice a glint in the "));
	
	
	
	
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
}
