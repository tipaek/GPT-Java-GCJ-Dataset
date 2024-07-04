
import java.util.*;
import java.io.*;

public class Solution {
	
	static Set<int[]> seen = new HashSet<>();
	
	public static int[] getArr(int[][]nums, int sorted[][], int k) {
		for(int i = 0; i < nums.length; i++) {
			if(nums[i][0] == sorted[k][0] && nums[i][1] == sorted[k][1] && !seen.contains(nums[i])) {
				seen.add(nums[i]);
				return nums[i];
			}
		}
		return nums[0];
	}
	
	public static void schedule(int[][] nums, int caseNum) {
		
		int[][] sorted = new int[nums.length][2];
		for(int i = 0; i < nums.length;  i++) {
			sorted[i][0] = nums[i][0];
			sorted[i][1] = nums[i][1];
		}
		Arrays.sort(sorted, Comparator.comparingDouble(a -> a[0]));
		
		Map<int[], String> map = new HashMap<>();
		
		StringBuilder sb = new StringBuilder();
		
		List<List<Integer>> j = new ArrayList<>();
		List<List<Integer>> c = new ArrayList<>();
		
		j.add(new ArrayList<Integer>(Arrays.asList(sorted[0][0], sorted[0][1])));
		int[] temp = getArr(nums, sorted, 0);
		map.put(temp, "J");
		
		int prev_start = temp[0];
		int prev_end = temp[1];
		int start = 1;
		int end = 1;
		
		for(int i = 1; i < sorted.length; i++) {
			if(prev_start == sorted[i][0] && prev_end == sorted[i][1]) {
				start++;
				end++;
				if(start > 2 && end > 2) {
					System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
					return;
				}
				
			}
			else {
				prev_start = sorted[i][0];
				prev_end = sorted[i][1];
				start = 1;
				end = 1;
			}
			if(c.isEmpty()) {
				c.add(new ArrayList<Integer>(Arrays.asList(sorted[i][0], sorted[i][1])));
				temp = getArr(nums, sorted, i);
				map.put(temp, "C");
			}
			//if we cant add to any
			else if((sorted[i][0] >= j.get(j.size()-1).get(0) && sorted[i][0] < j.get(j.size()-1).get(1)) && 
					(sorted[i][0] >= c.get(c.size()-1).get(0) && sorted[i][0] < c.get(c.size()-1).get(1))) {
				System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
				return;
			}
			//add to j first if we can't add to j then add to c
			else if(sorted[i][0] >= j.get(j.size()-1).get(0) && sorted[i][0] < j.get(j.size()-1).get(1)) {
				//add to c
				c.add(new ArrayList<Integer>(Arrays.asList(sorted[i][0], sorted[i][1])));
				temp = getArr(nums, sorted, i);
				map.put(temp, "C");
			}
			else {
				//add to j
				j.add(new ArrayList<Integer>(Arrays.asList(sorted[i][0], sorted[i][1])));
				temp = getArr(nums, sorted, i);
				map.put(temp, "J");
			}
			
		}
		for(int[] num: nums) {
//			System.out.println(num[0] + " " + num[1]);
			sb.append(map.get(num));
		}
		System.out.println("Case #" + caseNum + ": " + sb.toString());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = Integer.parseInt(in.nextLine());
		for(int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[][] nums = new int[n][2];
			for(int k = 0; k < n; k++) {
				for(int j = 0; j < 2; j++) { //start and end
					int temp = in.nextInt();
					nums[k][j] = temp;
				}
			}
			schedule(nums,i);
		}

	}

}
