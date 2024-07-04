import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        new Solution().processCases();
    }

    public void processCases() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCases = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= numberOfCases; i++) {
            processCase(i, reader);
        }
    }

    public void processCase(int caseNumber, BufferedReader reader) throws Exception {
        String[] input = reader.readLine().split(" ");
        long x = Long.parseLong(input[0]);
        long y = Long.parseLong(input[1]);
        findSolution(caseNumber, x, y);
    }

    private boolean solutionFound;
    private String solution;

    public void findSolution(int caseNumber, long x, long y) {
        solutionFound = false;
        solution = "";

        if (!areBothEvenOrOdd(x, y)) {
            long maxSteps = (long) Math.ceil(logBase2(Math.abs(x) + Math.abs(y))) + 1;
            searchPath(0, 0, 0, x, y, maxSteps, new StringBuilder());
        }

        if (!solutionFound) {
            solution = "IMPOSSIBLE";
        }
        System.out.println("Case #" + caseNumber + ": " + solution);
    }

    private void searchPath(long step, long currentX, long currentY, long targetX, long targetY, long maxSteps, StringBuilder path) {
        if (step > maxSteps) {
            return;
        }

        if (currentX == targetX && currentY == targetY) {
            solutionFound = true;
            solution = path.toString();
            return;
        }

        long moveDistance = 1L << step;

        path.append('N');
        searchPath(step + 1, currentX, currentY + moveDistance, targetX, targetY, maxSteps, path);
        path.setLength(path.length() - 1);
        if (solutionFound) return;

        path.append('S');
        searchPath(step + 1, currentX, currentY - moveDistance, targetX, targetY, maxSteps, path);
        path.setLength(path.length() - 1);
        if (solutionFound) return;

        path.append('E');
        searchPath(step + 1, currentX + moveDistance, currentY, targetX, targetY, maxSteps, path);
        path.setLength(path.length() - 1);
        if (solutionFound) return;

        path.append('W');
        searchPath(step + 1, currentX - moveDistance, currentY, targetX, targetY, maxSteps, path);
        path.setLength(path.length() - 1);
    }

    private boolean areBothEvenOrOdd(long x, long y) {
        return (x % 2 == y % 2);
    }

    private double logBase2(long value) {
        return Math.log(value) / Math.log(2);
    }
}