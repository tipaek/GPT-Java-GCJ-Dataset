import java.io.*;
import java.util.*;

public class Solution
{
  private static int t;
  private static int task;
  private static Scanner in;
  private static int b;

  public static void main(String[] args) throws Exception
  {
    in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    t = in.nextInt();
    b = in.nextInt();
    for (int i = 1; i <= t; ++i)
    {
      task = i;
      solve();
    }
  }

  private static void solve()
  {
    char[] ca = new char[b];

    for (int i = 0; i < b; i++)
    {
      // wrong answer
      if (i > 0 && i % 10 == 0)
      {
        int pair = -1;
        int sw = -1;
        for (int j = 0; j < (i + 1) / 2; j++)
        {
          int leftpos = (j + 1);
          char leftc = ca[leftpos];
          int rightpos = (b - j);
          char rightc = ca[rightpos];
          if ((leftc == '0' || leftc == '1') && (rightc == '0' || rightc == '1'))
          {
            if (pair < 0 && leftc == rightc)
              pair = leftpos;
            if (sw < 0 && leftc != rightc)
              sw = leftpos;
          }
        }
        if (pair > 0 && sw < 0)
        {
          System.out.println(pair);
          String s = in.next();
          if (ca[pair] != s.charAt(0))
          {
            // comp
            complement(ca);
          }

        }
        if (pair < 0 && sw > 0)
        {
          System.out.println(sw);
          String s = in.next();
          if (ca[sw] != s.charAt(0))
          {
            // comp
            complement(ca);
          }
        }
        if (pair > 0 && sw > 0)
        {
          System.out.println(pair);
          char pc = in.next().charAt(0);
          System.out.println(sw);
          char swc = in.next().charAt(0);
          if (ca[pair] == pc)
          {
            if (ca[sw] == swc)
            {
              // nothing
            }
            else
            {
              revert(ca);
            }
          }
          else
          {
            if (ca[sw] == swc)
            {
              complement(ca);
              revert(ca);
            }
            else
            {
              complement(ca);
            }
          }
        }
      }
      int pos = 0;
      if (i % 2 == 0)
      {
        pos = i / 2 + 1;
        System.out.println(pos);
      }
      else
      {
        pos = b - (i / 2);
        System.out.println(pos);
      }

      String s = in.next();
      if ("N".equals(s))
        System.exit(0);
      ca[pos - 1] = s.charAt(0);
    }
    String res = new String(ca);

    System.out.println(res);
    String ans = in.next();
    if ("N".equals(ans))
      System.exit(0);
  }

  private static void revert(char[] ca)
  {
    for (int j = 0; j < ca.length / 2; j++)
    {
      char c = ca[j];
      ca[j] = ca[ca.length - j - 1];
      ca[ca.length - j - 1] = c;
    }
  }

  private static void complement(char[] ca)
  {
    for (int j = 0; j < ca.length; j++)
    {
      if (ca[j] == '0')
        ca[j] = '1';
      else if (ca[j] == '1')
        ca[j] = '0';
    }

  }
}