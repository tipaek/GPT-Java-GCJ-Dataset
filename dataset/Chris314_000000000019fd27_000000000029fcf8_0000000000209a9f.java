 import java.util.*;
    import java.io.*;
public class Solution{
     public static void main(String []args){
               Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          String s = in.next();
          int curr = 0;
          String ans = "";
          for (int j = 0; j < s.length(); j++) {
              int num = s.charAt(j) - '0';
              int offset = num-curr; // need this many leftbrackets if positive, right if negative
                  for (int k = 0; k < offset; k++) {
                      ans += "(";
                  }
                  for (int k = 0; k > offset; k--) {
                      ans += ")";
                  }
                  ans += num;
                  curr = num;
              
          }
          for (int k = 0; k < curr; k++) {
                      ans += ")";
                  }
          System.out.println("Case #" + i + ": " + ans);
 
     }
     }
}