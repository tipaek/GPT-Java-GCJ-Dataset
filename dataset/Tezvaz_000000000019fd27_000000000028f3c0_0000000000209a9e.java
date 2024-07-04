import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String firstLine = in.nextLine();
		
		int totalTestCases = Integer.parseInt(firstLine.split(" ")[0]);
		int B = Integer.parseInt(firstLine.split(" ")[1]);

		for(int i = 0; i < totalTestCases; i++) {
			
			String firstOutput = "";
			for(int j = 0; j < 10; j++) {
				System.out.println(j+1);
				firstOutput += in.nextLine();
			}
			/*
			String secOutput = "";
			for(int j = 0; j < 10; j++) {
				System.out.println(j+1);
				secOutput += in.nextLine();
			}
			
			String thirdOutput = "";
			for(int j = 0; j < 10; j++) {
				System.out.println(j+1);
				thirdOutput += in.nextLine();
			}
			
			String thirdOutput = "";
			for(int j = 0; j < 10; j++) {
				System.out.println(j+1);
				thirdOutput += in.nextLine();
			}*/
			System.out.println(firstOutput);
			in.nextLine();
		}
		
		in.close();
	}

	public static ArrayList<String> getRoutes(ArrayList<String> input, int length) {
		if(length == 1) {
			ArrayList<String> output = new ArrayList<String>();
			output.add("C");
			output.add("J");
			return output;
		} else {
			ArrayList<String> outputTemp = getRoutes(input, length - 1);
			
			ArrayList<String> output = new ArrayList<String>();
			for(String temp : outputTemp) {
				output.add(temp + "C");
				output.add(temp + "J");
			}
			
			return output;
		}
	}
	
	public static boolean routeWorks(String route, int[] startTimes, int[] endTimes) {
		
		ArrayList<Integer> startTimesC = new ArrayList<Integer>();
		ArrayList<Integer> endTimesC = new ArrayList<Integer>();
		ArrayList<Integer> startTimesJ = new ArrayList<Integer>();
		ArrayList<Integer> endTimesJ = new ArrayList<Integer>();
		
		for(int i = 0; i < route.length(); i++) {
			if(route.charAt(i) == 'C') {
				startTimesC.add(startTimes[i]);
				endTimesC.add(endTimes[i]);
			} else if (route.charAt(i) == 'J') {
				startTimesJ.add(startTimes[i]);
				endTimesJ.add(endTimes[i]);
			}
		}
		
		for(int i = 0; i < startTimesC.size(); i++) {
			for(int j = 0; j < startTimesC.size(); j++) {
				if(i != j) {
					if((startTimesC.get(i) < startTimesC.get(j) && startTimesC.get(j) < endTimesC.get(i))
					|| (startTimesC.get(i) < endTimesC.get(j) && endTimesC.get(j) < endTimesC.get(i))
					|| (startTimesC.get(i) == startTimesC.get(j))
					|| (endTimesC.get(i) == endTimesC.get(j))) {
						return false;
					}
				}
			}
		}
		
		for(int i = 0; i < startTimesJ.size(); i++) {
			for(int j = 0; j < startTimesJ.size(); j++) {
				if(i != j) {
					if((startTimesJ.get(i) < startTimesJ.get(j) && startTimesJ.get(j) < endTimesJ.get(i))
					|| (startTimesJ.get(i) < endTimesJ.get(j) && endTimesJ.get(j) < endTimesJ.get(i))
					|| (startTimesJ.get(i) == startTimesJ.get(j))
					|| (endTimesJ.get(i) == endTimesJ.get(j))) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
}