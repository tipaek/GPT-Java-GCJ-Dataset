import java.util.*;

class Solution {
    static int targetX = -1, targetY = -1;
    static int[] powersOfTwo;
    static Map<Integer, String> directionsMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int maxAbsCoordinate = Math.max(Math.abs(x), Math.abs(y));
            powersOfTwo = new int[maxAbsCoordinate];

            for (int i = 0; i < maxAbsCoordinate; i++) {
                powersOfTwo[i] = 1 << i;
            }

            targetX = x;
            targetY = y;

            int minimumMoves = findMinimumMoves(0, 0, "", 0, maxAbsCoordinate);

            if (directionsMap.containsKey(minimumMoves)) {
                System.out.println("Case #" + caseNumber + ": " + directionsMap.get(minimumMoves));
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }

            caseNumber++;
        }

        scanner.close();
    }

    static int findMinimumMoves(int currentX, int currentY, String directionPath, int moveCount, int maxMoves) {
        if (currentX == targetX && currentY == targetY) {
            directionsMap.put(moveCount, directionPath);
            return moveCount;
        }

        if (moveCount >= maxMoves) {
            return moveCount;
        }

        return Math.min(
                findMinimumMoves(currentX + powersOfTwo[moveCount], currentY, directionPath + "E", moveCount + 1, maxMoves),
                Math.min(
                        findMinimumMoves(currentX - powersOfTwo[moveCount], currentY, directionPath + "W", moveCount + 1, maxMoves),
                        Math.min(
                                findMinimumMoves(currentX, currentY + powersOfTwo[moveCount], directionPath + "N", moveCount + 1, maxMoves),
                                findMinimumMoves(currentX, currentY - powersOfTwo[moveCount], directionPath + "S", moveCount + 1, maxMoves)
                        )
                )
        );
    }
}