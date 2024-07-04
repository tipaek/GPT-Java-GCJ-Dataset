import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
		
		char[] solution = new char[n];
		
		List<int[]> overlappingActivities = new ArrayList<int[]>();
		for (int i = 0; i < n; i++) {
			int[] current = activities.get(i);
			boolean overlapping = false;
			for(int j = 0; j < n; j++) {
				if(i == j) {
					continue;
				}
				int[] compare = activities.get(j);				
				if(current[0] < compare[1] && compare[0] < current[1]) {
					overlapping = true;
					overlappingActivities.add(current);
					break;
				}
			}
			
			if(!overlapping) {
				solution[i] = 'C';
			}
		}

		if(overlappingActivities.size() > 0) {
			char[] valid = genVariants(overlappingActivities, new boolean[24 * 60], new boolean[24 * 60], 0, solution);
			if(valid != null) {
				return new String(valid);
			} else {
				return "IMPOSSIBLE";
			}
		} else {
			return new String(solution);
		}
	}

	private static char[] genVariants(List<int[]> activities, boolean[] cameron, boolean[] jamie, int start, char[] solution) {
		if(start >= activities.size()) {
			return solution;
		}
		
		int[] current = activities.get(start);
		boolean cameronAdd = checkAdd(cameron, current);
		boolean jamieAdd = checkAdd(jamie, current);
		
		if(cameronAdd && !jamieAdd) {
			Arrays.fill(cameron, current[0], current[1], true);
			solution[current[2]] = 'C';
			return genVariants(activities, cameron, jamie, start+1, solution);
		} else if(!cameronAdd && jamieAdd) {
			Arrays.fill(jamie, current[0], current[1], true);
			solution[current[2]] = 'J';
			return genVariants(activities, cameron, jamie, start+1, solution);
		} else if(cameronAdd && jamieAdd) {
			boolean[] cameronCopy = Arrays.copyOf(cameron, cameron.length);
			boolean[] jamieCopy = Arrays.copyOf(jamie, jamie.length);
			char[] solutionCopy = Arrays.copyOf(solution, solution.length);
			
			Arrays.fill(cameron, current[0], current[1], true);
			solution[current[2]] = 'C';
			char[] ret = genVariants(activities, cameron, jamie, start+1, solution);
			if (ret != null) {
				return ret;
			}
			
			Arrays.fill(jamieCopy, current[0], current[1], true);
			solutionCopy[current[2]] = 'J';
			ret = genVariants(activities, cameronCopy, jamieCopy, start+1, solutionCopy);
			if (ret != null) {
				return ret;
			}
		}
		return null;
	}
	
	private static boolean checkAdd(boolean[] array, int[] current) {
		for(int j = current[0]; j < current[1]; j++) {
			if (array[j] != false) {
				return false;
			}
		}
		return true;
	}

}
