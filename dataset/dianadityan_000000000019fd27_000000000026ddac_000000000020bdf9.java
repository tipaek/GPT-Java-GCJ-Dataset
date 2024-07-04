import java.util.*;
import java.io.*;
	
public class Solution {
	private static class Schedule {
		int start;
		int end;
		
		Schedule(int S, int E) {
			this.start = S;
			this.end = E;
		}
	}
	
	public static void main(String args[]) throws FileNotFoundException {
		/* INPUT */
//		Scanner in = new Scanner(new File("./input.txt"));
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));	
		
		/* VARIABLE */
		int T, N, S, E, start, end;
		String validCase;
		
		T = in.nextInt();
		for(int testCase=1; testCase<=T; testCase++) {
			N = in.nextInt();
			
			validCase = "";
			ArrayList<Schedule> C = new ArrayList<Schedule>();
			ArrayList<Schedule> J = new ArrayList<Schedule>();
			
			for(int i=0; i<N; i++) {
				S = in.nextInt();
				E = in.nextInt();
				
				Schedule s = new Schedule(S, E);
				// Fill C
				int sizeC = C.size();
				int countC = 0;
				for(int j=0; j<sizeC; j++, countC++) {
					start = C.get(j).start;
					end = C.get(j).end;
					if((S >= end && E > end) || (S < start && E < start)) continue;
					else break;
				}
				if(sizeC == countC) {
					validCase += "C";
					C.add(s);
					continue;
				}
				
				// Fill J
				int sizeJ = J.size();
				int countJ = 0;
				for(int j=0; j<sizeJ; j++, countJ++) {
					start = J.get(j).start;
					end = J.get(j).end;
					if((S >= end && E > end) || (S < start && E < start)) continue;
					else break;
				}
				if(sizeJ == countJ) {
					validCase += "J";
					J.add(s);
					continue;
				}
				
				if(sizeC != countC && sizeJ != countJ) {
					validCase = "IMPOSSIBLE";
					break;
				}
			}
			
			
			System.out.println("Case #" + testCase + ": " + validCase);
		}
		
		in.close();
	}
}
