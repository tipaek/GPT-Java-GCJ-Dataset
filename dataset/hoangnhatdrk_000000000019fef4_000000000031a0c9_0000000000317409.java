import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            // Excited Fan
            int x = in.nextInt();
            int y = in.nextInt();
            String moves = in.nextLine().trim();

            System.out.println("Case #" + i + ": "+fan(x, y, moves));
        }
    }

    static int[][] dMove = {
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
    };

    private static String fan(int x, int y, String moves) {
        int curX = x;
        int curY = y;
        for (int i=0; i<moves.length(); i++) {
            char c = moves.charAt(i);
            int[] nextMove = {0,0};
            switch (c) {
                case 'N':
                    nextMove = dMove[0];
                    break;
                case 'E':
                    nextMove = dMove[1];
                    break;
                case 'S':
                    nextMove = dMove[2];
                    break;
                case 'W':
                    nextMove = dMove[3];
                    break;
            }

            curX += nextMove[0];
            curY += nextMove[1];

            int nextD = Math.abs(curX) + Math.abs(curY);
            if (nextD <= i+1) {
                return ""+(i+1);
            }
        }
        return "IMPOSSIBLE";
    }

}
