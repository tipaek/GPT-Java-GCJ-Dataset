import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
	static Scanner s = new Scanner(System.in);
    public static void main(String[] args) throws NumberFormatException, IOException {
    	int testCaseCount=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = s.nextInt();
        
        //QualificationRoundGoogleCodeJam problem = new QualificationRoundGoogleCodeJam();
        for (int i = 1; i <= testCount; i++) {
        	testCaseCount++;
            solve(testCount,testCaseCount);
        }
        br.close();
    }

    	static void solve(int testCount, int testCaseCount) throws IOException
    	{
    		int N = s.nextInt();
    		takeInputAndCalculate(testCount,N,testCaseCount);
    	}

		private static void takeInputAndCalculate(int testCount, int N, int testCaseCount) throws IOException {
			
			String finalString="";
			String outputString=".*";
			for(int i=0 ; i<N ; i++)
			{
				String input = s.next();
				input = input.replace("*", ".*");
				int inputLength = input.length();
//				if(inputLength==2 && input.charAt(0)=='*')
//					{
//					outputString = "A"+ input.charAt(1);
//					break;
//					}
//				if(inputLength==2 && input.charAt(1)=='*')
//				{
//				outputString =  input.charAt(0) + "A";
//				break;
//				}
//				
				if(Pattern.matches(outputString, input) || Pattern.matches(input, outputString) )	
				{
						if(inputLength>=outputString.length())
						outputString = input;
				}
				else
				{
					outputString = "*";
					break;
				}
				
			}
			outputString = outputString.replace(".*", "*");
			
			for(int i=0; i< outputString.length();i++)
			{
				if(outputString.charAt(i)!= '*')
					finalString = finalString + outputString.charAt(i);
				else
					finalString = finalString + "A";
			}
			if(finalString.equals("A"))
				System.out.println("Case #" + testCaseCount + ": "+ "*");
			else
			
			System.out.println("Case #" + testCaseCount + ": "+ finalString);
			
		}
		
    }
    
    
    
    
  
 