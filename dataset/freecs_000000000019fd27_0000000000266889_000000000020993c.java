import java.util.*;
import java.io.*;

public class Solution{
	
	public void solve(int test, Scanner sc){
		int n = sc.nextInt();
		
		int[][] mat = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				mat[i][j] = sc.nextInt();
			}
		}
		
		int k = 0;
		for(int i=1; i<=n; i++){
			k+=mat[i][i];
		}
		
		int r = 0;
		int c = 0;
		boolean[] found = new boolean[n+1];
		
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				if(!found[mat[i][j]]){
					found[mat[i][j]] = true;
				}
				else{
					r++;
					break;
				}
			}
			for(int j=1; j<=n; j++){
				found[j] = false;
			}
		}
		
		
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				if(!found[mat[j][i]]){
					found[mat[j][i]] = true;
				}
				else{
					c++;
					break;
				}
			}
			for(int j=1; j<=n; j++){
				found[j] = false;
			}
		}
		
		System.out.println("Case #"+test+": "+k+" "+r+" "+c);
	}
	
	public Solution(){
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
        
        for(int t=1; t<=tests; t++){
			solve(t, sc);
        }
	}
	
	public static void main(String[] args){
		new Solution();
	}
}