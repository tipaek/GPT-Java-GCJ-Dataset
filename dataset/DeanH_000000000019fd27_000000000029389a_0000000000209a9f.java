import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
       Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          List<Integer> digits = new ArrayList<Integer>();
          String n = in.next();
          StringBuilder str = new StringBuilder();
          for(String s: n.split("")){
              int digit = Integer.parseInt(s);
              digits.add(digit);
          }
          for(int s = 0; s < digits.get(0); s++){
              str.append("(");
              
          }
          for(int d = 0; d < digits.size() - 1; d++){
              str.append(digits.get(d));
              if(digits.get(d) > digits.get(d + 1)) {
                 for(int f = 0; f < (digits.get(d) - digits.get(d + 1)); f++) {
                     str.append(")");
                 } 
              }
              if(digits.get(d) < digits.get(d + 1)) {
                 for(int g = 0; g < (digits.get(d + 1) - 
                 digits.get(d)); g++){
                     str.append("(");
                 } 
              }
              if(digits.get(d) == digits.get(d + 1)){
                  continue;
              }
          }
          str.append(digits.get(digits.size() - 1));
          for(int f = 0; f < digits.get(digits.size() - 1); 
          f++){
              str.append(")");
          }
          
          System.out.println("Case #" + i + ": " + str.toString());
          
        }
      }
    }