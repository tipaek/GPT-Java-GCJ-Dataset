import java.io.*;
import java.util.*;
import java.math.*;

public class Solution
{
	public static void main(String[] args) throws Exception
	{		
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T=Integer.parseInt(in.nextLine());

		for (int i=1; i<=T; i++)
		{
      String s=in.nextLine();
      String ans=solve(s);
      System.out.println("Case #"+i+": "+ans);
    }

		in.close();
	}

  public static String solve(String s)
  {
    String out="";
    int open=0;

    for (int i=0; i<s.length(); i++)
    {
      int val=(int)(s.charAt(i)-'0');
      if (val>open)
      {
        for (int k=0; k<val-open; k++) out+="(";
      }
      else if (val<open)
      {
        for (int k=0; k<open-val; k++) out+=")";
      }
      open=val;      
      out+=val;
    }
    for (int k=0; k<open; k++) out+=")";

    return out;
  }
}