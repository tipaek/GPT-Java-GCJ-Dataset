import java.io.*;
import java.util.*;

import com.sun.org.apache.bcel.internal.classfile.PMGClass;

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
    for (int i = 0; i < n; i++)
    {
      p[i] = p[i].replace("*", " * ");
    }

    String[] l = new String[n];
    String[] r = new String[n];
    for (int i = 0; i < n; i++)
    {
      String[] split = p[i].split("\\*");
      l[i] = split[0].replace(" ", "");
      r[i] = split[1].replace(" ", "");
    }

    String lmax = getMax(l);
    for (int i = 0; i < l.length; i++)
    {
      if (!lmax.startsWith(l[i]))
      {
        System.out.println("Case #" + task + ": *");
        return;
      }

    }

    String rmax = getMax(r);
    for (int i = 0; i < l.length; i++)
    {
      if (!rmax.endsWith(r[i]))
      {
        System.out.println("Case #" + task + ": *");
        return;
      }
    }

    String res = lmax + rmax;
    System.out.println("Case #" + task + ": " + res);
  }

  static String getMax(String[] p)
  {
    String pmax = "";
    for (int i = 0; i < p.length; i++)
    {
      if (p[i].length() > pmax.length())
        pmax = p[i];
    }
    return pmax;

  }
}