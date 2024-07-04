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
        for (int i = 1; i <= t; ++i) {
        	
         // int d = in.nextInt();
          inputStr = in.next();

      //   System.out.println("   ...........  "+ inputStr);
          String result=processResult( inputStr);
          System.out.println("Case #" + i + ": "+result );
        }
      
	
	}
	public static String trimLeadingZeros(String source) {
	    for (int i = 0; i < source.length(); ++i) {
	        char c = source.charAt(i);
	        if (c != '0') {
	            return source.substring(i);
	        }
	    }
	    return ""; // or return "0";
	}
	public static String processResult(String  inputStr)
	{
		char[] carray = inputStr.toCharArray();
		int len = carray.length;
		char[] result1=new char[len*20];
		char[] result2=new char[len];
		boolean flag=false;
		int count=0;
		for(int i=0;i<len;++i)
		{
			if(!flag)
			{
				if(carray[i]=='0' )
				{
					result1[count] = carray[i];
				}
				else
				{

					result1[count] = '(';
					count++;
					result1[count] = carray[i] ;
					flag =true;
				}
			}
			else
			{

				if(carray[i]=='1' )
				{
					result1[count] = carray[i];
				}
				else
				{

					result1[count] = ')';
					count++;
					result1[count] = carray[i];
					flag =false;
				}
			}
			++count;
		}
		if(flag)
		{
			++count;
			result1[count] = ')';
		}
	   String s1 = new String(result1) ;
		return s1;
	}

	
}
