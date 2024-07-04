
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        for (int i = 1; i <= n; i++) {
            int k = reader.nextInt();
            solve(i, k, reader);
        }

    }

    private static void solve(int idx, int n, Scanner reader) {
        int[][] arr = new int[n][n];
        int diag = 0;
        int dupRow = 0, dupCol = 0;
        for (int i = 0; i < n; i++) {
            int[] checkRow = new int[n];
            boolean foundDup = false;
            for (int j = 0; j < n; j++) {
                int c = reader.nextInt();
                arr[i][j] = c;
                checkRow[c - 1]++;
                if (checkRow[c - 1] > 1) foundDup = true;
                if (i == j) {
                    diag += c;
                }
            }
            if (foundDup) dupRow++;
            reader.nextLine();
        }

        for (int i = 0; i < n; i++) {
            int[] checkCol = new int[n];
            boolean foundDup = false;
            for (int j = 0; j < n; j++) {
                int c = arr[j][i];
                checkCol[c - 1]++;
                if (checkCol[c - 1] > 1) foundDup = true;
            }
            if (foundDup) dupCol++;
        }
        System.out.println("Case #" + idx + ": " + diag + " " + dupRow + " " + dupCol);
    }

}

