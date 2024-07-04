
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
    // loop();
    in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    t = in.nextInt();
    b = in.nextInt();
    for (int i = 1; i <= t; ++i)
    {
      task = i;
      solve();
    }
  }

  static void loop()
  {
    b = 20;
    for (int i = 0; i < b; i++)
    {
      if (i % 2 == 0)
        System.out.println(i / 2 + 1);
      else
        System.out.println(b - (i / 2));

    }
  }

  private static void solve()
  {
    char[] ca = new char[b];
    int query = 0;

    for (int i = 0; i < b; i++)
    {
      // wrong answer
      if (query > 0 && query % 10 == 0)
      {
        int pair = -1;
        int sw = -1;
        for (int j = 0; j < (i + 1) / 2; j++)
        {
          int leftpos = (j + 1);
          char leftc = ca[leftpos - 1];
          int rightpos = (b - j);
          char rightc = ca[rightpos - 1];
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
          query++;
          String s = in.next();
          if (ca[pair - 1] != s.charAt(0))
          {
            // comp
            complement(ca);
          }

        }
        if (pair < 0 && sw > 0)
        {
          System.out.println(sw);
          query++;
          String s = in.next();
          if (ca[sw - 1] != s.charAt(0))
          {
            // comp
            complement(ca);
          }
        }
        if (pair > 0 && sw > 0)
        {
          System.out.println(pair);
          query++;
          char pc = in.next().charAt(0);
          System.out.println(sw);
          query++;
          char swc = in.next().charAt(0);
          if (ca[pair - 1] == pc)
          {
            if (ca[sw - 1] == swc)
            {
              // nothing
            }
            else
            {
              revert(ca);
              // i--;
            }
          }
          else
          {
            if (ca[sw - 1] == swc)
            {
              complement(ca);
              revert(ca);
              // i--;
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
        query++;
      }
      else
      {
        pos = b - (i / 2);
        System.out.println(pos);
        query++;
      }

      String s = in.next();
      if ("N".equals(s))
        System.exit(-2);
      ca[pos - 1] = s.charAt(0);
    }
    String res = new String(ca);

    System.out.println(res);
    String ans = in.next();
    if ("N".equals(ans))
      System.exit(-1);
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