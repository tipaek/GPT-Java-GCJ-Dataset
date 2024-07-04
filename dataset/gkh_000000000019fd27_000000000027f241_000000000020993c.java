package qualification2020;

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		
		for(int x = 1; x <= t; ++x) {
			int n = in.nextInt();
			int[][] m = new int[n][n];
			
			int k = 0, r = 0, c = 0;
			
			ArrayList<Set<Integer>> colSums = new ArrayList<HashSet<Integer>>(n);
			for(int i=0; i<n; i++) {
				colSums.add(new HashSet<Integer>());
			}
			
			for(int i=0; i<m.length; i++) {
				Set<Integer> rowSet = new HashSet<Integer>();
				for(int j=0; j<m[i].length; j++) {
					m[i][j] = in.nextInt();
					if(i==j) {
						k += m[i][i];
					}
					rowSet.add(m[i][j]);
					colSums.get(j).add(m[i][j]);
				}
				if(rowSet.size()!=n) {
					r+=1;
				}
			}
			for(Set<Integer> colSum: colSums) {
				if(colSum.size()!=n) {
					c++;
				}
			}
			System.out.println("Case #"+x+": "+k+" "+r+" "+c);
		}
		
		in.close();
	}
}