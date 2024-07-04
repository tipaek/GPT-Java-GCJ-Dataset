import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String[] inputs = reader.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);

            StringBuilder path = new StringBuilder();
            String result = findPath(path, 0, x, y, 0, 0);
            System.out.println("Case #" + testCase + ": " + (result == null ? "IMPOSSIBLE" : result));
        }
    }

    private static String findPath(StringBuilder path, int step, int targetX, int targetY, int currentX, int currentY) {
        if (currentX == targetX && currentY == targetY) {
            return path.toString();
        }
        if (step > 8) {
            return null;
        }

        int jumpDistance = (int) Math.pow(2, step);
        
        path.append('N');
        String northPath = findPath(path, step + 1, targetX, targetY, currentX, currentY + jumpDistance);
        path.deleteCharAt(step);
        
        path.append('S');
        String southPath = findPath(path, step + 1, targetX, targetY, currentX, currentY - jumpDistance);
        path.deleteCharAt(step);

        path.append('E');
        String eastPath = findPath(path, step + 1, targetX, targetY, currentX + jumpDistance, currentY);
        path.deleteCharAt(step);

        path.append('W');
        String westPath = findPath(path, step + 1, targetX, targetY, currentX - jumpDistance, currentY);
        path.deleteCharAt(step);

        String shortestPath = null;
        int minLength = Integer.MAX_VALUE;

        if (northPath != null && northPath.length() < minLength) {
            minLength = northPath.length();
            shortestPath = northPath;
        }
        if (southPath != null && southPath.length() < minLength) {
            minLength = southPath.length();
            shortestPath = southPath;
        }
        if (eastPath != null && eastPath.length() < minLength) {
            minLength = eastPath.length();
            shortestPath = eastPath;
        }
        if (westPath != null && westPath.length() < minLength) {
            minLength = westPath.length();
            shortestPath = westPath;
        }

        return shortestPath;
    }
}