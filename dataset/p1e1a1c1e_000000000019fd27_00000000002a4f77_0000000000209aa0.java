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
        int mat[][]; 
        //System.out.println("Input: "+t );
        for (int i = 1; i <= t; ++i) {
        	
          int n = in.nextInt(); 
          int k = in.nextInt(); 
          mat = new int[n][3];
         // inputStr = in.next();
          for (int l = 0; l < n; ++l) {
              for (int j = 0; j < n; ++j) {
        	  mat[l][j] =  ((l+j)%(n)+1);
              }
          }
          
      //   System.out.println("   ...........  "+ inputStr);
          //printArr(n,mat);
          String result=processResult( n,k,mat);
          System.out.println("Case #" + i + ": "+result);
          if(result.equalsIgnoreCase("POSSIBLE"))
        	  printArr(n,mat);
        }
      
	
	}
	public static void  printArr(int n, int duration[][])
	{
		 for (int j = 0; j < n; ++j) {
			 System.out.print( duration[j][0]+ " ");
			 System.out.print( duration[j][1]+ " ");
			 System.out.println( duration[j][2]);
         }
	}
	public static String processResult(int n,int k, int duration[][])
	{
		int trace = 0;
		  for (int j = 0; j < n; ++j) 
	        {
			  trace+= duration[j][j];
	        }
		if (trace== k)
			return "POSSIBLE";
		else
		{
			
			
			
			
			return "IMPOSSIBLE";
		}
	/*
		
		int lastCIndex=-1;
		int lastJIndex=-1;
        for (int j = 0; j < n; ++j) 
        {
        	int startValue= duration[j][0];
        	int endValue= duration[j][0];
        	if(lastCIndex ==(-1))
        	{
      	      seqOfSch[j] ='C';
			  lastCIndex = j;
        	}
        	else if (lastJIndex ==(-1))
        	{
        	      seqOfSch[j] ='J';
      			  lastJIndex = j;
        	}
        	else
        	{
        		
        		int cstartValue = duration[lastCIndex][0];
        		int cendValue = duration[lastCIndex][1];
        		int jstartValue = duration[lastJIndex][0];
        		int jendValue = duration[lastJIndex][1];
        		if(startValue >=cendValue)
        		{
        			  seqOfSch[j] ='C';
        			  lastCIndex = j;
        		}
        		else if (startValue >=jendValue )
        		{
      			  seqOfSch[j] ='J';
      			  lastJIndex = j;
        			
        		}
        		else
        		{
        			return "IMPOSSIBLE";
        		}        		
        		
        	}
        	
        }
       char ResultArr[] = new char[n];
       for (int j = 0; j < n; ++j) 
       {
    	   int indexValue = duration[j][2];
    	   ResultArr[indexValue] = seqOfSch[j];
       }
	   String s1 = new String(ResultArr) ;
		return s1;
		*/
	}

	
}
