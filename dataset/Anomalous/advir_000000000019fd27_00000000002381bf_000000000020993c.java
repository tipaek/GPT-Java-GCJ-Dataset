import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int tItr = 0; tItr < t; tItr++) {
            int m = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            int[][] matrix = new int[m][m];
            int trace = 0;
            int rowCount = 0;
            int colCount = 0;

            for (int i = 0; i < m; i++) {
                String[] rowItems = scanner.nextLine().split(" ");
                for (int j = 0; j < m; j++) {
                    int value = Integer.parseInt(rowItems[j]);
                    matrix[i][j] = value;
                }
            }

            // Calculate the trace
            for (int i = 0; i < m; i++) {
                trace += matrix[i][i];
            }

            // Check for duplicate values in rows
            for (int i = 0; i < m; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < m; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowCount++;
                        break;
                    }
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < m; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < m; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colCount++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (tItr + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }
        scanner.close();
    }
}