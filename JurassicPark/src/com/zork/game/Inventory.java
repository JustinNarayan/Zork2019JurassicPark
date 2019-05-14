package com.zork.game;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Object> inventoryItems = new ArrayList<Object>();
	
	public void addInventoryItem(Object item) {
		inventoryItems.add(item);
	}
	
	//Returns the object that you search for and delete
	//If item does not exist returns null
	public Object removeInventoryItem(Object item) {
		int position = isInInventory(item);
		if(position==-1) return null;
		else {
			return inventoryItems.remove(position);
		}
	}
	
	//Returns the index of the item in the ArrayList
	//If does not exist, returns -1
	public int isInInventory(Object item) {
		for(int i = 0; i < inventoryItems.size(); i++) {
			if(item.toString().equalsIgnoreCase(inventoryItems.get(i).toString())) {
				return i;
			}
		}
		return -1;
	}
	
	
	//Prints out a startstring such as "This room contains:" followed
	//by every item's toString() on its own line
	public void printInventory(String startstring) {
		System.out.println(startstring);
		for(Object o : inventoryItems) {
			System.out.println(o.toString());
		}
	}
	
}
