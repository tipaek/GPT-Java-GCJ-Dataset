import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = sc.nextInt();

		for(int testCase =1; testCase <=testCases ; testCase++) {

			int activities = sc.nextInt();
			int[] startTime = new int[activities];
			int[] endTime = new int[activities];

			for(int i = 0; i<activities; i++) {
				startTime[i] = sc.nextInt();
				endTime[i] = sc.nextInt();
			}

			scheduleActivities(startTime, endTime, activities, testCase);
		}
	}

	private static void scheduleActivities(int[] startTime, int[] endTime, int activities, int testCase) {

		LinkedList<Integer> cStartTime = new LinkedList<>();
		LinkedList<Integer> cEndTime = new LinkedList<>();

		LinkedList<Integer> jStartTime = new LinkedList<>();
		LinkedList<Integer> jEndTime = new LinkedList<>();

		StringBuilder s = new StringBuilder();

		cStartTime.add(100000);
		cEndTime.add(100000);

		jStartTime.add(100000);
		jEndTime.add(1000000);

		outer: for( int i=0; i < activities; i++) {
			boolean cOverlapping = false;
			boolean jOverlapping = false;
			for(int j=0; j<cStartTime.size(); j++) {
				if((startTime[i] > cStartTime.get(j) && startTime[i] < cEndTime.get(j)) || (endTime[i] > cStartTime.get(j) && endTime[i] < cEndTime.get(j))) {

					cOverlapping = true;
					break;
				}
			}

			if(!cOverlapping) {
				s.append("C");
				cStartTime.add(startTime[i]);
				cEndTime.add(endTime[i]);
				continue outer;
			}


			for(int j=0; j<jStartTime.size(); j++) {
				if((startTime[i] > jStartTime.get(j) && startTime[i] < jEndTime.get(j)) || (endTime[i] > jStartTime.get(j) && endTime[i] < jEndTime.get(j))) {

					jOverlapping = true;
					break;

				}
			}	
			if(!jOverlapping) {
				s.append("J");
				jStartTime.add(startTime[i]);
				jEndTime.add(endTime[i]);
				continue outer;
			}



			if (cOverlapping && jOverlapping)
			{
				s = new StringBuilder("IMPOSSIBLE");
				break outer;
			}

		}

		display(s.toString(), testCase);
	}

	private static void display(String s, int testCase) {

		System.out.println("Case #" +testCase + ": " + s);
	}


}
