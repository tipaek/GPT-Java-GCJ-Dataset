import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt(); // Read number of test cases

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();
            Problem problem = new Problem(targetX, targetY);
            problem.solve("", 0, 0, 1, 0);

            String result = problem.getResult();
            if (result == null) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + result);
            }
        }

        scanner.close();
    }

    static class Problem {
        private static final int[] DX = { -1, 1, 0, 0 };
        private static final int[] DY = { 0, 0, 1, -1 };
        private static final List<String> DIRECTIONS = Arrays.asList("W", "E", "N", "S");

        private final int goalX;
        private final int goalY;
        private String result = null;

        public Problem(int x, int y) {
            this.goalX = x;
            this.goalY = y;
        }

        public void solve(String currentPath, int currentX, int currentY, int jumpIndex, int accumulatedCost) {
            if (goalX == currentX && goalY == currentY) {
                this.result = currentPath;
                return;
            }

            if (accumulatedCost >= Math.abs(goalX) + Math.abs(goalY)) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int jumpCount = calculateJumpCount(jumpIndex);
                int nextX = currentX + DX[i] * jumpCount;
                int nextY = currentY + DY[i] * jumpCount;

                if (isMovePossible(nextX, nextY, jumpCount)) {
                    solve(currentPath + DIRECTIONS.get(i), nextX, nextY, jumpIndex + 1, accumulatedCost + jumpCount);
                }
            }
        }

        private boolean isMovePossible(int nextX, int nextY, int jumpCount) {
            int xDifference = Math.abs(nextX - goalX);
            int yDifference = Math.abs(nextY - goalY);

            if (xDifference % 2 == 1 || yDifference % 2 == 1) {
                return false;
            }
            if (xDifference == 0 && yDifference != 0) {
                return yDifference >= jumpCount;
            } else if (xDifference != 0 && yDifference == 0) {
                return xDifference >= jumpCount;
            } else if (xDifference == 0 && yDifference == 0) {
                return true;
            } else {
                return xDifference >= jumpCount && yDifference >= jumpCount;
            }
        }

        private int calculateJumpCount(int index) {
            return 1 << (index - 1);
        }

        public String getResult() {
            return result;
        }
    }
}