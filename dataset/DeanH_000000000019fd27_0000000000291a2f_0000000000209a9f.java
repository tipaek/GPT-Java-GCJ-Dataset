import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
       Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          String n = in.next();
          int s = n.length();
          int brac = 0;
          StringBuilder str = new StringBuilder();
          for(int j = 0; j < s; j++){
              int val = s.charAt(j) - 48;
              if(val == brac) {
                  str.append(s.charAt(j));
              }
              else if(val > brac) {
                  int diff = val - brac;
                  for(int h = 0; h < diff; h++) {
                      str.append("(");
                  }
                  str.append(s.charAt(j));
                  brac = brac + diff;
              }
              else {
                  int diff2 = brac - val;
                  for(int g = 0; g < diff; g++) {
                      str.append(")");
                  }
                  brac = brac - diff;
                  str.append(s.charAt(j));
              }
          }
          
          if(brac > 0){
              for(int b = 0; b < brac; b++){
                  str.append(")");
              }
          }
         
          System.out.println("Case #" + i + ": " + str.toString());
          
        }
      }
    }