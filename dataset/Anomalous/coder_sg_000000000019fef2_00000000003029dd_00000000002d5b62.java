import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static String minPath;

    private static void findMinPath(int currX, int currY, int endX, int endY, StringBuilder currPath) {
        if (currPath.length() > 7 || currX < -100 || currX > 100 || currY < -100 || currY > 100) {
            return;
        }
        if (currX == endX && currY == endY) {
            if (minPath == null || currPath.length() < minPath.length()) {
                minPath = currPath.toString();
            }
            return;
        }

        int step = currPath.length();
        int jump = (int) Math.pow(2, step);

        // Move South
        currPath.append("S");
        findMinPath(currX, currY - jump, endX, endY, currPath);
        currPath.deleteCharAt(currPath.length() - 1);

        // Move East
        currPath.append("E");
        findMinPath(currX + jump, currY, endX, endY, currPath);
        currPath.deleteCharAt(currPath.length() - 1);

        // Move North
        currPath.append("N");
        findMinPath(currX, currY + jump, endX, endY, currPath);
        currPath.deleteCharAt(currPath.length() - 1);

        // Move West
        currPath.append("W");
        findMinPath(currX - jump, currY, endX, endY, currPath);
        currPath.deleteCharAt(currPath.length() - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < testCases; i++) {
            String[] input = reader.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            StringBuilder answer = new StringBuilder();

            minPath = null;
            findMinPath(0, 0, x, y, new StringBuilder());
            if (minPath != null) {
                answer.append(minPath);
            } else {
                answer.append("IMPOSSIBLE");
            }

            result.append("Case #").append(i + 1).append(": ").append(answer).append("\n");
        }
        System.out.print(result);
    }
}