package CompetitiveCoding;

import java.util.Scanner;

class RepeatedMatrix {

	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc = new Scanner(System.in);	
	    int testCases = 0;
	    if(sc.hasNextInt()){
           testCases = sc.nextInt();
        }
	    int[] answer = new int[testCases];
	    int count = 1;
	    for(int k=testCases ; k>0 ; k--)
	    {
	    	int n = 0;
	    	 if(sc.hasNextInt()){
	    		  n = sc.nextInt();
	          }	    	
	    	int m = n;
	    	int first[][] = new int[m][n]; 
	    	                          
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    first[i][j] = sc.nextInt();
            
            int rowD = checkDuplicateRow(first,n);
            int colD = checkDuplicateCol(first,n);
            
            //Case #1: 4 0 0
            System.out.print("Case #"+count+":");
            System.out.print(" "+ Trace(first,n));
            System.out.print(" "+ rowD);
            System.out.print(" "+ colD);
            System.out.print("\n");
            count++;	    	
	    }
	}
	

	private static int Trace(int[][] array,int n) {
		int sum=0, row=n, col=n;
		for(int i = 0; i < row; i++)
	  	{  
	    	    for(int j = 0; j < col; j++)
	       	    {
	                if(i == j)
	            	 {
	               	     sum = sum + (array[i][j]);
	               	 }
	            }
	    }
		return sum;
	}


	private static int checkDuplicateCol(int[][] first, int n) {
		int count = 0;
		boolean colD = false;
		for(int i=0 ; i<n ; i++) {
			colD = false;
			for(int j=0 ; j<n; j++) {
				 int num = first[j][i];
		            for (int otherRow = j + 1; otherRow < first.length; otherRow++)
		            {
		                if (num == first[otherRow][i])
		                {		                	
		                  colD = true;   
		                }
		            }		            
			}
			if(colD)
				count++;
		}
		
		return count;
	}

	private static int checkDuplicateRow(int[][] first,int n) {
		int count = 0;
		boolean rowD = false;
		for(int i=0 ; i<n ; i++) {
			rowD = false;
			for(int j=0 ; j<n; j++) {
				 int num = first[i][j];
		            for (int otherCol = j + 1; otherCol < first.length; otherCol++)
		            {
		                if (num == first[i][otherCol])
		                {
		                    rowD = true;		                    
		                }
		            }		            
			}
			if(rowD)
				count++;
		}
		
		return count;
	}
}
