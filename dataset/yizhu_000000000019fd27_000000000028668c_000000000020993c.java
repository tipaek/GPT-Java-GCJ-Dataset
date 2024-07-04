package jam1
;
import java.io.*;
import java.util.*;




public class Solution {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n_testCase = in.nextInt();
		String[] res = new String[n_testCase];

			for(int i=0;i<n_testCase;i++) {
				int r = in.nextInt();

				int[][] row = new int[r+1][r+1];
				int[][] col = new int[r+1][r+1];
				
				int[][] g = new int[r][r];
				for(int j=0;j<r;j++) {
					
					for(int k=0;k<r;k++) {
						g[j][k] = in.nextInt();
					}
				}
				//res[i] = getRes(r,row,col,g);
				System.out.println(res[i]+"2");
		    
		        
		        
			}
			
		
	}
	
}
