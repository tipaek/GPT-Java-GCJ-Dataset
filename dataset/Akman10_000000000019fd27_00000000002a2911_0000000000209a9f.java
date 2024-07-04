import java.util.*;
import java.io.*;

 public class Solution {
	public static void main(String[] args) 
      {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int ii = 1; ii <= t; ++ii) 
        {
          String s=in.next();
          long bo=0,bc=0;
          String wd="";
          for(int i=0;i<s.length();i++)
          {
              int ch=((int)s.charAt(i))-48;
              if(bo==0)
              {
                  bo=ch;
                  for(int j=1;j<=ch;j++)
                  {
                	  wd=wd+"(";
                  }
              }
              else if(ch<bo)
              {
            	  for(int j=1;j<=bo-ch;j++)
                  {
                	  wd=wd+")";
                  }
            	  bo=ch;
              }
              else if(ch>bo)
              {
            	  for(int j=1;j<=ch-bo;j++)
                  {
                	  wd=wd+"(";
                  }
            	  bo=ch;
              }
              
              wd=wd+ch;
          }
          if(bo!=0)
          {
        	  for(int j=1;j<=bo;j++)
              {
            	  wd=wd+")";
              }
          }
          
          System.out.println("Case #" + ii + ": " + wd);
        }//test
      }
}