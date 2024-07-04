import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
	static boolean isTest = false;

	public static void main(String[] args) throws Exception
	{
		
        	Scanner scan = getScanner();
        	String x = scan.nextLine();
        	int T = Integer.parseInt(x);
		for (int i = 0; i < T; i++)
		{
			int R = scan.nextInt();
			int S = scan.nextInt();
			x = scan.nextLine();
        		System.out.println("Case #" + (i+1) + ": " + (R-1) * (S-1));
        		for (int j = R; j >1; j --)
        		{
        			for (int k =0; k < S-1; k++)
        			{
					System.out.println(((j*S-j)-k) + " " + (j-1));
        			}
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

  