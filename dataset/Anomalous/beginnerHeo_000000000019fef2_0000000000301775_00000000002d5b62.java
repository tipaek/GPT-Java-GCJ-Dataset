import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();
            ProblemSolver solver = new ProblemSolver(targetX, targetY);
            solver.findSolution("", 0, 0, 1, 0);
            String solution = solver.getResult();
            
            if (solution == null) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + solution);
            }
        }
    }

    static class ProblemSolver {
        private static final int[] DX = { -1, 1, 0, 0 };
        private static final int[] DY = { 0, 0, 1, -1 };
        private static final List<String> DIRECTIONS = Arrays.asList("W", "E", "N", "S");
        
        private final int goalX;
        private final int goalY;
        private String result = null;

        public ProblemSolver(int x, int y) {
            this.goalX = x;
            this.goalY = y;
        }

        public String getResult() {
            return result;
        }

        public void findSolution(String path, int currentX, int currentY, int jumpIndex, int accumulatedCost) {
            if (goalX == currentX && goalY == currentY) {
                this.result = path;
                return;
            }
            if (accumulatedCost >= Math.abs(goalX) + Math.abs(goalY)) {
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int jumpDistance = calculateJumpDistance(jumpIndex);
                int nextX = currentX + DX[i] * jumpDistance;
                int nextY = currentY + DY[i] * jumpDistance;
                
                if (isMovePossible(nextX, nextY, jumpDistance)) {
                    findSolution(path + DIRECTIONS.get(i), nextX, nextY, jumpIndex + 1, accumulatedCost + jumpDistance);
                }
            }
        }

        private boolean isMovePossible(int nextX, int nextY, int jumpDistance) {
            int xDifference = Math.abs(nextX - goalX);
            int yDifference = Math.abs(nextY - goalY);
            
            if (xDifference == 0 && yDifference != 0) {
                return yDifference >= jumpDistance;
            } else if (xDifference != 0 && yDifference == 0) {
                return xDifference >= jumpDistance;
            } else if (xDifference == 0 && yDifference == 0) {
                return true;
            } else {
                return xDifference >= jumpDistance && yDifference >= jumpDistance;
            }
        }

        private int calculateJumpDistance(int index) {
            return 1 << (index - 1);
        }
    }
}