import java.io.*;
import java.util.*;


public class Solution {
	public static void main(String[] args) throws IOException {
		//get input separately
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter p = new PrintWriter(new BufferedOutputStream(System.out));
		StringTokenizer s = new StringTokenizer(b.readLine());
		int cases = Integer.parseInt(s.nextToken());
		//store the answers in an int array
		for (int i = 0; i < cases; i++) {
			s = new StringTokenizer(b.readLine());
			String ans = "";
			int n = Integer.parseInt(s.nextToken());
			//guaranteed n
			if (n == 1) {
				ans += "1 1\n";
			} else {
				if (n == 2) {
					ans += "1 1\n";
					ans += "2 1\n";
				} else {
					ans += "1 1\n";
					int pow2 = (int)( Math.log10(n-1) / Math.log10(2));
					//p.println(pow2);
					int rem = n - (int)Math.pow(2, pow2) - 1;
					for (int j = 0; j < pow2; j++) {
						if (j % 2 == 0) {
							for (int f = 0; f < pow2 + 1; f++) {
								ans += (j + 2) + " " + (f+1) + "\n";
							}
						} else {
							for (int f = pow2; f > -1; f--) {
								ans += (j + 2) + " " + (f+1) + "\n";
							}
						}
					}
					//take care of remainder
					int row = pow2 + 1;
					if (pow2 % 2== 1) {
						//start at left
						int col = pow2 + 1;
						for (int j = 0; j < rem; j++) {
							ans += (row + 1) + " " + (col + 1) + "\n";
							row++;
							col++;
						}
					} else {
						//start at right
						int col = 0;
						for (int j = 0; j < rem; j++) {
							ans += (row + 1) + " " + (col + 1) + "\n";
							row++;
							col++;
						}
					}
					 
				}
			}
			p.print("Case #" + (i+1) + ":" + "\n" + ans);
		}
		p.close();
		

	}
	
	
	// you should actually read the stuff at the bottom

}

/* REMINDERS
 * PLANNING!!!!!!!! Concrete plan before code
 * DON'T MAKE ASSUMPTIONS
 * DON'T OVERCOMPLICATE
 * NAIVE SOL FIRST
 * CHECK INT VS LONG, IF YOU NEED TO STORE LARGE NUMBERS
 * CHECK CONSTRAINTS, C <= N <= F...
 * CHECK SPECIAL CASES, N = 1...
 * CHECK ARRAY BOUNDS, HOW BIG ARRAY HAS TO BE
 * TO TEST TLE/MLE, PLUG IN MAX VALS ALLOWED AND SEE WHAT HAPPENS
 * ALSO CALCULATE BIG-O, OVERALL TIME COMPLEXITY
 */
