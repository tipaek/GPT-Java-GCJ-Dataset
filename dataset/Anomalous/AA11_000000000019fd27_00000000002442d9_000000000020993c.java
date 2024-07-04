import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int h = 1; h <= t; h++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[101];
                StringTokenizer st = new StringTokenizer(br.readLine());
                boolean rowHasDuplicates = false;

                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (i == j) {
                        trace += arr[i][j];
                    }
                    if (rowCheck[arr[i][j]]) {
                        rowHasDuplicates = true;
                    }
                    rowCheck[arr[i][j]] = true;
                }

                if (rowHasDuplicates) {
                    duplicateRows++;
                }
            }

            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[101];
                boolean colHasDuplicates = false;

                for (int i = 0; i < n; i++) {
                    if (colCheck[arr[i][j]]) {
                        colHasDuplicates = true;
                    }
                    colCheck[arr[i][j]] = true;
                }

                if (colHasDuplicates) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + h + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}