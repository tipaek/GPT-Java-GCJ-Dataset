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
            int numSteps = catMoves.length();
            String result = "IMPOSSIBLE";

            for (int j = 1; j < numSteps + 1; j++) {
                char m = catMoves.charAt(j-1);
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

                if (Math.abs(catX) + Math.abs(catY) <= j) {
                    result = "" + j;
                    break;
                }
            }
            System.out.println(String.format("Case #%d: %s", i, result));
        }

    }

}