//package codejam2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int T = in.nextInt();
        for (int x = 1; x <= T; ++x) {
            final int N = in.nextInt();
            final int K = in.nextInt();
            if (N == 2) {
                if (K == 2) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("1 2");
                    System.out.println("2 1");
                    System.out.flush();
                } else if (K == 4) {
                    System.out.println("2 1");
                    System.out.println("1 2");
                    System.out.flush();
                } else {
                    System.out.println("Case #" + x + ": " + "IMPOSSIBLE");
                    System.out.flush();
                }
            } else if (N == 3) {
                if (K == 3) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("1 3 2");
                    System.out.println("2 1 3");
                    System.out.println("3 2 1");
                    System.out.flush();
                } else if (K == 6) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("3 2 1");
                    System.out.println("2 1 3");
                    System.out.println("1 3 2");
                    System.out.flush();
                } else if (K == 9) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("3 2 1");
                    System.out.println("1 3 2");
                    System.out.println("2 1 3");
                    System.out.flush();
                } else {
                    System.out.println("Case #" + x + ": " + "IMPOSSIBLE");
                    System.out.flush();
                }
            } else if (N == 4) {
                if (K == 16) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("4 1 2 3");
                    System.out.println("3 4 1 2");
                    System.out.println("2 3 4 1");
                    System.out.println("1 2 3 4");
                    System.out.flush();
                } else if (K == 4) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("1 4 2 3");
                    System.out.println("3 1 4 2");
                    System.out.println("2 3 1 4");
                    System.out.println("4 2 3 1");
                    System.out.flush();
                } else if (K == 6) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("1 4 2 3");
                    System.out.println("4 2 3 1");
                    System.out.println("2 3 1 4");
                    System.out.println("3 1 4 2");
                    System.out.flush();
                } else if (K == 7) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("1 4 2 3");
                    System.out.println("2 3 4 1");
                    System.out.println("3 2 1 4");
                    System.out.println("4 1 3 2");
                    System.out.flush();
                } else if (K == 8) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("4 1 2 3");
                    System.out.println("1 2 3 4");
                    System.out.println("3 4 1 2");
                    System.out.println("2 3 4 1");
                    System.out.flush();
                } else if (K == 9) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("4 1 2 3");
                    System.out.println("1 3 4 2");
                    System.out.println("3 2 1 4");
                    System.out.println("2 4 3 1");
                    System.out.flush();
                } else if (K == 10) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("4 1 2 3");
                    System.out.println("1 4 3 2");
                    System.out.println("3 2 1 4");
                    System.out.println("2 3 4 1");
                    System.out.flush();
                } else if (K == 11) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("4 1 2 3");
                    System.out.println("2 4 3 1");
                    System.out.println("3 2 1 4");
                    System.out.println("1 3 4 2");
                    System.out.flush();
                } else if (K == 12) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("4 1 2 3");
                    System.out.println("3 4 1 2");
                    System.out.println("1 2 3 4");
                    System.out.println("2 3 4 1");
                    System.out.flush();
                } else if (K == 13) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("4 1 2 3");
                    System.out.println("3 2 4 1");
                    System.out.println("1 4 3 2");
                    System.out.println("2 3 1 4");
                    System.out.flush();
                } else if (K == 14) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("4 1 2 3");
                    System.out.println("1 3 4 2");
                    System.out.println("2 4 3 1");
                    System.out.println("3 2 1 4");
                    System.out.flush();
                } else {
                    System.out.println("Case #" + x + ": " + "IMPOSSIBLE");
                    System.out.flush();
                }

            } else if (N == 5) {
                if (K == 5) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("1 2 3 4 5");
                    System.out.println("2 1 4 5 3");
                    System.out.println("3 5 1 2 4");
                    System.out.println("4 3 5 1 2");
                    System.out.println("5 4 2 3 1");
                    System.out.flush();
                } else if (K == 7) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("1 2 3 4 5");
                    System.out.println("3 1 4 5 2");
                    System.out.println("4 5 2 1 3");
                    System.out.println("5 3 1 2 4");
                    System.out.println("2 4 5 3 1");
                    System.out.flush();
                } else if (K == 8) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("1 2 3 4 5");
                    System.out.println("2 1 4 5 3");
                    System.out.println("3 5 1 2 4");
                    System.out.println("5 4 2 3 1");
                    System.out.println("4 3 5 1 2");
                    System.out.flush();
                } else if (K == 9) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("1 2 3 4 5");
                    System.out.println("2 1 4 5 3");
                    System.out.println("4 5 1 3 2");
                    System.out.println("3 4 5 2 1");
                    System.out.println("5 3 2 1 4");
                    System.out.flush();
                } else if (K == 10) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("1 2 3 4 5");
                    System.out.println("2 1 4 5 3");
                    System.out.println("3 4 5 1 2");
                    System.out.println("5 3 1 2 4");
                    System.out.println("4 5 2 3 1");
                    System.out.flush();
                } else if (K == 11) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("1 2 3 4 5");
                    System.out.println("2 3 1 5 4");
                    System.out.println("3 5 4 1 2");
                    System.out.println("4 1 5 2 3");
                    System.out.println("5 4 2 3 1");
                    System.out.flush();
                } else if (K == 12) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("1 2 3 4 5");
                    System.out.println("2 3 1 5 4");
                    System.out.println("3 4 5 1 2");
                    System.out.println("5 1 4 2 3");
                    System.out.println("4 5 2 3 1");
                    System.out.flush();
                } else if (K == 13) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("1 2 3 4 5");
                    System.out.println("2 3 1 5 4");
                    System.out.println("5 1 4 2 3");
                    System.out.println("4 5 2 3 1");
                    System.out.println("3 4 5 1 2");
                    System.out.flush();
                } else if (K == 14) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("1 2 3 4 5");
                    System.out.println("2 1 4 5 3");
                    System.out.println("3 4 5 1 2");
                    System.out.println("4 5 2 3 1");
                    System.out.println("5 3 1 2 4");
                    System.out.flush();
                } else if (K == 15) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("1 2 3 4 5");
                    System.out.println("2 3 1 5 4");
                    System.out.println("3 4 5 1 2");
                    System.out.println("4 5 2 3 1");
                    System.out.println("5 1 4 2 3");
                    System.out.flush();
                } else if (K == 16) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("1 2 3 4 5");
                    System.out.println("2 3 4 5 1");
                    System.out.println("4 1 5 2 3");
                    System.out.println("5 4 1 3 2");
                    System.out.println("3 5 2 1 4");
                    System.out.flush();
                } else if (K == 17) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("1 2 3 4 5");
                    System.out.println("2 4 1 5 3");
                    System.out.println("4 3 5 2 1");
                    System.out.println("5 1 4 3 2");
                    System.out.println("3 5 2 1 4");
                    System.out.flush();
                } else if (K == 18) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("1 2 3 4 5");
                    System.out.println("2 4 5 1 3");
                    System.out.println("3 5 4 2 1");
                    System.out.println("4 3 1 5 2");
                    System.out.println("5 1 2 3 4");
                    System.out.flush();
                } else if (K == 19) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("1 2 3 4 5");
                    System.out.println("2 5 1 3 4");
                    System.out.println("3 4 5 1 2");
                    System.out.println("4 3 2 5 1");
                    System.out.println("5 1 4 2 3");
                    System.out.flush();
                } else if (K == 20) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("1 2 3 4 5");
                    System.out.println("2 5 4 1 3");
                    System.out.println("3 4 5 2 1");
                    System.out.println("4 3 1 5 2");
                    System.out.println("5 1 2 3 4");
                    System.out.flush();
                } else if (K == 21) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("2 1 3 4 5");
                    System.out.println("1 5 4 2 3");
                    System.out.println("3 4 5 1 2");
                    System.out.println("4 3 2 5 1");
                    System.out.println("5 2 1 3 4");
                    System.out.flush();
                } else if (K == 22) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("3 1 2 4 5");
                    System.out.println("1 5 4 2 3");
                    System.out.println("2 4 5 3 1");
                    System.out.println("4 3 1 5 2");
                    System.out.println("5 2 3 1 4");
                    System.out.flush();
                } else if (K == 23) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("4 1 2 3 5");
                    System.out.println("1 5 3 4 2");
                    System.out.println("2 4 5 1 3");
                    System.out.println("3 2 4 5 1");
                    System.out.println("5 3 1 2 4");
                    System.out.flush();
                } else if (K == 25) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    System.out.println("5 1 2 3 4");
                    System.out.println("1 5 3 4 2");
                    System.out.println("2 4 5 1 3");
                    System.out.println("3 2 4 5 1");
                    System.out.println("4 3 1 2 5");
                    System.out.flush();
                } else {
                    System.out.println("Case #" + x + ": " + "IMPOSSIBLE");
                    System.out.flush();
                }

            } else {
                System.exit(1);
            }
        }
    }
}