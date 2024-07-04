//package  com.jsomers;

// Google Code Jam 2019
// Split big int into 2 positive addends, neither can have the digit 4

import java.util.*;
import java.io.*;
// import java.math.BigInteger;

public class Solution {

    void findSolution(final int size) {

    }


    void run() {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
            for (int i = 1; i <= t; ++i) {
                int trace = 0;
                int num_repeat_row = 0;
                int num_repeat_col = 0;
                int size = in.nextInt();
                boolean [][] col = new boolean[size+1][size+1];
                for (int r = 1; r <= size; ++r) {
                  boolean [] row = new boolean[size+1];
                  boolean row_repeat = false;
                  for (int c = 1; c <= size; ++c) {
                      int val = in.nextInt();
                      //System.out.println("Case #" + i + ": " + trace + " " + row + " " + c;
                      col[c][val] = true;
                      if (r == c) {
                          trace += val;
                      }
                      if (row[val]) {
                          row_repeat = true;
                      } else {
                          row[val] = true;
                      }
                  }
                  if (row_repeat) {
                      num_repeat_row++;
                  }

              }
              //findSolution(size);
                for (int c = 1; c <= size; ++c) {
                    for (int r = 1; r <= size; ++r) {
                        if (col[c][r] == false) {
                            num_repeat_col++;
                            break;
                        }
                    }
                }
                    System.out.println("Case #" + i + ": " + trace + " " + num_repeat_row + " " + num_repeat_col);
            }

    }

    public static void main(String[] args)  {

        Solution foregone = new Solution();
        foregone.run();

    }
}
