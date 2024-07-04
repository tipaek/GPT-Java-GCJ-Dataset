import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        StringBuilder ans = new StringBuilder();
        int caseNo = 0;

        while (t-- > 0) {
            caseNo++;
            int n = scn.nextInt();
            int[][] mat = new int[n][n];
            int trace = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = scn.nextInt();
                    if (i == j) {
                        trace += mat[i][j];
                    }
                }
            }

            int rowCount = 0;
            // Check for duplicate elements in rows
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[mat[i][j]]) {
                        rowCount++;
                        break;
                    }
                    seen[mat[i][j]] = true;
                }
            }

            int colCount = 0;
            // Check for duplicate elements in columns
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (seen[mat[i][j]]) {
                        colCount++;
                        break;
                    }
                    seen[mat[i][j]] = true;
                }
            }

            ans.append("Case ").append(caseNo).append(": ").append(trace).append(" ").append(rowCount).append(" ").append(colCount).append("\n");
        }

        System.out.print(ans.toString());
    }
}