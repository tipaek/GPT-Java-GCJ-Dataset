import java.util.*;
import java.io.*;
public class Solution {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      int n;
      for(int i = 1; i <= t; i++) {
         n = sc.nextInt();
         TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
         for(int j = 0; j < n; j++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            
            map.put(s, e);
         }
         
         StringBuilder ans = new StringBuilder();
         int endc = 0;
         int endj = 0;
         boolean okay = true;
         
         for(int start : map.keySet()) {
            if(start >= endc) {
               endc = map.get(start);
               ans.append("C");
            } else if(start >= endj) { 
               endj = map.get(start);
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