import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.text.*;
import java.math.BigInteger.*;
import java.util.Arrays; 

public class Main
{
  BufferedReader in;
  StringTokenizer as;
  int  nums[][];
  boolean nums2[];
  Map<Integer,Integer > map = new HashMap<Integer, Integer>();
  ArrayList < Integer >  ar = new ArrayList < Integer >();
  ArrayList < Long >  ar2 = new ArrayList < Long >();
  public static void main (String[] args)
  {
    new Main  ();
  }
  
  
  public Main  ()
  {
    try
    {
      
      in = new BufferedReader (new InputStreamReader (System.in));
      int a = nextInt();
      for(int aa = 0;aa<a;aa++)
      {
        int b = nextInt();
        nums = new int [b][b];
        for(int x = 0;x<b;x++)
        {
          for(int x1 = 0;x1<b;x1++)
            nums[x][x1] = nextInt();
        }
        int sum = 0;
        for(int x = 0;x<b;x++)
          sum += nums[x][x];
        int d1 = 0;
        for(int x = 0;x<b;x++)
        {
          nums2 = new boolean [1000];
          for(int x1 = 0;x1<b;x1++)
          {
            if(nums2[nums[x][x1]])
            {
              d1++;
              break;
            }
            nums2[nums[x][x1]] = true;
          }
        }
        int d2 = 0;
        for(int x = 0;x<b;x++)
        {
          nums2 = new boolean [1000];
          for(int x1 = 0;x1<b;x1++)
          {
            if(nums2[nums[x1][x]])
            {
              d2++;
              break;
            }
            nums2[nums[x1][x]] = true;
          }
        }
        System.out.println("Case #" + (aa+1) + ": " + sum + " " + d1 + " " + d2);
      }
      
    }
    
    
    
    catch(IOException e)
    {
      System.out.println(e);
      
    }
  }
  String next () throws IOException
  {
    while (as == null || !as.hasMoreTokens ())
    {
      as = new StringTokenizer (in.readLine ().trim ());
    }
    
    
    return as.nextToken ();
  }
  
  
  
  long nextLong () throws IOException
  {
    return Long.parseLong (next ());
  }
  
  
  int nextInt () throws IOException
  {
    return Integer.parseInt (next ());
  }
  
  
  double nextDouble () throws IOException
  {
    return Double.parseDouble (next ());
  }
  
  
  String nextLine () throws IOException
  {
    return in.readLine ().trim ();
  }
}