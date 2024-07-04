import java.util.*;
import java.io.*;

public class Solution
{
	private static Scanner infile = new Scanner(System.in);
	private static int r, c;
	private static int[][] skillLevels;
	
	public static void main(String[] args)
	{
		int numTestCases = infile.nextInt();
		for(int t = 1; t <= numTestCases; t++)
		{
			r = infile.nextInt();
			c = infile.nextInt();
			skillLevels = new int[r][c];
			for(int i = 0; i < r; i++)
				for(int j = 0; j < c; j++)
					skillLevels[i][j] = infile.nextInt();
			
			boolean someoneGetsOut = true;
			long skillLevelComp = 0;
			while(someoneGetsOut)
			{
				ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
				long skillLevelRound = 0;
				for(int i = 0; i < r; i++)
					for(int j = 0; j < c; j++)
					{
						if(skillLevels[i][j] == 0)
							continue;
						skillLevelRound += skillLevels[i][j];
						if(getsOut(i, j))
						{
							ArrayList<Integer> temp = new ArrayList<Integer>(2);
							temp.add(i);
							temp.add(j);
							out.add(temp);
						}
					}
				if(out.isEmpty())
					someoneGetsOut = false;
				for(ArrayList<Integer> o : out)
					skillLevels[o.get(0)][o.get(1)] = 0;
				skillLevelComp += skillLevelRound;
			}
			
			System.out.println("Case #" + t + ": " + skillLevelComp);
		}
	}
	
	private static boolean getsOut(int row, int col)
	{
		double sum = 0;
		double numDivide = 0;
		
		int temp = row - 1;
		while(temp >= 0 && skillLevels[temp][col] == 0)
			temp--;
		if(temp != -1)
		{
			sum += skillLevels[temp][col];
			numDivide++;
		}
		
		temp = row + 1;
		while(temp < r && skillLevels[temp][col] == 0)
			temp++;
		if(temp != r)
		{
			sum += skillLevels[temp][col];
			numDivide++;
		}

		temp = col - 1;
		while(temp >= 0 && skillLevels[row][temp] == 0)
			temp--;
		if(temp != -1)
		{
			sum += skillLevels[row][temp];
			numDivide++;
		}

		temp = col + 1;
		while(temp < c && skillLevels[row][temp] == 0)
			temp++;
		if(temp != c)
		{
			sum += skillLevels[row][temp];
			numDivide++;
		}
		
		if(skillLevels[row][col] < (sum / numDivide))
			return true;
		return false;
	}
}