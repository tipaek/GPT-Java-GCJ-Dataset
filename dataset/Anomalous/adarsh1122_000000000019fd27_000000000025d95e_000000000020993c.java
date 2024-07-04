import java.util.Scanner;

public class Bomber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] results = new int[t][3];

        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Diagonal Sum
            results[k][0] = 0;
            for (int i = 0; i < n; i++) {
                results[k][0] += matrix[i][i];
            }

            // Row Repeats Calculation
            results[k][1] = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> seen = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!seen.add(matrix[i][j])) {
                        hasDuplicate = true;
                    }
                }
                if (hasDuplicate) {
                    results[k][1]++;
                }
            }

            // Column Repeats Calculation
            results[k][2] = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> seen = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!seen.add(matrix[j][i])) {
                        hasDuplicate = true;
                    }
                }
                if (hasDuplicate) {
                    results[k][2]++;
                }
            }

            // Output the result for the current test case
            System.out.print("Case #" + (k + 1) + ": ");
            for (int q = 0; q < 3; q++) {
                System.out.print(results[k][q] + " ");
            }
            System.out.println();
        }
    }
}