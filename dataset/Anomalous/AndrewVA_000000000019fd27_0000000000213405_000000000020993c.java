import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(sc.nextLine());
            int[][] matrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            for (int row = 0; row < n; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                    if (!rowSet.add(matrix[row][col])) {
                        rowDuplicates++;
                    }
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            for (int col = 0; col < n; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        colDuplicates++;
                    }
                }
            }
            sc.nextLine(); // Consume the leftover newline

            System.out.println("Case #" + i + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}