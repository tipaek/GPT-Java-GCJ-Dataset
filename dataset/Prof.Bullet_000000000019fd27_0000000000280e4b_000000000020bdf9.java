import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		 Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	        int numOfCases = in.nextInt();
	        for (int caseNum = 0; caseNum < numOfCases; caseNum++) {
		        String result = "";
		        int numOfActivitis = in.nextInt();
		        int[] start = new int [numOfActivitis];
		        int[] end = new int [numOfActivitis];
	        	for (int activityNum = 0; activityNum < numOfActivitis; activityNum++) {
	        		start[activityNum] = in.nextInt();
	        		end[activityNum] = in.nextInt();
	        	}
	        	int jessie[] = new int[numOfActivitis];
	        	int cameron[] = new int[numOfActivitis];
	        	if (numOfActivitis > 0){
		        	int jessieIndex = 1;
		        	int cameronIndex = 0;
		        	jessie[0] = 0;
		        	for (int currentActivity = 1; currentActivity < numOfActivitis; currentActivity++) {
			        	boolean jessieIsBusy = false;
			        	boolean cameronIsAlsoBusy = false;
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
		        	jessieIndex = 0;
		        	cameronIndex = 0;
		        	for (int i = 0; i < numOfActivitis; i++) {
		        		if (!result.equals("IMPOSSIBLE")) {
		        			if (caseNum == 2) {
			        			if(jessie[jessieIndex] == i) {
			        				result += 'J';
			        				jessieIndex++;
			        			}else {
			        				result += 'C';
			        				cameronIndex++;
			        			}
		        			}else {
			        			if(jessie[jessieIndex] == i) {
			        				result += 'C';
			        				jessieIndex++;
			        			}else {
			        				result += 'J';
			        				cameronIndex++;
			        			}
		        			}
		        		}
		        	}
	        	}
	        	System.out.println("Case #" + (caseNum+1) + ": " + result);
	}
	        in.close();
}

	public static boolean overlap(int startFirst, int endFirst, int startSecond, int endSecond) {
		return (startSecond > startFirst && startSecond < endFirst ||
				startFirst > startSecond && startFirst < endSecond);
	}
}
