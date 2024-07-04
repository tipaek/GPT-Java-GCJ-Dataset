import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
			
			int diagnolSum = 0;
			Map<Integer,Integer> countRepetitions = new HashMap<Integer, Integer>();
			int columnRepetitions = 0;
			int rowRepetitions = 0;
			boolean flag = false;
			int [][] array = new int[N][N];
			for(int i=0 ; i<N ; i++)
			{
				for(int j=0 ; j<N ; j++)
				{
					int number = s.nextInt();
					if(i==j)
						diagnolSum = diagnolSum + number;
					
					array[i][j] = number;
					if(countRepetitions.containsKey(number)&&flag==false)
					{
						rowRepetitions++;
						flag= true;
					}
					else if (countRepetitions.containsKey(number))
					{
						
					}
					else
						countRepetitions.put(number, 1);
				}
				countRepetitions.clear();
				flag = false;
				
			}
			flag = false;
			for(int i =0 ;i<N ;i++)
			{
				for(int j=0 ; j<N ;j++)
				{
					int number = array[j][i];
					if(countRepetitions.containsKey(number)&&flag==false)
					{
						columnRepetitions++;
						flag= true;
					}
					else if (countRepetitions.containsKey(number))
					{
						
					}
					else
						countRepetitions.put(number, 1);
				}
				countRepetitions.clear();
				flag = false;
			}
			
			System.out.println("Case #" + testCaseCount + ": "+ diagnolSum + " " + rowRepetitions + " "+ columnRepetitions);
			
		}
		
    }
    