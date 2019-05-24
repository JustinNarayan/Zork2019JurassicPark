package com.zork.game;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.text.Document;

public class Inventory {
	private static final int NUM_INVENTORIES = 3;

	private ArrayList<Object> inventoryItems = new ArrayList<Object>();

	public ArrayList<Weapons> weaponsInventory;
	public ArrayList<Documents> docInventory;
	public ArrayList<Consumables> consumablesInventory;
	public ArrayList[] masterInventory;

	public Inventory() {
		docInventory = new ArrayList<Documents>();
		weaponsInventory = new ArrayList<Weapons>();
		consumablesInventory = new ArrayList<Consumables>();
		masterInventory = new ArrayList[NUM_INVENTORIES];
		masterInventory[0] = docInventory;
		masterInventory[1] = weaponsInventory;
		masterInventory[2] = consumablesInventory;
	}

	public void addInventoryItem(Object item) {
		inventoryItems.add(item);
	}

	// Returns the object that you search for and delete
		// If item does not exist returns null
	/*public Object removeInventoryItem(Object item) {
		int position = isInInventory(item);
		if (position == -1)
			return null;
		else {
			return inventoryItems.remove(position);
		}
	}
*/
	// Returns the index of the item in the ArrayList
	// If does not exist, returns -1
	public boolean isInInventory(Object item) {
		
			for(ArrayList<Item> i :masterInventory){
				for(Item j: i){
					if(j.equals(item)){
						return true;
					}	
				}
				
			}
		return false;
	}

	// Prints out a startstring such as "This room contains:" followed
	// by every item's toString() on its own line
	public void printInventory(String startstring) {
		System.out.println(startstring);
		for (Object o : inventoryItems) {
			System.out.println(o.toString());
		}
	}

	public void printMaster() {
		for (ArrayList<Item> i : masterInventory) {
			for (Item j : i) {
				System.out.println(j.name);
			}
		}
	}

	public Item getItem(String name) {
		int inventoryNum = getInventoryType(name);
		int index = indiviusalIndex(masterInventory[inventoryNum], name);
		return (Item) masterInventory[inventoryNum].get(index);

	}

	public int getInventoryType(String name) {
		if (Arrays.asList(docInventory).indexOf(name) != -1) {
			return 0;
		} else if (Arrays.asList(weaponsInventory).indexOf(name) != -1) {
			return 1;
		} else {
			return 2;
		}

	}

	private int indiviusalIndex(ArrayList arr, String name) {
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).equals(name)) {
				return i;
			}
		}
		return -1;
	}

	public Consumables getConsumable(String name) {
		int index = indiviusalIndex(consumablesInventory, name);
		if (index < 0) {
			return null;
		} else {
			return consumablesInventory.get(index);
		}
	}

}
