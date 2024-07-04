import java.io.*;
import java.util.*;

public class Solution
{
   public static void main(String[] args) throws IOException
   {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      for(int i = 1; i <= t; i++){
         int n = sc.nextInt();
         Interval[] seg = new Interval[n];
         point[] data = new point[2*n];
         for(int j = 0; j < n; j++){
            point a = new point(sc.nextInt(),  j);
            point b = new point(sc.nextInt(), j);
            data[2*j] = a;
            data[2*j+1] = b;
            seg[j] = new Interval(a, b);
         }  
         Arrays.sort(data);
         boolean[] ans = new boolean[n];
         boolean flag = false;
         ArrayList<Interval> active = new ArrayList<Interval>();
         for(int j = 0; j < 2*n; j++){
            point p = data[j];
            Interval in = seg[p.index];
            if(active.contains(in)){
               active.remove(in);
            }
            else{
               in.person = false;
               int count1 = 0;
               int count2 = 0;
               for(int k = 0; k < active.size(); k++){
                  Interval inter = active.get(k);
                  
                  if(p.compareTo(inter.end) < 0){
                     if(inter.person){
                        count2++;
                     }
                     else{
                        count1++;
                     }
                  }
               }
               if(count1>0 && count2 > 0){
                  flag = true;
               }
               else if(count1>0){
                  in.person = true;
               }
               active.add(in);
            }
         } 
         if(flag){
            System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
         }
         else{
            String s = "";
            for(int z = 0; z < seg.length; z++){
               if(seg[z].person){
                  s += "J";
               }
               else{
                  s+= "C";
               }
            }
            System.out.println("Case #" + i + ": " + s);
         } 
      }
   }
}
class Interval{
   point start, end;
   boolean person;
   public Interval(point a, point b){
      start = a;
      end = b;
   }
}
class point implements Comparable<point>{
   int start, index;
   public point(int a, int i){
      start = a;
      index = i;
   }
   public int compareTo(point b){
      return this.start - b.start;
   }
}