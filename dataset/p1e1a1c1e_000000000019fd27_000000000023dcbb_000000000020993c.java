

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    static  String[] inputs;
    static  String[] ouputs;
    static int numOfInputs; 
    static int numOfOutputs; 
    static final int NUM_OF_INPUTS =1;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	
	
        String inputStr ;
        
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        //System.out.println("Input: "+t );
      	int[][] mat;
 
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
            int trace = 0 ;
            mat = new int[n][n];
            for(int j=0;j<n;++j)
            {
                for(int k=0;k<n;++k)
                {
            	mat[j][k] =  in.nextInt();
                }
                   trace += mat[j][j];
            }
            
       

          String result=processResult( n,mat);
          System.out.println("Case #" + i + ": "+trace+" "+result );
        }
      
	
	}
	public static boolean compatible(int targx,int targty,int sourcex ,int sourcey,char dir)
	{
		boolean retVal= false;
		switch(dir)
		{
		case 'N':
			if(sourcey <targty)
				retVal =true;
			break;
		case 'S':
			if(sourcey >targty)
				retVal =true;
			break;
		case 'W':
			if(sourcex >targx)
				retVal =true;
			break;
		case 'E':
			if(sourcex <targx)
				retVal =true;
			break;
		}
		return retVal;
	}
	public static String processResult(int n,  int mat[][])
	{
		int maxCount =0;
		int maxx =0;
		int maxy =0;
		int finalx=0;
		int finaly=0;
		int ar01[] = new int[n];
		
		int counter =0;
		for(int k=0;k<n;++k)
		{
			for(int j=0;j<n;++j)
			{
				ar01[j]=-1;
			}
			for(int i=0;i<n;++i)
			{
				int value = mat[k][i] -1;
				if (ar01[value]== -1)
					ar01[value]=0;
				else
				{
					++counter;
					break;
				}
				
			}
		}
		int rowCount= counter;
		counter = 0;
		for(int k=0;k<n;++k)
		{
			for(int j=0;j<n;++j)
			{
				ar01[j]=-1;
			}
			for(int i=0;i<n;++i)
			{
				int value = mat[i][k] -1;
				if (ar01[value]== -1)
					ar01[value]=0;
				else
				{
					++counter;
					break;
				}
				
			}
		}

		int ColCount= counter;

		return rowCount+" "+ColCount;
	}

	
}
