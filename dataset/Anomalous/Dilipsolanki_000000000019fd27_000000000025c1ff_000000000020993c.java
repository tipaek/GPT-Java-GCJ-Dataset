import java.util.Scanner;

class Bomber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] results = new int[t][3];

        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Input matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Diagonal sum
            results[k][0] = 0;
            for (int i = 0; i < n; i++) {
                results[k][0] += matrix[i][i];
            }

            // Row repeat calculation
            results[k][1] = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        hasDuplicate = true;
                    }
                }
                if (hasDuplicate) {
                    results[k][1]++;
                }
            }

            // Column repeat calculation
            results[k][2] = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        hasDuplicate = true;
                    }
                }
                if (hasDuplicate) {
                    results[k][2]++;
                }
            }

            // Print result for the current case
            System.out.print("Case #" + (k + 1) + ": ");
            for (int q = 0; q < 3; q++) {
                System.out.print(results[k][q] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}