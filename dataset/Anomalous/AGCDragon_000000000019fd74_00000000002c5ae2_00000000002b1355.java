import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int totalInitialSum = 0;
            int[][] floor = new int[rows][cols];

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    floor[row][col] = scanner.nextInt();
                    totalInitialSum += floor[row][col];
                }
            }

            int eliminations;
            int totalRemainingSum = 0;

            do {
                int[][] newFloor = new int[rows][cols];
                eliminations = 0;
                totalRemainingSum = 0;

                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        if (floor[row][col] != 0) {
                            if (floor[row][col] < calculateAverage(row, col, floor)) {
                                eliminations++;
                                newFloor[row][col] = 0;
                            } else {
                                totalRemainingSum += floor[row][col];
                                newFloor[row][col] = floor[row][col];
                            }
                        } else {
                            newFloor[row][col] = 0;
                        }
                    }
                }

                totalInitialSum += totalRemainingSum;
                floor = newFloor;
            } while (eliminations != 0);

            System.out.println("Case #" + testCase + ": " + totalInitialSum);
        }
    }

    private static double calculateAverage(int row, int col, int[][] floor) {
        int sum = 0;
        int count = 0;

        for (int i = 1; i < 1000; i++) {
            if (row - i >= 0 && floor[row - i][col] != 0) {
                sum += floor[row - i][col];
                count++;
                break;
            }
        }

        for (int i = 1; i < 1000; i++) {
            if (row + i < floor.length && floor[row + i][col] != 0) {
                sum += floor[row + i][col];
                count++;
                break;
            }
        }

        for (int i = 1; i < 1000; i++) {
            if (col - i >= 0 && floor[row][col - i] != 0) {
                sum += floor[row][col - i];
                count++;
                break;
            }
        }

        for (int i = 1; i < 1000; i++) {
            if (col + i < floor[0].length && floor[row][col + i] != 0) {
                sum += floor[row][col + i];
                count++;
                break;
            }
        }

        return count > 0 ? (double) sum / count : 0;
    }
}