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
        int duration[][]; 
        //System.out.println("Input: "+t );
        for (int i = 1; i <= t; ++i) {
        	
          int n = in.nextInt(); 
          duration = new int[n][3];
         // inputStr = in.next();
          for (int j = 0; j < n; ++j) {
        	  duration[j][0] =  in.nextInt();
        	  duration[j][1] =  in.nextInt();
        	  duration[j][2] =  j;
          }
          
      //   System.out.println("   ...........  "+ inputStr);
          String result=processResult( n,duration);
          System.out.println("Case #" + i + ": "+result);
        }
      
	
	}
	public static void  printArr(int n, int duration[][])
	{
		 for (int j = 0; j < n; ++j) {
			 System.out.print( duration[j][0]+ ", ");
			 System.out.print( duration[j][1]+ ", ");
			 System.out.println( duration[j][2]);
         }
	}
	public static String processResult(int n, int duration[][])
	{
		char seqOfSch[] = new char[n];
		//System.out.println("before sorting ....................................");
		//printArr(n,duration);
		
		
		java.util.Arrays.sort(duration, new java.util.Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Integer.compare(a[0], b[0]);
		    }
		});
		

		//System.out.println("after sorting ....................................");
		//printArr(n,duration);
		//assuming ascendign sort
		
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
	}

	
}
