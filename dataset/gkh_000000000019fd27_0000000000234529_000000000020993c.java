import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		
		for(int x = 1; x <= t; x++) {
			int n = in.nextInt();
			int[][] m = new int[n][n];
			
			int k = 0, r = 0, c = 0;
			
			int sum = n*(1+n)/2;
			int rowSum = 0;
			int[] colSums = new int[n];
			
			for(int i=0; i<m.length; i++) {
				for(int j=0; j<m[i].length; j++) {
					m[i][j] = in.nextInt();
					if(i==j) {
						k += m[i][i];
					}
					rowSum += m[i][j];
					colSums[j] += m[i][j];
				}
				if(rowSum!=sum) {
					r+=1;
				}
				rowSum = 0;
			}
			for(int colSum: colSums) {
				if(colSum != sum) {
					c++;
				}
			}
			
			System.out.println("Case #"+x+": "+k+" "+r+" "+c);
		}
		
		in.close();
	}
}