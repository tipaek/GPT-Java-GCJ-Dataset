import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*Quick Notes
Use BigInteger & BigDecimal for large numbers - They are arbitrarily precise.

*/
public class Solution {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int totalTestCases = Integer.parseInt(in.nextLine());

		for(int i = 0; i < totalTestCases; i++) {
			
			int N = Integer.parseInt(in.nextLine());
			int[] startTimes = new int[N];
			int[] endTimes = new int[N];
			
			for(int j = 0; j < N; j++) {
				String line = in.nextLine();
				startTimes[j] = Integer.parseInt(line.split(" ")[0]);
				endTimes[j] = Integer.parseInt(line.split(" ")[1]);
			}
			
			String solution = "";
			
			ArrayList<String> allRoutes = getRoutes(null, N);
			//routeWorks("JJCCC", startTimes, endTimes);
			for(String route : allRoutes) {
				if(routeWorks(route, startTimes, endTimes)) {
					solution = route;
					continue;
				}
			}
			
			if(solution.isEmpty()) {
				System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + (i+1) + ": " + solution);
			}
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
					|| (startTimesC.get(i) < endTimesC.get(j) && endTimesC.get(j) < endTimesC.get(i))) {
						return false;
					}
				}
			}
		}
		
		for(int i = 0; i < startTimesJ.size(); i++) {
			for(int j = 0; j < startTimesJ.size(); j++) {
				if(i != j) {
					if((startTimesJ.get(i) < startTimesJ.get(j) && startTimesJ.get(j) < endTimesJ.get(i))
					|| (startTimesJ.get(i) < endTimesJ.get(j) && endTimesJ.get(j) < endTimesJ.get(i))) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
}
