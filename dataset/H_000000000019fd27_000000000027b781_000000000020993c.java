import java.io.*;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int T = Integer.parseInt(line);
        for (int t = 1; t <= T; t++) {
            line = reader.readLine();
            int n = Integer.parseInt(line);
            int[][] matrix = new int[n][n];
            for  (int i = 0; i < n; i++) {
                line = reader.readLine();
                parseRow(matrix, i, line);
            }

            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            HashSet<Integer> set = new HashSet<>();

            int badRows = 0;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    int val = matrix[r][c];
                    if (set.contains(val)) {
                        badRows++;
                        break;
                    }
                    set.add(val);
                }
                set.clear();
            }

            int badCols = 0;
            for (int c = 0; c < n; c++) {
                for (int r = 0; r < n; r++) {
                    int val = matrix[r][c];
                    if (set.contains(val)) {
                        badCols++;
                        break;
                    }
                    set.add(val);
                }
                set.clear();
            }

            System.out.println("Case #" + t + ": " + trace + " " + badRows + " " + badCols);
        }
    }

    private static void parseRow(int[][] matrix, int row, String line) {
        String[] values = line.split(" ");
        for (int i = 0; i < values.length; i++) {
            matrix[row][i] = Integer.parseInt(values[i]);
        }
    }
}
