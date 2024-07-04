import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	      int sum = in.nextInt();
	      boolean[][] visited = new boolean[500][501];
	      visited[0][0] = true;
	      sum -= 1;
	      List<int[]> path = new ArrayList<int[]>();
	      path.add(new int[]{1,1});
	      if (s.walk(visited, sum, 0 , 0, path)) {
	    	  System.out.println("Case #" + i + ": ");
	    	  for (int[] step : path) {
	    		  System.out.println(step[0] + " " + step[1]);
	    	  }
	      }

	      
	    }
	    in.close();

	}
	
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	private int fact(int n) {
		if (n <= 1) return n;
		if (!map.containsKey(n)) {
			map.put(n, n * fact(n-1));
		}
		return map.get(n);
	}

	int[][] dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {1,1}, {-1,-1}, {-1,0}};
	private boolean walk(boolean[][] visited, int sum, int r, int k, List<int[]> path) {
		if (sum == 0) return true;
		if (sum < 0) return false;
		if (path.size() > 500) return false;
		

		for (int[] dir : dirs) {
			int newR = r + dir[0];
			int newK = k + dir[1];
			
			if (newR >= 0 && newR < 500 && newK >= 0 && newK <= newR && !visited[newR][newK]) {
				visited[newR][newK] = true;
				path.add(new int[] {newR+1, newK+1});

				if (walk(visited, sum - calc(newR, newK), newR, newK, path)) return true;
				path.remove(path.size() -1);
				visited[newR][newK] = false;
				
			}
		}
		return false;
	}
	private int calcFirst(int r, int k) {
		if (r == k) return 1;
		return r * calcFirst(r -1, k);
	}
	
	private int calc(int r, int k) {
		if (k == 0 || k == r) return 1;
		return calcFirst(r, k) * (fact(r - k));
	}

}
