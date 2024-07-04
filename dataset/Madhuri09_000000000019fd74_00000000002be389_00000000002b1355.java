import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static int sum(int ar[][], int r, int c) {
        int s = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                s += ar[i][j];
            }
        }
        return s;
    }
    
    public static boolean compavg(int ar[][], int r, int c, int r1, int c1) {
        int c_ = 0;
        int s = 0;
        //side left 
        for (int i = c1 - 1; i >= 0; i--) {
            if (ar[r1][i] != 0) {
                c_++;
                s += ar[r1][i];
                break;
            }
        }
        //side right
        for (int i = c1 + 1; i < c; i++) {
            if (ar[r1][i] != 0) {
                c_++;
                s += ar[r1][i];
                break;
            }
        }
        //top 
        for (int i = r1 - 1; i >= 0; i--) {
            if (ar[i][c1] != 0) {
                c_++;
                s += ar[i][c1];
                break;
            }
        }
        // bottom
        for (int i = r1 + 1; i < r; i++) {
            if (ar[i][c1] != 0) {
                c_++;
                s += ar[i][c1];
                break;
            }
        }
        float avg = ((float)s / c_);
        float num = (float)ar[r1][c1];
        if (num < avg) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            String s[] = br.readLine().split(" ");
            int r = Integer.parseInt(s[0]);
            int c = Integer.parseInt(s[1]);
            int arr[][] = new int[r][c];
            for (int j = 0; j < r; j++) {
                String str[] = br.readLine().split(" ");
                for (int k = 0; k < c; k++) {
                    arr[j][k] = Integer.parseInt(str[k]);
                }
            }
            int rows[] = new int[r * c];
            int cols[] = new int[r * c];
            Arrays.fill(rows, 0);
            Arrays.fill(cols, 0);
            int x = 0;
            int tsum = sum(arr, r, c);
            int s1 = tsum; 
            int s2 = 0;
            while (true) {
                for (int a = 0; a < r; a++) {
                    for (int b = 0; b < c; b++) {
                        if (compavg(arr, r, c, a, b)) {
                            rows[x] = a;
                            cols[x++] = b;
                        }
                    }
                }
                for (int y = 0; y < x; y++) {
                    arr[rows[y]][cols[y]] = 0;
                }
                x = 0;
                Arrays.fill(rows, 0);
                Arrays.fill(cols, 0);
                s2 = sum(arr, r, c);
                if (s1 == s2) {
                    break;
                } else {
                    tsum += s2;
                    s1 = s2;
                }
            }
            bw.write("Case #" + i + ": " + tsum + "\n");
        }
        bw.flush();
    }
}