import java.io.*;
import java.util.*;

public class Solution
{
  private static int t;
  private static int task;
  private static Scanner in;

  public static void main(String[] args) throws Exception
  {
    in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    t = in.nextInt();
    for (int i = 1; i <= t; ++i)
    {
      task = i;
      solve();
    }
  }

  private static void solve()
  {
    String s = in.next();
    char[] sc = s.toCharArray();
    int[] si = new int[sc.length];
    for (int i = 0; i < sc.length; i++)
    {
      si[i] = Character.getNumericValue(sc[i]);
    }

    String res = "";
    int open = 0;
    for (int i = 0; i < si.length; i++)
    {
      int n = si[i];
      int p = n - open;
      for (int j = 0; j < Math.abs(p); j++)
      {
        if (p > 0)
        {
          res += '(';
          open++;
        }
        if (p < 0)
        {
          res += ')';
          open--;
        }
      }
      res += si[i];
    }
    for (int i = 0; i < open; i++)
      res += ')';

    System.out.println("Case #" + task + ": " + res);
  }
}