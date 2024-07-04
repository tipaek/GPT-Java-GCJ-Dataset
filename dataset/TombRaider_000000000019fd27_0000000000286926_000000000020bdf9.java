
import java.util.*;
import java.io.*;

public class Solution {
	
	
	public static String solve (int size, int [][] apps) {
		// prepare
		String [] result = new String [size];
		int JamieBusyUntil = 0;
		int CameronBusyUntil = 0;
		int done=0;
		
		while (done<size) {
			//find next task
			int nextTask = -1;
			int nextTaskStart = 25*60; //larger than day max
			for (int i=0; i<size; i++) {
				if (result [i] == null) { // task not yet assigned
					if (apps [i][0] < nextTaskStart) {
						nextTaskStart = apps [i][0];
						nextTask = i;
					}
				}
			}
			//assign next task
			if (apps [nextTask][0] >= JamieBusyUntil) {
				//Jamie is the working horse
				JamieBusyUntil = apps [nextTask][1];
				result [nextTask] = "J";
				done += 1;
			} else if (apps [nextTask][0] >= CameronBusyUntil) {
				//Cameron happy to take it
				CameronBusyUntil = apps [nextTask][1];
				result [nextTask] = "C";
				done += 1;
			} else {
				//Nobody can do it - so, no chance to do get stuff done
				return "IMPOSSIBLE"; 
			}
		}
		
		// aLL tasks are done, so let's build the result
		String resultString = "";
		for (int i=0; i<size; i++)
			resultString += result [i];
		return resultString;
	}
	
	
	public static void main(String[] args) {
          Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
          int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
          for (int i = 1; i <= t; i++) {
        	  int nrApp = in.nextInt();
        	  int [][] apps = new int [nrApp][2];
              for (int j = 0; j < nrApp; j++) {
            	  apps [j][0] = in.nextInt();
            	  apps [j][1] = in.nextInt();
              }
            System.out.println("Case #"+i+": "+Solution.solve(nrApp, apps));
          }
        }
}