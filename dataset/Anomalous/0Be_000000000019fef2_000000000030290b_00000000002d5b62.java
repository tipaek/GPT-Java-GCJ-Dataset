import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class Solution {
    private static int targetX, targetY, minSteps;
    private static StringBuilder resultPath;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            output.append("Case #").append(t).append(": ");

            String[] inputs = reader.readLine().split("\\s+");
            targetX = Integer.parseInt(inputs[0]);
            targetY = Integer.parseInt(inputs[1]);

            minSteps = Integer.MAX_VALUE;

            findPath(0, 0, 0, new StringBuilder());

            if (minSteps == Integer.MAX_VALUE) {
                output.append("IMPOSSIBLE");
            } else {
                output.append(resultPath);
            }

            output.append('\n');
        }

        writer.print(output);
        reader.close();
        writer.close();
    }

    private static void findPath(long currentX, long currentY, int steps, StringBuilder path) {
        if (currentX == targetY && currentY == targetX) {
            resultPath = new StringBuilder(path);
            minSteps = steps;
            return;
        }
        if (steps >= minSteps) {
            return;
        }

        long stepSize = 1 << steps;

        if ((currentX != targetY && Math.abs(currentX - targetY) < stepSize) || 
            (currentY != targetX && Math.abs(currentY - targetX) < stepSize)) {
            return;
        }

        if (Math.abs(currentX - stepSize) <= Math.abs(targetY)) {
            path.append('S');
            findPath(currentX - stepSize, currentY, steps + 1, path);
            path.deleteCharAt(path.length() - 1);
        }

        if (Math.abs(currentX + stepSize) <= Math.abs(targetY)) {
            path.append('N');
            findPath(currentX + stepSize, currentY, steps + 1, path);
            path.deleteCharAt(path.length() - 1);
        }

        if (Math.abs(currentY - stepSize) <= Math.abs(targetX)) {
            path.append('W');
            findPath(currentX, currentY - stepSize, steps + 1, path);
            path.deleteCharAt(path.length() - 1);
        }

        if (Math.abs(currentY + stepSize) <= Math.abs(targetX)) {
            path.append('E');
            findPath(currentX, currentY + stepSize, steps + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}