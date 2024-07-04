import java.util.Scanner;

public class CodeJam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int z = 0; z < t; z++) {
            int n = scanner.nextInt();
            int[][] array = new int[n][n];
            int sum = 0, r_r = 0, c_r = 0;

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = scanner.nextInt();
                }
            }

            // Calculating the sum of the diagonal elements
            for (int i = 0; i < n; i++) {
                sum += array[i][i];
            }

            // Checking for duplicate elements in rows
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[array[i][j]]) {
                        r_r++;
                        break;
                    }
                    seen[array[i][j]] = true;
                }
            }

            // Checking for duplicate elements in columns
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[array[j][i]]) {
                        c_r++;
                        break;
                    }
                    seen[array[j][i]] = true;
                }
            }

            System.out.println("Case #" + (z + 1) + ": " + sum + " " + r_r + " " + c_r);
        }

        scanner.close();
    }
}