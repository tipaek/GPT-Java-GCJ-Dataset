import java.util.HashSet;
import java.util.Scanner;

class Solution {
    static HashSet<String> possiblePaths = new HashSet<>();

    static void generateAllPaths(char[] directions, int length) {
        generatePathsRecursively(directions, "", directions.length, length);
    }

    static void generatePathsRecursively(char[] directions, String currentPath, int totalDirections, int remainingLength) {
        if (remainingLength == 0) {
            possiblePaths.add(currentPath);
            return;
        }

        for (int i = 0; i < totalDirections; ++i) {
            String newPath = currentPath + directions[i];
            generatePathsRecursively(directions, newPath, totalDirections, remainingLength - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();
            char[] directions = {'N', 'S', 'E', 'W'};
            String result = "IMPOSSIBLE";

            outerLoop:
            for (int length = 1; length < 5; length++) {
                generateAllPaths(directions, length);

                for (String path : possiblePaths) {
                    if (isValidPath(path.toCharArray(), targetX, targetY)) {
                        result = path;
                        break outerLoop;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }

        scanner.close();
    }

    private static boolean isValidPath(char[] path, int targetX, int targetY) {
        int currentX = 0, currentY = 0;
        int stepValue = 1;

        for (char direction : path) {
            switch (direction) {
                case 'N': currentY += stepValue; break;
                case 'S': currentY -= stepValue; break;
                case 'E': currentX += stepValue; break;
                case 'W': currentX -= stepValue; break;
            }
            stepValue *= 2;
        }

        return currentX == targetY && currentY == targetX;
    }
}