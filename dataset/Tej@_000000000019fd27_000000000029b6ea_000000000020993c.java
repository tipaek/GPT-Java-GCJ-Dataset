import java.util.*;
import java.io.*;  
class Vestigium {
	public static void main(String args[]) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testcases = sc.nextInt(); 
		int trace=0, row=0, col=0, r=0, c=0;
		for (int p=1;p<=testcases;p++){
			int n = sc.nextInt();
			int mat[][]=new int[n][n];
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					mat[i][j]=sc.nextInt();
				}
			}
			for(int i=0;i<n;i++){
				trace=trace+mat[i][i];
			}
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					int t1=mat[i][j];
					for (int k=j+1;k<n;k++){
						if (t1==mat[i][k])
							row++;
					}	
				} 
				if (row > 0)
					r=r+1;
				row=0;
			}
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					int t2=mat[j][i];
					for (int k=j+1;k<n;k++){
						if (t2==mat[k][i])
							col++;
					}	
				} 
				if (col > 0)
					c=c+1;
				col=0;
			}
			System.out.println("Case #"+p+": "+trace+" "+r + " " +c);
			trace=0;
			r=0;
			c=0;
		}	
	}
}