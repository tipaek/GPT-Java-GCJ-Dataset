import java.util.HashSet;
import java.util.Scanner;

class Solution {
    static HashSet<String> hs = new HashSet<>();

    static void findAllPossible(char[] set, int k) {
        int n = set.length;
        generateCombinations(set, "", n, k);
    }

    static void generateCombinations(char[] set, String prefix, int n, int k) {
        if (k == 0) {
            hs.add(prefix);
            return;
        }

        for (int i = 0; i < n; ++i) {
            String newPrefix = prefix + set[i];
            generateCombinations(set, newPrefix, n, k - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            char[] directions = {'N', 'S', 'E', 'W'};
            String result = "IMPOSSIBLE";

            outerLoop:
            for (int k = 1; k < 5; k++) {
                findAllPossible(directions, k);

                for (String str : hs) {
                    if (isValidPath(str.toCharArray(), x, y)) {
                        result = str;
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
        int currX = 0, currY = 0;
        int stepValue = 1;

        for (char direction : path) {
            switch (direction) {
                case 'N':
                    currY += stepValue;
                    break;
                case 'S':
                    currY -= stepValue;
                    break;
                case 'E':
                    currX += stepValue;
                    break;
                case 'W':
                    currX -= stepValue;
                    break;
            }
            stepValue *= 2;
        }

        return currX == targetX && currY == targetY;
    }
}