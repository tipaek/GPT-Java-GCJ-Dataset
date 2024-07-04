/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	
	public static void main (String[] args) {
		//code
		int T,i,j,k;
		
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for(i=1;i<=T;i++){
			int trace=0,rows=0,cols=0;
			HashSet<Integer> hs=new HashSet<>();
			int N=sc.nextInt();
			int mat[][]=new int[N][N];
			for(j=0;j<N;j++) {
				for(k=0;k<N;k++) {
					mat[j][k]=sc.nextInt();
				}
			}
			
			for(j=0;j<N;j++) {
				trace=trace+mat[j][j];
			}
			
			for(j=0;j<N;j++) {
				for(k=0;k<N;k++) {
					if(hs.contains(mat[j][k])) {
						rows++;
						break;
					}
					hs.add(mat[j][k]);
				}
				hs.clear();
			}
			hs.clear();
			for(j=0;j<N;j++) {
				for(k=0;k<N;k++) {
					if(hs.contains(mat[k][j])) {
						cols++;
						break;
					}
					hs.add(mat[k][j]);
				}
				hs.clear();
			}
			
			System.out.println("Case #"+T+":"+i+" "+trace+" "+rows+" "+cols);
			sc.close();
		}
	}
}