import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args){
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t = scan.nextInt();
		
		for(int i=0;i<t;i++){
		int n = scan.nextInt();
		int k = scan.nextInt();
		boolean flag = false;
		int j = n;
		for(j=n;j<=n*n;j=j+n){
		    if(j==k){
		        flag = true;
		        j = j/n;
		        break;
		    }
		}
		if(flag){
			System.out.println("Case #"+(i+1)+": POSSIBLE");
		    solve(n,k,j);
		}else{
		    System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
		}
		}
	}
	
	private static void solve(int n, int k, int p){
	
	    int ans[][] = new int[n][n];
	    
	    int temp = p;
	    
	    ans[0][0]=p;
	    

	        for(int j=1;j<n;j++){
	            ans[0][j] = ans[0][j-1]-1;
	            if(ans[0][j]==0) {
	            	ans[0][j]=n;
	            }
	        }
	        
	        for(int i=1;i<n;i++) {
	        	for(int j=0;j<n;j++){
		            ans[i][j] = ans[i-1][j]+1;
		            if(ans[i][j]==n+1) {
		            	ans[i][j]=1;
		            }
		        }
	        }
	    
	    for(int i=0;i<n;i++){
	        for(int j=0;j<n;j++){
	            System.out.print(ans[i][j]+" ");
	        }
	        System.out.println();
	    }
	}
}
