import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

public class Solution {

    public static char[] NAVIGATIONS = { 'N', 'S', 'E', 'W' };
    public static String path;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int c = 1; c <= t; c++) {
            String[] xy = in.nextLine().split("\\s+");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            path = "";

            int xyMax = Math.max(Math.abs(x), Math.abs(y));
            int round2 = round2(xyMax);
            int max = log2(round2) + 1;
            System.err.println("xyMax " + xyMax + " round2 " + round2 + " max " + max);

            boolean found = false;
            for (char nextDir : NAVIGATIONS) {
                if (navigate(1, nextDir, 0, 0, x, y, max, 0)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.println("Case #" + c + ": " + path);
            } else {
                System.out.println("Case #" + c + ": " + "IMPOSSIBLE");

            }

        }

    }

    public static boolean navigate(int i, char direction, int currentX, int currentY, int finalX, int finalY, int max,
            int movement) {
        /*
         * System.err.println("i " + i + " currentX " + currentX + " currentY " +
         * currentY + " path " + path + " movement " + movement);
         */

        if (currentX == finalX && currentY == finalY) {
            return true;
        }
        if (i > max)
            return false;

        path += direction;
        movement = (int) Math.pow(2, i - 1);
        i = i + 1;

        if (direction == 'E') {
            currentX += movement;
        }
        if (direction == 'W') {
            currentX -= movement;
        }
        if (direction == 'N') {
            currentY += movement;
        }
        if (direction == 'S') {
            currentY -= movement;
        }

        boolean found = false;

        for (char nextDir : NAVIGATIONS) {
            if (navigate(i, nextDir, currentX, currentY, finalX, finalY, max, movement)) {
                found = true;
                break;
            }
        }

        if (!found) {
            // i -= 1;
            path = path.substring(0, path.length() - 1);
        }

        return found;
    }

    static int round2(int x) {
        return ((x + 1) & (-2));
    }

    static int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }

}
