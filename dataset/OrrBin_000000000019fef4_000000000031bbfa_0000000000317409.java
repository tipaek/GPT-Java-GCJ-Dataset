import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int catX = in.nextInt();
            int catY = in.nextInt();
            String catMoves = in.next();
            String result = "IMPOSSIBLE";


            if (catX == 0 && catY == 0)
                result = "" + 0;
            else {
                int steps = rec(0, 0, catX, catY, 0, catMoves);

                if (steps < Integer.MAX_VALUE)
                    result = "" + steps;
            }
            System.out.println(String.format("Case #%d: %s", i, result));
        }
    }

    static int rec(int x, int y, int catX, int catY, int step, String catMoves) {

        if (x == catX && y == catY) {
            return step;
        }

        if (step >= catMoves.length())
            return Integer.MAX_VALUE;

        char m = catMoves.charAt(step);
        switch (m) {
            case 'N':
                catY++;
                break;
            case 'S':
                catY--;
                break;
            case 'E':
                catX++;
                break;
            case 'W':
                catX--;
                break;
        }



        int maxDistance = catMoves.length() - step + 1;
        if (Math.abs(x - catX) > maxDistance || Math.abs(y - catY) > maxDistance) {
            return Integer.MAX_VALUE;
        }
        

        int e = rec(x + 1, y, catX, catY, step + 1, catMoves);

        int w = rec(x - 1, y, catX, catY,step + 1, catMoves);

        int n = rec(x, y + 1, catX, catY,step + 1, catMoves);

        int s = rec(x, y - 1, catX, catY, step + 1, catMoves);

        int stay = rec(x, y, catX, catY,step + 1, catMoves);


        return Math.min(e, Math.min(w, Math.min(n, Math.min(s, stay))));
    }
}