import java.util.*;
import java.io.*;
public class Solution
{
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(in.readLine());
    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(in.readLine());
      boolean impossible = false;
      int[][] activities = new int[N][2];
      int[][] time = new int[1440][2];
      String[] overlaps = new String[N];
      for (int j = 0; j < N; j++)
      {
        String[] s = in.readLine().split(" ");
        activities[j][0] = Integer.parseInt(s[0]);
        activities[j][1] = Integer.parseInt(s[1]);
        boolean didOverlap = false;
        int actA = -1;
        int actB = -1;
        for (int k = activities[j][0]; k < activities[j][1]; k++)
        {
          if (time[k][0] ==0)
          {
            time[k][0]++;
            time[k][1] = j;
          }
          else if (time[k][0] == 1)
          {
            time[k][0]++;
            if (didOverlap)
            {
              overlaps[actA] += " " + actB;
              overlaps[actB] += " " + actA;
            }
            didOverlap = true;
            actA = time[k][1];
            actB = j;
          }
          else if (time[k][0] >=2)
          {
            impossible = true;
            break;
          }
        }
        if (didOverlap)
        {
          overlaps[actA] += " " + actB;
          overlaps[actB] += " " + actA;
        }
      }
      if (impossible)
      {
        System.out.println ("Case #" + (i+1) + ": IMPOSSIBLE");
      }
      else
      {
        char[] ans = new char[N];
        
        for (int u = 0; u < N; u++)
        {
          boolean change = false;
          for (int k = u; k < N; k++)
          {
            if (ans[k] != 'C' && ans[k] != 'J' && overlaps[k] != null)
            {
              change = true;
              ans[k] = 'C';
              String[] temp = overlaps[k].split(" ");
              for (int x = 1; x < temp.length; x++)
              {
                ans[Integer.parseInt(temp[x])] = 'J';
              }
              break;
            }
          }
          
          if (change)
          {
            for (int p = 0; p < N; p++)
            {
              for (int k = p; k < N; k++)
              {
                if (ans[k] == 'C' || ans[k] == 'J')
                {
                  char now = 'C';
                  char next = 'J';
                  if (ans[k] == next)
                  {
                    now = 'J';
                    next = 'C';
                  }
                  String[] temp = overlaps[k].split(" ");
                  for (int x = 1; x < temp.length; x++)
                  {
                    ans[Integer.parseInt(temp[x])] = next;
                  }
                  break;
                }
              }
            }
          }
        }
        
        for (int k = 0; k<N; k++)
        {
          if (ans[k] != 'C' && ans[k] != 'J')
            ans[k] = 'C';
        }
        
        /*
        for (int k = 0; k < N; k++)
        {
          if (ans[k] != 'C' && ans[k] != 'J')
          {
            ans[k] = 'C';
            if (overlaps[k] != null)
            {
              String[] temp = overlaps[k].split(" ");
              for (int x = 1; x < temp.length; x++)
              {
                ans[Integer.parseInt(temp[x])] = 'J';
                String[] temp2 = overlaps[Integer.parseInt(temp[x])].split(" ");
                for (int x2 = 1; x2 < temp2.length; x2++)
                {
                  ans[Integer.parseInt(temp2[x])] = 'C';
                  String[] temp3 = overlaps[Integer.parseInt(temp2[x])].split(" ");
                  for (int x3 = 1; x3 < temp3.length; x3++)
                  {
                    ans[Integer.parseInt(temp3[x])] = 'J';
                    String[] temp4 = overlaps[Integer.parseInt(temp3[x])].split(" ");
                    for (int x4 = 1; x4 < temp4.length; x4++)
                    {
                      ans[Integer.parseInt(temp4[x])] = 'C';
                    }
                  }
                }
              }
            }
          }
        }
        */
        System.out.print ("Case #" + (i+1) + ": ");
        for (int x = 0; x < ans.length; x++)
        {
          System.out.print(ans[x]);
        }
        System.out.println();
      }
      
      
      
    }
  }
}