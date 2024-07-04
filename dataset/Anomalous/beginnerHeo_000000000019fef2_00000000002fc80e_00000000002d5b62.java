import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Problem problem = new Problem(x, y);
            problem.solve("", 0, 0, 1, 0);
            String result = problem.getResult();
            
            if (result == null) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + result);
            }
        }
    }
}

class Problem {
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

    public void solve(String path, int currentX, int currentY, int jumpIndex, int accumulatedCost) {
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
            
            StringBuilder nextPath = new StringBuilder(path);
            nextPath.append(DIRECTIONS.get(i));
            solve(nextPath.toString(), nextX, nextY, jumpIndex + 1, accumulatedCost + jumpDistance);
        }
    }

    public String getResult() {
        return result;
    }

    private int calculateJumpDistance(int index) {
        return 1 << (index - 1);
    }
}