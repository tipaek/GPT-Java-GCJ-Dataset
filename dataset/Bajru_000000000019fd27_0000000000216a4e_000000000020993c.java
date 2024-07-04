import java.util.*;
import java.io.*;

public class Solution {
    
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
		solve(mat,n,i+1);
		}
	}
	
	private static void solve(int[][] mat,int n,int t){
	int trace = 0;
	
	for(int i=0;i<n;i++){
	trace+=mat[i][i];
	}
	
	int r=0;
	int l=0;

	
	for(int i=0;i<n;i++){
		int row[]= new int[101];
		int col[]= new int[101];
		boolean r_flag=false;
		boolean c_flag= false;
		
		for(int j=0;j<n;j++) {
			++row[mat[i][j]];
			++col[mat[j][i]];
			if(row[mat[i][j]]>1) {
				r_flag=true;
			}
			if(col[mat[j][i]]>1) {
				c_flag=true;
			}	
		}
		if(r_flag) {
			++r;
		}
		if(c_flag) {
			++l;
		}
	}
	
	System.out.println("Case #"+t+": "+trace+" "+r+" "+l);
	
	}
}