import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = scan.nextInt();
        for (int cas = 1; cas <= t; cas++) {
            int n = scan.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scan.nextInt();
                }
            }

            int diag = 0;
            for (int i = 0; i < n; i++) {
                diag += arr[i][i];
            }

            int rep1 = 0, rep2 = 0;

            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (rowCheck[arr[i][j]]) {
                        rep1++;
                        break;
                    }
                    rowCheck[arr[i][j]] = true;
                }
            }

            for (int i = 0; i < n; i++) {
                boolean[] colCheck = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (colCheck[arr[j][i]]) {
                        rep2++;
                        break;
                    }
                    colCheck[arr[j][i]] = true;
                }
            }

            System.out.println("Case #" + cas + ": " + diag + " " + rep1 + " " + rep2);
        }
    }
}