import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		 Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	        int numOfCases = in.nextInt();
	        for (int caseNum = 0; caseNum < numOfCases; caseNum++) {
		        String result = "IMPOSSIBLE";
		        int numOfActivitis = in.nextInt();
		        int[] start = new int [numOfActivitis];
		        int[] end = new int [numOfActivitis];
	        	for (int activityNum = 0; activityNum < numOfActivitis; activityNum++) {
	        		start[activityNum] = in.nextInt();
	        		end[activityNum] = in.nextInt();
	        	}
	        	int[] jessie = new int[numOfActivitis];
	        	int[] cameron = new int[numOfActivitis];
	        	Arrays.fill(jessie, -1);
	        	Arrays.fill(cameron, -1);
	        	long timerStart = System.currentTimeMillis();
	        	while (System.currentTimeMillis() < timerStart + 0.4*100) {
		        	int jessieIndex = 0;
		        	int cameronIndex = 0;
	        		boolean found = true;
	        		for (int currentActivity = 0; currentActivity < numOfActivitis; currentActivity++) {
	        			if (Math.random() < 0.5) {
	        				jessie[jessieIndex++] = currentActivity;
	        			}else {
	        				cameron[cameronIndex++] = currentActivity;
	        			}
	        		}
	        		for (int j = 0; j < jessieIndex; j++) {
	        			for (int k = 0; k < jessieIndex; k++) {
		        			if (j != k && overlap(start[jessie[j]], end[jessie[j]], start[jessie[k]], end[jessie[k]])) {
		        				found = false;
		        				break;
		        			}
	        			}
	        		}
	        		for (int j = 0; j < cameronIndex; j++) {
	        			for (int k = 0; k < cameronIndex; k++) {
		        			if (j != k && overlap(start[cameron[j]], end[cameron[j]], start[cameron[k]], end[cameron[k]])) {
		        				found = false;
		        				break;
		        			}
	        			}
	        		}
	        		if (found == true) {
	        			result = "";
	        			break;
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

