import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] floor = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    floor[i][j] = scanner.nextInt();
                }
            }

            long totalInterest = 0;
            boolean hasChanged = true;

            while (hasChanged) {
                hasChanged = false;
                totalInterest += calculateSum(floor);
                int[][] newFloor = new int[rows][cols];

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (floor[i][j] != 0 && shouldBeEliminated(i, j, floor)) {
                            hasChanged = true;
                        } else {
                            newFloor[i][j] = floor[i][j];
                        }
                    }
                }
                floor = newFloor;
            }

            System.out.println("Case #" + caseNumber + ": " + totalInterest);
        }
    }

    private static long calculateSum(int[][] floor) {
        long sum = 0;
        for (int[] row : floor) {
            for (int value : row) {
                sum += value;
            }
        }
        return sum;
    }

    private static boolean shouldBeEliminated(int x, int y, int[][] floor) {
        int sum = 0;
        int count = 0;

        // Check upward
        for (int i = x - 1; i >= 0; i--) {
            if (floor[i][y] != 0) {
                sum += floor[i][y];
                count++;
                break;
            }
        }

        // Check downward
        for (int i = x + 1; i < floor.length; i++) {
            if (floor[i][y] != 0) {
                sum += floor[i][y];
                count++;
                break;
            }
        }

        // Check leftward
        for (int j = y - 1; j >= 0; j--) {
            if (floor[x][j] != 0) {
                sum += floor[x][j];
                count++;
                break;
            }
        }

        // Check rightward
        for (int j = y + 1; j < floor[0].length; j++) {
            if (floor[x][j] != 0) {
                sum += floor[x][j];
                count++;
                break;
            }
        }

        return floor[x][y] * count < sum;
    }
}