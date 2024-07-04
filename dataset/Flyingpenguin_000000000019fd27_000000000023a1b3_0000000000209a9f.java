import java.util.*;
import java.io.*;

class Solution{
	public static void main(String args[]) throws IOException
	{
		Scanner inputScanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String inputStream = inputScanner.nextLine();
		String[] inputData = inputStream.split(" ");
		int t = Integer.parseInt(inputData[0]);
		for(int case_n = 0; case_n < t; case_n++)
		{
			String s = inputScanner.nextLine();
			String o = "";
			int d = Character.getNumericValue(s.charAt(0));
			for(int j = 0; j < d; j++)
			{
				o += "(";
			}
			for(int i = 0; i < s.length() - 1; i++)
			{
				d = Character.getNumericValue(s.charAt(i)) - Character.getNumericValue(s.charAt(i + 1));
				o += s.charAt(i);
				if(d > 0)
				{
					for(int j = 0; j < d; j++)
					{
						o += ")";
					}
				}
				else if(d < 0)
				{
					for(int j = 0; j > d; j--)
					{
						o += "(";
					}
				}
			}
			o += s.charAt(s.length() - 1);
			d = Character.getNumericValue(s.charAt(s.length() - 1));
			for(int j = 0; j < d; j++)
			{
				o += ")";
			}
			System.out.println("Case #" + (case_n + 1) + ": " + o);
		}
	}
}