import java.io.*;
import java.util.*;

public class Solution {
    private static final int MAX_POWERS = 32;
    private static final int MAX_COORDINATE = 100;
    private static long[] powers;
    private static boolean found;
    private static int caseNumber = 1;
    private static int minSteps;
    private static ArrayList<Character> resultPath;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        initializePowers();

        while (testCases-- > 0) {
            long targetX = scanner.nextLong();
            long targetY = scanner.nextLong();
            found = false;
            resultPath = new ArrayList<>();
            minSteps = Integer.MAX_VALUE;
            ArrayList<Character> currentPath = new ArrayList<>();

            findPath(0, 0, targetX, targetY, 0, currentPath);

            if (!found) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + caseNumber + ": ");
                for (char direction : resultPath) {
                    System.out.print(direction);
                }
                System.out.println();
            }
            caseNumber++;
        }
    }

    private static void initializePowers() {
        powers = new long[MAX_POWERS];
        powers[0] = 1;
        for (int i = 1; i < MAX_POWERS; i++) {
            powers[i] = 2 * powers[i - 1];
        }
    }

    private static void findPath(long currentX, long currentY, long targetX, long targetY, int step, ArrayList<Character> currentPath) {
        if (currentX == targetX && currentY == targetY) {
            if (minSteps > currentPath.size()) {
                found = true;
                resultPath = new ArrayList<>(currentPath);
                minSteps = currentPath.size();
            }
            return;
        }

        if (Math.abs(currentX) > MAX_COORDINATE || Math.abs(currentY) > MAX_COORDINATE || step >= MAX_POWERS) {
            return;
        }

        currentPath.add('E');
        findPath(currentX + powers[step], currentY, targetX, targetY, step + 1, currentPath);
        currentPath.remove(currentPath.size() - 1);

        currentPath.add('W');
        findPath(currentX - powers[step], currentY, targetX, targetY, step + 1, currentPath);
        currentPath.remove(currentPath.size() - 1);

        currentPath.add('S');
        findPath(currentX, currentY - powers[step], targetX, targetY, step + 1, currentPath);
        currentPath.remove(currentPath.size() - 1);

        currentPath.add('N');
        findPath(currentX, currentY + powers[step], targetX, targetY, step + 1, currentPath);
        currentPath.remove(currentPath.size() - 1);
    }
}