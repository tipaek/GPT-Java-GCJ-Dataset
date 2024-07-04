import java.util.*;
import java.io.*;
import java.lang.Math;

public class Solution {
  public static void main (String[] args) 
  {
	boolean d = false;
	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	String tString = in.nextLine();
	int t = Integer.parseInt(tString);
	for (int i = 1; i <= t; ++i) 
	{
	  String string = in.nextLine();
	  char[] c = string.toCharArray();
	  int currentStack = 0;
	  String ans = "";
	  for (char currentChar: cArr) 
	  {
		int currentInt = Character.getNumericValue(currentChar);
		if (currentInt > currentStack) 
		{
		  while (currentInt > currentStack) 
		  {
			ans += "(";
			currentStack++;
		  }
		ans += Integer.toString(currentInt);
	    }
	    else if (currentInt == currentStack) 
	    {
		  ans += currentInt;
		}
		else if (currentInt < currentStack) 
		{
		  while (currentInt < currentStack) 
		  {
		     ans += ")";
			 currentStack--;
		  }
		ans += Integer.toString(currentInt);
		}
	 }
		while (currentStack > 0) 
		{
		  ans += ")";
		  currentStack--;
		}

		if (d) 
		{
		  System.out.println("Case #" + i + ": " + Arrays.toString(c));
		  System.out.println(ans);
		}
		  System.out.println("Case #" + i + ": " + ans);
	}
  }
}