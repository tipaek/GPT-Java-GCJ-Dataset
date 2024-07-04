import java.io.*;
import java.util.*;
class Solution 
{
  public static void main(String[] args) 
  {
    try
    {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int h = 0;
      h = Integer.parseInt(br.readLine());
      for(int t=1;t<=h;t++)
      {
        String rs[] = br.readLine().split(" ");
        int r = Integer.parseInt(rs[0]);
        int s = Integer.parseInt(rs[1]);
        String dir = rs[2];
        int a=r, b=s, c=0, moves=0;
        for(int i=0;i<dir.length();i++)
        {
          if(dir.charAt(i)=='S')
          {
            b--;
          }
          else if(dir.charAt(i)=='N')
          {
            b++;
          }
          else if(dir.charAt(i)=='E')
          {
            a++;
          }
          else if(dir.charAt(i)=='W')
          {
            a--;
          }
          int diff = Math.abs(a)+Math.abs(b);
          if(diff <= (i+1))
          {
            moves = i+1;
            c = 1;
            break;
          }
        }
        if(c==1)
        {
          System.out.println("Case #" + t + ": " + moves);
        }
        else
        {
          System.out.println("Case #" + t + ": IMPOSSIBLE");
        }
      }
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}