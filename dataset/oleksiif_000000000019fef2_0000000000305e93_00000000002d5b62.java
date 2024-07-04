import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Solution {
        public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int caseIndex = 1; caseIndex <= T; caseIndex++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            int distance = Math.abs(X) + Math.abs(Y);
            int powerJumps = calculateJumps(distance);
            List<Character> arrows = new ArrayList<>();
            dfs(powerJumps, new int[] {X,Y}, new int [] {0, 0}, arrows);
            if (arrows.isEmpty()) {
                out.println(String.format("Case #%s: IMPOSSIBLE", caseIndex));
            } else {
                String arrowsString = "";
                for (Character character: arrows) {
                    arrowsString += character;
                }
                out.println(String.format("Case #%s: %s", caseIndex, arrowsString));
            }
        }
    }

    private static int[][] directions = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    private static char[] winds = new char[]{'S', 'E', 'N', 'W'};

    private static void dfs(int powerJumps, int[] destination, int[] current, List<Character> arrows) {
        if (powerJumps < 0) return;
        for (int i = 0; i < directions.length; i++) {
            arrows.add(winds[i]);
            int jumpX = (int) (current[0] + directions[i][0] * Math.pow(2, powerJumps));
            int jumpY = (int) (current[1] + directions[i][1] * Math.pow(2, powerJumps));
            if (jumpX == destination[0] && jumpY == destination[1])
                return;
            else {
                dfs(powerJumps - 1, destination, new int[]{jumpX, jumpY}, arrows);
            }
            arrows.remove(arrows.size() - 1);
        }
    }

    private static int calculateJumps(int distance) {
        int power2 = (int) (Math.log(distance) / Math.log(2));
        return power2;
    }
}