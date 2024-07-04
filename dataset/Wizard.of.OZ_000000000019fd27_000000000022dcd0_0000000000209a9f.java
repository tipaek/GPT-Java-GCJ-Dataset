import java.util.*;
import java.io.*;
    public class P2  {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          String n = in.next();
          
          int open = 0;
          int close = 0;
          int curr = 0;
          int prev = 0;
          StringBuilder n2 = new StringBuilder(); 
          for (int j = 0; j < n.length(); j++) {
            prev = curr;
            curr = Character.getNumericValue(n.charAt(j));

            if (curr < prev) {
              // downward
              // close the diff
              for (int k = 0; k < (prev - curr); k++) {
                n2.append(')');
                open--;
              }
            } else {
              for (int k = 0; k < (curr - prev); k++) {
                n2.append('(');
                open++; 
              }
            }
            n2.append(curr);
          }

          for (int k = 0; k < open; k++) {
            n2.append(')');
          }

          System.out.println("Case #" + i + ": " + n2);
        }
      }
    }