

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int caseId = 1; caseId <= t; caseId++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            String result = jump(x, y, 0, 0, 1, "");
            System.out.println("Case #" + caseId + ": " + result);
        }
    }

    private static String jump(int goalX, int goalY, int x, int y, int move, String trace) {
        if (x == goalX && y == goalY) {
            return trace;
        }
        if (move > 10) {
            return null;
        }
        int jump = (int) Math.pow(2, (move - 1));
        move++;
        String north = jump(goalX, goalY, x, y + jump, move, trace + "N");
        String south = jump(goalX, goalY, x, y - jump, move, trace + "S");
        String west = jump(goalX, goalY, x + jump, y, move, trace + "E");
        String east = jump(goalX, goalY, x - jump, y, move, trace + "W");

        return Stream.of(north, south, west, east)
                .filter(Objects::nonNull)
                .min(Comparator.comparing(String::length))
                .orElse("IMPOSSIBLE");
    }

}
