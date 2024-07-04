import java.util.Scanner;

public class Solution {

    private int t;
    private Scanner scanner;
    private int targetX;
    private int targetY;
    private final String[] directionStrings = { "N", "S", "E", "W" };
    private final int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    private String bestSolution = "";
    private boolean foundSolution = false;

    public Solution(int t, Scanner scanner) {
        this.t = t;
        this.scanner = scanner;
    }

    public void solve() {
        targetX = scanner.nextInt();
        targetY = scanner.nextInt();
        
        if (targetX % 2 == 1 && targetY % 2 == 1) {
            System.out.println("Case #" + t + ": IMPOSSIBLE");
            return;
        }

        StringBuilder solution = new StringBuilder();
        solveRecursive(solution, 0, 0, 0);
        
        if (!foundSolution) {
            bestSolution = "IMPOSSIBLE";
        }

        System.out.println("Case #" + t + ": " + bestSolution);
    }

    private void solveRecursive(StringBuilder solution, int currentX, int currentY, int depth) {
        if (depth == 4) {
            return;
        }

        if (currentX == targetX && currentY == targetY) {
            if (!foundSolution || solution.length() < bestSolution.length()) {
                bestSolution = solution.toString();
                foundSolution = true;
            }
            return;
        }

        for (int d = 0; d < 4; d++) {
            currentX += directions[d][0] * (1 << depth);
            currentY += directions[d][1] * (1 << depth);
            solution.append(directionStrings[d]);
            solveRecursive(solution, currentX, currentY, depth + 1);
            solution.setLength(solution.length() - 1);
            currentX -= directions[d][0] * (1 << depth);
            currentY -= directions[d][1] * (1 << depth);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            new Solution(i + 1, scanner).solve();
        }

        scanner.close();
    }
}