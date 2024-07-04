//package codejam2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int T = in.nextInt();

        for (int t = 1; t <= T; ++t) {

            final int X = in.nextInt();
            final int Y = in.nextInt();
            final String M = in.nextLine().trim();

            int catX = X;
            int catY = Y;

            int minimal = -1;

            if (Math.abs(catX) + Math.abs(catY) <= 0) {
                minimal = 0;
            }

            if (minimal == -1) {

                for (int i = 1; i <= M.length(); ++i) {
                    final char move = M.charAt(i - 1);
                    if (move == 'N') {
                        catY++;
                    } else if (move == 'S') {
                        catY--;
                    } else if (move == 'W') {
                        catX--;
                    } else if (move == 'E') {
                        catX++;
                    }
                    if (Math.abs(catX) + Math.abs(catY) <= i) {
                        minimal = i;
                        break;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + ( (minimal > -1) ? minimal : "IMPOSSIBLE" ) );
        }
    }
}
