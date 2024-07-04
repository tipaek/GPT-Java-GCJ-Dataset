import java.util.*;
import java.io.*;

class Solution {
    private static int targetX, targetY, minSteps;
    private static StringBuilder answer;
    private static final char[] xMoves = {'S', 'N'};
    private static final char[] yMoves = {'W', 'E'};
    private static final int[] xDirections = {-1, 1};
    private static final int[] yDirections = {-1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            output.append("Case #").append(testCase).append(": ");

            String[] input = reader.readLine().split("\\s+");
            targetX = Integer.parseInt(input[0]);
            targetY = Integer.parseInt(input[1]);

            minSteps = Integer.MAX_VALUE;
            answer = new StringBuilder();

            findPath(0, 0, 0, new StringBuilder());

            if (minSteps == Integer.MAX_VALUE) {
                output.append("IMPOSSIBLE");
            } else {
                output.append(answer);
            }
            output.append('\n');
        }

        writer.print(output);
        reader.close();
        writer.close();
    }

    private static void findPath(long currentX, long currentY, int steps, StringBuilder path) {
        if (steps >= minSteps || Math.abs(currentX) > Math.abs(targetY) || Math.abs(currentY) > Math.abs(targetX)) {
            return;
        }
        if (currentX == targetY && currentY == targetX) {
            answer = new StringBuilder(path);
            minSteps = steps;
            return;
        }
        long power = 1 << steps;

        path.append('S');
        findPath(currentX - power, currentY, steps + 1, path);
        path.deleteCharAt(path.length() - 1);

        path.append('N');
        findPath(currentX + power, currentY, steps + 1, path);
        path.deleteCharAt(path.length() - 1);

        path.append('W');
        findPath(currentX, currentY - power, steps + 1, path);
        path.deleteCharAt(path.length() - 1);

        path.append('E');
        findPath(currentX, currentY + power, steps + 1, path);
        path.deleteCharAt(path.length() - 1);
    }
}