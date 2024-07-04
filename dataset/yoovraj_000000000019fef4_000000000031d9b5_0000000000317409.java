/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author yoovraj.shinde
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int X = Integer.parseInt(in.next());
            int Y = Integer.parseInt(in.next());
            char[] tour = in.next().toCharArray();
            solve(i, X,Y,tour);
        }
    }
    public static void solve(final int testCaseNumber, int X, int Y, final char[] tour) {
//        System.out.println("--- x=" + X + " y=" + Y + " tour=" + Arrays.toString(tour));
        for (int t = 1; t <= tour.length; t++) {
            char dir = tour[t-1];
            if (dir == 'N') {
                Y++;
            } else if (dir == 'S') {
                Y--;
            }
            if (t >= Math.abs(X) + Math.abs(Y)) {
                System.out.println("Case #" + testCaseNumber + ": " + t);
                return;
            }
        }
        System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
    }
}
