import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private int[][] mat;
    private int n;

    public Solution(int n) {
        this.n = n;
        this.mat = new int[n][n];
    }

    public int trace() {
        int traceSum = 0;
        for (int i = 0; i < n; i++) {
            traceSum += mat[i][i];
        }
        return traceSum;
    }

    public int checkRows() {
        int repeatedRows = 0;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (seen[mat[i][j]]) {
                    repeatedRows++;
                    break;
                }
                seen[mat[i][j]] = true;
            }
        }
        return repeatedRows;
    }

    public int checkColumns() {
        int repeatedColumns = 0;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (seen[mat[j][i]]) {
                    repeatedColumns++;
                    break;
                }
                seen[mat[j][i]] = true;
            }
        }
        return repeatedColumns;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        Solution[] solutions = new Solution[t];

        for (int p = 0; p < t; p++) {
            int n = Integer.parseInt(in.readLine().trim());
            solutions[p] = new Solution(n);

            for (int i = 0; i < n; i++) {
                String[] arr = in.readLine().trim().split(" ");
                for (int j = 0; j < n; j++) {
                    solutions[p].mat[i][j] = Integer.parseInt(arr[j]);
                }
            }
        }

        for (int i = 0; i < t; i++) {
            int trace = solutions[i].trace();
            int repeatedRows = solutions[i].checkRows();
            int repeatedColumns = solutions[i].checkColumns();
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
    }
}