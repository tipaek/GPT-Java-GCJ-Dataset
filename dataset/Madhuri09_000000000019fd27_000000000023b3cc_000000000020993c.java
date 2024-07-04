import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            int arr[][] = new int[n][n];
            for (int j = 0; j < n; j++) {
                String s[] = br.readLine().split(" ");
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(s[k]);
                }
            }
            int trace = 0;
            for (int j = 0; j < n; j++) {
                trace += arr[j][j];
            }
            int rows = 0;
            int cols = 0;
            int val[] = new int[n];
            for (int j = 0; j < n; j++) {
                Arrays.fill(val, 0);
                for (int k = 0; k < n; k++) {
                    val[arr[j][k] - 1]++;
                }
                for (int k = 0; k < n; k++) {
                    if (val[k] != 1) {
                        rows++;
                        break;
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                Arrays.fill(val, 0);
                for (int k = 0; k < n; k++) {
                    val[arr[k][j] - 1]++;
                }
                for (int k = 0; k < n; k++) {
                    if (val[k] != 1) {
                        cols++;
                        break;
                    }
                }
            }
            bw.write("" + "Case #" + i + ": " + trace + " " + rows + " " + cols + "\n");
        }
        bw.flush();
    }
}