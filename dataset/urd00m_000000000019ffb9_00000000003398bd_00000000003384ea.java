//package round22020;
/*
ID: urd00m
LANG: JAVA
TASK: pancake
 */
import java.io.*;
import java.util.*;

public class Solution {
	static int t; 
	static long l, r; 
	public static void main(String args[]) throws IOException { 
		//input 
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input; 
		t = Integer.parseInt(f.readLine()); 
		for(int cn = 1; cn < t+1; cn++) {
			input = new StringTokenizer(f.readLine()); 
			l = Long.parseLong(input.nextToken()); r = Long.parseLong(input.nextToken()); 
			//determine the max number of items before the stacks equal each other 
			//simulation 
			int i = 1; 
			boolean possible = true;
			int n = 0; 
			while(possible) {
				possible = false;
				if(l == r) {
					if(l >= i) {
						n++; 
						l-=i; 
						possible = true; 
					}
				}
				else if(l > r) {
					if(l >= i) {
						n++; 
						l-=i; 
						possible = true; 
					}
				}
				else { // r > l 
					if(r >= i) {
						n++; 
						r-=i; 
						possible = true; 
					}
				}
				i++; 
			}
			
			//output
			System.out.println("Case #" + cn + ": " + n + " " + l + " " + r);
		}
	}
}
