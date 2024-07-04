//package QualificationRound2020;
/*
ID: urd00m
LANG: JAVA
TASK: indicium
 */
import java.io.*;
import java.util.*;

public class Solution {
	static int t; 
	static int n, k; 
	public static void main(String args[]) throws IOException {
		//input 
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input;
		t = Integer.parseInt(f.readLine()); 
		for(int cn = 1; cn < t+1; cn++) {
			input = new StringTokenizer(f.readLine());
			n = Integer.parseInt(input.nextToken()); 
			k = Integer.parseInt(input.nextToken()); 
			
			//k must be multiple of N 
			if(k%n == 0) {
				//generate the latin matrix
				String[][] matrix = new String[n][n];
				int start = 1;
				Queue<Integer> rowSwaps = new LinkedList<Integer>(); 
				for(int i = 0; i < n; i++) {
					int idx = 0; 
					for(int j = start; j < n+start; j++) {
						matrix[i][idx++] = "" + ((j-1)%(n)+1);
					}
					start = (n+start-2)%n+1; 
				}
				for(int i = n-1; i >= 0; i--) rowSwaps.add(i); 
				
				//begin swaps
				for(int i = 0; i < (k/n)-1; i++) { //every correct swap adds n so to get 15 we only need to add 10 which is 2 swaps  
					int s1 = rowSwaps.poll(); //s1 is larger of the two  
					int s2 = rowSwaps.poll(); 
					String[] temp = matrix[s1]; 
					matrix[s1] = matrix[s2]; 
					matrix[s2] = temp; 
					rowSwaps.add(s1); 
				}
				//output
				System.out.println("Case #" + cn + ": POSSIBLE");
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						System.out.print(matrix[i][j]);
						if(j != n-1) System.out.print(" ");
					}
					System.out.println();
				}
			}
			else System.out.println("Case #" + cn + ": IMPOSSIBLE"); 
		}
	}
}
