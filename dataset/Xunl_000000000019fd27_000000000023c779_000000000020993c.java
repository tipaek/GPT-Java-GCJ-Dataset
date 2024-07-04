import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            calcVestigium(i, N, in);
        }
    }

    public static void calcVestigium(int x, int N , Scanner in) {
        int k = 0, r = 0, c = 0;
        boolean[][] rowNumbersUnused = new boolean[N][N];
        boolean[] rowViolated = new boolean[N];
        boolean[][] colNumbersUnused = new boolean[N][N];
        boolean[] colViolated = new boolean[N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                int num = in.nextInt();
                if (rowNumbersUnused[i][num - 1]) {
                    if (!rowViolated[i]) {
                        r++;
                        rowViolated[i] = true;
                    }
                } else {
                    rowNumbersUnused[i][num - 1] = true;
                }
                if (colNumbersUnused[j][num - 1]) {
                    if (!colViolated[j]) {
                        c++;
                        colViolated[j] = true;
                    }
                } else {
                    colNumbersUnused[j][num - 1] = true;
                }
                if (i == j) {
                    k += num;
                }
            }
        }
        System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
    }
}