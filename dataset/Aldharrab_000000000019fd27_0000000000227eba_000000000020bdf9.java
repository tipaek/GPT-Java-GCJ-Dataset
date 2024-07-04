import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scnr = new Scanner(System.in); // make the scanner
		int numEntries = Integer.parseInt(scnr.nextLine());// get the number of entries
		String retVal;
		for (int i = 0; i < numEntries; i++) {// for every case
			int entries = scnr.nextInt();// get how many you need
			scnr.nextLine();// point to the next line
			retVal = "Case #" + (i + 1) + ": "; // the case number
			for (int j = 0; j < entries; j++) {
				Integer[][] CActivities = new Integer[entries][2];// Cameron's activity schedule
				Integer[][] JActivities = new Integer[entries][2];// Jamie's activity schedule
				Integer[] eventTime = { scnr.nextInt(), scnr.nextInt() };// new event
				scnr.nextLine();
				// check if Cameron can accomodate
				boolean Cincompat= false;//if cameron is busy at this time
				boolean Jincompat= false;//if jamie is busy at this time
				for (int k = 0; k < entries; k++) {
					if (CActivities[k][0] == null) {// if cameron can accomodate
						CActivities[k] = eventTime;
						retVal = retVal + "C";
						break;
					} else {
						if ((eventTime[0] > CActivities[k][0] && eventTime[0] < CActivities[k][1])
								|| (eventTime[1] > CActivities[k][0] && eventTime[1] < CActivities[k][1])
								|| (eventTime[0] < CActivities[k][0] && eventTime[1] > CActivities[k][1])) {
							Cincompat = true;//Cameron is busy
break; 
						}
						continue;
					}

				}
				for (int k = 0; k < entries; k++) {
					if (JActivities[k][0] == null) {// if cameron can accomodate
						JActivities[k] = eventTime;
						retVal = retVal + "J";
						break;
					} else {
						if ((eventTime[0] > JActivities[k][0] && eventTime[0] < JActivities[k][1])
								|| (eventTime[1] > JActivities[k][0] && eventTime[1] < JActivities[k][1])
								|| (eventTime[0] < JActivities[k][0] && eventTime[1] > JActivities[k][1])) {
							Jincompat = true;//Cameron is busy
break; 
						}
						continue;
					}

				}
				if(Jincompat && Cincompat) {
					retVal = ("Case #" + (i + 1) + ": " + "IMPOSSIBLE");
					break;
				}
			}

			System.out.println(retVal);

		}

	}
}
