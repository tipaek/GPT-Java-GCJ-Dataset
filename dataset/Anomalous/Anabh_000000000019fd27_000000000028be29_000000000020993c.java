import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Read matrix and calculate trace and row duplicates
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;

                    // Calculate trace
                    if (i == j) {
                        trace += value;
                    }

                    // Check for row duplicates
                    if (!rowSet.add(value) && !rowHasDuplicate) {
                        rowDuplicates++;
                        rowHasDuplicate = true;
                    }
                }
            }

            // Check for column duplicates
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;
                for (int i = 0; i < n; i++) {
                    int value = matrix[i][j];
                    if (!colSet.add(value) && !colHasDuplicate) {
                        colDuplicates++;
                        colHasDuplicate = true;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}