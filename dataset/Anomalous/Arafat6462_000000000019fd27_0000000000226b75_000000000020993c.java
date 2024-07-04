import java.util.Scanner;

public class Google1 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[][] arr = new int[n][n];

            // Input
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[k][j] = in.nextInt();
                }
            }

            int[] row = new int[n];
            int[] column = new int[n];

            // Check rows for duplicates
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (arr[k][j] == arr[l][j]) {
                            row[j] = 1;
                            break;
                        }
                    }
                }
            }

            // Check columns for duplicates
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (arr[j][k] == arr[j][l]) {
                            column[j] = 1;
                            break;
                        }
                    }
                }
            }

            // Calculate diagonal sum and count duplicate rows and columns
            int sum = 0, ro = 0, co = 0;
            for (int p = 0; p < n; p++) {
                sum += arr[p][p];
                if (row[p] == 1) {
                    ro++;
                }
                if (column[p] == 1) {
                    co++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + sum + " " + ro + " " + co);
        }
    }
}