import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String[] inputs = reader.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);

            StringBuilder path = new StringBuilder();
            boolean isPossible = findPath(path, x, y);
            System.out.println("Case #" + caseNumber + ": " + (isPossible ? path.toString() : "IMPOSSIBLE"));
        }
    }

    private static boolean findPath(StringBuilder path, long x, long y) {
        if (x == 0 && y == 1) {
            path.append('N');
            return true;
        }
        if (x == 0 && y == -1) {
            path.append('S');
            return true;
        }
        if (x == 1 && y == 0) {
            path.append('E');
            return true;
        }
        if (x == -1 && y == 0) {
            path.append('W');
            return true;
        }

        if (x == 0 && y == 0) {
            return true;
        }
        if ((x % 2 != 0 && y % 2 != 0) || (x % 2 == 0 && y % 2 == 0)) {
            return false;
        }

        if (x % 2 != 0) {
            path.append('W');
            if (findPath(path, (x + 1) / 2, y / 2)) {
                return true;
            }
            path.deleteCharAt(path.length() - 1);
            path.append('E');
            if (findPath(path, (x - 1) / 2, y / 2)) {
                return true;
            }
            path.deleteCharAt(path.length() - 1);
            return false;
        }

        if (y % 2 != 0) {
            path.append('S');
            if (findPath(path, x / 2, (y + 1) / 2)) {
                return true;
            }
            path.deleteCharAt(path.length() - 1);
            path.append('N');
            if (findPath(path, x / 2, (y - 1) / 2)) {
                return true;
            }
            path.deleteCharAt(path.length() - 1);
            return false;
        }

        throw new IllegalStateException("Unexpected state");
    }
}