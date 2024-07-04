import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static String minPath;

    private static void findMinPath(int currX, int currY, int endX, int endY, StringBuilder currPath) {
        if (currX < -100 || currX > 100 || currY < -100 || currY > 100) {
            return;
        }
        
        if (currX == endX && currY == endY) {
            if (minPath == null || currPath.length() < minPath.length()) {
                minPath = currPath.toString();
            }
            return;
        }

        int step = currPath.length();
        int jump = 1 << step; // Equivalent to Math.pow(2, step)
        
        currPath.append("N");
        findMinPath(currX, currY + jump, endX, endY, currPath);
        currPath.deleteCharAt(currPath.length() - 1);
        
        currPath.append("S");
        findMinPath(currX, currY - jump, endX, endY, currPath);
        currPath.deleteCharAt(currPath.length() - 1);
        
        currPath.append("E");
        findMinPath(currX + jump, currY, endX, endY, currPath);
        currPath.deleteCharAt(currPath.length() - 1);
        
        currPath.append("W");
        findMinPath(currX - jump, currY, endX, endY, currPath);
        currPath.deleteCharAt(currPath.length() - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < testCases; i++) {
            String[] coordinates = reader.readLine().split(" ");
            int targetX = Integer.parseInt(coordinates[0]);
            int targetY = Integer.parseInt(coordinates[1]);

            minPath = null;
            findMinPath(0, 0, targetX, targetY, new StringBuilder());
            String output = (minPath != null) ? minPath : "IMPOSSIBLE";

            result.append("Case #").append(i + 1).append(": ").append(output).append("\n");
        }

        System.out.print(result);
    }
}