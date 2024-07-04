import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Scanner s = new Scanner(System.in);
    public static void main(String[] args) throws NumberFormatException, IOException {
    	int testCaseCount=0;
		

        int testCount = Integer.parseInt(br.readLine());
        
        //QualificationRoundGoogleCodeJam problem = new QualificationRoundGoogleCodeJam();
        for (int i = 1; i <= testCount; i++) {
        	testCaseCount++;
            solve(testCount,testCaseCount);
        }
        br.close();
    }

    	static void solve(int testCount, int testCaseCount) throws IOException
    	{
    		
    		takeInputAndCalculate(testCount,testCaseCount);
    	}

		private static void takeInputAndCalculate(int testCount, int testCaseCount) throws IOException {
			String output="";
			int currentNumberOfOpenParanthesis = 0;
			String input = br.readLine(); 
			int strLength = input.length();
			for (int i=0 ; i< strLength ; i++)
			{
				int number = Character.getNumericValue(input.charAt(i));
				
				if(strLength==1)
				{
					for(int j=0 ; j< number ;j++)
					{
						output = output + "(";
					}
					output = output + number;
					for(int j=0 ; j< number ;j++)
					{
						output = output + ")";
					}
				}
				else if(i==0)
				{
					for(int j=0 ; j< number ;j++)
					{
						output = output + "(";
						currentNumberOfOpenParanthesis++;
					}
					output = output + number;
				}
				
			
				
				else if(i!=0 )
				{
					
					if(number<Character.getNumericValue(input.charAt(i-1)))
					{
						int diff = Character.getNumericValue(input.charAt(i-1)) - number;
						for(int j=0 ; j<diff;j++)
						{
							output = output + ")";
							currentNumberOfOpenParanthesis--;
						}
						output = output + number;
					}
					else if (number>Character.getNumericValue(input.charAt(i-1)))
					{
						int diff = number - Character.getNumericValue(input.charAt(i-1));
//						for(int j=0 ; j<currentNumberOfOpenParanthesis;)
//						{
//							output = output + ")";
//							currentNumberOfOpenParanthesis--;
//						}
						for(int j=0 ; j<diff; j++)
						{
							output = output + "(";
							currentNumberOfOpenParanthesis++;
						}
						
						output = output + number;
					}
					else
						output = output + number;
					
					
					if(i==strLength-1)
					{
						for(int j=0 ; j<currentNumberOfOpenParanthesis;)
						{
							output = output + ")";
							currentNumberOfOpenParanthesis--;
						}
					}
					
				}
					
				
				
			}
			System.out.println("Case #" + testCaseCount + ": "+ output);	
		}	
    }