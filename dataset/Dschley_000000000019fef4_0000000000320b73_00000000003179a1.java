
import java.util.*;
import java.io.*;
public class Solution {
 public static void main(String[] args) {
   Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
   int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
   for (int i = 1; i <= t; ++i) {
     int u = in.nextInt();
     List<Pair> q = new ArrayList<>();

     for(int x = 0; x < 10000; x++){
         int qi = in.nextInt();
         String ri = in.next();
         
         q.add(new Pair(qi,ri));
     }
     
     String D = getD(u, q);
     
     System.out.println("Case #" + i + ": " + D);
   }
 }
 
 private static String getD(int m, List<Pair> qs){
     qs.sort(new Comparator<Pair>(){
         @Override
         public int compare(Pair a, Pair b){
             return a.q - b.q;
         }
     });
     
     Set<Character> discovered = new HashSet<>();
     
     char[] d = new char[10];
     int di = 1;
     for(int i = 0; i < qs.size() && di <= d.length; i++){
         Pair q = qs.get(i);
         
         for(int c = 0; c < q.r.length(); c++){
        	 
             if(!discovered.contains(q.r.charAt(c))){
            	 if(di == d.length){
                     di = 0;
                 }
                 discovered.add(q.r.charAt(c));
                 d[di++] = q.r.charAt(c);
             }
         }
     }
     
     return new String(d);
 }
 
 static class Pair{
     int q;
     String r;
     public Pair(int q, String r){
         this.q=q;
         this.r=r;
     }
 }
} 