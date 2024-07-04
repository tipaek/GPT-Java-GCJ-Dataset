import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Solution {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in); // make the scanner
		int numEntries = Integer.parseInt(scnr.nextLine());// get the number of entries
		String retVal;
		for (int i = 0; i < numEntries; i++) {// for every case
			int entries = scnr.nextInt();// get how many events are scheduled
			scnr.nextLine();// point to the next line
			retVal = "Case #" + (i + 1) + ": "; // the case number
			Schedule cameron = new Schedule("Cameron");
			Schedule jamie = new Schedule("Jamie");
			for (int j = 0; j < entries; j++) {// for every event
				Event newEvent = new Event(scnr.nextInt(), scnr.nextInt());// make a new event
				if (!cameron.addEvent(newEvent)) {// if it doesn't fit cam
					if (!jamie.addEvent(newEvent)) {// and it doesn't fit jamie
						retVal = "Case #" + (i + 1) + ": " + "IMPOSSIBLE";// impossible schedule
						continue;
					}
					retVal = retVal + "J";// if it only fits jamie, then add it to jamie
				}else {
					retVal = retVal + "C";
				}
				
				
			}
			System.out.println(retVal);


		}
	}

	public static class Event {
		int startTime;
		int endTime;

		public Event(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}

	public static class Schedule {
		String user;
		List<Event> events;

		public Schedule(String user) {
			this.user = user;
			this.events = new ArrayList<Event>();
		}

		public boolean addEvent(Event eventToAdd) {

			boolean collision = false;
			for (Event currEvent : events) {
				if (eventToAdd.startTime > currEvent.startTime && eventToAdd.startTime < currEvent.endTime) {
					return false;
				} else if (eventToAdd.endTime > currEvent.startTime && eventToAdd.endTime < currEvent.endTime) {
					return false;
				} else if (eventToAdd.startTime < currEvent.startTime && eventToAdd.endTime > currEvent.endTime) {
					return false;
				}
			}
			events.add(eventToAdd);
			return true;
		}
	}
}
