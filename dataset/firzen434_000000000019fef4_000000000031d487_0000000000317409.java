import java.util.*;
import java.io.*;
public class Solution {
    
    private static final char NORTH = 'N';
    private static final char SOUTH = 'S';
    private static final char EAST = 'E';
    private static final char WEST = 'W';
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static String soln(int catX, int catY, String catMoves) {
        if (catX == 0 && catY == 0) {
            return "" + 0;
        }

        int T = 0;
        int cx = catX;
        int cy = catY;
        for (int i = 0; i < catMoves.length(); i++) {
            char move = catMoves.charAt(i);
            switch (move) {
                case NORTH:
                    cy++;
                    break;
                case SOUTH:
                    cy--;
                    break;
                case EAST:
                    cx++;
                    break;
                case WEST:
                    cx--;
                    break;
            }

            T++;

            if (Math.abs(cx) + Math.abs(cy) <= T) {
                return "" + T;
            }
        }

        return IMPOSSIBLE;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int cx = in.nextInt();
            int cy = in.nextInt();
            String moves = in.next();
            System.out.println("Case #" + i + ": " + soln(cx, cy, moves));
        }
    }
}