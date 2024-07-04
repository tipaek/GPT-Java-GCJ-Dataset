import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int cnt = 1; cnt <= t; cnt++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += arr[i][i];
            }

            int rowcount = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[arr[i][j]]) {
                        rowcount++;
                        break;
                    }
                    seen[arr[i][j]] = true;
                }
            }

            int colcount = 0;
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (seen[arr[i][j]]) {
                        colcount++;
                        break;
                    }
                    seen[arr[i][j]] = true;
                }
            }

            System.out.println("Case #" + cnt + ": " + trace + " " + rowcount + " " + colcount);
        }
        sc.close();
    }
}