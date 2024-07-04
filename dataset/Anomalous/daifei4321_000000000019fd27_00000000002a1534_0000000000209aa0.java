import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[][] rows = generateRows(N);
            int[] validConfiguration = findValidConfiguration(rows, K - N);

            if (validConfiguration != null) {
                System.out.println("CASE #" + (t + 1) + ": POSSIBLE");
                for (int y = 0; y < N; y++) {
                    int[] row = rows[validConfiguration[y]];
                    for (int x = 0; x < N; x++) {
                        if (x > 0) {
                            System.out.print(' ');
                        }
                        System.out.print(row[x] + 1);
                    }
                    System.out.println();
                }
            } else {
                System.out.println("CASE #" + (t + 1) + ": IMPOSSIBLE");
            }
        }
        scanner.close();
    }

    private static int[] findValidConfiguration(int[][] rows, int k) {
        int n = rows[0].length;
        int rowTypeCount = rows.length;
        return findConfiguration(rows, k, 0, new int[n], new boolean[rowTypeCount]);
    }

    private static int[] findConfiguration(int[][] rows, int k, int index, int[] buffer, boolean[] used) {
        int n = rows[0].length;
        int rowTypeCount = rows.length;

        for (int v = 0; v < rowTypeCount; v++) {
            if (used[v]) continue;

            buffer[index] = v;
            if (index == n - 1) {
                if (isValidConfiguration(buffer, rows, k)) {
                    return buffer;
                }
                continue;
            }

            used[v] = true;
            if (findConfiguration(rows, k, index + 1, buffer, used) != null) {
                return buffer;
            }
            used[v] = false;
        }
        return null;
    }

    private static boolean isValidConfiguration(int[] rowIndexes, int[][] rowData, int k) {
        int n = rowIndexes.length;
        int traceSum = 0;

        for (int i = 0; i < n; i++) {
            traceSum += rowData[rowIndexes[i]][i];
        }
        if (traceSum != k) return false;

        boolean[] buffer = new boolean[n];
        for (int c = 0; c < n; c++) {
            Arrays.fill(buffer, false);
            for (int r = 0; r < n; r++) {
                int value = rowData[rowIndexes[r]][c];
                if (buffer[value]) return false;
                buffer[value] = true;
            }
        }
        return true;
    }

    private static int[][] generateRows(int n) {
        List<int[]> rows = new ArrayList<>(factorial(n));
        populateRows(n, rows, new int[n], new boolean[n], 0);

        int[][] resultArray = new int[rows.size()][];
        for (int i = 0; i < rows.size(); i++) {
            resultArray[i] = rows.get(i);
        }
        return resultArray;
    }

    private static void populateRows(int n, List<int[]> rows, int[] buffer, boolean[] used, int col) {
        int nextCol = col + 1;
        for (int i = 0; i < n; i++) {
            if (used[i]) continue;

            buffer[col] = i;
            if (nextCol < n) {
                used[i] = true;
                populateRows(n, rows, buffer, used, nextCol);
                used[i] = false;
            } else {
                rows.add(Arrays.copyOf(buffer, n));
            }
        }
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}