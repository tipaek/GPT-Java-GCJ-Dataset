import java.util.*;
import java.io.*;

public class solution {
    
    public static void main(String[] args){
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = scan.nextInt();
		
		for(int i=0;i<t;i++){
		int n = scan.nextInt();
		
		int mat[][] = new int[n][n];
		
		for(int j=0;j<n;j++){
			for(int k=0;k<n;k++){
				mat[j][k] = scan.nextInt();
			}
			
		}
		solve(mat,n,t);
		}
	}
	
	private static void solve(int[][] mat,int n,int t){
	
	int trace = 0;
	
	for(int i=0;i<n;i++){
	trace+=mat[i][i];
	}
	
	int sum = n*(n+1)/2;
	
	int r=0,l=0;
	
	for(int i=0;i<n;i++){
		int row=sum;
		int col=sum;
		for(int j=0;j<n;j++){
		row = row - mat[i][j];
		col = col - mat[j][i];
		}
		if(row!=0){
		++r;
		}
		if(col!=0){
		++l;
		}
	}
	
	System.out.println("Case #"+t+": "+trace+" "+r+" "+l);
	


	}
}