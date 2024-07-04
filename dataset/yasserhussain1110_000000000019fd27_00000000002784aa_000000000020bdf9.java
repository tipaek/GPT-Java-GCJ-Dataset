// package com.yasser.twenty20.parenting;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.in;
import static java.lang.System.out;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] inp = new int[n][3];
            for (int j = 0; j < n; j++) {
                inp[j][0] = scanner.nextInt();
                inp[j][1] = scanner.nextInt();
            }

            solve(i + 1, inp);
        }
    }

    private static void solve(int caseNumber, int[][] inp) {
        int numActivities = inp.length;
        Integer[] indices = new Integer[numActivities];
        for (int i = 0; i < numActivities; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> inp[a][1] - inp[b][1]);

        int lastAct = 0;
        for (int i = 0; i < numActivities; i++) {
            int[] act = inp[indices[i]];
            if (act[0] >= lastAct) {
                lastAct = act[1];
                act[2] = 'C';
            }
        }

        lastAct = 0;
        for (int i = 0; i < numActivities; i++) {
            int[] act = inp[indices[i]];
            if (act[2] == 'C') continue;
            if (act[0] >= lastAct) {
                lastAct = act[1];
                act[2] = 'J';
            }
        }

        for (int i=0; i<numActivities; i++) {
            if (inp[i][2] != 'C' && inp[i][2] != 'J') {
                out.println(String.format("Case #%s: IMPOSSIBLE", caseNumber));
                return;
            }
        }

        out.print(String.format("Case #%s: ", caseNumber));

        for (int i=0; i<numActivities; i++) {
            out.print((char) inp[i][2]);
        }
        out.println();
    }
}
