import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		int p = t;
		while(t-->0) {
			int n = scn.nextInt();
			int[][] arr = new int[n][n];
			int trace = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j] = scn.nextInt();
					if(i==j)
						trace += arr[i][j];
				}
			}
			int r = 0;
			HashMap<Integer, Integer> map = new HashMap<>();
			for(int i=0; i<n; i++) {
				map.clear();
				for(int j=0; j<n; j++)
					map.put(arr[i][j], 1);
				if(map.size()<n)
					r++;
			}
			int c = 0;
			for(int i=0; i<n; i++) {
				map.clear();
				for(int j=0; j<n; j++)
					map.put(arr[j][i], 1);
				if(map.size()<n)
					c++;
			}
			System.out.println("Case #" + (p-t) + ": " + trace + " " + r + " "+ c);
		}
	}
	

}

