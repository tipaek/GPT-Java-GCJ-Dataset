import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int c = 1; c <= t; c++) {

            String[] XYM = in.nextLine().split("\\s+");
            int PX = Integer.parseInt(XYM[0]);
            int PY = Integer.parseInt(XYM[1]);
            int X = 0;
            int Y = 0;
            String M = XYM[2];

            int moves = 0;
            boolean found = false;
            for (char ch : M.toCharArray()) {
                if (canYouArriveWith(moves, X, Y, PX, PY)) {
                    System.out.println("Case #" + c + ": " + moves);
                    found = true;
                    break;
                }
                if (ch == 'N') {
                    PY += 1;
                    if (PY - Y >= 0) {
                        //Y += 1;
                    }

                    if (PY - Y <= -2) {
                       // Y -= 1;
                    }
                }

                if (ch == 'S') {
                    PY -= 1;
                    if (PY - Y >= 2) {
                       // Y += 1;
                    }
                    if (PY - Y <= 0) {
                       // Y -= 1;
                    }
                }

                if (ch == 'W') {
                    PX -= 1;
                }

                if (ch == 'E') {
                    PX += 1;
                }
                moves++;
            }

            if (!found && canYouArriveWith(moves, X, Y, PX, PY)) {
                System.out.println("Case #" + c + ": " + moves);
                found = true;
            }

            // System.out.println("Case #" + c + ": " + solution);
            if (!found) {
                System.out.println("Case #" + c + ": " + "IMPOSSIBLE");
            }
        }

    }

    public static boolean canYouArriveWith(int moves, int startX, int startY, int PX, int PY) {
        int requiredMoves = Math.abs(PX - startX) + Math.abs(PY - startY);

        return moves >= requiredMoves;
    }

}