import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Reading the matrix and calculating the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int[][] rowOccurrences = new int[n][n];
            int[][] columnOccurrences = new int[n][n];

            // Counting occurrences of each number in each row and column
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    rowOccurrences[i][matrix[i][j] - 1]++;
                    columnOccurrences[j][matrix[i][j] - 1]++;
                }
            }

            int rowRepeats = 0;
            int columnRepeats = 0;

            // Counting rows with duplicate entries
            for (int i = 0; i < n; i++) {
                boolean rowHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (rowOccurrences[i][j] != 1) {
                        rowHasDuplicate = true;
                        break;
                    }
                }
                if (rowHasDuplicate) {
                    rowRepeats++;
                }
            }

            // Counting columns with duplicate entries
            for (int i = 0; i < n; i++) {
                boolean columnHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (columnOccurrences[i][j] != 1) {
                        columnHasDuplicate = true;
                        break;
                    }
                }
                if (columnHasDuplicate) {
                    columnRepeats++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + columnRepeats);
        }

        sc.close();
    }
}