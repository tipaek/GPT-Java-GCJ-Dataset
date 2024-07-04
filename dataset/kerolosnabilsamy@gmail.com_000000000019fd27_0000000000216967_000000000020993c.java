/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{	
	public static int countIdenticalRows(int mat[][]) 
    { 
  
        int count = 0; 
  
        for (int i = 0; i < mat.length; i++) { 
  
            // HashSet for current row 
            HashSet<Integer> hs = new HashSet<>(); 
  
            // Traverse the row 
            for (int j = 0; j < mat[i].length; j++) { 
  
                // Add all the values of the row in HashSet 
                hs.add(mat[i][j]); 
            } 
  
            // Check if size of HashSet = 1 
            if (hs.size() == 1) 
                count++; 
        } 
  
        return count; 
    } 
    public static int countIdenticalColumns(int mat[][]) 
    { 
  
        int count = 0; 
  
        for (int i = 0; i < mat.length; i++) { 
  
            // HashSet for current row 
            HashSet<Integer> hs = new HashSet<>(); 
  
            // Traverse the row 
            for (int j = 0; j < mat[i].length; j++) { 
  
                // Add all the values of the row in HashSet 
                hs.add(mat[j][i]); 
            } 
  
            // Check if size of HashSet = 1 
            if (hs.size() == 1) 
                count++; 
        } 
  
        return count; 
    } 
	
	
	
	public static int dSum(int[][]matrix){
	 int sum=0;
	 //Diagonalsum;
	 for(int i=0;i<matrix.length;i++)
     { 
      for(int j=0;j<matrix[i].length;j++)
      { 
		if(i==j) //this condition checks for diagonal
		{
		sum = sum + matrix[i][j];
			}
		}
	}
	return sum;
}
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
 
    int numberOfTests;
    int i,j,row,col,sum=0,temp=1;
    numberOfTests=sc.nextInt();
 
 while(temp <=numberOfTests){
 
 //System.out.println("Enter the number of rows:");
	row = sc.nextInt();
 //System.out.println("Enter the number of columns:");
 col = sc.nextInt();
 int[][] mat = new int[row][col];
 
     System.out.println("Enter the elements of the matrix") ;
     for(i=0;i<row;i++)
     { 
      for(j=0;j<col;j++)
      { 
          mat[i][j] = sc.nextInt();
     }
 }
 
 
 temp++;
 System.out.print("Case #"+temp+":"+" "+dSum(mat)+" "+countIdenticalRows(mat)+" "+countIdenticalColumns(mat));
 }
    
	}
}