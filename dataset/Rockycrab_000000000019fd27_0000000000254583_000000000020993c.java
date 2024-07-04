import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	
	public static int getTrace(int[][] matrix)
	{
		int trace=0;
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[i].length;j++)
			{
				if(i==j)
					trace=trace+matrix[i][j];
			}
		}
		return trace;
	}

	
	public static int numOfDupinRow(int[][] matrix) 
	{
		int rowcount=0;
	    for (int i=0; i < matrix.length; i++) {
	        HashSet<Integer> set = new HashSet<Integer>();
	        for (int j=0; j < matrix.length; j++) {
	            if (set.contains(matrix[i][j]))
	            {
	            	rowcount++;
	            	break;
	            }
	            else
	            	set.add(matrix[i][j]);
	        }
	    }
	    return rowcount;
	}
	
	public static int numOfDupinCol(int[][] matrix) 
	{
		int colcount=0;
	    for (int i=0; i < matrix.length; i++) {
	        HashSet<Integer> set = new HashSet<Integer>();
	        for (int j=0; j < matrix.length; j++) {
	            if (set.contains(matrix[j][i])) 
	            {
	            	colcount++;
	            	break;
	            }
	            else
	            	set.add(matrix[j][i]);
	        }
	    }
	    return colcount;
	}
	
	
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		
		int cases=scan.nextInt();
		for(int loop=1;loop<=cases;loop++) {
			
			int rc=scan.nextInt();
			int[][] mat= new int[rc][rc];
			
			for(int i=0;i<rc;i++)
			{
				for(int j=0;j<rc;j++)
				{
					mat[i][j]=scan.nextInt();
				}
			}
			
			int trace=getTrace(mat);
			int rowdup=numOfDupinRow(mat);
			int coldup=numOfDupinCol(mat);
			System.out.print("\nCase #"+loop+": "+trace+" "+rowdup+" "+coldup);
			
		}
	}
}
