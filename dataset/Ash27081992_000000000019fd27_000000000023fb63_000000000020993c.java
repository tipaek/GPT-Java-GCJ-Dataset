
import java.util.Scanner;

public class Solution {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
        int testCase=sc.nextInt();
        
        for(int i=0;i<testCase;i++){
           int mxn = sc.nextInt();
        	solve(mxn,i);
        }
	}
	
	 public static void solve(int mxn,int testCase){
	        int[][] a = new int[mxn][mxn];
	        int sum=0;
	        int rowCount=0;
	        int colCount=0;
	        for(int i=0;i<mxn;i++){
	                for(int j=0;j<mxn;j++){
	                    a[i][j]=sc.nextInt();
	                    if(i==j){
	                    	sum=sum+a[i][j];
	                    }
	                }
	           }
	       for(int i=0;i<mxn;i++){
	    	outer:   for(int j=0;j<mxn;j++){
	    		   for(int k=j+1;k<mxn;k++){
	    			   if(a[i][j]==a[i][k]){
	    				   rowCount++;
	    				   break outer;
	    			   }
	    	       }
	    	   }
	       }
	       for(int i=0;i<mxn;i++){
		    	outer:   for(int j=0;j<mxn;j++){
		    		   for(int k=j+1;k<mxn;k++){
		    			   if(a[j][i]==a[k][i]){
		    				   colCount++;
		    				   break outer;
		    			   }
		    	       }
		    	   }
		       }
	       System.out.println("Case #"+(testCase+1)+": "+sum+" "+rowCount+" "+colCount);
	 }
}
