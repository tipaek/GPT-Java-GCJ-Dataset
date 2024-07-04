
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

class Solution {

    private Input reader = new Input();


    public static void main(String args[]) throws Exception {
        Solution sol = new Solution();
        sol.solve();
    }

    void solve() throws Exception {
        int t = reader.readInt();
        for (int caseId = 1; caseId <= t; caseId++) {
            int n = reader.readInt();
            int a[][] = reader.readIntMatrix(n);
            int trace = calculateTrace(a);
            int rowsWithDuplicate = 0;
            int colsWithDuplicate = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowElements = new HashSet<>();
                Set<Integer> colElements = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowElements.add(a[i][j]);
                    colElements.add(a[j][i]);
                }
                if (rowElements.size() < n) rowsWithDuplicate++;
                if (colElements.size() < n) colsWithDuplicate++;
            }
            System.out.printf("Case #%d: %d %d %d\n", caseId, trace, rowsWithDuplicate, colsWithDuplicate);
        }

    }

    int calculateTrace(int a[][]) {
        int trace = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            trace += a[i][i];
        }
        return trace;
    }

    private static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int readInt() throws Exception {
            return parseInt(br.readLine());
        }

        long readLong() throws Exception {
            return parseLong(br.readLine());
        }

        int[] readIntArray(int n) throws Exception {
            String[] s = br.readLine().split("\\s");
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = parseInt(s[i]);
            }
            return a;
        }

        /*Reads and return square matrix of integer elements*/
        int[][] readIntMatrix(int n) throws Exception {
            int a[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split("\\s");
                for (int j = 0; j < n; j++) {
                    a[i][j] = parseInt(s[j]);
                }
            }
            return a;
        }

        long[] readLongArray(int n) throws Exception {
            String[] s = br.readLine().split("\\s");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = parseLong(s[i]);
            }
            return a;
        }

        String readLine() throws Exception {
            return br.readLine();
        }

    }


}