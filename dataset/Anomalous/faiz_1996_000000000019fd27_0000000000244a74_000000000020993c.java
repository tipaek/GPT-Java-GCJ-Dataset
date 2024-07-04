import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        List<Matrix> matrices = new ArrayList<>(t);

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] arr = new int[n][n];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    arr[row][col] = scanner.nextInt();
                }
            }
            matrices.add(new Matrix(n, arr));
        }
        scanner.close();

        for (int i = 0; i < matrices.size(); i++) {
            Matrix matrix = matrices.get(i);
            System.out.println("Case #" + (i + 1) + ": " +
                    calculateTrace(matrix) + " " +
                    countRowDuplicates(matrix) + " " +
                    countColumnDuplicates(matrix));
        }
    }

    private static int calculateTrace(Matrix matrix) {
        int trace = 0;
        int[][] arr = matrix.getArr();
        for (int i = 0; i < matrix.getN(); i++) {
            trace += arr[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(Matrix matrix) {
        int duplicateRows = 0;
        int[][] arr = matrix.getArr();
        for (int[] row : arr) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                uniqueElements.add(element);
            }
            if (uniqueElements.size() != row.length) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countColumnDuplicates(Matrix matrix) {
        int duplicateColumns = 0;
        int[][] arr = matrix.getArr();
        int n = matrix.getN();
        for (int col = 0; col < n; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < n; row++) {
                uniqueElements.add(arr[row][col]);
            }
            if (uniqueElements.size() != n) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }

    static class Matrix {
        private final int n;
        private final int[][] arr;

        public Matrix(int n, int[][] arr) {
            this.n = n;
            this.arr = arr;
        }

        public int getN() {
            return n;
        }

        public int[][] getArr() {
            return arr;
        }
    }
}