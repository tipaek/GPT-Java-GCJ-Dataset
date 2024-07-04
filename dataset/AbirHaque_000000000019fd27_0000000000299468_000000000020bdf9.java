import java.util.*;
import java.io.*;

public class Solution
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader

(System.in)));
    int t = in.nextInt();;
    for (int i = 0; i < t ; i++)
    {
      int n = in.nextInt();
      int[] s = new int[n];
      int[] e = new int[n];
      String[] possible = new String[n];
      String string = "";
      for (int j = 0; j < n ; j++)
      {
        String se = in.next() + in.nextLine();
        String[] arr = se.split(" ");
        for (int x = 0; x < arr.length; x++)
        {
		s[x] = Integer.valueOf(arr[0]);
		e[x] = Integer.valueOf(arr[1]);
        }
  int other = 1;
	for (int x = 0; x < e.length; x++)
	{
		if (x == e.length-1)
    {
      if (e[x]-s[0] > 0)
      {
        if (other % 2 == 1)
        {
          possible[x] = "C";
          other++;
        }
        else
        {
          possible[x] = "J";
          other++;
        }
      }
      else
      {
        if (other % 2 == 1)
        {
          possible[x] = "J";
          other++;
        }
        else
        {
          possible[x] = "C";
          other++;
        }
      }
    }
    else
    {
      if (e[x]-s[x+1] > 0)
      {
        if (other % 2 == 1)
        {
          possible[x] = "J";
          other++;
        }
        else
        {
          possible[x] = "C";
          other++;
        }
      }
      else
      {
        if (other % 2 == 1)
        {
          possible[x] = "C";
          other++;
        }
        else
        {
          possible[x] = "J";
          other++;
        }
      }
    }
	}
      }  
      for (int x = 0; x < possible.length; x++)
	{
		string = string + possible[x];
	}
  int wrong = 0;
  for (int x = 0; x < n-1; x++)
  {
    int start = s[x];
    int end = e[x];
    for (int r = 0; r < n; r++)
    {
      if (start<s[r]&&end>e[r])
      {
        wrong++;
        System.out.println(wrong);
      }
      if (wrong>1)
      {
        string = "IMPOSSIBLE";
      }
    }
  }
      System.out.println("Case #"+(i+1)+": "+string);;
    }
	}
}
/*
4
3
360 480
420 540
600 660
3
0 1440
1 3
2 4
5
99 150
1 100
100 301
2 5
150 250
2
0 720
720 1440
*/
  