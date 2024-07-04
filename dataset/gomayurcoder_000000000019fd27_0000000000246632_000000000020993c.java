import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = s.nextInt();
		for(int ti=1;ti<=t;ti++)
		{
			int n = s.nextInt();
			int[][] arr = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j] = s.nextInt();
				}
			}
			
			int ans1 = 0;
			for(int i=0;i<n;i++) {
				int j = i;
				ans1 += arr[i][j];
			}
			
			int ans2 = 0;
			for(int i=0;i<n;i++) {
				boolean[] vis = new boolean[n];
				for(int j=0;j<n;j++) {
					if(vis[arr[i][j]-1]) {
						ans2++;
						break;
					}
					vis[arr[i][j]-1] = true;
				}
			}
			
			int ans3 = 0;
			for(int j=0;j<n;j++) {
				boolean[] vis = new boolean[n];
				for(int i=0;i<n;i++) {
					if(vis[arr[i][j]-1]) {
						ans3++;
						break;
					}
					vis[arr[i][j]-1] = true;
				}
			}
			
			System.out.println("Case #"+ti+": "+ans1+" "+ans2+" "+ans3);

		}
	}
}