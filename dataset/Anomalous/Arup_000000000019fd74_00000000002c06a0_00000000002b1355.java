import java.util.Scanner;

public class Solution {

    private static final int[] DX = {-1, 0, 0, 1};
    private static final int[] DY = {0, -1, 1, 0};

    private static int nR;
    private static int nC;
    private static int[][] grid;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numCases; caseNumber++) {
            nR = scanner.nextInt();
            nC = scanner.nextInt();
            grid = new int[nR][nC];

            long currentSum = 0;
            for (int i = 0; i < nR; i++) {
                for (int j = 0; j < nC; j++) {
                    grid[i][j] = scanner.nextInt();
                    currentSum += grid[i][j];
                }
            }

            long result = currentSum;

            while (true) {
                long removedSum = removeElements();

                if (removedSum == 0) {
                    break;
                }

                currentSum -= removedSum;
                result += currentSum;
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static long removeElements() {
        int[][] tempGrid = new int[nR][nC];
        long removalCost = 0;

        for (int i = 0; i < nR; i++) {
            for (int j = 0; j < nC; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                int neighborSum = 0, neighborCount = 0;
                for (int direction = 0; direction < 4; direction++) {
                    int neighborValue = getNeighborValue(i, j, direction);
                    if (neighborValue != -1) {
                        neighborCount++;
                        neighborSum += neighborValue;
                    }
                }

                if (neighborCount * grid[i][j] < neighborSum) {
                    removalCost += grid[i][j];
                } else {
                    tempGrid[i][j] = grid[i][j];
                }
            }
        }

        grid = tempGrid;
        return removalCost;
    }

    private static int getNeighborValue(int x, int y, int direction) {
        int newX = x + DX[direction];
        int newY = y + DY[direction];

        if (!isInBounds(newX, newY)) {
            return -1;
        }

        while (true) {
            if (grid[newX][newY] != 0) {
                return grid[newX][newY];
            }
            newX += DX[direction];
            newY += DY[direction];

            if (!isInBounds(newX, newY)) {
                return -1;
            }
        }
    }

    private static boolean isInBounds(int x, int y) {
        return x >= 0 && x < nR && y >= 0 && y < nC;
    }
}