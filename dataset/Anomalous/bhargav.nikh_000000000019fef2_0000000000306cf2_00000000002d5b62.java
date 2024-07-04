import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        new Solution().processCases();
    }

    public void processCases() throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCases = Integer.parseInt(reader.readLine());
            for (int i = 1; i <= numberOfCases; i++) {
                handleCase(i, reader);
            }
        }
    }

    public void handleCase(int caseNumber, BufferedReader reader) throws Exception {
        String[] inputs = reader.readLine().split(" ");
        long x = Long.parseLong(inputs[0]);
        long y = Long.parseLong(inputs[1]);
        findSolution(caseNumber, x, y);
    }

    private boolean solutionFound;
    private String solution;

    public void findSolution(int caseNumber, long x, long y) {
        solutionFound = false;
        solution = "";

        if (!isBothEvenOrOdd(x, y)) {
            long maxSteps = (long) (Math.log(Math.abs(x) + Math.abs(y)) / Math.log(2)) + 1;
            explorePaths(0, 0, 0, x, y, maxSteps, new StringBuilder());
        }

        if (!solutionFound) {
            solution = "IMPOSSIBLE";
        }
        System.out.println("Case #" + caseNumber + ": " + solution);
    }

    private void explorePaths(long step, long currentX, long currentY, long targetX, long targetY, long maxSteps, StringBuilder path) {
        if (step > maxSteps || Math.abs(currentX) > Math.abs(targetX) || Math.abs(currentY) > Math.abs(targetY)) {
            return;
        }

        if (currentX == targetX && currentY == targetY) {
            solutionFound = true;
            solution = path.toString();
            return;
        }

        long value = 1L << step;

        exploreDirection(step, currentX, currentY + value, targetX, targetY, maxSteps, path, 'N');
        if (solutionFound) return;

        exploreDirection(step, currentX, currentY - value, targetX, targetY, maxSteps, path, 'S');
        if (solutionFound) return;

        exploreDirection(step, currentX + value, currentY, targetX, targetY, maxSteps, path, 'E');
        if (solutionFound) return;

        exploreDirection(step, currentX - value, currentY, targetX, targetY, maxSteps, path, 'W');
    }

    private void exploreDirection(long step, long newX, long newY, long targetX, long targetY, long maxSteps, StringBuilder path, char direction) {
        path.append(direction);
        explorePaths(step + 1, newX, newY, targetX, targetY, maxSteps, path);
        path.setLength(path.length() - 1);
    }

    private boolean isBothEvenOrOdd(long x, long y) {
        return (x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0);
    }
}