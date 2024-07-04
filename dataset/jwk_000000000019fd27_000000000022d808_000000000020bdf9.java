import java.util.*;
import java.io.*;
public class Solution {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      int n;
      for(int i = 1; i <= t; i++) {
         n = sc.nextInt();
         Pair[] times = new Pair[n];
         for(int j = 0; j < n; j++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            
            times[j] = new Pair();
            times[j].s = s;
            times[j].e = e;
            times[j].c = ' ';
            times[j].order = j;
         }
         
         Arrays.sort(times, 
            new Comparator<Pair>() {
               public int compare(Pair one, Pair other) {
                  if(one.s < other.s) 
                     return -1;
                  if(one.s > other.s) 
                     return 1;
                  if(one.e < other.e) 
                     return -1;
                  return 1;
               }
            });
         
         int endc = 0;
         int endj = 0;
         boolean okay = true;
         
         //BRUH THEY HAVE TO BE IN INPUT ORDER NOOOOOO
         for(Pair p : times) {
            int start = p.s;
            int end = p.e;
            if(start >= endc) {
               endc = p.e;
               p.c = 'C';
            } else if(start >= endj) { 
               endj = p.e;
               p.c = 'J';
            } else {
               okay = false;
               break;
            }
         }
         
         if(okay) {
            Arrays.sort(times, 
               new Comparator<Pair>() {
                  public int compare(Pair one, Pair other) {
                     if(one.order < other.order) 
                        return -1;
                     return 1;
                  }
               });
            StringBuilder ans = new StringBuilder();
            for(int j = 0; j < n; j++) {
               ans.append(times[j].c);
            }
            System.out.println("Case #" + i + ": " + ans.toString());
         } else {
            System.out.println("Case #" + i + ": IMPOSSIBLE");
         }
      }
   }
}

class Pair {
   public int s;
   public int e;
   public char c;
   public int order;
   
   public String toString() {
      return s + " " + e + " " + c + " " + order;
   }
}