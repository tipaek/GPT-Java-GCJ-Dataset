
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        main(in, System.out);
    }

    public static void main(Scanner in, PrintStream out) {
        int testCases = in.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String path = in.next();
            int time = solveNorthSouthPath(x, y, path);
            String result = "IMPOSSIBLE";
            if (time >= 0) {
                result = String.valueOf(time);
            }
            out.printf("Case #%d: %s%n", i, result);
        }
    }

    public static int solveNorthSouthPath(int blocksEast, int blocksNorth, String path) {
        int pathDuration = path.length();
        int targetX = blocksEast;
        int targetY = blocksNorth;
        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'N':
                    targetY++;
                    break;
                case 'S':
                    targetY--;
                    break;
            }
            int time = i + 1;
            int timeToTarget = targetX + Math.abs(targetY);
            if (time >= timeToTarget) {
                return time;
            }
        }
        return -1;
    }
}
