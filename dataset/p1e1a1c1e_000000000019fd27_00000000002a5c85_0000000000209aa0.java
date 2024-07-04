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
			 for (int i = 0; i < n; ++i) {
			 System.out.print( duration[j][i]+ " ");
			 }
			 System.out.println("");
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
	
	}

	
}
