//make sure to make new file!
import java.io.*;
import java.util.*;

public class Solution{
   
   public static void main(String[] args)throws IOException{
      BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter out = new PrintWriter(System.out);
      
      int t = Integer.parseInt(f.readLine());
      
      for(int q = 1; q <= t; q++){
      
         int n = Integer.parseInt(f.readLine());
      
         Point[] points = new Point[n];
         for(int k = 0; k < n; k++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
         
            points[k] = new Point(x,y);
         }
         
         HashSet<Point> slopes = new HashSet<Point>();
         
         for(int k = 0; k < n; k++){
            for(int j = k+1; j < n; j++){
               slopes.add(calcslope(points[k],points[j]));
            }
         }
         
         int maxpair = 0;
         for(Point slope : slopes){
            int paircount = 0;
            for(int k = 0; k < n; k++){
               for(int j = 0; j < n; j++){
                  if(k==j) continue;
                  if(slope.equals(calcslope(points[k],points[j]))){
                     paircount++;
                     break;
                  }
               }
            }
            maxpair = Math.max(maxpair,paircount);
         }
         
         int answer = Math.min(n,Math.max(4,maxpair+2));
         out.println("Case #" + q + ": " + answer);
            
      }
      
      
      
      
      out.close();
   }
   
   public static Point calcslope(Point p1, Point p2){
      int dx = p1.x-p2.x;
      int dy = p1.y-p2.y;
               
      if(dx < 0){
         dx *= -1;
         dy *= -1;
      } else if(dx == 0 && dy < 0){
         dy *= -1;
      }
               
      boolean yneg = dy < 0;
               
      int gcd = -1;
      if(yneg) gcd = gcd(dx,dy*-1);
      else gcd = gcd(dx,dy);
      
      return (new Point(dx/gcd,dy/gcd));
   }
   
   public static int gcd(int a, int b){
      if(a == b) 
         return a;
      if(a > b){
         if(b == 0) 
            return a;
         return gcd(a%b,b);
      } else {
         if(a == 0) 
            return b;
         return gcd(b%a,a);
      }
   }
   
   public static class Point{
      int x;
      int y;
      public Point(int a, int b){
         x = a;
         y = b;
      }
      
      @Override
      public boolean equals(Object o){
         Point p = (Point)o;
         return x == p.x && y == p.y;
      }
      @Override
      public int hashCode(){
         return toString().hashCode();
      }
      
      public String toString(){
         return "" + x + "?" + y;
      }
   }
      
}