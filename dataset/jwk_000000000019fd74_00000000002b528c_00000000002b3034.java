import java.util.*;
import java.io.*;
public class Solution {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      int n;
      for(int i = 1; i <= t; i++) {
         n = sc.nextInt();
         sc.nextLine();
         
         String[] patterns = new String[n];
         for(int j = 0; j < n; j++) {
            patterns[j] = sc.nextLine();
         }
         
         String[] front = new String[n];
         String[] end = new String[n];
         String[] middle = new String[n];
         String frontlongest = "";
         String endlongest = "";
         for(int j = 0; j < n; j++) {
            String s = patterns[j];
            int ind = 0;
            for(; ind < s.length(); ind++) {
               if(s.charAt(ind) == '*') {
                  break;
               }
            }
            front[j] = s.substring(0, ind);
            if(front[j].length() > frontlongest.length()) {
               frontlongest = front[j];
            }
            
            int k = s.length();
            for(; k > ind; k--) {
               if(s.charAt(k - 1) == '*') {
                  break;
               }
            }
            end[j] = s.substring(k, s.length());
            if(end[j].length() > endlongest.length()) {
               endlongest = end[j];
            }
            
            middle[j] = (ind + 1 > k - 1 ? "" : s.substring(ind + 1, k - 1));
         }
         
         boolean answer = true;
         for(String s : front) {
            if(frontlongest.indexOf(s) < 0) {
               answer = false;
            }
         }
         for(String s : end) {
            if(endlongest.indexOf(s) < 0) {
               answer = false;
            }
         }
         
         if(!answer) {
            System.out.println("Case #" + i + ": *");
         }
         else {
            StringBuilder sol = new StringBuilder();
            sol.append(frontlongest);
            for(String s : middle) {
               s = s.replace("*", "");
               sol.append(s);
            }
            sol.append(endlongest);
            System.out.println("Case #" + i + ": " + sol.toString());
         }
      }
   }
}