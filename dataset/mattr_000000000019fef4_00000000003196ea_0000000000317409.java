import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(in);
    }

    public static void solve(Scanner sc) throws Exception {
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; ++i) {
            doCase(sc, i);
        }
    }

    private static void doCase(Scanner sc, int caseNumber) throws Exception {
        String[] pStart = sc.nextLine().split(" ");
        int xStart = Integer.parseInt(pStart[0]);
        int yStart = Integer.parseInt(pStart[1]);
        String path = pStart[2];
        int pathLength = path.length();

        int xCurr = xStart;
        int yCurr = yStart;
        int time = 0;

        if (canTakePicture(xCurr, yCurr, time)) {
            printRes(caseNumber, Integer.toString(time));
            return;
        }

        for (int i = 0; i < pathLength; i++) {
            char direction = path.charAt(i);

            // tweak directions
            if (direction == 'N') {
                yCurr++;
            } else if (direction == 'S') {
                yCurr--;
            } else if (direction == 'E') {
                xCurr++;
            } else if (direction == 'W') {
                xCurr--;
            }
            time++;

            if (canTakePicture(xCurr, yCurr, time)) {
                printRes(caseNumber, Integer.toString(time));
                return;
            }
        }

        printRes(caseNumber, "IMPOSSIBLE");

    }

    private static boolean canTakePicture(int xCurr, int yCurr, int time) {
        return Math.abs(xCurr) + Math.abs(yCurr) <= time;
    }

    private static void printRes(int caseNumber, String res) {
        System.out.println("Case #" + Integer.toString(caseNumber) + ": " + res);

    }
}
