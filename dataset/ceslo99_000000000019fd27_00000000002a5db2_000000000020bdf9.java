
import java.util.*;
import java.io.*;

public class Solution {
	
	
	
	static Set<int[]> seen = new HashSet<>();
	
	public static void main(String[] args) {
	
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = Integer.parseInt(in.nextLine());
		for(int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[][] arr = new int[n][2];
			for(int k = 0; k < n; k++) {
				for(int j = 0; j < 2; j++) { 
					int temp = in.nextInt();
					arr[k][j] = temp;
				}
			}
			schedule(arr,i);
		}

	}
	
	public static int[] getArr(int[][]arr, int sorted[][], int k) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i][0] == sorted[k][0] && arr[i][1] == sorted[k][1] && !seen.contains(arr[i])) {
				seen.add(arr[i]);
				return arr[i];
			}
		}
		return arr[0];
	}
	
	public static void schedule(int[][] arr, int caseNum) {
		
		int[][] sortedArr = new int[arr.length][2];
		for(int i = 0; i < arr.length;  i++) {
			sortedArr[i][0] = arr[i][0];
			sortedArr[i][1] = arr[i][1];
		}
		Arrays.sort(sortedArr, Comparator.comparingDouble(q -> q[0]));
		
		List<List<Integer>> jJobs = new ArrayList<>();
		List<List<Integer>> cJobs = new ArrayList<>();
		
		Map<int[], String> jobs = new HashMap<>();
		
		StringBuilder answer = new StringBuilder();
		
		
		
		jJobs.add(new ArrayList<Integer>(Arrays.asList(sortedArr[0][0], sortedArr[0][1])));
		int[] temp = getArr(arr, sortedArr, 0);
		jobs.put(temp, "J");
		
		int previousS = temp[0];
		int previousE = temp[1];
		int s = 1;
		int e = 1;
		
		for(int i = 1; i < sortedArr.length; i++) {
			if(previousS == sortedArr[i][0] && previousE == sortedArr[i][1]) {
				s++;
				e++;
				if(s > 2 && e > 2) {
					System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
					return;
				}
				
			}
			else {
				previousS = sortedArr[i][0];
				previousE = sortedArr[i][1];
				s = 1;
				e = 1;
			}
			if(cJobs.isEmpty()) {
				cJobs.add(new ArrayList<Integer>(Arrays.asList(sortedArr[i][0], sortedArr[i][1])));
				temp = getArr(arr, sortedArr, i);
				jobs.put(temp, "C");
			}
			
			else if((sortedArr[i][0] >= jJobs.get(jJobs.size()-1).get(0) && sortedArr[i][0] < jJobs.get(jJobs.size()-1).get(1)) && 
					(sortedArr[i][0] >= cJobs.get(cJobs.size()-1).get(0) && sortedArr[i][0] < cJobs.get(cJobs.size()-1).get(1))) {
				System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
				return;
			}
			
			else if(sortedArr[i][0] >= jJobs.get(jJobs.size()-1).get(0) && sortedArr[i][0] < jJobs.get(jJobs.size()-1).get(1)) {
				
				cJobs.add(new ArrayList<Integer>(Arrays.asList(sortedArr[i][0], sortedArr[i][1])));
				temp = getArr(arr, sortedArr, i);
				jobs.put(temp, "C");
			}
			else {
				
				jJobs.add(new ArrayList<Integer>(Arrays.asList(sortedArr[i][0], sortedArr[i][1])));
				temp = getArr(arr, sortedArr, i);
				jobs.put(temp, "J");
			}
			
		}
		for(int[] num: arr) {
			answer.append(jobs.get(num));
		}
		System.out.println("Case #" + caseNum + ": " + answer.toString());
		
	}

	

}
