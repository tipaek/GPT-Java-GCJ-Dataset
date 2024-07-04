import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[][] results = new int[testCases][3];

        for (int k = 0; k < testCases; k++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Input the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate diagonal sum
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }
            results[k][0] = diagonalSum;

            // Calculate row repeats
            int rowRepeats = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    }
                }
            }
            results[k][1] = rowRepeats;

            // Calculate column repeats
            int colRepeats = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        colRepeats++;
                        break;
                    }
                }
            }
            results[k][2] = colRepeats;

            // Print the result for this test case
            System.out.print("Case #" + (k + 1) + ": ");
            for (int q = 0; q < 3; q++) {
                System.out.print(results[k][q] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}