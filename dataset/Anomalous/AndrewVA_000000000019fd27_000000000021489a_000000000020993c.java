import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int row = 0; row < n; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                    if (rowSet.contains(matrix[row][col])) {
                        rowDuplicates++;
                    } else {
                        rowSet.add(matrix[row][col]);
                    }
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            for (int col = 0; col < n; col++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (colSet.contains(matrix[row][col])) {
                        colDuplicates++;
                    } else {
                        colSet.add(matrix[row][col]);
                    }
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}