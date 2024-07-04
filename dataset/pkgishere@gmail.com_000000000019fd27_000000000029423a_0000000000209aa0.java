
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static void createMatrix(int n, int k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    static boolean flag;
    static int[][] array;
    static HashMap<Integer, HashSet> columnE;

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test_cases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= test_cases; ++i) {
            int n = in.nextInt();
            array = new int[n][n];
            int k = in.nextInt();
            flag = false;
            if (k < n || k > n * n) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                columnE = new HashMap<>();
                createMatrix(n, k, 0, 0, new HashSet<>());
                if (flag) {
                    System.out.println("Case #" + i + ": POSSIBLE");
                    printMatrix();
                } else {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                }
            }
        }
    }

    static void createMatrix(int length, int trace, int row, int column, Set<Integer> rowE) {
        if (trace < 0) {
            return;
        }
        if (row == length) {
            validateMatrix(trace);
            return;
        }
        if (column == length) {
            createMatrix(length, trace, row + 1, 0, new HashSet<>());
        }
        for (int i = 1; i <= length; i++) {
            if (rowE.contains(i)) {
                continue;
            }
            HashSet<Integer> columnSet;
            columnSet = columnE.getOrDefault(column, new HashSet<>());
            if (columnSet.contains(i)) {
                continue;
            }
            array[row][column] = i;
            rowE.add(i);
            columnSet.add(i);
            columnE.put(column, columnSet);
            if (row == column) {
                trace -= i;
            }
            createMatrix(length, trace, row, column + 1, rowE);
            if (flag) {
                break;
            }
            rowE.remove(i);
            columnSet.remove(i);
            columnE.put(column, columnSet);
            if (row == column) {
                trace += i;
            }
        }
    }

    private static void validateMatrix(int trace) {
        if (trace == 0) {
            flag = true;
        }
    }

    static void printMatrix() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
