import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        for (int x = 1; x <= t; x++) {
            int n = scn.nextInt();
            int[][] arr = new int[n][n];
            int sumd = 0;
            int cntr = 0;
            int cntc = 0;

            // Reading the matrix and calculating diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scn.nextInt();
                    if (i == j) {
                        sumd += arr[i][j];
                    }
                }
            }

            // Checking for duplicate rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(arr[i][j])) {
                        cntr++;
                        break;
                    }
                }
            }

            // Checking for duplicate columns
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(arr[i][j])) {
                        cntc++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + x + ": " + sumd + " " + cntr + " " + cntc);
        }

        scn.close();
    }
}