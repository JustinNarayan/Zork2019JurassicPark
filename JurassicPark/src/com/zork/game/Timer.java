package com.zork.game;

public class Timer {
	private int timeLeft = -1; // -1 means time has not been initialized; 10800 seconds when really initialized
	private final int MAX_TIME = 7200;
	private final int TIME_IN_HOUR = 3600;
	
	public final int TIME_TO_GO = 45;
	public final int TIME_TO_USE = 5;
	public final int TIME_TO_LOOK = 15;
	public final int TIME_TO_GRAB = 5;
	public final int TIME_TO_DROP = 5;
	public final int TIME_TO_READ = 45;
	public final int TIME_TO_ATTACK = 15;
	public final int TIME_TO_SEARCH = 20;
	public final int TIME_TO_CLIMB = 20;
	
	
	
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
