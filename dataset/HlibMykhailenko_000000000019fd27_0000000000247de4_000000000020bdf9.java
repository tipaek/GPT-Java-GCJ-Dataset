package com.gleb;

import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        int [][][] data = new int[cases][][];
        String [] ans = new String[cases];
        for (int cs = 0; cs < cases; ++cs) {
            int N = in.nextInt();
            data[cs] = new int[N][];
            for (int n = 0; n < N; ++n) {
                data[cs][n] = new int[4];
                data[cs][n][0] = in.nextInt();
                data[cs][n][1] = in.nextInt();
                data[cs][n][2] = n;
            }

            ans[cs] = schedule(data[cs]);
        }

        for (int i = 0; i < ans.length; ++i) {
            System.out.println("Case #" + (i + 1) + ": " + ans[i]);
        }
    }

    private static int MAN = 1;
    private static int WOMAN = 0;
    private static String IMPOSIBRU = "IMPOSSIBLE";

    private static String schedule(int [][] slots) {
        int M = 0;
        int W = 0;

        for (int [] slot: slots) {
            int start = slot[0];
            int end = slot[1];
            if (M < W) {
                if (M <= start) {
                    slot[3] = MAN;
                    M = end;
                } else {
                    return IMPOSIBRU;
                }
            } else {
                if (W <= start) {
                    slot[3] = WOMAN;
                    W = end;
                } else {
                    return IMPOSIBRU;
                }
            }

        }

        Arrays.sort(slots, Comparator.comparingInt(ar -> ar[2]));
        String ans = "";

        for (int [] slot: slots) {
            if (slot[3] == MAN) {
                ans += "J";
            } else {
                ans += "C";
            }
        }

        return ans;
    }
}























