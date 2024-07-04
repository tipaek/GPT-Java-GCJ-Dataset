import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			int n = Integer.parseInt(in.readLine());
			int r = 0;
			
			int sum = 0;
			int[][] nums = new int[n][n];
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				boolean[] vis = new boolean[n+1];
				boolean rep = false;
				for(int j = 0; j < n; j++) {
					nums[i][j] = Integer.parseInt(st.nextToken());
					if(vis[nums[i][j]]) rep = true;
					vis[nums[i][j]] = true;
					
					if(i == j) sum += nums[i][j];
				}
				if(rep) r++;
			}
			
			int c = 0;
			for(int j = 0; j < n; j++) {
				boolean[] vis = new boolean[n+1];
				boolean rep = false;
				for(int i = 0; i < n; i++) {
					if(vis[nums[i][j]]) rep = true;
					vis[nums[i][j]] = true;
				}
				if(rep) c++;
			}
			
			System.out.println("Case #" + t + ": " + sum + " " + r + " " + c);
		}
	}
}
