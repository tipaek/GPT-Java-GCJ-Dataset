import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
	static boolean isTest = false;

	static int n;
	static StringBuffer out;

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
			n = 0;
			out = new StringBuffer();
			Calc(R, S);
        		System.out.println("Case #" + (i+1) + ": " + n);
        		System.out.println(out);
        		
        	}
	}
	
	static void Calc (int R, int S)
	{
		if (R == 1) return;
		n+= S-1;
		for (int i=0; i < S-1; i++)
		{
			out.append(((R*S-R)-i) + " " + (R-1) + "\n");
		}
		Calc(R-1, S);
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

  