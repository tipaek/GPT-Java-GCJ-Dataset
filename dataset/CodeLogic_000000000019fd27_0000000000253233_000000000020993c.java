

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class Solution {
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner S = new Scanner (System.in);
		int N = S.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int ii =1; ii<=N; ii++) {
		
			int n = S.nextInt();
			int p =0;
			int r =0;
			int c=0;
			
		
			int A[][] = new int[n][n];
			
			for(int i=0; i<n;i++) {
				for (int j=0;j<n;j++) {
					A[i][j]= S.nextInt();
					
				}
			}
			
			for(int i=0; i<n;i++) {
				p+= A[i][i];
			}
			HashMap<Integer,Integer> h;
			
			for(int i=0; i<n;i++) {
				h = new HashMap<Integer,Integer>();
				for (int j=0;j<n;j++) {
					if(h.containsKey(A[i][j])) { r++; break;}
					else h.put(A[i][j],1);
					
				}
				
					}
			
			
			for(int i=0; i<n;i++) {
			 h= new HashMap<Integer,Integer>();
				for (int j=0;j<n;j++) {
					if(h.containsKey(A[j][i])) { c++; break;}
					else h.put(A[j][i],1);
					
				}}


		
						sb.append("Case #"+ii+": "+p+" "+ r + " "+c+"\n");
		}
		System.out.println(sb.toString());
	
		S.close();
	}
	


}
