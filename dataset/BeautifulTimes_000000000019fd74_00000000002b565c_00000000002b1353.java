import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.text.*;
import java.math.BigInteger.*;
import java.util.Arrays; 

public class  Solution
{
  BufferedReader in;
  StringTokenizer as;
  long  nums[][],nums2[];
  Map<Integer,Integer > map = new HashMap<Integer, Integer>();
  ArrayList < Integer >  ar = new ArrayList < Integer >();
  ArrayList < Long >  ar2 = new ArrayList < Long >();
  public static void main (String[] args)
  {
    new Solution  ();
  }
  
  
  public Solution  ()
  {
    try
    {
      
      in = new BufferedReader (new InputStreamReader (System.in));
      int numcases = nextInt();
      nums = new long [501][501];
      nums[0][0] = 1;
      for(int x = 1;x<501;x++)
      {
        for(int x1 = 0;x1<=x;x1++)
        {
          if(x1 == 0)
            nums[x][x1] = 1;
          else if(x1 == x)
            nums[x][x1] = 1;
          else
          {
            if(nums[x-1][x1] != -1 && nums[x-1][x1-1] != -1)
            nums[x][x1] = nums[x-1][x1] + nums[x-1][x1-1];
            else
              nums[x][x1] = -1;
            if(nums[x][x1] > Math.pow(10,9))
             nums[x][x1] = -1;
          }
        }
      }
      for(int abc = 0;abc<numcases;abc++)
      {
        long sum = 0;
        System.out.println("Case #" + (abc+1) + ": ");
        int a = nextInt();
        if(a  < 400)
        {
          for(int x = 0;x<a;x++)
            System.out.println((x+1) + " " + 1);
        }
        else
        {
          int b = a-100;
          int bits[] = new int [32];
          for(int x = 0;x<32;x++)
          {
            if(b % 2 == 1)
              bits[x] = 1;
            b = b/2;
          }
          int rowstaken = 0;
          int side = 0;
          for(int x = 0;x<32;x++)
          {
            if(bits[x] == 0)
            {
           sum += 1;
              if(side == 0)
              {
                System.out.println((x+1) + " " + 1);
              }
              else
                System.out.println((x+1) + " " + (x+1));
            }
            else
            {
              rowstaken++;
              if(side == 0)
              {
                for(int x1 = 0;x1<=x;x1++)
                {
                  sum += nums[x][x1];
                  System.out.println((x+1) + " " + (x1+1));
                }
              }
              else
              {
                for(int x1 = x;x1>=0;x1--)
                {
                  sum += nums[x][x1];
                  System.out.println((x+1) + " " + (x1+1));
                }
                
              }
              side++;
              side = side % 2;
            }
          }
          for(int x = 32;x<100+rowstaken;x++)
          {
            sum++;
            if(side == 0)
            {
              System.out.println((x+1) + " " + 1);
            }
            else
              System.out.println((x+1) + " " + (x+1));
          }
        //  System.out.println(sum);
        }
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