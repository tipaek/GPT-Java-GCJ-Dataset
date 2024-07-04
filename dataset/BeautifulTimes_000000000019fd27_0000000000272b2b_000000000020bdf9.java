import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.text.*;
import java.math.BigInteger.*;
import java.util.Arrays; 

public class   Solution
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
    new Solution  ();
  }
  
  
  public Solution  ()
  {
    try
    {
      
      in = new BufferedReader (new InputStreamReader (System.in));
      int a = nextInt();
      for(int aa = 0;aa<a;aa++)
      {
        String out = "";
        int b = nextInt();
        nums = new int [b][3];
        for(int x = 0;x<b;x++)
        {
          nums[x][0] = nextInt();
          nums[x][1] = nextInt();
          nums[x][2] = x;
        }
        Arrays.sort(nums, (aaa,bb) -> Integer.compare(aaa[0],bb[0]));
        int atime = 0;
        int btime = 0;
        boolean good = false;
        String outs[] = new String [b];
        for(int x = 0;x<b;x++)
        {
          if(atime <= nums[x][0])
          {
            outs[nums[x][2]] = "C";
            atime = nums[x][1];
          }
          else if(btime <= nums[x][0])
          {
             outs[nums[x][2]]= "J";
            btime = nums[x][1];
          }
          else
          {
            out = "IMPOSSIBLE";
            good = true;
            break;
          }
          
        }
        if(!good)
        {
          for(int x = 0;x<b;x++)
            out += outs[x];
        }
        System.out.println("Case #" + (aa+1) + ": " + out);
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