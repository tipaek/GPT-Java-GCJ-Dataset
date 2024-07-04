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
        int jump = (int) Math.pow(2, step);

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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            minPath = null;
            findMinPath(0, 0, x, y, new StringBuilder());

            if (minPath != null) {
                result.append("Case #").append(i + 1).append(": ").append(minPath).append("\n");
            } else {
                result.append("Case #").append(i + 1).append(": IMPOSSIBLE\n");
            }
        }
        System.out.print(result);
    }
}