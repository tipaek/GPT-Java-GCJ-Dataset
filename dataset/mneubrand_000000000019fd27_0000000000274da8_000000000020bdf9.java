import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int numCases = Integer.parseInt(br.readLine());
			for (int i = 0; i < numCases; i++) {
				System.out.println("Case #" + (i + 1) + ": " + handleCase(br));
			}
		}
	}

	private static String handleCase(BufferedReader br) throws Exception {
		int n = Integer.parseInt(br.readLine());

		List<int[]> activities = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			activities.add(new int[] { Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), i });
		}

		List<int[]> cameron = new ArrayList<int[]>();
		cameron.add(activities.get(0));
		List[] valid = genVariants(activities, cameron, new ArrayList<int[]>(), 1);
		if(valid != null) {
			return printVariant(valid[0], valid[1], n);
		} else {
			return "IMPOSSIBLE";
		}
	}

	private static List[] genVariants(List<int[]> activities, List<int[]> cameron, List<int[]> jamie, int start) {
		if(start >= activities.size()) {
			return new List[] { cameron, jamie };
		}
		
		int[] current = activities.get(start);
		boolean cameronAdd = checkAdd(cameron, current);
		boolean jamieAdd = checkAdd(jamie, current);
		
		if(cameronAdd && !jamieAdd) {
			cameron.add(current);
			return genVariants(activities, cameron, jamie, start+1);
		} else if(!cameronAdd && jamieAdd) {
			jamie.add(current);
			return genVariants(activities, cameron, jamie, start+1);
		} else if(cameronAdd && jamieAdd) {
			List<int[]> cameronCopy = new ArrayList<>(cameron);
			List<int[]> jamieCopy = new ArrayList<>(jamie);
			
			jamie.add(current);
			List[] ret = genVariants(activities, cameron, jamie, start+1);
			if (ret != null) {
				return ret;
			}
			
			cameronCopy.add(current);
			ret = genVariants(activities, cameronCopy, jamieCopy, start+1);
			if (ret != null) {
				return ret;
			}
			
			return null;
		} else {
			return null;
		}
	}
	
	private static boolean checkAdd(List<int[]> schedule, int[] current) {
		for(int j = 0; j < schedule.size(); j++) {
			int[] compare = schedule.get(j);				
			if(current[0] < compare[1] && compare[0] < current[1]) {
				return false;
			}
		}
		
		return true;
	}

	private static String printVariant(List<int[]> cameron, List<int[]> jamie, int n) {
		char[] solution = new char[n];
		printSchedule(cameron, solution, 'C');
		printSchedule(jamie, solution, 'J');
		return new String(solution);
	}

	private static void printSchedule(List<int[]> schedule, char[] solution, char who) {
		for(int i = 0; i < schedule.size(); i++) {
			int[] current = schedule.get(i);
			solution[current[2]] = who;
		}
	}
	
}
