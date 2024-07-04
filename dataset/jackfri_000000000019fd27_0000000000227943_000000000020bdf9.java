import java.util.*;
import java.awt.Point;

public class Solution
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int testcases = in.nextInt();
      
      for(int i = 0; i < testcases; i++)
      {
         int jEndTime = 0;
         int cEndTime = 0;
         int numTimes = in.nextInt();
         String combo = "";
         Point[] p = new Point[numTimes];
         for(int l = 0; l < p.length; l++)
         {
           p[l] = new Point(in.nextInt(), in.nextInt());
         }
         Arrays.parallelSort(p);
         
         for(int k = 0; k < numTimes; k++)
         {          
            if(cEndTime <= p[k].a)
            {
               combo += "C";
               cEndTime = p[k].b;
            }
            else if(jEndTime <= p[k].a)
            {
               combo += "J";
               jEndTime = p[k].b;
            }
            else
            {
               combo = "IMPOSSIBLE";
               break;
            }
         }
         
         System.out.println("Case " + (i+1) + ": " + combo);
      }
   }
   
   static class Point implements Comparable<Point>
   {
      int a, b;
      Point(int first, int second)
      {
         a = first;
         b = second;
      }
      
      public int compareTo(Point otherPoint)
      {
         return (this.a == otherPoint.a) ? this.b - otherPoint.b : this.a - otherPoint.a;
      }
   }
}

