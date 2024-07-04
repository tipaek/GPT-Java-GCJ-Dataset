import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];

            int trace = 0;
            int row = 0;
            int col = 0;

            // Calculate trace and rows with duplicate elements
            for (int i = 0; i < N; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowDuplicate = false;
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowSet.add(matrix[i][j]) && !rowDuplicate) {
                        row++;
                        rowDuplicate = true;
                    }
                }
            }

            // Calculate columns with duplicate elements
            for (int j = 0; j < N; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean colDuplicate = false;
                for (int i = 0; i < N; i++) {
                    if (!colSet.add(matrix[i][j]) && !colDuplicate) {
                        col++;
                        colDuplicate = true;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + row + " " + col);
        }

        sc.close();
    }
}