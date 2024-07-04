
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
          System.out.println("Case #" + i + ": "+result);
        }
      
	
	}
	public static String processResult(String  inputStr)
	{
		char[] carray = inputStr.toCharArray();
		int len = carray.length;
		char[] result1=new char[len*20];
		char[] result2=new char[len];
		char  oldValue='0';
		int count=0;
		char padChar='(' ;
		for(int i=0;i<len;++i)
		{
			char digit = carray[i];
			int diff = digit - oldValue;
			if(diff ==0)
			{
				result1[count++] = digit;
			}
			else
			{
				if(diff >0)
				{
					padChar = '(';
				}
				else
				{
					padChar = ')';
				}
				if(diff <0)
					diff = -diff;
				
					for(int k = 0 ;k<diff;++k)
					{
						result1[count++] = padChar;
					}				
					result1[count++] = digit;	
			}
			oldValue = digit;
		}

		int  numCount = (oldValue -'0');
		if(numCount >0)
		{

			padChar = ')';
			for(int k = 0 ;k<numCount;++k)
			{
				result1[count++] = padChar;
			}				
		}
	   String s1 = new String(result1,0,count+1) ;
		return s1;
	}

	
}
