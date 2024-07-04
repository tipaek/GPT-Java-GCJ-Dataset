import java.util.*;
import java.io.*;

public class Solution {

    public static void vestigium() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt(); // Number of test cases

        List<String> results = new ArrayList<>();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = scanner.nextInt(); // Size of the matrix
            int[][] matrix = new int[N][N];
            int diagonalSum = 0;
            int rowDuplicates = 0;
            int columnDuplicates = 0;

            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() < N) {
                    rowDuplicates++;
                }
            }

            for (int j = 0; j < N; j++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    columnSet.add(matrix[i][j]);
                }
                if (columnSet.size() < N) {
                    columnDuplicates++;
                }
            }

            results.add("Case #" + testCase + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
        }

        results.forEach(System.out::println);
        scanner.close();
    }

    public static void main(String[] args) {
        vestigium();
    }
}