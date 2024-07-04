import java.util.*;
import java.io.*;
	
public class Solution {
	private static int[] CStart = new int[1000];
	private static int[] CEnd = new int[1000];
	private static int[] JStart = new int[1000];
	private static int[] JEnd = new int[1000];
	private static String validCase;
	private static int countC, countJ;
	
	private static void init() {
		validCase = "";
		countC = 0;
		countJ = 0;
		for(int i=0; i<1000; i++) {
			CStart[i] = 0;
			CEnd[i] = 0;
			JStart[i] = 0;
			JEnd[i] = 0;
		}
	}
	
	public static void main(String args[]) throws FileNotFoundException {
		/* INPUT */
//		Scanner in = new Scanner(new File("./input.txt"));
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));	
		
		/* VARIABLE */
		int T, N; 
		int[] S = new int[1000];
		int[] E = new int[1000];
		
		T = in.nextInt();
		for(int testCase=1; testCase<=T; testCase++) {
			N = in.nextInt();
			
			init();
			for(int i=0; i<N; i++) {
				S[i] = in.nextInt();
				E[i] = in.nextInt();
			}
			
			for(int i=0; i<N; i++) {
				boolean isOverlapC = false;
				for(int j=0; j<countC; j++) {
					if(S[i] >= CEnd[j] || E[i] <= CStart[j]) continue;
					else {
						isOverlapC = true;
						break;
					}
				}
				if(!isOverlapC) {
					validCase += "C";
					CStart[countC] = S[i];
					CEnd[countC]= E[i];
					countC++;
					continue;
				}
				
				boolean isOverlapJ = false;
				for(int j=0; j<countJ; j++) {
					if(S[i] >= JEnd[j] || E[i] <= JStart[j]) continue;
					else {
						isOverlapJ = true;
						break;
					}
				}
				if(!isOverlapJ) {
					validCase += "J";
					JStart[countJ] = S[i];
					JEnd[countJ] = E[i];
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
