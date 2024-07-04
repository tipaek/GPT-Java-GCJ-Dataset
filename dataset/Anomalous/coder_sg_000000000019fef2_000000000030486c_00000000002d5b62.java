import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static String minPath;

    private static void findMinPath(long currX, long currY, long endX, long endY, StringBuilder currPath) {
        if (currPath.length() > 29 || currX < -1_000_000_000 || currX > 1_000_000_000 || currY < -1_000_000_000 || currY > 1_000_000_000) {
            return;
        }

        if (currX == endX && currY == endY) {
            if (minPath == null || currPath.length() < minPath.length()) {
                minPath = currPath.toString();
            }
            return;
        }

        long step = currPath.length();
        long jump = 1L << step;

        char[] directions = {'N', 'S', 'E', 'W'};
        long[][] moves = {{0, jump}, {0, -jump}, {jump, 0}, {-jump, 0}};

        for (int i = 0; i < directions.length; i++) {
            currPath.append(directions[i]);
            findMinPath(currX + moves[i][0], currY + moves[i][1], endX, endY, currPath);
            currPath.deleteCharAt(currPath.length() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < testCases; i++) {
            String[] input = reader.readLine().split(" ");
            long x = Long.parseLong(input[0]);
            long y = Long.parseLong(input[1]);
            StringBuilder answer = new StringBuilder();

            if ((Math.abs(x) % 2 == Math.abs(y) % 2)) {
                answer.append("IMPOSSIBLE");
            } else {
                minPath = null;
                findMinPath(0L, 0L, x, y, new StringBuilder());
                answer.append(minPath != null ? minPath : "IMPOSSIBLE");
            }

            result.append("Case #").append(i + 1).append(": ").append(answer).append("\n");
        }

        System.out.print(result);
    }
}