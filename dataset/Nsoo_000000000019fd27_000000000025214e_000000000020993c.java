import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public final int ROW = 0;
	public final int COL = 1;
	
	public static void main(String[] args) {
		new Solution().solution();
//		System.out.println(answer);
		
		
	}

	public void solution() {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int i = 1; i <= tc; i++) {
			int n = sc.nextInt();
			
			int[][] arr = new int[n][n];
			
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			
			System.out.println("Case #"+i+": "+getTrace(arr) + " " + getRepeatCount(arr, ROW) + " " + getRepeatCount(arr, COL));
		}
		
		sc.close();
	}
	
	public int getRepeatCount(int[][] map, int dir) {
		int cnt = 0;
		
		for (int i = 0; i < map.length; i++) {
			Set<Integer> set = new HashSet<>();
			for (int j = 0; j < map.length; j++) {
				if(dir == ROW) {
					if(set.contains(map[i][j])) {
						cnt++;
						break;
					} else {
						set.add(map[i][j]);
					}
				} else if(dir == COL) {
					if(set.contains(map[j][i])) {
						cnt++;
						break;
					} else {
						set.add(map[j][i]);
					}
				}
			}
		}
		
		return cnt;
	}
	
	public int getTrace(int[][] map) {
		int trace = 0;
		
		for (int i = 0; i < map.length; i++) {
			trace += map[i][i];
		}
		
		return trace;
	}
}