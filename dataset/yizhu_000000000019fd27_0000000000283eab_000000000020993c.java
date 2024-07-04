import java.io.*;
import java.util.*;




public class j1 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n_testCase = in.nextInt();
		String[] res = new String[n_testCase];

			for(int i=0;i<n_testCase;i++) {
				int r = in.nextInt();

				in.nextLine();
				int[][] row = new int[r+1][r+1];
				int[][] col = new int[r+1][r+1];
				
				int[][] g = new int[r][r];
				for(int j=0;j<r;j++) {
					
					for(int k=0;k<r;k++) {
						g[j][k] = in.nextInt();
					}
				}
				res[i] = getRes(r,row,col,g);
				System.out.println(res[i]);
		    
		        
		        
			}
			
		
	}
		
	public static String getRes(int r,int[][] row,int[][] col,int[][] g) {
		
		int[] res = count(r,row,col,g);
		return "Case #1: "+res[0]+res[1]+res[2];
	}
	
	public static int[] count(int r,int[][] row,int[][] col,int[][] g) {
		
		int[] res = new int[3];
		int[] rl = new int[r];
		int[] cl = new int[r];
		for(int i=0;i<r;i++) {
			res[0]+=g[i][i];
		}
		for(int i=0;i<r;i++) {
			for(int j=0;j<r;j++) {
				if(row[i][g[i][j]]++==1) {
					rl[i]++;
				}
				if(col[j][g[i][j]]++==1) {
					cl[j]++;
				}
			}
		}
		for(int i=0;i<r;i++) {
			if(rl[i]!=0) {
				res[1]++;
			}
			if(cl[i]!=0) {
				res[2]++;
			}
		}
		return res;
	}
}