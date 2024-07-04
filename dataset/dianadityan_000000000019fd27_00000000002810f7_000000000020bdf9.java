import java.util.*;
import java.io.*;
	
public class Solution {
	private static int[] CStart = new int[1000];
	private static int[] CEnd = new int[1000];
	private static int[] JStart = new int[1000];
	private static int[] JEnd = new int[1000];
	private static String validCase;
	private static int countC, countJ;
	
	private static void init(int N) {
		validCase = "";
		countC = 0;
		countJ = 0;
		for(int i=0; i<N; i++) {
			CStart[i] = -1;
			CEnd[i] = -1;
			JStart[i] = -1;
			JEnd[i] = -1;
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
			
			init(N);
			for(int i=0; i<N; i++) {
				S[i] = in.nextInt();
				E[i] = in.nextInt();
			}
			
			for(int i=0; i<N; i++) {
				boolean isOverlapC = false;
				for(int j=0; j<countC; j++) {
					if((S[i] < CStart[j] && E[i] <= CStart[j]) || (S[i] >= CEnd[j] && E[i] > CEnd[j])) continue;
					else {
						isOverlapC = true;
						break;
					}
				}
				if(!isOverlapC) {
					validCase += "J";
					CStart[countC] = S[i];
					CEnd[countC]= E[i];
					countC++;
					continue;
				}
				
				boolean isOverlapJ = false;
				for(int j=0; j<countJ; j++) {
					if((S[i] < JStart[j] && E[i] <= JStart[j]) || (S[i] >= JEnd[j] && E[i] > JEnd[j])) continue;
					else {
						isOverlapJ = true;
						break;
					}
				}
				if(!isOverlapJ) {
					validCase += "C";
					JStart[countJ] = S[i];
					JEnd[countJ] = E[i];
					countJ++;
					continue;
				}
				
				validCase = "IMPOSSIBLE";
				break;
			}
			
			System.out.println("Case #" + testCase + ": " + validCase);
		}
		
		in.close();
	}
}
