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
         }
         
         Arrays.sort(times);
         
         StringBuilder ans = new StringBuilder();
         int endc = 0;
         int endj = 0;
         boolean okay = true;
         
         for(Pair p : times) {
            int start = p.s;
            int end = p.e;
            if(start >= endc) {
               endc = p.e;
               ans.append("C");
            } else if(start >= endj) { 
               endj = p.e;
               ans.append("J");
            } else {
               okay = false;
               break;
            }
         }
         
         if(okay) {
            System.out.println("Case #" + i + ": " + ans.toString());
         } else {
            System.out.println("Case #" + i + ": IMPOSSIBLE");
         }
      }
   }
}

class Pair implements Comparable<Pair> {
   public int s;
   public int e;
   
   public int compareTo(Pair other) {
      if(s < other.s) return -1;
      if(s > other.s) return 1;
      if(e < other.e) return -1;
      return 1;
   }
}