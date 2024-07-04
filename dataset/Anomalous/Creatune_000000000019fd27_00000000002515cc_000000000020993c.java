import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        int T = sc.nextInt();
        int x = 0;

        while (x < T) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculate trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Check for duplicate elements in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Check for duplicate elements in columns
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            x++;
            System.out.println("case #" + x + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}