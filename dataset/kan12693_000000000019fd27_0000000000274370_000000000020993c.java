/*package whatever //do not write package name here */

import java.util.*;

class Solution {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int caseNum = 1; 
		while(t-->0) {
		    int N = sc.nextInt();
		    int mat[][] = new int[N][N];
		    for (int i = 0; i < N; i++) {
		        for(int j = 0; j < N; j++)
		            mat[i][j] = sc.nextInt();
		    }
		    printTrace(mat, N, caseNum++);
		}
	}
	static void printTrace(int mat[][], int N, int t) {
	
	  int rowCount = 0;
	  int colCount = 0;
	  int trace = 0 ;
	  int col [] = new int[N]; 
	  HashSet<Integer> set; 
	  
	  for (int i = 0; i < N; i++) {
	    set = new HashSet<Integer>();
	    boolean duplicate = false;
	    for(int j= 0; j < N; j++) {
	        if(i == j)
	            trace += mat[i][j] ;
	        boolean isDuplicate = set.add(mat[i][j]) ;
	       //System.out.println(isDuplicate+" "+ t);
	        if(!isDuplicate && !duplicate) {
	            rowCount++;
	            duplicate = true;
	        }
	   }
	  }
	  for (int i = 0; i < N; i++) {
	    set = new HashSet<Integer>();
	    boolean duplicate = false;
	    label: for(int j = 0; j < N; j++) {
	        boolean isDuplicate = set.add(mat[j][i]) ;
	        if(!isDuplicate && !duplicate) {
	            colCount++;
	            duplicate = true;
	        }
	   }
	  }
	  System.out.println("case "+"#"+t+":"+" "+trace+" "+rowCount+" "+colCount);
	    
	}
}