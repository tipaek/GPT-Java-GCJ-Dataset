import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    static Scanner sc;

    public static void main(String[] args) throws Exception {
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = sc.nextInt();

        for (int test = 1; test <= t; test++) {
            int N = sc.nextInt();
            sc.nextLine();

            int[][] matrix = readMatrix(N, N);
            int trace = calculateTrace(matrix, N);
            int rowDuplicates = countRowDuplicates(matrix, N);
            int colDuplicates = countColDuplicates(matrix, N);

            System.out.println("Case #" + test + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static int[][] readMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix, int size) {
        int rowDuplicates = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                rowSet.add(matrix[i][j]);
            }
            if (rowSet.size() != size) {
                rowDuplicates++;
            }
        }
        return rowDuplicates;
    }

    private static int countColDuplicates(int[][] matrix, int size) {
        int colDuplicates = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                colSet.add(matrix[j][i]);
            }
            if (colSet.size() != size) {
                colDuplicates++;
            }
        }
        return colDuplicates;
    }
}