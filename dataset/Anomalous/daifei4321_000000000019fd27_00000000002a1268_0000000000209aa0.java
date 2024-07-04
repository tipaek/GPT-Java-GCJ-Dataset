import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] rows = generateRows(n);
            int[] validRows = findValidRows(rows, k - n);

            if (validRows != null) {
                System.out.println("CASE #" + (t + 1) + ": POSSIBLE");
                for (int y = 0; y < n; y++) {
                    int[] row = rows[validRows[y]];
                    for (int x = 0; x < n; x++) {
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

    private static int[][] generateRows(int n) {
        List<int[]> rows = new ArrayList<>(factorial(n));
        fillRows(n, rows, new int[n], new boolean[n], 0);
        return rows.toArray(new int[0][]);
    }

    private static void fillRows(int n, List<int[]> rows, int[] rowBuffer, boolean[] used, int col) {
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                rowBuffer[col] = i;
                if (col + 1 < n) {
                    used[i] = true;
                    fillRows(n, rows, rowBuffer, used, col + 1);
                    used[i] = false;
                } else {
                    rows.add(Arrays.copyOf(rowBuffer, n));
                }
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

    private static int[] findValidRows(int[][] rows, int k) {
        int n = rows[0].length;
        return searchValidRows(rows, k, 0, new int[n], new boolean[rows.length]);
    }

    private static int[] searchValidRows(int[][] rows, int k, int index, int[] buffer, boolean[] used) {
        int n = rows[0].length;

        for (int i = 0; i < rows.length; i++) {
            if (!used[i]) {
                buffer[index] = i;
                if (index == n - 1) {
                    if (isValid(buffer, rows, k)) {
                        return buffer;
                    }
                } else {
                    used[i] = true;
                    int[] result = searchValidRows(rows, k, index + 1, buffer, used);
                    if (result != null) {
                        return result;
                    }
                    used[i] = false;
                }
            }
        }
        return null;
    }

    private static boolean isValid(int[] rowIndexes, int[][] rowData, int k) {
        int n = rowIndexes.length;
        int traceSum = 0;

        for (int i = 0; i < n; i++) {
            traceSum += rowData[rowIndexes[i]][i];
        }

        if (traceSum != k) {
            return false;
        }

        boolean[] seen = new boolean[n];
        for (int col = 0; col < n; col++) {
            Arrays.fill(seen, false);
            for (int row = 0; row < n; row++) {
                int value = rowData[rowIndexes[row]][col];
                if (seen[value]) {
                    return false;
                }
                seen[value] = true;
            }
        }

        return true;
    }
}