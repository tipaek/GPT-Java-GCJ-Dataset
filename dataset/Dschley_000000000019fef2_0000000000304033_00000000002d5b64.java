import java.util.*;
import java.io.*;
public class Solution {
 public static void main(String[] args) {
   Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
   int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
   for (int i = 1; i <= t; ++i) {
     int n = in.nextInt();
     int m = in.nextInt();
     
     List<Pair> shuffles = getShuffles(n, m);
     System.out.println("Case #" + i + ": " + shuffles.size());
     for(Pair p : shuffles){
         System.out.println(p.a + " " + p.b);
     }
   }
 }
 
 private static List<Pair> getShuffles(int r, int s){
     List<Pair> shuffles = new ArrayList<>();
     
     if(s == 1){
    	 return shuffles;
     }
     
     int x = 0;
     for(int b = r * s - r - 1; x / (s - 1) < r - 1; b--){
         int a = r - (x++ / (s - 1));
         
         shuffles.add(new Pair(a, b));
     }
     
     return shuffles;
 }
 
 static class Pair{
     int a;
     int b;
     
     public Pair(int a, int b){
         this.a = a;
         this.b = b;
     }
 }
} 