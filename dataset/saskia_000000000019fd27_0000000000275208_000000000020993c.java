import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        if (testCases == 0)
            return;
        for (int i = 0; i < testCases; i++) {
            int rowRepeat = 0;
            int colRepeat = 0;
            int diaSum = 0;
            try {
                int n_current = in.nextInt();
                if (n_current == 0)
                    System.out.println("Case #" + i + ": 0 0 0");
                else {
                    HashMap<Integer, HashMap<Integer, Integer>> column_map = new HashMap<>();
                    // read whole square
                    for (int j = 0; j < n_current; j++) {
                        HashMap<Integer, Integer> curr_row = new HashMap<>();
                        // read whole row
                        for(int h = 0; h < n_current; h++) {
                            HashMap<Integer, Integer> curr_col;
                            if (h==0) {
                                curr_col = new HashMap<>();
                            } else {
                                curr_col = column_map.get(h);
                            }

                            int firstNo = in.nextInt();
                            if (h == j)
                                diaSum += firstNo;
                            curr_row.put(firstNo, h);
                            curr_col.put(firstNo, h);
                        }

                        if (curr_row.size() < n_current) {
                            rowRepeat++;
                        }

                    }

                    for (int j = 0; j < n_current; j++) {
                        HashMap<Integer, Integer> curr_col = column_map.get(j);
                        if (curr_col.size() < n_current)
                            colRepeat++;
                    }
                }

                System.out.println("Case #" + i + ": " + diaSum + " " + rowRepeat + " " + colRepeat);
            } catch (Exception e) {
                break;
            }
        }

    }
}