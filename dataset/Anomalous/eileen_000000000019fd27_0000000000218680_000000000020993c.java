import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];

            // Read the matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int rowDuplicates = 0;
            int columnDuplicates = 0;

            // Check for duplicate elements in each row
            for (int i = 0; i < N; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    if (rowSet.contains(matrix[i][j])) {
                        rowDuplicates++;
                        break;
                    } else {
                        rowSet.add(matrix[i][j]);
                    }
                }
            }

            // Check for duplicate elements in each column
            for (int j = 0; j < N; j++) {
                HashSet<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    if (columnSet.contains(matrix[i][j])) {
                        columnDuplicates++;
                        break;
                    } else {
                        columnSet.add(matrix[i][j]);
                    }
                }
            }

            System.out.println(rowDuplicates + " " + columnDuplicates);
        }

        scanner.close();
    }
}