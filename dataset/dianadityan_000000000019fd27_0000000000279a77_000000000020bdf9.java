import java.util.*;
import java.io.*;
	
public class Solution {
	static class Schedule {
		int start;
		int end;
		
		Schedule(int S, int E) {
			this.start = S;
			this.end = E;
		}
	}
	
	private static Schedule[] C = new Schedule[1000];
	private static Schedule[] J = new Schedule[1000];
	private static String validCase;
	private static int countC, countJ;
	
	private static void init() {
		validCase = "";
		countC = 0;
		countJ = 0;
		for(int i=0; i<1000; i++) {
			C[i] = new Schedule(0, 0);
			J[i] = new Schedule(0, 0);
		}
	}
	
	public static void main(String args[]) throws FileNotFoundException {
		/* INPUT */
		Scanner in = new Scanner(new File("./input.txt"));
//		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));	
		
		/* VARIABLE */
		int T, N, S, E;
		
		T = in.nextInt();
		for(int testCase=1; testCase<=T; testCase++) {
			N = in.nextInt();
			
			init();
			for(int i=0; i<N; i++) {
				S = in.nextInt();
				E = in.nextInt();

				// Fill C
				boolean isOverlapC = false;
				for(int j=0; j<countC; j++) {
					if(S >= C[j].end || E <= C[j].start) continue;
					else {
						isOverlapC = true;
						break;
					}
				}
				if(!isOverlapC) {
					validCase += "C";
					C[countC].start = S;
					C[countC].end = E;
					countC++;
					continue;
				}
				
				// Fill J
				boolean isOverlapJ = false;
				for(int j=0; j<countJ; j++) {
					if(S >= J[j].end || E <= J[j].start) continue;
					else {
						isOverlapJ = true;
						break;
					}
				}
				if(!isOverlapJ) {
					validCase += "J";
					J[countJ].start = S;
					J[countJ].end = E;
					countJ++;
					continue;
				}
				
				if(isOverlapC && isOverlapJ) {
					validCase = "IMPOSSIBLE";
					break;
				}
			}
			
			System.out.println("Case #" + testCase + ": " + validCase);
		}
		
		in.close();
	}
}
