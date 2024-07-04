import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[][] a = new int[m][m];

            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    a[j][k] = sc.nextInt();
                }
            }

            int t = 0, r = 0, c = 0;

            // Calculate the sum of the main diagonal
            for (int j = 0; j < m; j++) {
                t += a[j][j];
            }

            // Count the number of repeated elements in each row
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m - 1; k++) {
                    if (a[j][k] == a[j][k + 1]) {
                        r++;
                    }
                }
            }

            // Count the number of repeated elements in each column
            for (int k = 0; k < m; k++) {
                for (int j = 0; j < m - 1; j++) {
                    if (a[j][k] == a[j + 1][k]) {
                        c++;
                    }
                }
            }

            System.out.println(t + " " + r + " " + c);
        }
        sc.close();
    }
}