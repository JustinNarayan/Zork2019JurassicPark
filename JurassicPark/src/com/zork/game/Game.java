package com.zork.game;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.zork.game.dinosaurs.Dinosaur;
import com.zork.game.dinosaurs.DinosaurController;
import com.zork.game.dinosaurs.Pterodactyl;
import com.zork.game.dinosaurs.Spinosaurus;
import com.zork.game.dinosaurs.TyrannosaurusRex;

/**
 * Class Game - the main class of the "Zork" game.
 *
 * Author: Michael Kolling Version: 1.1 Date: March 2000
 * 
 * This class is the main class of the "Zork" application. Zork is a very
 * simple, text based adventure game. Users can walk around some scenery. That's
 * all. It should really be extended to make it more interesting!
 * 
 * To play this game, create an instance of this class and call the "play"
 * routine.
 * 
 * This main class creates and initialises all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates the commands that
 * the parser returns.
 */
public class Game {
	private Parser parser;
	private Timer timer;
	private static Room currentRoom;
	private final String SIREN_POSITION = "Supply Shed";
	private final String LEAVE_POSITION = "Shipyard_N";
	private static Player player;
	private static DinosaurController dinosaurController;
	private static final int winPoints = 50;
	private boolean gameStarted;

	// This is a MASTER object that contains all of the rooms and is easily
	// accessible.
	// The key will be the name of the room -> no spaces (Use all caps and
	// underscore -> Great Room would have a key of GREAT_ROOM
	// In a hashmap keys are case sensitive.
	// masterRoomMap.get("GREAT_ROOM") will return the Room Object that is the Great
	// Room (assuming you have one).
	private static HashMap<String, Room> masterRoomMap;

	public static HashMap<String, Room> getMasterRoomMap() {
		return masterRoomMap;
	}
	
	public static Player getPlayer() {
		return player;
	}
	
	public static DinosaurController getDinosaurController() {
		return dinosaurController;
	}

	private void initRooms(String fileName) throws Exception {
		masterRoomMap = new HashMap<String, Room>();
		Scanner roomScanner;
		try {
			HashMap<String, HashMap<String, String>> exits = new HashMap<String, HashMap<String, String>>();
			roomScanner = new Scanner(new File(fileName));
			while (roomScanner.hasNext()) {
				Room room = new Room();
				// Read the Name
				String roomName = roomScanner.nextLine();
				room.setRoomName(roomName.split(":")[1].trim());
				// Read the Description
				String roomDescription = roomScanner.nextLine();
				room.setDescription(roomDescription.split(":")[1].replaceAll("<br>", "\n").trim());
				// Read the Exits
				String roomExits = roomScanner.nextLine();
				// An array of strings in the format E-RoomName
				String[] rooms = roomExits.split(":")[1].split(",");
				HashMap<String, String> temp = new HashMap<String, String>();
				for (String s : rooms) {
					temp.put(s.split("-")[0].trim(), s.split("-")[1]);
				}

				exits.put(roomName.substring(10).trim().toUpperCase().replaceAll(" ", "_"), temp);

				// This puts the room we created (Without the exits in the masterMap)
				masterRoomMap.put(roomName.toUpperCase().substring(10).trim().replaceAll(" ", "_"), room);

				// Now we better set the exits.
			}

			for (String key : masterRoomMap.keySet()) {
				Room roomTemp = masterRoomMap.get(key);
				HashMap<String, String> tempExits = exits.get(key);
				for (String s : tempExits.keySet()) {
					// s = direction
					// value is the room.

					String roomName2 = tempExits.get(s.trim());
					Room exitRoom = masterRoomMap.get(roomName2.toUpperCase().replaceAll(" ", "_"));
					roomTemp.setExit(s.trim().charAt(0), exitRoom);

				}

			}

			roomScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the game and initialise its internal map.
	 */
	public Game() {
		// init player
		player = new Player(); // the parameters have not been made yet
		gameStarted = false;
		try {
			initRooms("data/rooms.dat");
			currentRoom = masterRoomMap.get("BOAT_LANDING_A");
		} catch (Exception e) {

			e.printStackTrace();
		}
		parser = new Parser();
		timer = new Timer();
		dinosaurController = new DinosaurController();
	}

	/**
	 * Main play routine. Loops until end of play.
	 */
	public void play() {
		printWelcome();
		// Enter the main command loop. Here we repeatedly read commands and execute
		// them until the game is over.
		RoomItemInit.initRooms();
		boolean finished = false;
		while (!finished) {
			Command command = parser.getCommand();
			finished = processCommand(command);
			if (timer.isOutOfTime() && gameStarted) {
				endGame("time");
				finished = true;
			}
			if (player.hasSucceeded()) {
				endGame("success");
				finished = true;
			}
			if (player.isDead()) {
				finished = true;
			}
		}
		System.out.println("\nThank you for playing.");
	}

	/**
	 * Print out the opening message for the player.
	 */
	private void printWelcome() {
		System.out.println("-------------------------------------------------------------------");
		System.out.print("Welcome to Isla Nublar, the site of Jurassic Park! \nYou are a reporter who is looking "
				+ "to write an article to \nexpose the dangerous experiments being conducted on the island. "
				+ "\nType '?' or 'help' if you need help. \n");
		System.out.println("-------------------------------------------------------------------");
		System.out.println(currentRoom.longDescription());
	}

	/*
	 * Plays a sound from a specific directory
	 */
	public static void play(String file) {
		String filename = file;
		try {

			FileInputStream fis = new FileInputStream(filename);
			BufferedInputStream bis = new BufferedInputStream(fis);
			Player player = new Player(bis);
			// player.play();
		} catch (Exception e) {
			System.out.println("Problem playing file " + filename);
			System.out.println(e);
		}
	}

	/**
	 * Given a command, process (that is: execute) the command. If this command ends
	 * the game, true is returned, otherwise false is returned.
	 */
	private boolean processCommand(Command command) {
		if (command.isUnknown()) {
			System.out.println("I don't know what you mean...");
			return false;
		}
		String commandWord = command.getCommandWord();
		String word2 = command.getSecondWord();

		switch (commandWord) {
		case "help":
			printHelp();
			break;
		case "?":
			printHelp();
			break;
		case "go":
			if(goRoom(command)) {
				timer.reduceTime(timer.TIME_TO_GO);
				dinosaurController.moveDinosaurs();
			}
			break;
		case "quit":
			if (command.hasSecondWord())
				System.out.println("Quit what?");
			else
				return true; // signal that we want to quit
			break;
		case "use":
			if(use(command)) {
				timer.reduceTime(timer.TIME_TO_USE);
				dinosaurController.checkDinosaurAwareness();
			}
			break;
		case "climb":
			if(climb(command)) {
				timer.reduceTime(timer.TIME_TO_CLIMB);
				dinosaurController.checkDinosaurAwareness();
			}			
			break;
		case "check":
			check(command);
			break;
		case "inventory":
			checkInventory(command);
			break;
		case "ammo":
			checkAmmo(command);
			break;
		case "drop":
			if(drop(command, true)) {
				timer.reduceTime(timer.TIME_TO_DROP);
			}
			break;
		case "throw":
			if(doThrow(command)) {
				timer.reduceTime(timer.TIME_TO_DROP);
			}
			break;
		case "grab":
			if(grab(command)) {
				timer.reduceTime(timer.TIME_TO_GRAB);
				dinosaurController.checkDinosaurAwareness();
			}
			break;
		case "take": // same as grab
			if(grab(command)) {
				timer.reduceTime(timer.TIME_TO_GRAB);
				dinosaurController.checkDinosaurAwareness();
			}
			break;
		case "attack":
			if(attack(command)) {
				timer.reduceTime(timer.TIME_TO_ATTACK);
				dinosaurController.checkDinosaurAwareness();
			}
			break;
		case "suicide":
			killSelf();
			break;
		case "where":
			whereIsPlayer();
			break;
		default:
			if (!inFight()) { // the following commands are for when you are not in battle
				switch (commandWord) {
				case "look":
					if(look(command)) {
						timer.reduceTime(timer.TIME_TO_LOOK);
						dinosaurController.moveDinosaurs();
					}
					break;
				case "search":
					if(search(command)) {
						timer.reduceTime(timer.TIME_TO_SEARCH);
						dinosaurController.moveDinosaurs();
					}
					break;
				case "time":
					checkTime(command);
					break;
				case "leave":
					leave(command);
					break;
				case "read":
					if(read(command)) {
						timer.reduceTime(timer.TIME_TO_READ);
					}
					break;
				}
			} else {
				System.out.println("You must do a battle command!");

			}

		}

		return player.isDead();

	}

	
	/*
	/**
	 * this method is used to equid a specified item
	 * 
	 * @param command
	 *
	private void equip(Command command) {
		if (player.getInventory() == null) {
			System.out.println("You have nothing to equip.");
		} else if (!command.hasSecondWord()) {
			System.out.println("You must say what you want to equip.");
		} else if (player.getInventory().isInInventory(command.getSecondWord())==null) {
			System.out.println("That item is not in your inventory.");
		} else if (!(player.getInventory().getItem(command.getSecondWord()) instanceof Weapons)) {
			System.out.println("You can not equip that item.");
		} else if ((((Weapons) player.getInventory().getItem(command.getSecondWord())).isEquipped())) {
			System.out.println("That item is already equiped.");
		} else {
			player.equip(player.getInventory().getItem(command.getSecondWord()));
		}
	}

	/**
	 * this method is used to unequip a specified item
	 * 
	 * @param command
	 *
	private void unequip(Command command) {
		if (!command.hasSecondWord()) {
			System.out.println("You must say what you want to equip.");
		} else if (player.getInventory().isInInventory(command.getSecondWord())==null) {
			System.out.println("That item is not in your inventory.");
		} else if (!(player.getInventory().getItem(command.getSecondWord()) instanceof Weapons)) {
			System.out.println("You can not unequip that item");
		} else if (!(((Weapons) player.getInventory().getItem(command.getSecondWord())).isEquipped())) {
			System.out.println("That item is already unequiped.");
		} else {
			player.unequip(command.getSecondWord());
		}
	}*/

	public boolean inFight() {
		return (currentRoom.getRoomInventory().hasDinosaurs() && currentRoom.getRoomInventory().getDinosaur().isAware());
	}
	
	/**
	 * check the amount of time the player has left
	 * 
	 * @param command
	 */
	private void checkTime(Command command) {
		if (timer.getTimeLeft() == -1)
			System.out.println("It is midday on the island.");
		else
			System.out.println("You have " + Formatter.properTime(timer.getTimeLeft()) + " until you have to "
					+ "leave the island. Get going!");
	}

	/**
	 * this method is for the player to be able to use items
	 * 
	 * @param command
	 */
	private boolean use(Command command) {
		if (player.inTree) {
			System.out.println("You cannot use items while you're in a tree!");
		} else if (player.getInventory() == null) {
			System.out.println("You have nothing to use.");
		} else if (!command.hasSecondWord()) {
			System.out.println("You must say what you want to use.");
		} else if(player.getInventory().isInInventory(command.getSecondWord())!=null) {
			player.getInventory().isInInventory(command.getSecondWord()).use(currentRoom.getRoomInventory().getDinosaur());
			return true;
		}
		return false;		
	}

	private boolean search(Command command) {
		// Look at environment
		ArrayList<EnvironmentItem> env = currentRoom.getRoomInventory().getEnvironment();
		if (!command.hasSecondWord()) {
			System.out.println("You must include what you want to search.");
			return false;
		}
		if (env.size() == 0)
			System.out.println("There is nothing here to search.");
		else {
			boolean canSearch = false;
			for (int i = 0; i < env.size(); i++) {
				EnvironmentItem temp = env.get(i);
				if ( (temp.toString().indexOf(command.getSecondWord())>-1 && !command.getSecondWord().equals("a")) || (command.hasThirdWord() && temp.toString().indexOf(command.getThirdWord())>-1 && !command.getThirdWord().equals("a"))) {
					canSearch = true;
					if (temp.getItems().size() > 0) {
						System.out.print("You search the " + command.getSecondWord() + " grab ");
						for (int j = 0; j < temp.getItems().size(); j++) {
							System.out.print(
									temp.getItems().get(j).getNameLowerCase() + temp.getItems().get(j).getPoints());
							player.inventory.addInventoryItem(temp.getItems().get(j));
							temp.removeItem(j);
						}
						System.out.print(".\n");
					} else {
						System.out.println("You searched the " + command.getSecondWord() + " and found nothing.");
					}

				}
			}
			if (!canSearch) {
				System.out.println("You can't search that.");
				return false;
			}
		}
		return true;
	}

	/**
	 * this method grabs an specific object
	 * 
	 * @param command the users command
	 */
	private boolean grab(Command command) {
		if (player.inTree) {
			System.out.println("You cannot grab items while you're in a tree!");
			return false;
		}

		if (!command.hasSecondWord()) {
			System.out.println("You must include what you want to grab.");
			return false;
		}

		// Determine the item
		String word;
		String real;
		if (command.getSecondWord().equals("a") || command.getSecondWord().equals("the")) {
			real = command.getThirdWord();
			word = "a " + real;
		} else {
			real = command.getSecondWord();
			word = "a " + command.getSecondWord();
		}

		if (!currentRoom.getRoomInventory().roomHasItem(word)) {
			System.out.println("That item is not here.");
			return false;
		} else {
			player.getInventory().addInventoryItem(currentRoom.getRoomInventory().getRoomItem(word));
			System.out.println("You picked up " + currentRoom.getRoomInventory().getRoomItem(word).getNameLowerCase()
					+ currentRoom.getRoomInventory().getRoomItem(word).getPoints() + ".");
			currentRoom.getRoomInventory().removeRoomItem(word);
			return true;
		}
	}

	private boolean attack(Command command) {
		if (currentRoom.getRoomInventory().getDinosaur() == null) {
			System.out.println("There is nothing for you to attack.");
		} else {
			return playerAttack(command);
		}
		return false;
	}
/**
 * it processes the players attack
 * the user can enter either "dino", "dinosaur", or the specific name of the dino in the room
 * @param command
 * @return boolean if the player dies or not
 */
	private boolean playerAttack(Command command) {
		Dinosaur currentDino = currentRoom.getRoomInventory().getDinosaur();

		if (!command.hasSecondWord()) {
			System.out.println("You must say what you want to attack.");
		} else if(!command.hasThirdWord()) {
			System.out.println("You must say what you want to attack with.");
		} else if(player.getInventory().getItem(command.getThirdWord())==null) { 
			System.out.println("You do not have that item!");
		} else if (!(player.getInventory().getItem(command.getThirdWord()) instanceof Weapons)) {
			System.out.println("That is not a weapon.");
		} else if ((!command.getSecondWord().equalsIgnoreCase(currentDino.toString())
				&& (!command.getSecondWord().equalsIgnoreCase("dino"))
				&& (!command.getSecondWord().equalsIgnoreCase("dinosaur")))) {
			System.out.println("That enemy is not here.");
		} else if (player.getInventory().isInInventory(command.getThirdWord())==null) {
			System.out.println("That weapon is not in your inventory");
		} else {
			if (currentDino.isInvincible()) {
				System.out.println("That dinosaur can't be harmed.");
				currentDino.killPlayer();
				player.hasDied();
				return false;
			} else {

				Weapons current = (Weapons) player.getInventory().isInInventory(command.getThirdWord());
				if (current instanceof Melee) {
					if ((int) (Math.random() * 5) == 1) {
						System.out.println("Your stab has failed and the dinosaur has decided to take revenge!");
						currentDino.killPlayer();
						player.hasDied();
						return false;
					} else {
						if ((int) (Math.random() * 2) == 1) {
							System.out.println("You killed the dinosaur and proved your species is superior.");
							currentDino.die(dinosaurController);
							return true;
						} else {
							System.out
									.println(Formatter.blockText("You launched a successful attack, but it did not kill. You would have to stab again before it can retaliate with any chance to succeed!", Formatter.getCutoff(),""));
							return true;
						}

					}
				} else if(current instanceof Ranged) {
					System.out.println("You have shot the " + currentDino.toString() + ". It is now dead");
					System.out.println(
							"You walk over the dinosaur with a sense of pride... You represented your species well");
					System.out.println("You say \"We discovered fire first you oversized gecko.\"");
					System.out.println("You proceed to spit on the dead " + currentDino.toString() + ".");
					System.out.println("\nThe weapon you used is now out of ammo so you throw it away.");
					drop(new Command("drop", "gun", null), false);
					current.setRoom(null);
					checkAmmo(command);
					currentDino.die(dinosaurController);
					return true;

				} else {
					System.out.println("You cannot attack with that!");
				}
			}

		}
		return false;
	}

	private void checkAmmo(Command command) {
		Inventory temp = player.getInventory();
		int ammoLeft = 0;
		for (Weapons w : temp.weaponsInventory) {
			if (w instanceof Ranged) ammoLeft++;
		}
		System.out.println("You have " + ammoLeft + " weapons with ammo left.");

	}

	private void check(Command command) {
		if ((command.hasSecondWord() && (command.getSecondWord().equals("inventory") || command.getSecondWord().equals("items")))
				|| (command.hasThirdWord()	&& (command.getThirdWord().equals("inventory") || command.getThirdWord().equals("items")))) {
			checkInventory(command);
		} else if ((command.hasSecondWord() && command.getSecondWord().equals("ammo"))
				|| (command.hasThirdWord() && command.getThirdWord().equals("ammo"))) {
			checkAmmo(command);
		} else if (!command.hasSecondWord()) {
			System.out.println("You must include what you want to check.");
		} else {
			search(command);
		}
	}

	private void checkInventory(Command command) {
		player.getInventory().printInventory("Here are the items in your inventory: ", true);
	}

	/**
	 * this methods allows the player to climb trees
	 * 
	 * @param command
	 */
	private boolean climb(Command command) {
		if (!command.hasSecondWord() || (command.getSecondWord().equals("up") && !command.hasThirdWord())) {
			System.out.println("What do you want to climb?");
		} else if (command.getSecondWord().equals("down")) {
			if (player.inTree) {
				System.out.println("You have climbed down the tree.");
				player.inTree = false;
				return true;
			} else {
				System.out.println("You haven't climbed anything yet!");
			}
		} else if ((!command.getSecondWord().equals("tree") && !command.getSecondWord().equals("trees"))
				&& (!command.hasThirdWord() && !command.getSecondWord().equals("up")
						&& !command.getSecondWord().equals("tree") && !command.getSecondWord().equals("trees"))) {
			System.out.println("You can only climb trees.");
		} else if (!currentRoom.getRoomInventory().environmentHasItem("trees")) {
			System.out.println("You don't see any trees to climb.");
		} else if (!player.inTree) {
			if (inFight()) {
				if ((int) (Math.random() * 8) == 1) { // 1/8 chance that they fall and die
					System.out.println(
							"In your panic to escape the dinosaur, you fell down, broke your legs, and got eaten.");
					player.hasDied();
				} else {
					System.out.println("You have climbed the tree.");
					player.inTree = true;
					return true;
				}
			} else {
				if ((int) (Math.random() * 20) == 1) {
					System.out.println("A branch snapped and you have fallen to a painful death.");
					player.hasDied();
				} else {
					System.out.println("You have climbed the tree.");
					player.inTree = true;
					
					if(currentRoom.getRoomInventory().getDinosaur()!=null && currentRoom.getRoomInventory().getDinosaur() instanceof Spinosaurus) {
						System.out.println(Phrases.getEvadeSpinosaurus());
						currentRoom.getRoomInventory().getDinosaur().evade(dinosaurController);
					}
					return true;
				}
			}
		} else {
			System.out.println("You are already in a tree!");
		}
		return false;
	}

	private boolean drop(Command command, boolean show) {
		if (!command.hasSecondWord()) {
			System.out.println("You must include what you want to drop.");
		} else {
			// If the second word is a number in the inventory
			try {
				int number = Integer.parseInt(command.getSecondWord());
				if (number <= player.getInventory().getInventoryItems().size()) {
					System.out.println("Item " + number + ", " + player.getInventory().removeItem(number - 1).toString()
							+ ", has been removed from your inventory.");
					return true;
				} else {
					System.out.println("There aren't that many items in your inventory!");
					return false;
				}
			} catch (Exception e) {
				// The second word wasn't a number
			}

			// If the third word is a number in the inventory
			if (command.hasThirdWord()) {
				try {
					int number = Integer.parseInt(command.getThirdWord());
					if (number <= player.getInventory().getInventoryItems().size()) {
						System.out.println(
								"Item " + number + ", " + player.getInventory().removeItem(number - 1).toString()
										+ ", has been removed from your inventory.");
						return true;
					} else {
						System.out.println("There aren't that many items in your inventory!");
						return false;
					}
				} catch (Exception e) {
					// The second word wasn't a number
				}
			}

			if (player.getInventory().isInInventory(command.getSecondWord())==null) {
				System.out.println("That item is not in your inventory.");
			} else {
				String name = player.getInventory().isInInventory(command.getSecondWord()).toString();
				if(show && command.getSecondWord().length()>1) System.out.println(name.substring(0,1).toUpperCase() + name.substring(1) + " has been removed from your inventory.");
				player.getInventory().removeItem(command.getSecondWord());
				return true;
			}
		}
		return false;
	}

	private boolean read(Command command) {
		if (!command.hasSecondWord()) {
			System.out.println("You must include what you want to read.");
		} else {
			// If the second word is a number in the inventory
			try {
				int number = Integer.parseInt(command.getSecondWord());
				if (number <= player.getInventory().getInventoryItems().size()) {
					Item i = player.getInventory().getItem(number - 1);
					if (i != null && i instanceof Artifacts) {
						System.out.println("You take out " + i.getNameLowerCase() + " and read it.\n");
						System.out.println(((Artifacts) i).getRead());
						return true;
					} else {
						System.out.println("You can't read that!");
					}
					return false;
				} else {
					System.out.println("There aren't that many items in your inventory!");
					return false;
				}
			} catch (Exception e) {
				// The second word wasn't a number
			}

			// If the third word is a number in the inventory
			if (command.hasThirdWord()) {
				try {
					int number = Integer.parseInt(command.getThirdWord());
					if (number <= player.getInventory().getInventoryItems().size()) {
						Item i = player.getInventory().getItem(number - 1);
						if (i != null && i instanceof Artifacts) {
							System.out.println("You take out " + i.getNameLowerCase() + " and read it.\n");
							System.out.println(((Artifacts) i).getRead());
							return true;
						} else {
							System.out.println("You can't read that!");
						}
						return false;
					} else {
						System.out.println("There aren't that many items in your inventory!");
						return false;
					}
				} catch (Exception e) {
					// The third word wasn't a number
				}
			}

			// See if they type a word
			Item i = player.getInventory().isInInventory(command.getSecondWord());
			if (i != null) {
				if(i instanceof Artifacts == false) {
					System.out.println("You can't read that!");
					return false;
				}
				System.out.println("You take out " + i.getNameLowerCase() + " and read it.\n");
				System.out.println(((Artifacts) i).getRead());
				return true;
			} else if (command.hasThirdWord()) {
				i = player.getInventory().isInInventory(command.getThirdWord());
				if (i != null) {
					if(i instanceof Artifacts == false) {
						System.out.println("You can't read that!");
						return false;
					}
					System.out.println("You take out " + i.getNameLowerCase() + " and read it.\n");
					System.out.println(((Artifacts) i).getRead());
					return true;
				} else
					System.out.println("That item isn't in your inventory.");
			} else {
				System.out.println("That item isn't in your inventory.");
			}
		}
		return false;
	}

	private boolean doThrow(Command command) {
		if (command.hasSecondWord() && command.getSecondWord().equalsIgnoreCase("flare")
				&& player.getInventory().isInInventory(command.getSecondWord())!=null) {
			System.out.println("You have thrown the flare into another room.");
			if(currentRoom.getRoomInventory().getDinosaur()!=null && currentRoom.getRoomInventory().getDinosaur() instanceof TyrannosaurusRex) {
				System.out.println(Phrases.getEvadeTrex());
				currentRoom.getRoomInventory().getDinosaur().evade(dinosaurController);
			}
			Item item = player.getInventory().isInInventory(command.getSecondWord());
			drop(new Command("drop", "flare", null), false);//change true to false
			item.setRoom(null);
			return true;
		} else {
			// Default to the drop command
			drop(command, true);
		}
		return false;
	}

	// implementations of user commands:
	/**
	 * Print out some help information. Here we print some stupid, cryptic message
	 * and a list of the command words.
	 */
	private void printHelp() {
		System.out.println("You are a reporter who is looking to write an article");
		System.out.println("to expose the dangerous experiments being conducted on");
		System.out.println("Isla Nublar, site of Jurassic Park.");
		System.out.println();
		System.out.println("Your command words are:");
		parser.showCommands();
	}

	/**
	 * Try to go to one direction. If there is an exit, enter the new room,
	 * otherwise print an error message.
	 */
	private boolean goRoom(Command command) {
		if (player.inTree) {
			System.out.println("You cannot leave the area while you're in a tree!");
			return false;
		}

		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println("Go where?");
			return false;
		}
		String direction = command.getSecondWord();
		// Try to leave current room.
		Room nextRoom = currentRoom.nextRoom(direction);
		if (nextRoom == null) {
			System.out.println("You cannot go that way!");
			return false;
		} else {
			currentRoom = nextRoom;
			System.out.println(currentRoom.longDescription());

			// Print out the siren message in-story to open the facilities
			if (currentRoom.getRoomName().equals(SIREN_POSITION)) {
				if (timer.getTimeLeft() == -1) {
					timer.initTime();
					gameStarted = true;

					System.out
							.println(Formatter
									.blockText("\nInside the shed, you hear sirens begin to blare and an alert "
											+ "message sounds through the speakers:", Formatter.getCutoff(), "")
									+ "\n");
					System.out.println(Formatter
							.blockText("\"Attention! Attention everyone on Jurassic Park! Worsening "
									+ "conditions have made it unsafe to continue work here. All staff personnel must evacuate "
									+ "the island immediately. Approaching storms from the south of the island "
									+ "are forcing all personnel to make their way to the northeast shipyard. "
									+ "I repeat, all personnel to the northeast shipyard. Control centers are losing power, "
									+ "meaning enclosure doors may be starting to open due to technical malfunctions. "
									+ "The last personnel ship will evacuate in "
									+ timer.getTimeLeft() / timer.getTimeInHour() + " hours. I repeat, you have "
									+ timer.getTimeLeft() / timer.getTimeInHour()
									+ " hours to get off the island. Over and out.\"", Formatter.getCutoff(), "\t")
							+ "\n");
					System.out.println(Formatter.blockText(
							"You hear clanging of metal outside of the shed - the security "
									+ "doors have opened. You have limited time to gather information on the island before you "
									+ "need to escape. The more documents and artifacts you acquire, the more successful your article"
									+ "will be. You'll need to evade the creaters unleashed on the island, and if not, face death.",
							Formatter.getCutoff(), " ") + "\n");
				}
			} else if (currentRoom.getRoomName().equals(LEAVE_POSITION)) {
				System.out.println(Formatter.blockText(
						"\nThis is it! You can leave the island from here if you wish, you can sneak aboard a boat to safety. "
								+ "If you wish to remain and search for more artifacts, you have "
								+ Formatter.properTime(timer.getTimeLeft()) + " to do so.",
						Formatter.getCutoff(), ""));
			}
			return true;
		}
	}

	private boolean look(Command command) {
		// Check if should be a search
		if (command.hasSecondWord() && command.hasThirdWord()) {
			if (command.getSecondWord().equals("inside") || command.getSecondWord().equals("in")) {
				return search(new Command(command.getCommandWord(), command.getThirdWord(), null));
			}
		}

		System.out.println(Phrases.getLook().get((int) (Math.random() * Phrases.getLook().size())));

		// Look at environment
		ArrayList<EnvironmentItem> env = currentRoom.getRoomInventory().getEnvironment();
		// List all the environmentItems in the room
		if (env.size() == 1) {
			System.out.print(Phrases.getLookEnv().get((int) (Math.random() * Phrases.getLookEnv().size())) + "only ");
			for (EnvironmentItem obj : env)
				System.out.print(obj.toString());
			System.out.println(". ");
		} else if (env.size() > 1) {
			System.out.print(Phrases.getLookEnv().get((int) (Math.random() * Phrases.getLookEnv().size())));
			for (int i = 0; i < env.size(); i++) {
				if (i < env.size() - 1) {
					System.out.print(env.get(i).toString());
					if (env.size() > 2)
						System.out.print(", ");
					else
						System.out.print(" ");
				} else
					System.out.print("and " + env.get(i).toString());
			}
			System.out.println(". ");
		}
		String seeInEnvironment = "";
		for (EnvironmentItem obj : env) {
			if (obj.getItems().size() > 0) {
				if (seeInEnvironment.equals("")) {
					seeInEnvironment += Phrases.getLookInEnv()
							.get((int) (Math.random() * Phrases.getLookInEnv().size()));
				} else
					seeInEnvironment += "and ";
				if (obj.toString().length() > 1 && obj.toString().substring(0, 2).equals("a "))
					seeInEnvironment += obj.toString().substring(2) + " ";
				else
					seeInEnvironment += obj.toString() + " ";
			}
		}
		if (!seeInEnvironment.equals(""))
			System.out.println(seeInEnvironment.substring(0, seeInEnvironment.length() - 1) + ".");

		// Look at roomItems
		ArrayList<Item> items = currentRoom.getRoomInventory().getItems();
		// List all the items in the room
		if (items.size() == 1) {
			System.out
					.print(Phrases.getLookItems().get((int) (Math.random() * Phrases.getLookItems().size())) + "only ");
			for (Item obj : items)
				System.out.print(obj.getNameLowerCase());
			System.out.println(". ");
		} else if (items.size() > 1) {
			System.out.print(Phrases.getLookItems().get((int) (Math.random() * Phrases.getLookItems().size())));
			for (int i = 0; i < items.size(); i++) {
				if (i < items.size() - 1) {
					System.out.print(items.get(i).getNameLowerCase());
					if (items.size() > 2)
						System.out.print(", ");
					else
						System.out.print(" ");
				} else
					System.out.print("and " + items.get(i).getNameLowerCase());
			}
			System.out.println(". ");
		}

		// Check both
		if (env.size() == 0 && items.size() == 0) {
			System.out.println(Phrases.getLookNothing().get((int) (Math.random() * Phrases.getLookNothing().size())));
		}
		return true;
	}

	public void killSelf() {
		if (player.inTree == true) {
			System.out.println(
					"You have pursued your dream of flying by jumping out a tree... until gravity did something about it.");
		} else {
			System.out.println("You look around for something to kill yourself with.");
			System.out.println("You have picked up a small pebble and lodged it in your throat");
		}
		System.out.println("You are dead...");
		System.out.println("GG m8");
		player.hasDied();
		endGame("");
	}

	public void whereIsPlayer() {
		System.out.println(currentRoom.longDescription());
	}

	public void leave(Command command) {
		if (!command.hasSecondWord()) {
			System.out.println("Where do you want to leave?");
		} else {
			if (command.getSecondWord().equals("isla") || command.getSecondWord().equals("island")
					|| command.getSecondWord().equals("here")) {
				if (currentRoom.getRoomName().equals(LEAVE_POSITION)) {
					player.gainSuccess();
				} else {
					System.out.println("You can't leave the island from here!");
				}
			}
		}
	}

	public static Room getCurrentRoom() {
		return currentRoom;
	}

	public static void endGame(String s) {
		if (s.equals("time")) {
			System.out.println(Formatter.blockText(
					"\nYou are too late! The last boat off the island has left and you have been trapped on the island with no escape"
							+ " to fend for yourself among the park's dinosaurs. As your last hope for survival sails away in the distance, you remember all the artifacts you recovered"
							+ " and how close you came to exposing the horrors around you.",
					Formatter.getCutoff(), ""));
		} else if (s.equals("success")) {
			System.out.println(Formatter.blockText(
					"\nYou have successfully left the island! You have snuck aboard an escaping ship yet again, and must hope no one finds you"
							+ " until you can safely reach land. You have got out with your life and what you hope will be enough evidence to shut the park down for good.",
					Formatter.getCutoff(), ""));
			System.out.println("\nYou have gained " + winPoints + " from successfully escaping the island.");

		}
		System.out.println("\nYou have gained " + player.calculatePoints() + " points from all the artifacts you recovered.");
	}
}
