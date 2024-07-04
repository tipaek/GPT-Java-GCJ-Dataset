// Arup Guha

import java.util.*;

public class Solution {
	
	public static int n;
	public static int[][] info;

	public static void main(String[] args) {
	
		// Get basic input.
		Scanner stdin = new Scanner(System.in);
		int nC = stdin.nextInt();
		n = stdin.nextInt();
		
		// Process each case.
		for (int loop=0; loop<nC; loop++) {
			
			// println, then System.out.flush()
			// read in their response via scanner.
				
			System.out.println(1);
			System.out.flush();
			int junk = stdin.nextInt();
			
			info = new int[15][n];
			for (int i=0; i<15; i++) Arrays.fill(info[i], -1);
			
			// This is all of the raw data.
			for (int rnd=0; rnd<n/10; rnd++) {
				
				for (int i=0; i<5; i++) {
					System.out.println(10*rnd+i+1);
					System.out.flush();
					info[rnd][10*rnd+i] = stdin.nextInt();
				}
				
				for (int i=0; i<5; i++) {
					System.out.println(n-(10*rnd+i));
					System.out.flush();
					info[rnd][n-(10*rnd+i)-1] = stdin.nextInt();
				}
				
			}
			
			if (n <= 20) {
				
				// Put result here.
				int[] res = new int[n];
				
				for (int rnd=0; rnd<n/10; rnd++) {
				
					// Get two bits.
					ArrayList<Integer> sample = getSample(5*rnd, rnd);
					int[] ans = new int[sample.size()];
					for (int i=0; i<ans.length; i++) {
						System.out.println(sample.get(i)+1);
						System.out.flush();
						ans[i] = stdin.nextInt();
					}
				
					// assign xor and flip.
					int xor = ans[0] == info[0][sample.get(0)] ? 0 : 1;
				
					int flip = 0;
					if (sample.size() > 1)
						flip = ans[1] == info[0][sample.get(1)] ? 0 : 1;
				
					for (int i=0; i<10; i++) {
						int loc = flip == 0 ? i : n-1-i;
						res[loc] = xor^info[rnd][loc];
					}
				}
				
				for (int i=0; i<n; i++)
					System.out.print(res[i]);
				System.out.println();
				System.out.flush();
				String j = stdin.next();
			}
			
			else {
				
			}
		}
	}
	
	public static ArrayList<Integer> getSample(int s, int rnd) {
		
		// Always add the first one.
		ArrayList<Integer> res = new ArrayList<Integer>();
		res.add(s);
		boolean state = info[rnd][s] == info[rnd][n-1-s];
		
		for (int i=s+1; i<s+5; i++) {
			boolean curState = info[rnd][i] == info[rnd][n-1-i];
			if (curState != state) {
				res.add(i);
				break;
			}
		}
		
		if (!state && res.size() == 2) {
			int tmp = res.get(0);
			res.set(0, res.get(1));
			res.set(1, tmp);
		}
		
		return res;
		
	}
	
	
}