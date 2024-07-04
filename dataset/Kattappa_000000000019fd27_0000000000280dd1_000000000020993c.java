import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int k=1; k<=t; k++) {
			int n = in.nextInt();
			int [][] M = new int [n][n];
			for(int i=0; i<n ; ++i){
				for(int j=0; j<n ; ++j){
					M[i][j] = in.nextInt();
				}
			} 
			int trace=0;
			for (int l=0 ; l<n ; ++l ) {
				trace = trace+M[l][l];
			} 
			System.out.println("Case #"+k+": " + trace + " "  + sumRow(M, n) + " " + sumCol(M, n));
		}
	}

	public static int sumRow(int[][] M, int n) {
	
	int r=0;
	for (int i=0 ; i<n ; ++i ) {
		int f =0;
		for (int j=0; j<n-1; ++j ) {
			     
			for (int k=j+1 ; k<n ; ++k ) {
				if(M[i][j]==M[i][k])
				{	
					f=f+1;

					break;
			    }

				
			} 
		}if( f!=0)
			r=r+1;
		
	}
	return r;

	}
	
	public static int sumCol(int[][] M, int n) {
	int	c=0;

	for (int i=0 ; i<n ; ++i ) {
		int f =0;
		for (int j=0; j<n-1; ++j ) {
			
			for (int k=j+1 ; k<n ; ++k ) {
				if(M[j][i]==M[k][i]) {
					
					f=f+1;

					break; }
			} 
		}if( f!=0)
			c=c+1;
	}
	return c;		
	}
}