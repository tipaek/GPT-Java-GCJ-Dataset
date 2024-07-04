import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        String[] ans = new String[t];
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            in.nextLine();
            int trace = 0;
            int repeat_rows = 0;
            int repeat_cols = 0;
            
            
            String[][] matrix = new String[n][n];
            for (int j = 0; j < n; j++) {
                matrix[j] = in.nextLine().split(" ");
                trace += Integer.parseInt(matrix[j][j]);

            }
            for (int j = 0; j < n; j++) {
                Hashtable<String, Boolean> row_dict = new Hashtable<String,Boolean>(n);
                for (int k = 0; k < n; k++) {
                    
                    if (row_dict.containsKey(matrix[j][k])) {
                        repeat_rows = repeat_rows+1;
                        break;
                    }
                    else {
                        row_dict.put(matrix[j][k],true);
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                Hashtable<String, Boolean> col_dict = new Hashtable<String,Boolean>(n);
                for (int k = 0; k < n; k++) {
                    if (col_dict.containsKey(matrix[k][j])) {
                        repeat_cols = repeat_cols+1;
                        break;
                    }
                    else {
                        col_dict.put(matrix[k][j],true);
                    }
                }

            
        }
          ans[i-1] = ("Case #" + i + ": " + (trace) + " " + (repeat_rows) + " " + (repeat_cols));
          
        }
        for (int j = 0; j < t; j++) {
            System.out.println(ans[j]);
    }

      }
}