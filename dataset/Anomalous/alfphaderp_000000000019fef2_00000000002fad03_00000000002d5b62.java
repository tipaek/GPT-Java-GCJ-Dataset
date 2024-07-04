import java.util.Scanner;

public class Solution {
    private static Scanner scanner;
    private static int testCases;

    private int targetX, targetY;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            Solution solution = new Solution();
            solution.solve(caseNumber);
        }

        scanner.close();
    }

    private void solve(int caseNumber) {
        readInput();

        int maxSteps = (int) Math.floor(Math.log(Math.abs(targetX) + Math.abs(targetY)) / Math.log(2));
        String path = findPath(0, 0, maxSteps);

        if (path == null) {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        } else {
            System.out.println("Case #" + caseNumber + ": " + path);
        }
    }

    private void readInput() {
        targetX = scanner.nextInt();
        targetY = scanner.nextInt();
    }

    private String findPath(int currentX, int currentY, int steps) {
        if (steps == -1) {
            return (currentX == targetX && currentY == targetY) ? "" : null;
        }

        String direction;
        int nextX, nextY;
        if (Math.abs(targetX - currentX) > Math.abs(targetY - currentY)) {
            if (targetX > currentX) {
                direction = "E";
                nextX = currentX + (int) Math.pow(2, steps);
            } else {
                direction = "W";
                nextX = currentX - (int) Math.pow(2, steps);
            }
            nextY = currentY;
        } else {
            if (targetY > currentY) {
                direction = "N";
                nextY = currentY + (int) Math.pow(2, steps);
            } else {
                direction = "S";
                nextY = currentY - (int) Math.pow(2, steps);
            }
            nextX = currentX;
        }

        String result = findPath(nextX, nextY, steps - 1);
        return (result == null) ? null : result + direction;
    }
}