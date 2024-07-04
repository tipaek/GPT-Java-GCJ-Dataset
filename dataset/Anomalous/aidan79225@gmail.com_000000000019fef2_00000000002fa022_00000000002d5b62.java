import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution().processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String OUTPUT_FORMAT = "Case #%d: %s";
    private static final String IMPOSSIBLE_OUTPUT_FORMAT = "Case #%d: IMPOSSIBLE";
    private StringBuilder path = new StringBuilder();

    private void processCase(int caseNum, Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if (findPath(x, y)) {
            System.out.println(String.format(OUTPUT_FORMAT, caseNum, path.toString()));
        } else {
            System.out.println(String.format(IMPOSSIBLE_OUTPUT_FORMAT, caseNum));
        }
    }

    private boolean findPath(int x, int y) {
        if (x == 0 && y == 0) {
            return true;
        }

        int rx = Math.abs(x % 2);
        int ry = Math.abs(y % 2);
        if (rx == ry) {
            return false;
        }

        if (rx == 1) {
            int direction = x > 0 ? -1 : 1;
            if (recursePath((x + direction) / 2, y / 2, direction > 0 ? 'W' : 'E')) {
                return true;
            } else if (recursePath((x - direction) / 2, y / 2, direction > 0 ? 'E' : 'W')) {
                return true;
            }
        } else {
            int direction = y > 0 ? -1 : 1;
            if (recursePath(x / 2, (y + direction) / 2, direction > 0 ? 'N' : 'S')) {
                return true;
            } else if (recursePath(x / 2, (y - direction) / 2, direction > 0 ? 'S' : 'N')) {
                return true;
            }
        }
        return false;
    }

    private boolean recursePath(int newX, int newY, char direction) {
        if (findPath(newX, newY)) {
            path.append(direction);
            return true;
        }
        return false;
    }
}