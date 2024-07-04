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
            String s[] = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int arr[][] = new int[n][n];
            bw.write("Case #" + i + ": ");
            if (k % n == 0) {
                bw.write("POSSIBLE" + "\n");
                int a = (k / n);
                int ans = a;
                for (int j = 0; j < n; j++) {
                    arr[j][j] = a;
                }
                for (int j = 0; j < n; j++) {
                    for (int l = j + 1; l < n; l++) {
                        if (a == n) a = 0;
                        arr[j][l] = ++a;
                    }
                    for (int l = 0; l < j; l++) {
                        if (a == n) a = 0;
                        arr[j][l] = ++a;
                    }
                    a = ans;
                }
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < n; l++) {
                        bw.write(arr[j][l] + " ");
                    }
                    bw.write("\n");
                }
            } else {
                bw.write("IMPOSSIBLE" + "\n");
            }
        }
        bw.flush();
    }
}