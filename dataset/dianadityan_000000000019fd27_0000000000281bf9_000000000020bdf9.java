import java.util.*;
import java.io.*;
	
public class Solution {
	private static int[] CStart = new int[1000];
	private static int[] CEnd = new int[1000];
	private static int[] JStart = new int[1000];
	private static int[] JEnd = new int[1000];
	private static char[] validCase = new char[1000];
	private static int countC, countJ;
	
	private static void init(int N) {
		countC = 0;
		countJ = 0;
		for(int i=0; i<N; i++) {
			validCase[i] = '\0';
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
					validCase[i] = 'C';
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
					validCase[i] = 'J';
					JStart[countJ] = S[i];
					JEnd[countJ] = E[i];
					countJ++;
					continue;
				}
				
				System.out.println("Case #" + testCase + ": IMPOSSIBLE");
				break;
			}
			
			System.out.print("Case #" + testCase + ": ");
			for(int i=0; i<N; i++) {
				System.out.print(validCase[i]);
			}
			System.out.println();
		}
		
		in.close();
	}
}
