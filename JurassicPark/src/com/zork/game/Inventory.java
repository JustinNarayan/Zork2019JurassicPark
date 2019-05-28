package com.zork.game;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.text.Document;

public class Inventory {
	private static final int NUM_INVENTORIES = 3;

	private ArrayList<Item> inventoryItems = new ArrayList<Item>();

	public ArrayList<Weapons> weaponsInventory;
	public ArrayList<Artifacts> artifactInventory;
	public static ArrayList[] masterInventory;

	public Inventory() {
		artifactInventory = new ArrayList<Artifacts>();
		weaponsInventory = new ArrayList<Weapons>();
		masterInventory = new ArrayList[NUM_INVENTORIES];
		masterInventory[0] = artifactInventory;
		masterInventory[1] = weaponsInventory;
	}

	public void addInventoryItem(Item item) {
		inventoryItems.add(item);
	}

	// Returns the object that you search for and delete
	// If item does not exist returns null
	/*
	 * public Object removeInventoryItem(Object item) { int position =
	 * isInInventory(item); if (position == -1) return null; else { return
	 * inventoryItems.remove(position); } }
	 */
	// Returns the index of the item in the ArrayList
	// If does not exist, returns -1

	// Prints out a startstring such as "This room contains:" followed
	// by every item's toString() on its own line
	public void printInventory(String startstring, boolean showNumber) {
		System.out.println(startstring);
		int i = 1;
		for (Item o : inventoryItems) {
			if(showNumber) System.out.print("Item "+i+": ");
			System.out.println(o.getNameLowerCase()+o.getPoints());
			i++;
		}
	}

	public void printMaster() {
		if(masterInventory==null){
			System.out.println("The inventory is empty");
		}
		for (ArrayList<Item> i : masterInventory) {
			for (Item j : i) {
				System.out.println(j.getName());
			}
		}
	}

	public Item isInInventory(String item) {
		
		/*if(masterInventory == null){
			return false;
		}
		for (int i =0; i<masterInventory.length;i++) {
			if (individualIndex(masterInventory[i], item) != -1) {
				return true;
			}
		}
		return false;*/
		
		if(inventoryItems.size() == 0) {
			return null;
		}
		for(Item obj : inventoryItems) {
			if(obj.toString().equalsIgnoreCase(item) ||
					obj.toString().toLowerCase().indexOf(item.toLowerCase())>-1) return obj;
		}
		return null;
	}
			
	

	public Item getItem(String name) {
		/*int inventoryNum = getInventoryType(name);
		int index = individualIndex(masterInventory[inventoryNum], name);
		return (Item) masterInventory[inventoryNum].get(index);*/
		
		for(Item i : inventoryItems) {
			if(i.getNameLowerCase().indexOf(name)>-1) return i;
		}
		return null;
	}
	
	public Item getItem(int i) {
		return inventoryItems.get(i);
	}
	
	

	public int getInventoryType(String name) {
		if (Arrays.asList(artifactInventory).indexOf(name) != -1) {
			return 0;
		} else if (Arrays.asList(weaponsInventory).indexOf(name) != -1) {
			return 1;
		} else {
			return 2;
		}

	}

	private int individualIndex(ArrayList arr, String name) {
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).equals(name)) {
				return i;
			}
		}
		return -1;
	}

	public Item removeItem(String name) {
		if(isInInventory(name)!=null) {
			Item i = isInInventory(name);
			inventoryItems.remove(i);
			return i;
		}
		else return null;
	}
	
	public Item removeItem(int i) {
		Item item = (Item) inventoryItems.remove(i);
		item.setEnvironmentItem(null);
		item.setRoom(Game.getCurrentRoom());
		return item;
	}
	
	public ArrayList<Item> getInventoryItems() {
		return inventoryItems;
	}

}
