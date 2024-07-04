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
          for(int j = 0; j < digits.size() - 1; j++) {
              int digit = digits.get(j);
              str.append(digit);
              if(digit > digits.get(j + 1)) {
                  for(int h = 0; h < (digit - digits.get(j+1));
                  h++){
                      str.append(")");
                  }
              }
              if(digit < digits.get(j + 1)) {
                  for(int g = 0; g < (digits.get(j+1) - 
                  digit); g++){
                      str.append("(");
                  }
              }
              if(digit == digits.get(j + 1)){
                  continue;
              }
              if(j+2 > digits.size() - 1){
                  str.append(digits.get(j+1));
              }
          }
          
          if(digits.size() == 1){
              str.append(digits.get(0));
          }
          
          if(digits.get(digits.size() - 1) == 0){
              str.append(digits.get(digits.size() - 1));
          }
          
          for(int s = 0; s < digits.get(digits.size() - 1); s++)
          {
              str.append(")");
          }
          
          System.out.println("Case #" + i + ": " + str.toString());
          
        }
      }
    }