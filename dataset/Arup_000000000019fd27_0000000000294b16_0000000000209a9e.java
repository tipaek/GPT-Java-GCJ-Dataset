// Arup Guha

import java.util.*;

public class Solution {
	
	public static int n;
	public static int[][] info;
	
	public static int[][] QUERIES = {{0,1,2,3},{0,4,5,6},{0,7,8,9}};

	public static void main(String[] args) {
	
		// Get basic input.
		Scanner stdin = new Scanner(System.in);
		int nC = stdin.nextInt();
		n = stdin.nextInt();
		
		// Process each case.
		for (int loop=0; loop<nC; loop++) {
			
			// println, then System.out.flush()
			// read in their response via scanner.
			
			info = new int[15][n];
			for (int i=0; i<15; i++) Arrays.fill(info[i], -1);
			
			// This is all of the raw data.
			for (int rnd=0; rnd<n/10; rnd++) {
				
				for (int i=0; i<5; i++) {
					System.out.println(5*rnd+i+1);
					System.out.flush();
					info[rnd][5*rnd+i] = stdin.nextInt();
				}
				
				for (int i=0; i<5; i++) {
					System.out.println(n-(5*rnd+i));
					System.out.flush();
					info[rnd][n-(5*rnd+i)-1] = stdin.nextInt();
				}
				
			}
			/*
			for (int i=0; i<10; i++) {
				for (int j=0; j<100; j++)
					System.out.print(info[i][j]);
				System.out.println();
			}*/
			
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
					int xor = ans[0] == info[rnd][sample.get(0)] ? 0 : 1;
				
					int flip = 0;
					if (sample.size() > 1) {
						flip = ans[1] == info[rnd][sample.get(1)] ? 0 : 1;
						flip = flip^xor;
					}
					
					
				
					for (int i=5*rnd; i<5*rnd+5; i++) {
						int loc = flip == 0 ? i : n-1-i;
						res[loc] = xor^info[rnd][i];
					}
					for (int i=n-(5*rnd+5); i<n-(5*rnd); i++) {
						int loc = flip == 0 ? i : n-1-i;
						res[loc] = xor^info[rnd][i];
					}					
				}
				
				for (int i=0; i<n; i++)
					System.out.print(res[i]);
				System.out.println();
				System.out.flush();
				String j = stdin.next();
				if (j.equals("N")) break;
			}
			
			else {
				
				for (int i=0; i<QUERIES.length; i++) {
					
					int[] flip = new int[QUERIES[i].length];
					int[] xor = new int[QUERIES[i].length];
					
					int ask = 0;
					for (int j=0; j<QUERIES[i].length; j++) {
						
						int rnd = QUERIES[i][j];
						ArrayList<Integer> sample = getSample(5*rnd, rnd);
						ask += sample.size();
						int[] ans = new int[sample.size()];
						for (int z=0; z<ans.length; z++) {
							System.out.println(sample.get(z)+1);
							System.out.flush();
							ans[z] = stdin.nextInt();
						}
				
						// assign xor and flip.
						xor[j] = ans[0] == info[rnd][sample.get(0)] ? 0 : 1;
				
						flip[j] = 0;
						if (sample.size() > 1) {
							flip[j] = ans[1] == info[rnd][sample.get(1)] ? 0 : 1;
							//flip[j] = flip[j];
						}	
						
					}
					
					int askMore = 10 - ask;
					for (int j=0; j<askMore; j++) {
						System.out.println(1);
						System.out.flush();
						int junk = stdin.nextInt();
					}
					
					// Mode relative to first block.
					//System.out.println("base block "+flip[0]+" "+xor[0]);
					for (int j=1; j<QUERIES[i].length; j++) {
						flip[j] = flip[j] ^ flip[0];
						xor[j] = xor[j] ^ xor[0];
						//System.out.println(i+" "+j+" apply "+flip[j]+" "+xor[j]+" "+QUERIES[i][j]);
						apply(flip[j], xor[j], QUERIES[i][j]);
					}
					
				} // end my 30 queries.
				
				ArrayList<Integer> sample = getSample(0, 0);
				int[] ans = new int[sample.size()];
				for (int i=0; i<ans.length; i++) {
					System.out.println(sample.get(i)+1);
					System.out.flush();
					ans[i] = stdin.nextInt();
				}
				
				// assign xor and flip.
				int finalxor = ans[0] == info[0][sample.get(0)] ? 0 : 1;
				
				int finalflip = 0;
				if (sample.size() > 1) {
					finalflip = ans[1] == info[0][sample.get(1)] ? 0 : 1;
					finalflip = finalflip^finalxor;
				}

				int[] fAns = apply(finalflip, finalxor);
				
				for (int i=0; i<n; i++)
					System.out.print(fAns[i]);
				System.out.println();
				System.out.flush();
				String jAns = stdin.next();
				if (jAns.equals("N")) break;				

			}
		}
	}
	
	public static int[] apply(int myf, int myx) {
		
		int[] res = new int[n];
		if (myf == 0 && myx == 0) {
			for (int i=0; i<n; i++) res[i] = info[0][i];
		}
		else if (myf == 0 && myx == 1) {
			for (int i=0; i<n; i++) res[i] = info[0][i]^1;
		}
		else if (myf == 1&& myx == 0) {
			for (int i=0; i<n; i++) res[i] = info[0][n-1-i];
		}
		else {
			for (int i=0; i<n; i++) res[i] = info[0][n-1-i]^1;
		}
		return res;
	}
	
	public static void apply(int myf, int myx, int idx) {
		
		// bits are 5*idx to 5*idx+5, n-5*idx-5 to n-5*idx
		int[] bounds = {5*idx, 5*idx+5, n-5*idx-5, n-5*idx};
		
		if (myf == 1 && myx == 0) {
			for (int i=0; i<2; i++)
				for (int j=bounds[2*i]; j<bounds[2*i+1]; j++)
					info[0][j] = info[idx][n-1-j];
		}
		else if (myf == 1 && myx == 1) {
			for (int i=0; i<2; i++)
				for (int j=bounds[2*i]; j<bounds[2*i+1]; j++)
					info[0][j] = info[idx][n-1-j] ^ 1;			
		}
		else if (myf == 0 && myx == 1) {
			for (int i=0; i<2; i++)
				for (int j=bounds[2*i]; j<bounds[2*i+1]; j++)
					info[0][j] = info[idx][j] ^ 1;
		}
		else {
			for (int i=0; i<2; i++)
				for (int j=bounds[2*i]; j<bounds[2*i+1]; j++)
					info[0][j] = info[idx][j];			
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