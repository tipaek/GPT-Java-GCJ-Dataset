import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		 Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	        int numOfCases = in.nextInt();
	        for (int caseNum = 0; caseNum < numOfCases; caseNum++) {
		        String result = "";
		        int numOfActivitis = in.nextInt();
		        int[][] bucket = new int[numOfActivitis][3];
		        for (int b=0; b<numOfActivitis; b++){
			        Arrays.fill(bucket[b], -1);
		        }
		        int[] start = new int [numOfActivitis];
		        int[] end = new int [numOfActivitis];
	        	for (int activityNum = 0; activityNum < numOfActivitis; activityNum++) {
	        		start[activityNum] = in.nextInt();
	        		end[activityNum] = in.nextInt();
	        	}
	        	for (int activityNum = 0; activityNum < numOfActivitis; activityNum++) {
	        		int numOfOverlaps = 0;
	        		for (int otherActivity = 0; otherActivity < numOfActivitis; otherActivity++) {
	        			if (activityNum != otherActivity && overlap(start[activityNum], end[activityNum], start[otherActivity], end[otherActivity])) {
	        				bucket[activityNum][numOfOverlaps++] = otherActivity;
	        				if (numOfOverlaps > 2){ 
	        					result = "IMPOSSIBLE";
	        					break;
	        				}
	        			}
	        		}
	        	}
	        	int[] marked = new int[numOfActivitis];
	        	int[] jessie = new int[numOfActivitis];
	        	int[] cameron = new int[numOfActivitis];
	        	Arrays.fill(jessie, -1);
	        	Arrays.fill(cameron, -1);
	        	int jessieIndex = 0;
	        	int cameronIndex = 0;
	        	int markedIndex = 0;
	        	for (int currentActivity = 0; currentActivity < numOfActivitis; currentActivity++) {
	        		boolean done = false;
		        	for (int buck = 0; buck < numOfActivitis; buck++) {
		        		if (bucket[buck][1] != -1) {
				        	for (int m = 0; m < markedIndex; m++) {
				        		if (marked[m] == buck) {
				        			done = true;
				        		}
				        	}
				        	if (!done) {
			        			jessie[jessieIndex++] = buck;
				        		marked[markedIndex++] = buck;
				        		for (int m = 0; m < markedIndex; m++) {
					        		if (marked[m] == bucket[buck][0]) {
					        			done = true;
					        		}
					        	} 
					        	if (!done) {
					        		cameron[cameronIndex++] = bucket[buck][0];
					        		marked[markedIndex++] = bucket[buck][0];
					        		if (bucket[buck][1] != -1) {
							        	for (int m = 0; m < markedIndex; m++) {
							        		if (marked[m] == bucket[buck][1]) {
							        			done = true;
							        		}
							        	} 
							        	if (!done) {
						        			if (!overlap(start[bucket[buck][0]], end[bucket[buck][0]], start[bucket[buck][1]], end[bucket[buck][1]])) {
							        		cameron[cameronIndex++] = bucket[buck][1];
							        		marked[markedIndex++] = bucket[buck][1];
						        			}else {
				        	        			result = "IMPOSSIBLE";
						        			}
							        	}
					        		}
					        	}
				        	}
		        		}
		        	}
	        	}
	        	for (int currentActivity = 0; currentActivity < numOfActivitis; currentActivity++) {
		        	boolean alreadyDone = false;
		        	boolean jessieIsBusy = false;
		        	boolean cameronIsAlsoBusy = false;
		        	for (int m = 0; m < markedIndex; m++) {
		        		if (marked[m] == currentActivity) {
		        			alreadyDone = true;
		        		}
		        	}
		        	if (!alreadyDone) {
			        	if (bucket[currentActivity][0] != -1) {
	        				jessie[jessieIndex++] = currentActivity;
			        		marked[markedIndex++] = currentActivity;
				        	for (int m = 0; m < markedIndex; m++) {
				        		if (marked[m] == bucket[currentActivity][0]) {
				        			alreadyDone = true;
				        		}
				        	} 
				        	if (!alreadyDone) {
				        		cameron[cameronIndex++] = bucket[currentActivity][0];
				        		marked[markedIndex++] = bucket[currentActivity][0];
				        		if (bucket[currentActivity][1] != -1) {
						        	for (int m = 0; m < markedIndex; m++) {
						        		if (marked[m] == bucket[currentActivity][1]) {
						        			alreadyDone = true;
						        		}
						        	} 
						        	if (!alreadyDone) {
					        			if (!overlap(start[bucket[currentActivity][0]], end[bucket[currentActivity][0]], start[bucket[currentActivity][1]], end[bucket[currentActivity][1]])) {
						        		cameron[cameronIndex++] = bucket[currentActivity][1];
						        		marked[markedIndex++] = bucket[currentActivity][1];
					        			}else {
			        	        			result = "IMPOSSIBLE";
					        			}
						        	}
				        		}
				        	}
			        	}else {
		        			for (int j = 0; j < jessieIndex; j++) {
		    	        		if (overlap(start[currentActivity], end[currentActivity], start[jessie[j]], end[jessie[j]])) {
		    	        			jessieIsBusy = true;
		    	        		}
		        			}
		        			if (!jessieIsBusy) {
		        				jessie[jessieIndex++] = currentActivity;
		        			}else {
		        				for (int c = 0; c < cameronIndex; c++) {
		        	        		if (overlap(start[currentActivity], end[currentActivity], start[cameron[c]], end[cameron[c]])) {
		        	        			cameronIsAlsoBusy = true;
		        	        			result = "IMPOSSIBLE";
		        	        		}
		        				}
		        				if (!cameronIsAlsoBusy) {
		            				cameron[cameronIndex++] = currentActivity;
		        				}
		        			}
			        	}
		        	}
	        	}

        		if (!result.equals("IMPOSSIBLE")) {
		        	for (int i = 0; i < numOfActivitis; i++) {
		        		boolean jesDuty = false;
		        		for (int j = 0; j < numOfActivitis; j++) {
		        			if (jessie[j] == i) {
		        				jesDuty = true;
		        			}
		        		}
		        		if (jesDuty) {
		        			result += 'J';
		        		}else {
		        			result += 'C';
		        		}
		        	}
	        	}
	        	System.out.println("Case #" + (caseNum+1) + ": " + result);
	}
	        in.close();
}

	public static boolean overlap(int startFirst, int endFirst, int startSecond, int endSecond) {
		return (startSecond >= startFirst && startSecond < endFirst ||
				startFirst >= startSecond && startFirst < endSecond);
	}
}

