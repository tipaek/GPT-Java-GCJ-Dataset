import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int num_tests_T = sc.nextInt();
    for (int x_test = 1; x_test <= num_tests_T; x_test++) {
      int k_trace = 0;
      int r_bad_rows = 0;
      int c_bad_columns = 0;
      int N_size = sc.nextInt();
      ArrayList<Integer> outputs = calc_trace_and_latin(N_size, k_trace, r_bad_rows, c_bad_columns, sc);
      System.out.println("Case #" + x_test + ": " + outputs.get(0) + " " + outputs.get(1) + " " +
		outputs.get(2));
    }
	sc.close();
  }

  private static ArrayList<Integer> calc_trace_and_latin(int size, int trace,
		int num_bad_rows, int num_bad_cols, Scanner sc) {
	ArrayList<HashSet<Integer>> rows_data = new ArrayList<HashSet<Integer>>(size);
    ArrayList<HashSet<Integer>> cols_data = new ArrayList<HashSet<Integer>>(size);
    for (int i = 0; i < size; i++) {
      rows_data.add(i, new HashSet<Integer>());
      cols_data.add(i, new HashSet<Integer>());
    }
    HashSet<Integer> bad_rows = new HashSet<Integer>();
    HashSet<Integer> bad_cols = new HashSet<Integer>();
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        int cell_value = sc.nextInt();
        if (row == col) {
          trace += cell_value; // calc trace
        }
		HashSet<Integer> relevant_row = rows_data.get(row);
        if (!relevant_row.contains(cell_value)) {
          relevant_row.add(cell_value);
        } else if (!bad_rows.contains(row)) {
          bad_rows.add(row);
        }
		HashSet<Integer> relevant_col = cols_data.get(col);
        if (!relevant_col.contains(cell_value)) {
          relevant_col.add(cell_value);
        } else if (!bad_cols.contains(col)) {
          bad_cols.add(col);
        }
      }
    }
    num_bad_rows = bad_rows.size();
    num_bad_cols = bad_cols.size();
	ArrayList<Integer> outputs = new ArrayList<Integer>();
	outputs.add(trace);
	outputs.add(num_bad_rows);
	outputs.add(num_bad_cols);
	return outputs;
  }
}