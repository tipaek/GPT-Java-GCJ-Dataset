//package round1c2020;
/*
ID: urd00m
LANG: JAVA
TASK: fan
 */
import java.io.*;
import java.util.*;

public class Solution {
	static int t; 
	static int x, y; 
	static String m; 
	public static void main(String args[]) throws IOException { 
		//input 
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input; 
		t = Integer.parseInt(f.readLine()); 
		for(int cn = 1; cn < t+1; cn++) {
			//binary search 
			//the data is sorted in a way 
			input = new StringTokenizer(f.readLine()); 
			x = Integer.parseInt(input.nextToken()); y = Integer.parseInt(input.nextToken()); m = input.nextToken();
			
			//the position of the cat at a specific time
			int[][] position = new int[m.length()+1][2]; //x y away from the person
			position[0][0] = x; 
			position[0][1] = y; 
			for(int i = 0; i < m.length(); i++) {
				position[i+1][0] = position[i][0]; position[i+1][1] = position[i][1]; 
				if(m.charAt(i) == 'N') position[i+1][1]++; 
				else if(m.charAt(i) == 'S') position[i+1][1]--; 
				else if(m.charAt(i) == 'E') position[i+1][0]++; 
				else position[i+1][0]--; 
			}
			
			//binary search 
			int l = 0; 
			int r = m.length(); 
			while(l+1 < r) {
				int mid = (l+r)/2; 
				int totalDist = Math.abs(position[mid][0])+Math.abs(position[mid][1]); 
				if(totalDist <= mid) {
					r = mid; 
				}
				else {
					l = mid;
				}
			}
			boolean impossible = false; 
			int totalDist = Math.abs(position[r][0])+Math.abs(position[r][1]); 
			if(totalDist > r) {
				impossible = true; 
			}
			//output
			if(x == 0 && y == 0) System.out.println("Case #" + cn + ": 0");
			else if(impossible == true) System.out.println("Case #" + cn + ": IMPOSSIBLE");
			else System.out.println("Case #" + cn + ": " + r);
		}
	}
}

