package Round2Prob1;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int cc = 1; cc <= t; ++cc) {
            long a = in.nextInt();
            long b = in.nextInt();
            boolean flipped = false;

            if (b > a) {
                flipped = true;
                long temp = a;
                a = b;
                b = temp;
            }

            long n1 = (long) Math.floor(-0.5 + Math.sqrt(0.25 + 2 * (a - b)));
            a -= n1 * (n1 + 1) / 2;

            if (b > a) {
                flipped = !flipped;
                long temp = a;
                a = b;
                b = temp;
            }

            if (b == a && flipped) {
                flipped = !flipped;
                long temp = a;
                a = b;
                b = temp;
            }

            long n2 = (long) Math.floor((-(n1) + Math.sqrt(n1 * n1 + 4 * a)) / 2);

            if (n2 > 0) {
                a -= (n2 - 1) * (n1 + 2) + (n2 - 1) * (n2 - 1) + n1 + 1;
                b -= (n2 - 2) * (n1 + 3) + (n2 - 2) * (n2 - 2) + n1 + 2;
            }

            int finalRemoveFromB = (b >= n1 + n2 * 2 - (n2 > 0 ? 1 : 0) + 1) ? 1 : 0;

            if (finalRemoveFromB > 0) {
                b -= n1 + n2 * 2 - (n2 > 0 ? 1 : 0) + 1;
            }

            if (flipped) {
                long temp = a;
                a = b;
                b = temp;
            }

            System.out.println("Case #" + cc + ": " + (n1 + (n2 * 2) - (n2 > 0 ? 1 : 0) + finalRemoveFromB) + " " + a + " " + b);
        }
    }
}