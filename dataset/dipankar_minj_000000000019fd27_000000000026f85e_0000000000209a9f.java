 import java.util.*;
 import java.io.*;
 class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          String input = in.next();
          String s ="";
          int curr = 0;
          int next = 0;
          int l = input.length();
          for(int j=0;j<l;j++){
            
            char c = input.charAt(j);
            next = c - '0';
            int diff = next - curr;
            if(diff>0){
                
                for(int k = 0;k<diff;k++){
                    s=s+'(';
                }
                s=s+c;
            }
            else if(diff == 0){
                s=s+c;
            }
            else{
                
                diff = Math.abs(diff);
                for(int k=0;k<diff;k++){
                    s=s+')';
                }
                s=s+c;
            }
            curr = next;
              
          }
          int last = Math.abs(curr);
          for(int h =0;h<last;h++)
          {
              s=s+')';
          }
          System.out.println("Case #" + i + ": " + s);
        }
      }
 }
    