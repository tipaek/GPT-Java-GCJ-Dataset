
import java.util.*;
import java.io.*;

public class Solution {
	
	public static void latinSquare(int[][] nums, int caseNum) {
		
		int k = 0;
		int r = 0;
		int c = 0;
		Map<String, Integer> map = new HashMap<>();
		Set<String> seen = new HashSet<>();
		
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums[i].length; j++) {
				int current_val = nums[i][j];
				if(i == j)
					k += current_val;
				String temp = current_val + " at row " + i;
				map.put(temp, map.getOrDefault(temp, 0) + 1);
				if(map.get(temp).intValue() == 2) {
					String unique = "duplicate in row " + i;
					if(!seen.contains(unique)) {
						seen.add(unique);
						r += 1;
					}
				}
				temp = current_val + " at column " + j;
				map.put(temp, map.getOrDefault(temp, 0) + 1);
				if(map.get(temp).intValue() == 2) {
					String unique = "duplicate in column " + j;
					if(!seen.contains(unique)) {
						seen.add(unique);
						c += 1;
					}
				}
			}
		}
		System.out.println("Case #" + caseNum + ": " + k + " " + r + " " + c);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[][] nums = new int[n][n];
			for(int k = 0; k < nums.length; k++) {
				for(int j = 0; j < nums[k].length; j++) {
					int temp = in.nextInt();
					nums[k][j] = temp;
				}
			}
			latinSquare(nums, i);
		}
	}

}
