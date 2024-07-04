import java.util.*;
import java.io.*;

public class Solution 
{
	public static boolean patternFinished(char[] patterns, int curIndex)
	{
		return curIndex == 0;
	}
	
	public static boolean allPatternFinished(ArrayList<char[]> patterns, int[] curIndex)
	{
		for (int i=0; i<patterns.size(); i++)
		{
			if (!patternFinished(patterns.get(i), curIndex[i]))
				return false;
		}
		
		return true;
	}

	public static String findSolution(ArrayList<char[]> patterns)
	{
		StringBuilder sb = new StringBuilder();
		
		int[] curIndexList = new int[patterns.size()];
		for (int i=0; i<patterns.size(); i++)
		{
			curIndexList[i] = patterns.get(i).length - 1;
		}
		
		char curChar = Character.MIN_VALUE;
		
		while (!allPatternFinished(patterns, curIndexList)) 
		{
			int numStars = 0;
			for (int i=0; i<patterns.size(); i++)
			{
				char[] pattern = patterns.get(i);
				int curIndex = curIndexList[i];
				
				if (pattern[curIndex] != '*')
				{
					if (curChar == Character.MIN_VALUE)
					{
						curChar = pattern[curIndex];
						curIndexList[i] --;
					}
					else if (pattern[curIndex] == curChar)
					{
						curIndexList[i] --;
					}
					else
					{
						return "*";
					}
				}
				else
				{
					numStars++;
				}
				
			}
			
			if (numStars == patterns.size())
			{
				for (int i=0; i<patterns.size(); i++)
				{
					if (curIndexList[i] != 0)
					{
						curIndexList[i]--;
						break;
					}
				}
			}
			
			if (curChar != Character.MIN_VALUE)
				sb.append(curChar);
			numStars = 0;
			curChar = Character.MIN_VALUE;
		}
		
		return sb.reverse().toString();
	}
	
	
	public static void main(String[] args) 
	{
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int numTestCase = in.nextInt(); 
	
	    for (int i = 1; i <= numTestCase; ++i) 
	    {
	    	int numPatterns = in.nextInt();
	    	ArrayList<char[]> patterns = new ArrayList<char[]>();
	    	
	    	for (int j=0; j<numPatterns; j++)
	    	{
	    		String s = in.next();
	    		patterns.add(s.toCharArray());
	    	}
	    	
	    	String solution = Solution.findSolution(patterns);
	    	System.out.println("Case #" + i + ": " + solution);
	    }
	}
}