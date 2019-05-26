package com.zork.game;

import java.util.ArrayList;
import java.util.HashMap;

public class RoomItemInit {

	private static ArrayList<String> roomsWithTrees;
	private static ArrayList<String> roomsWithWater;
	private static ArrayList<String> roomsWithDesks;
	private static ArrayList<String> roomsWithTables;
	private static ArrayList<Artifacts> artifacts;

	public static void initRooms() {
		roomsWithTrees = new ArrayList<String>();
		roomsWithWater = new ArrayList<String>();
		roomsWithDesks = new ArrayList<String>();
		roomsWithTables = new ArrayList<String>();
		
		initEnvironmentItems();
		
		artifacts = new ArrayList<Artifacts>();
		
		initArtifacts();
	}
	
	private static void initEnvironmentItems() {

		// All hallways/pathways have trees in them
		roomsWithTrees.add("HALLWAY_1");
		roomsWithTrees.add("HALLWAY_2");
		roomsWithTrees.add("HALLWAY_3");
		roomsWithTrees.add("HALLWAY_4");
		roomsWithTrees.add("HALLWAY_5");
		roomsWithTrees.add("HALLWAY_6");
		roomsWithTrees.add("HALLWAY_7");
		roomsWithTrees.add("HALLWAY_8");
		roomsWithTrees.add("HALLWAY_9");
		roomsWithTrees.add("HALLWAY_10");
		roomsWithTrees.add("HALLWAY_11");
		roomsWithTrees.add("HALLWAY_12");
		roomsWithTrees.add("HALLWAY_13");
		roomsWithTrees.add("HALLWAY_14");
		roomsWithTrees.add("HALLWAY_15");
		roomsWithTrees.add("HALLWAY_16");
		roomsWithTrees.add("HALLWAY_17");
		roomsWithTrees.add("HALLWAY_18");
		roomsWithTrees.add("HALLWAY_19");
		roomsWithTrees.add("HALLWAY_20");
		roomsWithTrees.add("HALLWAY_21");
		roomsWithTrees.add("HALLWAY_22");
		roomsWithTrees.add("HALLWAY_23");
		roomsWithTrees.add("HALLWAY_24");
		roomsWithTrees.add("HALLWAY_25");
		roomsWithTrees.add("HALLWAY_26");
		roomsWithTrees.add("HALLWAY_27");
		roomsWithTrees.add("HALLWAY_28");
		roomsWithTrees.add("HALLWAY_29");
		roomsWithTrees.add("HALLWAY_30");
		roomsWithTrees.add("HALLWAY_31");

		// Herbivore enclosures with trees in them
		roomsWithTrees.add("BRONCHIOSAURUS_NW");
		roomsWithTrees.add("BRONCHIOSAURUS_NE");
		roomsWithTrees.add("BRONCHIOSAURUS_SW");
		roomsWithTrees.add("BRONCHIOSAURUS_SE");

		roomsWithTrees.add("TRICERATOPS_NW");
		roomsWithTrees.add("TRICERATOPS_NE");
		roomsWithTrees.add("TRICERATOPS_SW");
		roomsWithTrees.add("TRICERATOPS_NE");

		roomsWithTrees.add("STEGOSAURUS_NW");
		roomsWithTrees.add("STEGOSAURUS_NE");
		roomsWithTrees.add("STEGOSAURUS_SW");
		roomsWithTrees.add("STEGOSAURUS_SE");

		roomsWithTrees.add("VELOCIRAPTOR_NE");
		roomsWithTrees.add("VELOCIRAPTOR_NW");
		roomsWithTrees.add("VELOCIRAPTOR_NC");
		roomsWithTrees.add("VELOCIRAPTOR_SW");
		roomsWithTrees.add("VELOCIRAPTOR_SC");

		// Specific rooms with trees in them
		roomsWithTrees.add("EQUIPMENT_YARD");
		roomsWithTrees.add("QUARRY_N");
		roomsWithTrees.add("QUARRY_S");
		roomsWithTrees.add("BEACH_1_S");
		roomsWithTrees.add("BEACH_1_C");
		roomsWithTrees.add("MOUNTAIN_TOP");
		roomsWithTrees.add("PLAINS_E");
		roomsWithTrees.add("PLAINS_W");
		roomsWithTrees.add("HILLS_NW");
		roomsWithTrees.add("HILLS_NE");
		roomsWithTrees.add("HILLS_SW");
		roomsWithTrees.add("HILLS_SE");
		roomsWithTrees.add("JUNGLE_NW");
		roomsWithTrees.add("JUNGLE_NE");
		roomsWithTrees.add("JUNGLE_SW");
		roomsWithTrees.add("JUNGLE_SE");
		roomsWithTrees.add("FOREST_E");
		roomsWithTrees.add("FOREST_W");
		roomsWithTrees.add("CABIN");
		roomsWithTrees.add("RIVER_1_SW");
		roomsWithTrees.add("RIVER_1_SE");
		roomsWithTrees.add("PTERODACTYL_NE");
		
		// Rooms with water
		roomsWithWater.add("WATERFALL");
		roomsWithWater.add("RIVER_2_E");
		roomsWithWater.add("RIVER_2_W");
		roomsWithWater.add("BEACH_1_N");
		roomsWithWater.add("BEACH_1_C");
		roomsWithWater.add("BEACH_1_S");
		roomsWithWater.add("BEACH_2_N");
		roomsWithWater.add("BEACH_2_S");
		roomsWithWater.add("LAKE");
		roomsWithWater.add("RIVER_1_SE");
		roomsWithWater.add("RIVER_1_NE");
		roomsWithWater.add("RIVER_1_SW");
		roomsWithWater.add("AQUATIC_SW");
		roomsWithWater.add("AQUATIC_SE");
		roomsWithWater.add("TREX_SC");
		roomsWithWater.add("STEGOSAURUS_SW");
		roomsWithWater.add("VELOCIRAPTOR_SW");
		roomsWithWater.add("SPINOSAURUS_SW");
		roomsWithWater.add("BRONCHIOSAURUS_SE");
		roomsWithWater.add("TRICERATOPS_SE");
		
		
		//Rooms with Desks
		roomsWithDesks.add("MAIN_CONTROL_CENTRE_NW");
		roomsWithDesks.add("MAIN_CONTROL_CENTRE_NE");
		roomsWithDesks.add("RECORDS_W");
		roomsWithDesks.add("COMMUNICATIONS_CENTRE_SE");
		roomsWithDesks.add("AQUATIC_SE");
		roomsWithDesks.add("MECHANICAL_ROOM_E");
		roomsWithDesks.add("TREX_CONTROL");
		roomsWithDesks.add("STEGOSAURUS_CONTROL");
		roomsWithDesks.add("VELOCIRAPTOR_CONTROL");
		roomsWithDesks.add("SPINOSAURUS_CONTROL");
		roomsWithDesks.add("BRONCHIOSAURUS_CONTROL");
		roomsWithDesks.add("DILOPHOSAURUS_CONTROL");
		roomsWithDesks.add("PTERODACTYL_CONTROL");
		roomsWithDesks.add("TRICERATOPS_CONTROL");
		roomsWithDesks.add("CABIN");
		roomsWithDesks.add("STAFF_QUARTERS_SW");
		
		
		//Rooms with Tables
		roomsWithTables.add("BREEDING_CENTRE_E");
		roomsWithTables.add("BREEDING_CENTRE_C");
		roomsWithTables.add("AQUATIC_NW");
		roomsWithTables.add("MUNITIONS_SHED_SW");
		
		//Add all of these items to room
		for(String s : roomsWithTrees) {
			getMap().get(s).getRoomInventory().addItemEnvironment(new EnvironmentItem("trees", getMap().get(s)));
		}
		for(String s : roomsWithWater) {
			getMap().get(s).getRoomInventory().addItemEnvironment(new EnvironmentItem("water", getMap().get(s)));
		}
		for(String s : roomsWithDesks) {
			getMap().get(s).getRoomInventory().addItemEnvironment(new EnvironmentItem("a desk", getMap().get(s)));
		}
		
		for(String s : roomsWithTables) {
			getMap().get(s).getRoomInventory().addItemEnvironment(new EnvironmentItem("a table", getMap().get(s)));
		}
		
	}
	
	private static void initArtifacts() {
		
		//artifacts.add(new Artifacts("NAME", points, getMap().get("ROOM NAME"), getMap().get("ROOM NAME").getRoomInventory().getEnvironmentItem("LOCATION")));
		
		// Artifacts in a tree
		artifacts.add(new Artifacts("A bone from a Stegosaurus", 7, getMap().get("HALLWAY_25"), getMap().get("HALLWAY_25").getRoomInventory().getEnvironmentItem("trees")));
		artifacts.add(new Artifacts("A tooth from the T-Rex", 9, getMap().get("HALLWAY_23"), getMap().get("HALLWAY_23").getRoomInventory().getEnvironmentItem("trees")));
		artifacts.add(new Artifacts("A tooth from a Stegosaurus", 7, getMap().get("STEGOSAURUS_SW"), getMap().get("STEGOSAURUS_SW").getRoomInventory().getEnvironmentItem("trees")));
		artifacts.add(new Artifacts("A tooth from a Stegosaurus", 6, getMap().get("HALLWAY_14"), getMap().get("HALLWAY_14").getRoomInventory().getEnvironmentItem("trees")));
		artifacts.add(new Artifacts("A tooth from a Velociraptor", 8, getMap().get("VELOCIRAPTOR_SW"), getMap().get("VELOCIRAPTOR_SW").getRoomInventory().getEnvironmentItem("trees")));
		artifacts.add(new Artifacts("A tooth from a Velociraptor", 8, getMap().get("JUNGLE_SE"), getMap().get("JUNGLE_SE").getRoomInventory().getEnvironmentItem("trees")));
		artifacts.add(new Artifacts("A tooth from a Triceratops", 7, getMap().get("TRICERATOPS_SW"), getMap().get("TRICERATOPS_SW").getRoomInventory().getEnvironmentItem("trees")));
		artifacts.add(new Artifacts("A bone from a Velociraptor", 8, getMap().get("HILLS_SE"), getMap().get("HILLS_SE").getRoomInventory().getEnvironmentItem("trees")));
		artifacts.add(new Artifacts("A bone from a Spinosaurus", 6, getMap().get("PLAINS_E"), getMap().get("PLAINS_E").getRoomInventory().getEnvironmentItem("trees")));
		artifacts.add(new Artifacts("A bone from a Spinosaurus", 6, getMap().get("MOUNTAIN_TOP"), getMap().get("MOUNTAIN_TOP").getRoomInventory().getEnvironmentItem("trees")));
		artifacts.add(new Artifacts("A tooth from a Dilophosaurus", 7, getMap().get("QUARRY_S"), getMap().get("QUARRY_S").getRoomInventory().getEnvironmentItem("trees")));
		artifacts.add(new Artifacts("An egg shell from a Pterodactyl", 7, getMap().get("PTERODACTYL_NE"), getMap().get("PTERODACTYL_NE").getRoomInventory().getEnvironmentItem("trees")));
		artifacts.add(new Artifacts("A bone from a Bronchisaurus", 6, getMap().get("HALLWAY_3"), getMap().get("HALLWAY_3").getRoomInventory().getEnvironmentItem("trees")));
			
		// Artifacts in a desk
		artifacts.add(new Artifacts("A journal kept by a member of staff", 7, getMap().get("STAFF_QUARTERS_SW"), getMap().get("STAFF_QUARTERS_SW").getRoomInventory().getEnvironmentItem("a desk")));
		artifacts.add(new Artifacts("A journal kept by a communications staff", 8, getMap().get("COMMUNICATIONS_CENTRE_SE"), getMap().get("COMMUNICATIONS_CENTRE_SE").getRoomInventory().getEnvironmentItem("a desk")));
		artifacts.add(new Artifacts("A journal from the server room staff", 10, getMap().get("SERVER_ROOM"), getMap().get("SERVER_ROOM").getRoomInventory().getEnvironmentItem("a desk")));
		artifacts.add(new Artifacts("A diary from a previous resident of this cabin", 9, getMap().get("CABIN"), getMap().get("CABIN").getRoomInventory().getEnvironmentItem("a desk")));
		
		/*do not touch - to be added 
		artifacts.add(new Artifacts("", , getMap().get(""), getMap().get("").getRoomInventory().getEnvironmentItem("a desk")));
		artifacts.add(new Artifacts("", , getMap().get(""), getMap().get("").getRoomInventory().getEnvironmentItem("a desk")));
		artifacts.add(new Artifacts("", , getMap().get(""), getMap().get("").getRoomInventory().getEnvironmentItem("a desk")));
		artifacts.add(new Artifacts("", , getMap().get(""), getMap().get("").getRoomInventory().getEnvironmentItem("a desk")));
		artifacts.add(new Artifacts("", , getMap().get(""), getMap().get("").getRoomInventory().getEnvironmentItem("a desk")));
		artifacts.add(new Artifacts("", , getMap().get(""), getMap().get("").getRoomInventory().getEnvironmentItem("a desk")));
		artifacts.add(new Artifacts("", , getMap().get(""), getMap().get("").getRoomInventory().getEnvironmentItem("a desk")));
		artifacts.add(new Artifacts("", , getMap().get(""), getMap().get("").getRoomInventory().getEnvironmentItem("a desk")));
		artifacts.add(new Artifacts("", , getMap().get(""), getMap().get("").getRoomInventory().getEnvironmentItem("a desk")));
		artifacts.add(new Artifacts("", , getMap().get(""), getMap().get("").getRoomInventory().getEnvironmentItem("a desk")));
		artifacts.add(new Artifacts("", , getMap().get(""), getMap().get("").getRoomInventory().getEnvironmentItem("a desk")));
		*/
		
		// Artifacts in water
		artifacts.add(new Artifacts("The egg shell from a Spinosaurus", 7, getMap().get("BEACH_1_N"), getMap().get("BEACH_1_N").getRoomInventory().getEnvironmentItem("water")));
		artifacts.add(new Artifacts("A tooth from a Stegosaurus", 8, getMap().get("LAKE"), getMap().get("LAKE").getRoomInventory().getEnvironmentItem("water")));
		artifacts.add(new Artifacts("A tooth from the T-Rex", 10, getMap().get("TREX_SC"), getMap().get("TREX_SC").getRoomInventory().getEnvironmentItem("water")));
		artifacts.add(new Artifacts("A tooth from the T-Rex", 8, getMap().get("RIVER_W"), getMap().get("RIVER_2_W").getRoomInventory().getEnvironmentItem("water")));
		artifacts.add(new Artifacts("A tooth from a Velociraptor", 8, getMap().get("BEACH_2_N"), getMap().get("BEACH_2_N").getRoomInventory().getEnvironmentItem("water")));
		
		
		// Artifacts on a table
		artifacts.add(new Artifacts("An aquatic dinosaur's bone", 6, getMap().get("AQUATIC_NW"), getMap().get("AQUATIC_NW").getRoomInventory().getEnvironmentItem("a table")));
		artifacts.add(new Artifacts("A set of personnel records for the security agency", 6, getMap().get("MUNITIONS_SHED_SW"), getMap().get("MUNITIONS_SHED_SW").getRoomInventory().getEnvironmentItem("a table")));
		artifacts.add(new Artifacts("The egg shell from a Velociraptor", 8, getMap().get("BREEDING_CENTRE_E"), getMap().get("BREEDING_CENTRE_E").getRoomInventory().getEnvironmentItem("a table")));
		artifacts.add(new Artifacts("The egg shell from a Bronchiosaurus", 5, getMap().get("BREEDING_CENTRE_C"), getMap().get("BREEDING_CENTRE_C").getRoomInventory().getEnvironmentItem("a table")));
	}
	
	private static HashMap<String, Room> getMap() {
		return Game.getMasterRoomMap();
	}
	
	public boolean addInRoomEnvironment(Room room, Item item, String type) {
		if(room.getRoomInventory().getEnvironmentItem(type) != null) {
			room.getRoomInventory().getEnvironmentItem(type).addItem(item);
			return true;
		}
		else return false;
	}
}