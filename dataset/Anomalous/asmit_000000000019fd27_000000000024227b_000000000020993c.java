import java.io.*;
import java.util.*;

class Vestigium {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int T = Math.abs(sc.nextInt());
        int[] results = new int[3 * T];

        for (int h = 0; h < T; h++) {
            int size = Math.abs(sc.nextInt());
            int[][] arr = new int[size][size];

            // Reading the matrix
            for (int v = 0; v < size; v++) {
                int row = Math.abs(sc.nextInt());
                for (int y = size - 1; y >= 0; y--) {
                    arr[v][y] = row % 10;
                    row = row / 10;
                }
            }

            // Calculating the trace
            int trace = 0;
            for (int d = 0; d < size; d++) {
                trace += arr[d][d];
            }
            results[h * 3] = trace;

            // Counting duplicate rows
            int duplicateRows = 0;
            for (int j = 0; j < size; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int l = 0; l < size; l++) {
                    rowSet.add(arr[j][l]);
                }
                if (rowSet.size() != size) {
                    duplicateRows++;
                }
            }
            results[h * 3 + 1] = duplicateRows;

            // Counting duplicate columns
            int duplicateColumns = 0;
            for (int s = 0; s < size; s++) {
                Set<Integer> colSet = new HashSet<>();
                for (int l = 0; l < size; l++) {
                    colSet.add(arr[l][s]);
                }
                if (colSet.size() != size) {
                    duplicateColumns++;
                }
            }
            results[h * 3 + 2] = duplicateColumns;
        }

        // Printing the results
        for (int a = 0; a < T; a++) {
            System.out.println("Case #" + (a + 1) + ": " + results[a * 3] + " " + results[a * 3 + 1] + " " + results[a * 3 + 2]);
        }
    }
}