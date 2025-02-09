//package round22020;
/*
ID: urd00m
LANG: JAVA
TASK: Security
 */
import java.io.*;
import java.util.*;

public class Solution {
	static int t; 
	static int n; 
	static HashMap<Integer, Integer> x, y;
	static HashMap<Double, Integer> slopes; 
	public static void main(String args[]) throws IOException { 
		//input 
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input; 
		t = Integer.parseInt(f.readLine()); 
		for(int cn = 1; cn < t+1; cn++) {
			n = Integer.parseInt(f.readLine()); 
			//sort into blocks 
			x = new HashMap<Integer, Integer>(); 
			y = new HashMap<Integer, Integer>(); 
			slopes = new HashMap<Double, Integer>(); 
			int[][] points = new int[n][2]; 
			for(int i = 0; i < n; i++) {
				input = new StringTokenizer(f.readLine()); 
				int a = Integer.parseInt(input.nextToken()); int b = Integer.parseInt(input.nextToken());
				points[i][0] = a; points[i][1] = b; 
				if(x.containsKey(a)) {
					x.put(a, x.get(a)+1); 
				}
				else {
					x.put(a, 1); 
				}
				if(y.containsKey(b))
					y.put(b, y.get(b)+1); 
				else 
					y.put(b, 1); 
			}
			//brute force the slopes
			for(int i = 0; i < n; i++) {
				for(int j = i+1; j < n; j++) {
					//System.out.println(i + " " + j);
					if(points[i][1] == points[j][1] || points[i][0] == points[j][0]) continue;
					//System.out.println(i + " " + j);
					Double slope = (Math.abs(points[i][1]-points[j][1])+0.0)/(Math.abs(points[i][0]-points[j][0])+0.0); 
					if(slopes.containsKey(slope)) {
						slopes.put(slope, slopes.get(slope)+1);
						//System.out.println(slopes.get(slope));
					}
					else {
						slopes.put(slope, 1);
						//System.out.println(slopes.get(slope));
					}
				}
			}
			//counting the maximum number of "Even" sections 
			int xMax = 0;
			int numOdds = 0; 
			for(int item : x.keySet()) {
				if(x.get(item) == 1) numOdds++; 
				else {
					xMax += x.get(item); 
				}
			}
			int yMax = 0; 
			int yOdds = 0; 
			for(int item : y.keySet()) {
				if(y.get(item) == 1) yOdds++; 
				else {
					yMax += y.get(item); 
				}
			}
			int slopeMax = 0; 
			for(double item : slopes.keySet()) {
				int add = 0; 
				if(slopes.get(item)%2==1) add = Math.min(1, n-slopes.get(item));
				else add = Math.min(2, n-slopes.get(item)); 
				slopeMax = Math.max(slopeMax, slopes.get(item)+add); 
			}
			if(xMax%2==0) xMax += Math.min(2, numOdds); 
			else xMax += Math.min(1, numOdds); 
			if(yMax%2==0) yMax += Math.min(2, yOdds); 
			else yMax += Math.min(1, yOdds); 
			//output
			//System.out.println(slopeMax); 
			System.out.println("Case #" + cn + ": " + Math.max(xMax, Math.max(slopeMax, yMax)));
			 
		}
	}
}
