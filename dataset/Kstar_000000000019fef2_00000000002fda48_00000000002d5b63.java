import java.io.*;
import java.util.*;

public class Solution
{
  public static void main (String [] args) throws IOException
  {
    Scanner sc1 = new Scanner(System.in);
    int tc = sc1.nextInt();
    for(int i =0; i < tc; i++)
    {
      int topt =1000000000;
      int topb = 0;
      int bottomt = 0;
      int bottomb = -1000000000;
      
        int mid = (topt + topb)/2;
      boolean pass = false;
      while(topt > topb)
      {
        mid = (topt + topb)/2;
        System.out.println(mid+ " "+ mid);
        String t= sc1.next();
        
        if(t.equals("CENTER"))
        {
          pass = true;
          break;
        }
        else if (t.equals("HIT"))
        {
          topt = mid;
        }
        else
        {
          topb= mid+1;
        }
      }
      if(!pass)
      {
      while(bottomt > bottomb)
      {
        mid = (bottomt + bottomb)/2;
        System.out.println(mid+ " "+ mid);
        String t= sc1.next();
        
        if(t.equals("CENTER"))
        {
          pass = true;
          break;
        }
        else if (t.equals("HIT"))
        {
          bottomt = mid;
        }
        else
        {
          bottomb= mid+1;
        }
        
      }
      if(!pass)
      {
        int m = (topt+bottomt)/2;
        System.out.println(m +" "+ m);
        String c = sc1.next();
        if(!c.equals("CENTER"))
        {
          m++;
          System.out.println(m + " " + m);
        }
      }
          
          
      
      }
    }
  }
}