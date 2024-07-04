
import java.util.*;
import java.io.*;

public class Solution {
    public static PrintWriter out;
    public static boolean DEBUG = false;
    public static int type = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = sc.nextInt();
        int N = sc.nextInt();
        int C = sc.nextInt();
        
        int[][] lowered = new int[t][N];
        int[] highestFound = new int[t];
        int[] loc = new int[t];
        Arrays.fill(highestFound, -1);
        Arrays.fill(loc, 0);
        boolean done = false;
        while (!done) {
            done = true;
            for (int i = 0; i < t; i++) {
                if (highestFound[i] != type) {
                    done = false;
                    out.print((loc[i] + 1) + " ");
                } else {
                    out.print("0 ");
                }
            }
            out.println();
            out.flush();
            if (done) break;
            for (int i = 0; i < t; i++) {
                int x = sc.nextInt();
                if (highestFound[i] != type && x == 0) {
                    lowered[i][loc[i]] = N + 1;
                    highestFound[i]++;
                    loc[i] = 0;
                } else if (highestFound[i] != type) {
                    lowered[i][loc[i]]++;
                    if (lowered[i][loc[i]] > highestFound[i] + 1) {
                        loc[i]++;
                        while (lowered[i][loc[i]] == N + 1)
                        loc[i]++;
                    }
                }
            }
        }
        for (int i = 0; i < t; i++) {
            int b1 = 0;
            int b2 = 1;
            for (int j = 0; j < N; j++) {
                if (lowered[i][b1] > lowered[i][j]) {
                    b1 = j;
                }
            }
            if (b2 == b1)
                b2 = 0;
            for (int j = 0; j < N; j++) {
                if (j != b1 && lowered[i][b2] > lowered[i][j]) {
                    b2 = j;
                }
            }
            out.print((b1 + 1) + " " + (b2 + 1) + " ");
        }
        out.println();

        out.close();
        sc.close();
    }
    public static double go(int target, int red1, int red2, int cant) {
        int total = 0;
        double good = 0;
        for (int i = cant + 1; i < target; i++) {
            for (int j = cant + 1; j < target; j++){
                if (i == j) continue;
                total++;
                if (target <= i+j-red1-red2) {
                    good++;
                }
            }
        }
        return good/total;
    }
}