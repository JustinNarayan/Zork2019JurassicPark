package com.zork.game;

public class Formatter {
	private static final int FORMAT_BLOCK_TEXT_TOLERANCE = 0; //If this is 0, no word will be split between two lines
	private static final int FORMAT_BLOCK_TEXT_CUTOFF = 56;

	/* Converts a long string message into a properly formatted 
	 * String with line-breaks at appropriate positions
	 * 
	 * @param message	The long string to be edited.
	 * 					For the purpose of the method,
	 * 					there should be no line breaks.
	 * 
	 * @param cutoff	The maximum length between line
	 * 					breaks.
	 * 
	 * @param start		A string to be added at the start
	 * 					of each new line.
	 * 
	 * @return			The newly formatted sting. 
	 */
	
	public static String blockText(String message, int cutoff, String start) {
		int tolerance = FORMAT_BLOCK_TEXT_TOLERANCE;
		String newString = "";
		String[] oldWords = message.split(" ");
		
		int line = 0;
		for(String word : oldWords) {
			if(line+word.length()<cutoff) {
				newString += word + " ";
				line += word.length();
			} else {
				if(word.length() - (cutoff-line) > tolerance) {
					newString += "\n" + start + word + " ";
					line = word.length();
				} else {
					if((cutoff-line)!=word.length()) newString += word.substring(0,(cutoff-line)) + "-\n" + start + word.substring((cutoff-line)) + " ";
					else newString += word.substring(0,(cutoff-line)) + "\n" + start + word.substring((cutoff-line));
					
					line = word.substring((cutoff-line)).length();
				}
			}
		}
		
		return start+newString;
	}
	
	/* Converts a number of minutes to a 24 hour clock
	 * 
	 * @ param minutes		The number of minutes
	 * 
	 * @return				The time in the format of hh:mm
	 */
	
	public static String properTime(int seconds) {
		String time = "";
		int hours = seconds/3600;
		if(hours<10) time = "0"+hours;
		else time = ""+hours;
		time += ":";
		int mins = (seconds/60)%60;
		if(mins<10) time += "0"+mins;
		else time += mins;
		time += ":";
		int secs = seconds%60;
		if(secs<10) time += "0"+secs;
		else time += secs;
		return time;
	}
	
	public static int getCutoff() {
		return FORMAT_BLOCK_TEXT_CUTOFF;
	}
	
}
