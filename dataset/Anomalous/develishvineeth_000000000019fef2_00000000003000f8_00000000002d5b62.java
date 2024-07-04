import java.util.*;

class Solution {
    static HashSet<String> possibleCombinations = new HashSet<>();

    static void generateAllCombinations(char[] set, int length) {
        int n = set.length;
        generateCombinationsRecursively(set, "", n, length);
    }

    static void generateCombinationsRecursively(char[] set, String prefix, int n, int length) {
        if (length == 0) {
            possibleCombinations.add(prefix);
            return;
        }

        for (int i = 0; i < n; ++i) {
            String newPrefix = prefix + set[i];
            generateCombinationsRecursively(set, newPrefix, n, length - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            possibleCombinations.clear();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            char[] directions = {'N', 'S', 'E', 'W'};
            String result = "IMPOSSIBLE";

            outerLoop: 
            for (int k = 1; k < 7; k++) {
                generateAllCombinations(directions, k);

                for (String combination : possibleCombinations) {
                    if (isValidPath(combination.toCharArray(), x, y)) {
                        result = combination;
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
        long stepValue = 1;

        for (char direction : path) {
            switch (direction) {
                case 'N': currentY += stepValue; break;
                case 'S': currentY -= stepValue; break;
                case 'E': currentX += stepValue; break;
                case 'W': currentX -= stepValue; break;
            }
            stepValue *= 2;
        }

        return currentX == targetX && currentY == targetY;
    }
}