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
    int n = in.nextInt();
    String[] p = new String[n];
    for (int i = 0; i < n; i++)
    {
      p[i] = in.next();
    }
    String pmax = "";
    for (int i = 0; i < n; i++)
    {
      if (p[i].length() > pmax.length())
        pmax = p[i];
    }

    for (int i = 0; i < n; i++)
    {
      String pws = p[i].replace("*", "");
      if (!pmax.endsWith(pws))
      {
        System.out.println("Case #" + task + ": *");
        return;
      }
    }

    String res = pmax.replace("*", "");
    System.out.println("Case #" + task + ": " + res);
  }
}