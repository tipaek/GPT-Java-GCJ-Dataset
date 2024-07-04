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
      int N=Integer.parseInt(in.nextLine());
      int[] start=new int[N];
      int[] end=new int[N];

      for (int k=0; k<N; k++)
      {
        String[] s=in.nextLine().split(" ");
        start[k]=Integer.parseInt(s[0]);
        end[k]=Integer.parseInt(s[1]);
      }
      String ans=solve(start,end);
      System.out.println("Case #"+i+": "+ans);
    }

		in.close();
	}

  public static String solve(int[] start, int[] end)
  {
    int N=start.length;

    char[] ans=new char[N];
    boolean Jfree=true;
    boolean Cfree=true;

    for (int time=0; time<=24*60; time++)
    {
      for (int i=0; i<N; i++)
      {
        if (time==start[i])
        {
          if (Jfree)
          {
            ans[i]='J';
            Jfree=false;
          }
          else if (Cfree)
          {
            ans[i]='C';
            Cfree=false;
          }
          else return "IMPOSSIBLE";
        }
        if (time==end[i])
        {
          if (ans[i]=='J') Jfree=true;
          else Cfree=true;
        }
      }
    }

    return new String(ans);
  }
}