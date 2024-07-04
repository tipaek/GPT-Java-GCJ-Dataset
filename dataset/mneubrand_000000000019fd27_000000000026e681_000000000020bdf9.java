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

		// Check all options
		int size = activities.size();
		boolean[] flags = new boolean[size];
		for (int i = 0; i != size;) {
			List<int[]> cameron = new ArrayList<>();
			List<int[]> jamie = new ArrayList<>();
			
			boolean shouldCheck = true;
			for (int j = 0; j < size; j++) {
				int[] activity = activities.get(j);
				if (flags[j]) {
					boolean added = checkAdd(cameron, activity);
					if(!added) {
						shouldCheck = false;
						break;
					}
				} else {
					boolean added = checkAdd(jamie, activity);
					if(!added) {
						shouldCheck = false;
						break;
					}
				}
			}
			
			if(shouldCheck) {
				String ret = checkVariant(cameron, jamie, n);
				if(!ret.equals("IMPOSSIBLE")) {
					return ret;
				}
			}
			
			for (i = 0; i < size && !(flags[i] = !flags[i]); i++)
				;
		}

		return "IMPOSSIBLE";
	}

	private static String checkVariant(List<int[]> cameron, List<int[]> jamie, int n) {
		char[] solution = new char[n];
		
		boolean cameronOverlap = checkSchedule(cameron, solution, 'C');
		boolean jamieOverlap = checkSchedule(jamie, solution, 'J');
		
		return !cameronOverlap && !jamieOverlap ? new String(solution) : "IMPOSSIBLE";
	}

	private static boolean checkSchedule(List<int[]> schedule, char[] solution, char who) {
		for(int i = 0; i < schedule.size(); i++) {
			int[] current = schedule.get(i);
			solution[current[2]] = who;
			for(int j = i+1; j < schedule.size(); j++) {
				int[] compare = schedule.get(j);				
				if(current[0] < compare[1] && compare[0] < current[1]) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private static boolean checkAdd(List<int[]> schedule, int[] current) {
		for(int j = 0; j < schedule.size(); j++) {
			int[] compare = schedule.get(j);				
			if(current[0] < compare[1] && compare[0] < current[1]) {
				return false;
			}
		}
		
		schedule.add(current);
		return true;
	}

}
