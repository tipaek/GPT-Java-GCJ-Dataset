import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";
    private static final String IMPOSSIBLE_OUTPUT = "Case #%d: IMPOSSIBLE";
    private StringBuilder pathBuilder = new StringBuilder();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            Solution solution = new Solution();
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                solution.processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processCase(int caseNum, Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if (findPath(x, y)) {
            System.out.println(String.format(OUTPUT_FORMAT, caseNum, pathBuilder.toString()));
        } else {
            System.out.println(String.format(IMPOSSIBLE_OUTPUT, caseNum));
        }
        pathBuilder.setLength(0); // Clear the path for the next case
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
            if (tryDirection(x, y, direction, 'W', 'E')) {
                return true;
            }
        } else {
            int direction = y > 0 ? -1 : 1;
            if (tryDirection(y, x, direction, 'S', 'N')) {
                return true;
            }
        }

        return false;
    }

    private boolean tryDirection(int primary, int secondary, int direction, char positiveDir, char negativeDir) {
        if (findPath((primary + direction) / 2, secondary / 2)) {
            pathBuilder.insert(0, direction > 0 ? positiveDir : negativeDir);
            return true;
        } else if (findPath((primary - direction) / 2, secondary / 2)) {
            pathBuilder.insert(0, direction > 0 ? negativeDir : positiveDir);
            return true;
        }
        return false;
    }
}