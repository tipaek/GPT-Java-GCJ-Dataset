

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        System.out.println("Test cases :");

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
//            System.out.println("Matrix size :");
            int matrix_size = in.nextInt();

            int trace = 0;
            int row_repeats = 0;
            int col_repeats = 0;

            HashSet[] col_vals = new HashSet[matrix_size];

            boolean[] found_repeat_col = new boolean[matrix_size];

            Arrays.fill(found_repeat_col, false);

            for (int row = 0; row < matrix_size; row++) {
                HashSet row_vals = new HashSet();
                boolean found_repeat_row = false;
                for (int col = 0; col < matrix_size; col++) {

                    if(row == 0){
                        col_vals[col] = new HashSet();
                    }

//                    System.out.println("Value row "+ row + " coloumn " + col);
                    int val = in.nextInt();

                    if (!found_repeat_row && row_vals.contains(val)) {
                        row_repeats++;
                        found_repeat_row = true;
                    }

                    if (!found_repeat_col[col] && col_vals[col].contains(val)) {
                        col_repeats++;

//                        System.out.println(col);
//                        System.out.println(row);
//                        System.out.println(val);
                        found_repeat_col[col] = true;
                    }

                    if (row == col) {
                        trace += val;
                    }

                    row_vals.add(val);
                    col_vals[col].add(val);
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + row_repeats + " " + col_repeats);

           
        }
    }
}
