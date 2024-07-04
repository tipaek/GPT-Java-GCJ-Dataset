import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		long startTime = System.nanoTime();
		BufferedReader fin = new BufferedReader((new InputStreamReader(System.in)));
		//BufferedReader fin = new BufferedReader((new FileReader("paren.in")));
		int numtestcases = Integer.parseInt(fin.readLine());
		for (int i = 0; i < numtestcases; i++)
		{
			String s = fin.readLine();
			String s1 = "";
			int order = 0;
			for (int j = 0; j < s.length(); j++)
			{
				int x = Integer.parseInt(s.substring(j, j+1));
				for (int k = 0; k < x-order; k++)
				{
					s1 += "(";
				}
				for (int k = 0; k < order-x; k++)
				{
					s1 += ")";
				}
				order = x;
				s1 += x;
			}
			for (int k = 0; k < order; k++)
			{
				s1 += ")";
			}
			
			System.out.println("Case #" + (i+1) + ": " + s1);
			
		}
		
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		//System.out.println(totalTime/1000000000.0);	  
	}
	
}
