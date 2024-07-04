import java.io.*;
import java.util.Scanner;

public class Solution {
    
    public static boolean rowCheck(int[][] m,int n,int i){
        
	    	    for (int j = 0; j < n; j++){
	    	        int num1 = m[i][j];
	    	        for (int j1 = j+1;j1<n;j1++){
	    	            if(num1==m[i][j1]){
	    	                return true;
	    	            }
	    	        }
	    	    }
	    	
	    	return false;
    }
    
    public static boolean colCheck(int[][] m,int n,int j){
        
	    	    for (int i = 0; i < n; i++){
	    	        int num1 = m[i][j];
	    	        for (int i1 = i+1;i1<n;i1++){
	    	            if(num1==m[i1][j]){
	    	                return true;
	    	            }
	    	        }
	    	    }
	    	
	    	return false;
    }

	public static void main(String[] args) {
		String number;
		Scanner std = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = std.nextInt();
	    int n;
	    int[][] m;
	    
		for (int caseNumber = 1; caseNumber <=t; caseNumber++){
		    n =	std.nextInt();
		    m = new int[n][n];
		    int dupRow =0;
		    int dupCol =0;
		    int trace = 0;
    	    for (int i = 0; i < n; i++) {
	    	    for (int j = 0; j < n; j++){
	    	        m[i][j] = std.nextInt();
	    	        if(i==j){
	    	            trace+=m[i][j];
	    	        }
	    	    }
	    	}
	    
	    	for (int i = 0; i < n; i++) {
	    	 //System.out.println(rowCheck(m,n,i));
	    	 if(rowCheck(m,n,i)){
	    	     dupRow++;
	    	 }
	    	}
	    	
	    	for (int j = 0; j < n; j++) {
	    	     if(colCheck(m,n,j)){
	    	     dupCol++;
	    	 }
	    	}
            System.out.println("Case #" + caseNumber + ": " + trace + " " + dupRow + " " + dupCol);
 		}
	}
}