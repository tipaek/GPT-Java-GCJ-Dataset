import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int tests =  in.nextInt();

        for(int test = 1; test <= tests; test++) {
            int n = in.nextInt();
            int[][] m = new int[n][n];

            int trace = 0;
            int duplicate_rows = 0;
            int duplicate_cols = 0;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    m[i][j] = in.nextInt();
                    if(i == j) {
                        trace += m[i][j];
                    }
                }
            }

            duplicate_rows = countDuplicates(m, n, true);
            duplicate_cols = countDuplicates(m, n, false);

            System.out.println("Case #" + test + ": " + trace + " " + duplicate_rows + " " + duplicate_cols);
        }
    }

    private static int countDuplicates(int[][] m, int n, boolean isRow) {
        int duplicates = 0;
        for(int i = 0; i < n; i++) {
            int[] row = new int[n + 1];
            boolean containsDuplicate = false;
            int temp;
            for(int j = 0; j < n; j++) {
                temp = (isRow) ? m[i][j] : m[j][i];
                if(row[temp] == -1 && !containsDuplicate) {
                    duplicates++;
                    containsDuplicate = true;
                } else {
                    row[temp] = -1;
                }
            }
        }

        return duplicates;
    }
}