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
        String s = br.readLine();
        String output = new String("");
        int c = 0;
        for(int i=0;i<s.length();i++)
        {
          int n = Integer.parseInt(Character.toString(s.charAt(i)));
          if(n>c)
          {
            for(int k = 0; k < n-c ; k++)
            {
              output += "(";
            }
            output += s.charAt(i);
          }
          else if(c>n)                                        
          {
            for(int k = 0; k < c-n ; k++)
            {
              output += ")";
            }
            output += s.charAt(i);
          }
          else
          {
            output += s.charAt(i);
          }
          c = n;
        }
        for(int k = 0; k < c ; k++)
        {
          output += ")";
        }
        System.out.println("Case #" + t + ": " + output);
      }
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}