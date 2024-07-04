import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] results = new int[t][3];

        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculate diagonal sum
            results[k][0] = 0;
            for (int i = 0; i < n; i++) {
                results[k][0] += matrix[i][i];
            }

            // Calculate row repeats
            results[k][1] = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasRepeat = false;
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        hasRepeat = true;
                    }
                }
                if (hasRepeat) {
                    results[k][1]++;
                }
            }

            // Calculate column repeats
            results[k][2] = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasRepeat = false;
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        hasRepeat = true;
                    }
                }
                if (hasRepeat) {
                    results[k][2]++;
                }
            }

            // Print results for the current test case
            System.out.print("Case #" + (k + 1) + ": ");
            for (int q = 0; q < 3; q++) {
                System.out.print(results[k][q] + " ");
            }
            System.out.println();
        }
    }
}