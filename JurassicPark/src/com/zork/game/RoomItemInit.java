package com.zork.game;

import java.util.ArrayList;
import java.util.HashMap;

public class RoomItemInit {

	private static ArrayList<String> roomsWithTrees;
	private static ArrayList<String> roomsWithWater;
	private static ArrayList<String> roomsWithDesks;
	private static ArrayList<Artifacts> artifacts;

	public static void initRooms() {
		roomsWithTrees = new ArrayList<String>();
		roomsWithWater = new ArrayList<String>();
		roomsWithDesks = new ArrayList<String>();
		
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
		roomsWithDesks.add("BREEDING_CENTRE_E");
		roomsWithDesks.add("COMMUNICATIONS_CENTRE_SE");
		roomsWithDesks.add("AQUATIC_SE");
		roomsWithDesks.add("MECHANICAL_ROOM_E");
		roomsWithDesks.add("TREX_CONTROL");
		roomsWithDesks.add("STEGOSAURUS_CONTROL");
		roomsWithDesks.add("VELOCIRAPTOR_CONTROL");
		roomsWithDesks.add("SPINOSAURUS_CONTROL");
		roomsWithDesks.add("BRONCHIOCAURUS_CONTROL");
		roomsWithDesks.add("DILOPHOSAURUS_CONTROL");
		roomsWithDesks.add("PTERODACTYLE_CONTROL");
		roomsWithDesks.add("TRICERATOPS_CONTROL");

		
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
		
	}
	
	private static void initArtifacts() {
		
		//artifacts.add(new Artifacts("name", points, getMap().get("ROOM_NAME"), getMap.get("ROOM_NAME").getRoomInventory().getEnvironmentItem("a desk OR trees OR water"));
		//artifacts.add(new Artifacts("Personnel records", 0, getMap().get("RECORDS_W"), getMap.get("RECORDS_W").getRoomInventory().getEnvironmentItem("a desk"));
		//artifacts.add(new Artifacts("Dinosaur eggshell", 0, getMap().get("AQUATIC_SW"), getMap.get("AQUATIC_SW").getRoomInventory().getEnvironmentItem("water"));
		//artifacts.add(new Artifacts("Dinosaur tooth", 0, getMap().get("FOREST_E"), getMap.get("FOREST_E").getRoomInventory().getEnvironmentItem("trees"));
		
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