import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception
	{
		
        	Scanner scan = getScanner();
        	int T = scan.nextInt();
		for (int i = 1; i <= T; i++)
		{
        		int size = scan.nextInt();
        		int sumDiag = 0;
        		int repeatsRow = 0;
        		int repeatsCol = 0;
        		HashSet<Integer> hash = new HashSet<Integer>();
        		ArrayList<Integer> arr = new ArrayList<Integer>();
        		for (int j = 1; j <= size; j++)
        		{
        			for (int k = 1; k <= size; k++)
        			{
        				int num = scan.nextInt();
        				if (k == j)
        				{
        					sumDiag += num;
        				}
        				arr.add(num);
        				hash.add(num);
        			}
        			if (hash.size() != size)
        			{
        				repeatsRow++;
        			}
        			hash.clear();
        		}
        		for (int m = 0; m < size; m++)
        		{
        			int tracker = m;
        			while (tracker < size * size)
        			{
        				hash.add(arr.get(tracker));
        				tracker += size;
        			}
        			if (hash.size() != size)
        			{
        				repeatsCol++;
        			}
        			hash.clear();
        		}
        		System.out.println("Case #" + i + ": " + sumDiag + " " + repeatsRow + " " + repeatsCol);
        	}
	}
	
	static Scanner getScanner() throws Exception
	{
		//return new Scanner(new File("input.txt"));
		return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }
}

  