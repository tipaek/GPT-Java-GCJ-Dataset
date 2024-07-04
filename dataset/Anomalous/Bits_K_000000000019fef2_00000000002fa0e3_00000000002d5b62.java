import java.util.*;

class Solution {
    private static int targetX = -1, targetY = -1;
    private static int[] powersOfTwo;
    private static final Map<Integer, String> movesMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int maxAbsValue = Math.max(Math.abs(x), Math.abs(y));
            powersOfTwo = new int[maxAbsValue];

            for (int i = 0; i < maxAbsValue; i++) {
                powersOfTwo[i] = 1 << i;
            }

            targetX = x;
            targetY = y;

            if (Math.abs(x) == Math.abs(y)) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                int minMoves = calculateMinMoves(0, 0, "", 0, maxAbsValue);
                String result = movesMap.get(minMoves);
                if (result != null) {
                    System.out.println("Case #" + caseNumber + ": " + result);
                } else {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                }
            }
            caseNumber++;
        }
        scanner.close();
    }

    private static int calculateMinMoves(int x, int y, String path, int step, int maxSteps) {
        if (x == targetX && y == targetY) {
            movesMap.put(step, path);
            return step;
        }
        if (step >= maxSteps) {
            return step;
        }

        int moveEast = calculateMinMoves(x + powersOfTwo[step], y, path + "E", step + 1, maxSteps);
        int moveWest = calculateMinMoves(x - powersOfTwo[step], y, path + "W", step + 1, maxSteps);
        int moveNorth = calculateMinMoves(x, y + powersOfTwo[step], path + "N", step + 1, maxSteps);
        int moveSouth = calculateMinMoves(x, y - powersOfTwo[step], path + "S", step + 1, maxSteps);

        return Math.min(moveEast, Math.min(moveWest, Math.min(moveNorth, moveSouth)));
    }
}