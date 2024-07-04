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
            solver.solvePath("", 0, 0, 1, 0);
            String result = solver.getResult();
            if (result == null) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + result);
            }
        }
    }
}

class ProblemSolver {
    private static final int[] DX = { -1, 1, 0, 0 };
    private static final int[] DY = { 0, 0, 1, -1 };
    private static final List<String> DIRECTIONS = Arrays.asList("W", "E", "N", "S");
    
    private final int goalX;
    private final int goalY;
    private String result;

    public ProblemSolver(int x, int y) {
        this.goalX = x;
        this.goalY = y;
        this.result = null;
    }

    public void solvePath(String currentPath, int currentX, int currentY, int jump, int accumulatedCost) {
        if (currentX == goalX && currentY == goalY) {
            this.result = currentPath;
            return;
        }
        if (accumulatedCost >= Math.abs(goalX) + Math.abs(goalY)) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int jumpDistance = calculateJumpDistance(jump);
            int nextX = currentX + DX[i] * jumpDistance;
            int nextY = currentY + DY[i] * jumpDistance;
            if (isWithinBounds(nextX, nextY)) {
                solvePath(currentPath + DIRECTIONS.get(i), nextX, nextY, jump + 1, accumulatedCost + jumpDistance);
            }
        }
    }

    private boolean isWithinBounds(int x, int y) {
        return Math.abs(x) <= Math.abs(goalX) && Math.abs(y) <= Math.abs(goalY);
    }

    private int calculateJumpDistance(int jump) {
        return 1 << (jump - 1);
    }

    public String getResult() {
        return result;
    }
}