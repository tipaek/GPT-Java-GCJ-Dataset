import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int trace = 0;
            int[] rowsSum = new int[n];
            int[] rowsMin = new int[n];
            int[] rowsMax = new int[n];
            int[] colsSum = new int[n];
            int[] colsMin = new int[n];
            int[] colsMax = new int[n];

            int sum = n * (n+1) / 2;

            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");

                for (int k = 0; k < n; k++) {
                    int a = Integer.parseInt(input[k]);
                    if (k == j) {
                        trace += a;
                    }
                    rowsSum[j] += a;
                    colsSum[k] += a;
                    if (rowsMax[j] < a) rowsMax[j] = a;
                    if (rowsMin[j] > a || rowsMin[j] == 0) rowsMin[j] = a;
                    if (colsMax[j] < a) colsMax[j] = a;
                    if (colsMin[j] > a || colsMin[j] == 0) colsMin[j] = a;
                }
            }

            int wrongRows = 0;
            int wrongCols = 0;
            for (int l = 0; l < n; l++) {
                if (rowsSum[l] != sum || rowsMax[l] != n || rowsMin[l] != 1) wrongRows++;
                if (colsSum[l] != sum || colsMax[l] != n || colsMin[l] != 1) wrongCols++;
            }
            System.out.println("Case #" + (i+1) + ": " + trace + " " + wrongRows + " " + wrongCols);
        }
    }
}