//package round1b2020;

/*
ID: urd00m
LANG: JAVA
TASK: rhyme
 */
import java.io.*;
import java.util.*;

public class Solution {
	static int t;
	static int x, y;
	static ArrayList<String> ret; 
	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer input;
		t = Integer.parseInt(f.readLine());
		for (int cn = 1; cn < t + 1; cn++) {
			// you need a min of 30 steps for the last test sets
			// two odd numbers are impossible
			// 2 even numbers unless 0,0 is also impossible
			// only if one odd and one even is it possible and the first one has to be inthe
			// direction of the odd one
			// you don't want them to be equal
			// not dp or divide
			// to see if it is possible always subtract the highest power of 2 if their is
			// any overlap between the 2 it is impossible
			// for the odd one you can add 1 or subtract 1 and see if their is any overlap

			// input
			input = new StringTokenizer(f.readLine());
			x = Integer.parseInt(input.nextToken());
			y = Integer.parseInt(input.nextToken());

			// if it is possible
			boolean impossible = false;
			if ((Math.abs(x) % 2 == 0 && Math.abs(y) % 2 == 0) || (Math.abs(x) % 2 == 1 && Math.abs(y) % 2 == 1))
				impossible = true;
			else {
				// running through to see overlap
				// determine which one is odd
				if (Math.abs(x) % 2 == 1) {
					ret = solve(x, y, false);
				} else {
					ret = solve(y, x, true);
				}
			}
			
			// output
			if(impossible == true || ret.size() == 0) System.out.println("Case #" + cn + ": IMPOSSIBLE");
			else {
				System.out.print("Case #" + cn + ": ");
				for(String item : ret) System.out.print(item);
				System.out.println();
			}
		}
	}

	public static ArrayList<String> solve(int a, int b, boolean switched) {
		int[] top = new int[2]; 
		int signTop = a < 0 ? -1 : 1; 
		int signBottom = b < 0 ? -1 : 1; 
		top[0] = Math.abs(a)-1; 
		top[1] = Math.abs(a)+1; 
		b = Math.abs(b); 
		int bStore = b; 
		
		//checking for overlap 
		int[] pow2 = new int[31];
		boolean[] used;  
		pow2[0] = 1; 
		for(int i = 1; i <= 30; i++) {
			pow2[i] = 2*pow2[i-1]; 
		}
		
		int minStep = Integer.MAX_VALUE; 
		ArrayList<String> best = new ArrayList<String>(); 
		for(int i = 0; i < 2; i++) {
			int maxHit = 0; 
			used = new boolean[31]; 
			int steps = 0;
			boolean possible = true; 
			ArrayList<String> ret = new ArrayList<String>();
			b = bStore; 
			for(int j = 30; j >= 1; j--) {
				if(pow2[j] <= top[i]) {
					maxHit = Math.max(maxHit, j); 
					used[j] = true; 
					top[i] = top[i] - pow2[j]; 
					ret.add(convert(signTop, switched)); 
					steps++;
				}
				if(pow2[j] <= b) {
					maxHit = Math.max(maxHit, j); 
					if(used[j] == true) {
						possible = false;
						break; 
					}
					used[j] = true; 
					b = b - pow2[j]; 
					ret.add(convert(signBottom, !switched)); 
					steps++; 
				}
			}
			if(possible == true && steps < minStep && maxHit == steps) {
				minStep = steps;
				if(i == 0) ret.add( convert(1*signTop, switched) ); 
				else ret.add( convert(-1*signTop, switched) ); 
				best = ret; 
			}	
		}
		Collections.reverse(best); 
		return best; 

	}
	
	public static String convert(int sign, boolean top) {
		if(top == true && sign == -1) return "S"; 
		else if(top == true && sign == 1) return "N"; 
		else if(top == false && sign == -1) return "W"; 
		else return "E"; 
	}

	// for outputting
	public static class pair {
		String ret;
		int i;

		public pair(String a, int b) {
			ret = a;
			i = b;
		}
	}
}
