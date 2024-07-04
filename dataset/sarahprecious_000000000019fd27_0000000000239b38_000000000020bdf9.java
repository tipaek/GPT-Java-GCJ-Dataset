import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    in.nextLine();
	    //System.out.println("# of test cases:" + t);
	    
	    for (int i = 1; i <= t; ++i) {

		    int timings = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		    in.nextLine();
		    List<int[]> choreTimings = new ArrayList<>();
		    for(int time=0; time < timings; time++) {
	  	      	String rowVal = in.nextLine();
	  	      	String[] row = rowVal.split(" ");
	  	      	int[] timeRange =  getIntArray(row);
		    	choreTimings.add(timeRange);
		    }
	    	System.out.println("Case #" + i + ": " + organizeWork(choreTimings));
	    }
	  }
	
		private static String organizeWork(List<int[]>choreTimings) {
			String arrangement = "";
			int[] cTimes = new int[1440];
			int[] jTimes = new int[1440];
			int checkC = 0;
			int checkJ = 0;
			for(int[]timing : choreTimings) {
				checkC = arrangeSlot(cTimes, timing);
				if(checkC==1) {
					arrangement+="C";
					setTiming(cTimes, timing);
				} else {
					checkJ = arrangeSlot(jTimes, timing);
					if(checkJ>-1) {
						arrangement+="J";
						setTiming(jTimes, timing);
					} else {
						if(checkC ==0) {
							arrangement+="C";
							setTiming(cTimes, timing);
						} else 
							return "IMPOSSIBLE";
					}
				}
			}
			return arrangement;
		}
		
		private static void setTiming(int[]timings, int[]timing) {
			for(int t = timing[0]; t<timing[1]; t++) {
				timings[t] = 1;
			}
		}
		
		private static int arrangeSlot(int[]timings, int[]newChore) {
			int decision = -1;
			/**
			 * -1: no fit
			 * 0: can fit but not optimal
			 * 1: best fit
			 */
			if(timings[newChore[0]+1] != 1 && 
					((newChore[1]==1440 && timings[1440]!=1) || timings[newChore[1]+1]!=1)) {
				if(timings[newChore[0]]==1 || timings[newChore[1]] == 1)
					return 1;
				else return 0;
			}
			return decision;
		}
		
	
		private static int[] getIntArray(String[] e) {
		  int [] arr = new int [e.length];
	      for(int i=0; i<e.length; i++) {
	         arr[i] = Integer.parseInt(e[i]);
	      }
	      return arr;
	  }
}
