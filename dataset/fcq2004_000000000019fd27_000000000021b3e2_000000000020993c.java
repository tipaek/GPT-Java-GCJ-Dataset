import java.util.*;
import java.io.*;

public class Solution {
    static int N;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            N = in.nextInt();
            int[][] ar = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int j2 = 0; j2 < N; j2++) {
                    ar[j][j2] = in.nextInt();
                }
            }
            System.out.println("Case #" + (i + 1) + ": ");
            solve(ar);
        }
    }

    static void solve(int[][] ar) {
        int r = 0;
        int c = 0;
        int rCheck = 0;
        int cCheck = 0;
        int trace = 0;
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> columns = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    trace += ar[i][j];
                }
                if (rows.contains(ar[i][j])) {
                    rCheck++;
                } else {
                    rows.add(ar[i][j]);
                }
                if (columns.contains(ar[j][i])) {
                    cCheck++;
                } else {
                    columns.add(ar[j][i]);
                }
            }
            rows.clear();
            columns.clear();

            if (rCheck > 0) {
                r++;
            }
            if (cCheck > 0) {
                c++;
            }
            rCheck = 0;
            cCheck = 0;
        }

        System.out.print(trace + " " + r + " " + c);
    }
}