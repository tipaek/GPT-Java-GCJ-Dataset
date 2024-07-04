import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Reading the matrix and calculating the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += arr[i][j];
                    }
                }
            }

            // Checking for repeated elements in rows
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[arr[i][j]]) {
                        rowRepeats++;
                        break;
                    }
                    seen[arr[i][j]] = true;
                }
            }

            // Checking for repeated elements in columns
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[arr[j][i]]) {
                        colRepeats++;
                        break;
                    }
                    seen[arr[j][i]] = true;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
            t--;
            caseNumber++;
        }
    }
}