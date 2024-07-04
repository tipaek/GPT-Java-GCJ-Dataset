import java.io.*;
import java.util.*;

// public class B {
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int cases = 1; cases <= t; cases++) {
            int c = sc.nextInt();
            int d = sc.nextInt();
            int[] xs = new int[c];
            for (int i = 1; i < c; i++) {
                xs[i] = -1 * sc.nextInt();
            }
            boolean[][] adj = new boolean[c][c];
            int[][] weights = new int[c][c];
            int[] us = new int[d];
            int[] vs = new int[d];
            for (int i = 0; i < d; i++) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                us[i] = u; vs[i] = v;
                if (xs[u] == xs[v]) {
                    weights[u][v] = 1000000;
                    weights[v][u] = 1000000;
                }
                adj[u][v] = true;
                adj[v][u] = true;
            }
            int num = 1;
            int before = 1;
            while (num < c) {
                // System.out.println(num);
                for (int i = 0; i < c; i++) {
                    if (xs[i] == before) { // Do now
                        num++;
                        for (int j = 0; j < c; j++) {
                            if (xs[j] < xs[i] && adj[i][j]) {
                                weights[i][j] = (xs[i] * (xs[i] +1)) / 2 - (xs[j] * (xs[j] + 1)) / 2;
                                weights[j][i] = (xs[i] * (xs[i] +1)) / 2 - (xs[j] * (xs[j] + 1)) / 2;
                            }
                        }
                    }
                }
                before = num;
            }
            System.out.print("Case #" + cases + ":");
            for (int i = 0; i < d; i++) {
                System.out.print(" " + weights[us[i]][vs[i]]);
            }
            System.out.println();
        }
    }
}
