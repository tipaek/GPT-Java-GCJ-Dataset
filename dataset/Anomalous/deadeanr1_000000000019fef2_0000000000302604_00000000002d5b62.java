import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

    static char[] path;
    static String result;
    static int minSteps;
    static boolean foundSolution;
    static int targetX, targetY;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            path = new char[35];
            foundSolution = false;
            minSteps = 100;
            targetX = scanner.nextInt();
            targetY = scanner.nextInt();

            System.out.print("Case #" + i + ": ");
            findPath(0, 0, 0);

            if (!foundSolution) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    static boolean findPath(int currentX, int currentY, int step) {
        if (currentX == targetX && currentY == targetY) {
            foundSolution = true;
            if (minSteps > step) {
                result = new String(path, 0, step);
                minSteps = step;
            }
        }

        if (foundSolution && minSteps <= step) {
            return true;
        }

        int limit = 1 << Math.max(10, step - 2);

        if (step > 33 || 
            Math.abs(currentY) >= Math.max(limit, Math.abs(targetY)) || 
            Math.abs(currentY - targetY) > Math.max(limit, Math.abs(targetY + currentY)) ||
            Math.abs(currentX) >= Math.max(limit, Math.abs(targetX)) || 
            Math.abs(currentX - targetX) > Math.max(limit, Math.abs(targetX + currentX))) {
            return false;
        }

        path[step] = 'N';
        findPath(currentX, currentY + (1 << step), step + 1);
        path[step] = 'S';
        findPath(currentX, currentY - (1 << step), step + 1);
        path[step] = 'W';
        findPath(currentX - (1 << step), currentY, step + 1);
        path[step] = 'E';
        findPath(currentX + (1 << step), currentY, step + 1);

        if (step == 0 && foundSolution) {
            System.out.println(result);
        }

        return false;
    }
}