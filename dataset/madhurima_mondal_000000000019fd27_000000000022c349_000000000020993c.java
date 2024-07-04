import java.util.*;
import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution{

private void traceMatrix(int caseNumber ,int n, int[][] matrix){
    int diagonalSum = 0;
    int repeatedRowCount = 0;
    int repeatedColCount = 0;
    for(int r = 0 ;r<n;r++){
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        boolean repeatedRow = false;
        boolean repeatedCol = false;
        for(int c=0;c<n;c++){
            if(rowSet.contains(matrix[r][c]))
                repeatedRow= true;
            
            if(colSet.contains(matrix[c][r]))
                repeatedCol = true;
                
            rowSet.add(matrix[r][c]);
            colSet.add(matrix[c][r]);
            
            if(r==c)
                diagonalSum+=matrix[r][c];
        }
        if(repeatedCol)
            repeatedColCount++;
        if(repeatedRow)  
            repeatedRowCount++;
            
        
    }
    
    System.out.println("Case #"+caseNumber+": "+diagonalSum+" "+repeatedRowCount+" "+repeatedColCount);
}
public static void main(String args[]){
	
	Scanner  sc = new Scanner(System.in);
	int t = sc.nextInt();
	for(int i=0;i<t;i++) {
	    Solution sol = new Solution();
	    int n = sc.nextInt();
	    int[][] matrix = new int[n][n];
	    for(int r=0;r<n;r++){
	        for(int c=0;c<n;c++){
	            matrix[r][c] = sc.nextInt();
	        }
	    }
	    
	    sol.traceMatrix(i+1,n,matrix);
	}
	sc.close();
			
    }
}