package com.zork.game;

public class Timer {
	private int timeLeft = -1; // -1 means time has not been initialized; 10800 seconds when really initialized
	private final int MAX_TIME = 10800;
	private final int TIME_IN_HOUR = 3600;
	
	public final int TIME_TO_GO = 30;
	public final int TIME_TO_USE = 5;
	public final int TIME_TO_LOOK = 10;
	public final int TIME_TO_GRAB = 3;
	public final int TIME_TO_DROP = 3;
	public final int TIME_TO_READ = 45;
	public final int TIME_TO_ATTACK = 5;
	public final int TIME_TO_SEARCH = 10;
	public final int TIME_TO_CLIMB = 20;
	public final int TIME_TO_EQUIP = 3;
	public final int TIME_TO_UNEQUIP = 3;
	
	
	
	public void initTime() {
		timeLeft = MAX_TIME;
	}
	
	public int getTimeInHour() {
		return TIME_IN_HOUR;
	}
	
	public int getTimeLeft() {
		return timeLeft;
	}

	public void reduceTime(int amount) {
		if(timeLeft > -1) timeLeft -= amount;
		//time = 0
	}
	
	public boolean isOutOfTime() {
		return timeLeft <= 0;
	}
}
