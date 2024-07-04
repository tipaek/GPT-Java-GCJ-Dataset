import java.util.*;

class Solution {
    private static int targetX = -1, targetY = -1;
    private static int[] powersOfTwo;
    private static Map<Integer, String> directionMap;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            directionMap = new HashMap<>();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int maxDistance = Math.max(Math.abs(x), Math.abs(y));
            powersOfTwo = new int[maxDistance];

            for (int i = 0; i < maxDistance; i++) {
                powersOfTwo[i] = 1 << i;
            }

            targetX = x;
            targetY = y;

            int minimumMoves = findMinimumMoves(0, 0, "", 0, maxDistance);

            if (directionMap.containsKey(minimumMoves)) {
                System.out.println("Case #" + caseNumber + ": " + directionMap.get(minimumMoves));
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }

            caseNumber++;
        }
    }

    private static int findMinimumMoves(int currentX, int currentY, String path, int moveCount, int maxMoves) {
        if (currentX == targetX && currentY == targetY) {
            directionMap.put(moveCount, path);
            return moveCount;
        }

        if (moveCount >= maxMoves) {
            return moveCount;
        }

        return Math.min(
            findMinimumMoves(currentX + powersOfTwo[moveCount], currentY, path + "E", moveCount + 1, maxMoves),
            Math.min(
                findMinimumMoves(currentX - powersOfTwo[moveCount], currentY, path + "W", moveCount + 1, maxMoves),
                Math.min(
                    findMinimumMoves(currentX, currentY + powersOfTwo[moveCount], path + "N", moveCount + 1, maxMoves),
                    findMinimumMoves(currentX, currentY - powersOfTwo[moveCount], path + "S", moveCount + 1, maxMoves)
                )
            )
        );
    }
}