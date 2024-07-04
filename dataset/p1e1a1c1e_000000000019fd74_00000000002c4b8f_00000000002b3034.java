
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

	
	
	
        String inputStr[] ;
        
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        //System.out.println("Input: "+t );
        for (int i = 1; i <= t; ++i) {
        	
          int d = in.nextInt();
          inputStr =  new String[d];
          for (int j = 0; j < d; ++j) {
              
          inputStr[j] = in.next();
          }

       // System.out.println("   ...........  "+ inputStr);
          String result=processResult(d, inputStr);
          System.out.println("Case #" + i + ": "+result);
          
        }
      
	
	}
	public static String  twoRegExprEquiv(String  inputStr1, String  inputStr2)
	{
		
		//case 1
		int len1 = inputStr1.length();
		int len2 = inputStr2.length();
	
		if((inputStr1.lastIndexOf('*')==0) && inputStr2.lastIndexOf('*')==0 ) 
		{
			String Str1 = inputStr1.substring(1);
			String	Str2 =  inputStr2.substring(1);
			if(len1 <=len2)
			{
				int index0 = Str2.indexOf(Str1);
				if(index0 ==(-1))
					return "*";
				else return Str2;
				
			}
			else
			{
				int index0 = Str1.indexOf(Str2);
				if(index0 ==(-1))
					return "*";
				else return Str1;
				
			}
		}
		return "*";
	}
	public static String processResult(int n,String  inputStr[])
	{
		int max =1;
		String maxString="*";
		for(int i=0;i<n;++i)
		{
				for(int j=0;j<n;++j)
			
			   {
					String ret = twoRegExprEquiv(inputStr[i],inputStr[j]);
					if(ret.equalsIgnoreCase("*"))
						return "*";
					else
					{
						int len = ret.length();
						if(len >max )
						{
							max = len;
							maxString = ret;
						}
					}
				
			}
		}
		return maxString;
	
	}

	
}
