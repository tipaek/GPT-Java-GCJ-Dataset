import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
	
	static PrintWriter out;
	
	static final String INVALID = "IMPOSSIBLE";
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		out = new PrintWriter(System.out, true);
		
		int t = in.nextInt();
	    for (int i = 0; i < t; i++) {
	    	int n = in.nextInt();
	    	TreeMap<Integer, Activity> map = new TreeMap(new ActivityComparator());
	    	Activity[] array = new Activity[n];
	    	for (int j = 0; j < n; j++) {
	    		int s = in.nextInt();
	    		int e = in.nextInt();
	    		Activity a = new Activity();
	    		a.startTime = s;
	    		a.endTime = e;
	    		
	    		map.put(s, a);
	    		array[j] = a;
	    	}
	        boolean possible = solveCase(map);

			out.println(String.format("Case #%d: %s", i + 1, printSolution(possible, array)));
	    }
	    
	    out.close();
	    System.exit(0);
	}
	
	static boolean solveCase(TreeMap<Integer, Activity> map) {
		int minC = 0, minJ = 0;
		Map.Entry<Integer, Activity> iterator = map.pollFirstEntry();
		while (iterator != null) {
			if (iterator.getKey() < Math.min(minC, minJ)) {
				return false;
			}
			iterator.getValue().assignedToC = minJ >= minC;
			if (iterator.getValue().assignedToC) {
				minC = iterator.getValue().endTime;
			} else {
				minJ = iterator.getValue().endTime;
			}
			
			iterator = map.pollFirstEntry();
		}
		
		return true;
	}
	
	static String printSolution(boolean possible, Activity[] array) {
		if (possible) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < array.length; i++) {
				sb.append(array[i].assignedToC ? 'C' : 'J');
			}
			return sb.toString();
		} else {
			return INVALID;
		}
	}
	
	static class Activity {
		int startTime;
		int endTime;
		boolean assignedToC;
	}
	
	static class ActivityComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return Integer.compare(o1, o2);
		}
		
	}

}
