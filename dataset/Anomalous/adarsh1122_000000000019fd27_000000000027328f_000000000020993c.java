import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[][] c = new int[t][3];

        for (int k = 0; k < t; k++) {
            int n = scanner.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scanner.nextInt(); // Input Matrix
                }
            }

            c[k][0] = 0;
            for (int i = 0; i < n; i++) {
                c[k][0] += arr[i][i]; // Diagonal Addition
            }

            // Row repeat Calculation
            c[k][1] = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[arr[i][j]]) {
                        c[k][1]++;
                        break;
                    }
                    seen[arr[i][j]] = true;
                }
            }

            // Column repeat Calculation
            c[k][2] = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[arr[j][i]]) {
                        c[k][2]++;
                        break;
                    }
                    seen[arr[j][i]] = true;
                }
            }

            System.out.print("Case #" + (k + 1) + ": ");
            for (int q = 0; q < 3; q++) {
                System.out.print(c[k][q] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}