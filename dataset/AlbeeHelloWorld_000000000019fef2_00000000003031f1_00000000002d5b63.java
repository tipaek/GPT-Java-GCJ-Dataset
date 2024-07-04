import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
	static boolean isTest = false;

	public static void main(String[] args) throws Exception
	{
		
        	Scanner scan = getScanner();
		int T = scan.nextInt();
		int A = scan.nextInt();
		int B = scan.nextInt();
		String f = scan.nextLine();
		//System.out.println(T + " " + A + " " + B);
		for (int i = 0; i < T; i++)
		{
			boolean isFound = false;
			for (int x=-5; x<6; x++)
			{
				for (int y=-5; y<6; y++)
				{
					System.out.println ("" + x + " " + y);
					String verdict = scan.nextLine();
					if (verdict.equals("CENTER"))
					{
						isFound = true;
						break;
					}
					if (verdict.equals("WRONG"))
					{
						isFound = true;
						break;
					}
				}
				if (isFound) break;
			}
        	}
	}
	
	static Scanner getScanner() throws Exception
	{
		if (isTest)
			return new Scanner(new File("input.txt"));
		else
			return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }
        
        static void debug(String s)
        {
        	if(isTest)
        		System.out.println(s);
        }
}

  