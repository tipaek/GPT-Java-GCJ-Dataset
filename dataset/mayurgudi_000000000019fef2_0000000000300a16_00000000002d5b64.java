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
        if(r>=s)
        {
          System.out.println("Case #" + t + ": " + (r-1));
          int a = (r*s)/2;
          int b = a-1;
          do
          {
            System.out.println(a+" "+b);
            a--;
            b--;
          }while(b>=1);
        }
        else
        {
          System.out.println("Case #" + t + ": " + (s-1));
          do
          {
            System.out.println("2 "+s);
            s--;
          }while(s>=2);
        }
      }
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}