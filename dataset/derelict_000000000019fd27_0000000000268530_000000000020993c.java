import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            in.nextLine();
            int trace = 0;
            int repeat_rows = 0;
            int repeat_cols = 0;
            Hashtable<String, Boolean> row_dict = new Hashtable<String,Boolean>(n);
            Hashtable<String, Boolean> col_dict = new Hashtable<String,Boolean>(n);
            for (int j = 0; j < n; j++) {
                String row = in.nextLine();
                String[] arr_row = row.split(" ");
                trace += Integer.parseInt(arr_row[j]);
                Boolean repeat_found = false;

                for (int k = 0; k < n; k++) {
                    // System.out.println("hello - - - -" +  arr_row[k]);
                    // System.out.println("contains " + (j+arr_row[k]) + " " + row_dict.containsKey(j+arr_row[k]));
                    if (!repeat_found && row_dict.containsKey(j+arr_row[k])) {
                        repeat_found = true;
                        repeat_rows = repeat_rows+1;
                        
                    }
                    else {
                        row_dict.put(j + ""+arr_row[k],true);
                    }

                    if (col_dict.containsKey(k+arr_row[k]) && !col_dict.containsKey(k+"found")) {
                        col_dict.put(k+"found", true);
                        repeat_cols = repeat_cols+1;
                        
                    }
                    else {
                        col_dict.put(k + "" +arr_row[k],true);
                    }

                    
                }
          }
          System.out.println("Case #" + i + ": " + (trace) + " " + (repeat_rows) + " " + (repeat_cols));
        }
      }
}