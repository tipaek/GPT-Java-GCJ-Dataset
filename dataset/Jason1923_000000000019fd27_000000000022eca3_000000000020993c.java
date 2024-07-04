import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt(); // # of test cases
        for (int t = 1; t <= tests; t++) {
            // Construct array
            int n = in.nextInt();
            int[][] arr = new int[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    int curr = in.nextInt();
                    arr[r][c] = curr;
                }
            }

            // Trace
            int trace = 0;
            for (int i = 0; i < n; i++)
                trace += arr[i][i];

            // Rows
            int row = 0;
            for (int r = 0; r < n; r++) {
                Set<Integer> seen = new HashSet<>();
                for (int c = 0; c < n; c++) {
                    if (!seen.add(arr[r][c])) {
                        row++;
                        break;
                    }
                }
            }

            // Columns
            int col = 0;
            for (int c = 0; c < n; c++) {
                Set<Integer> seen = new HashSet<>();
                for (int r = 0; r < n; r++) {
                    if (!seen.add(arr[r][c])) {
                        col++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + row + " " + col);
        }
    }
}