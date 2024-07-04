import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();

        for (int k = 1; k <= testCases; k++) {
            int n = sc.nextInt();
            if (n < 2 || n > 100) continue;

            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = sc.nextInt();
                    if (value >= 1 && value <= n) {
                        matrix[i][j] = value;
                    } else {
                        matrix[i][j] = 0;
                    }
                }
            }

            printMatrix(matrix);
            checkLatinSquare(matrix, n, k);
        }

        sc.close();
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static void checkLatinSquare(int[][] matrix, int n, int caseNumber) {
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;

        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) rowDuplicates++;
                if (!colSet.add(matrix[j][i])) colDuplicates++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
    }
}