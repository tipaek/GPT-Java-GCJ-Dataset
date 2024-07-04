import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        
        for (int testCase = 1; testCase <= t; ++testCase) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] floor = new int[rows][cols];
            int[][][] emptySpotsInDirection = new int[4][rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    floor[i][j] = scanner.nextInt();
                }
            }

            long totalInterest = 0;
            boolean changed = true;

            while (changed) {
                changed = false;
                totalInterest += sumAll(floor);
                int[][] newFloor = new int[rows][cols];

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (floor[i][j] != 0 && checkIfOut(i, j, floor, emptySpotsInDirection)) {
                            changed = true;
                        } else {
                            newFloor[i][j] = floor[i][j];
                        }
                    }
                }
                floor = newFloor;
            }

            System.out.println("Case #" + testCase + ": " + totalInterest);
        }
    }

    public static long sumAll(int[][] floor) {
        long sum = 0;
        for (int[] row : floor) {
            for (int cell : row) {
                sum += cell;
            }
        }
        return sum;
    }

    public static boolean checkIfOut(int x, int y, int[][] floor, int[][][] emptySpotsInDirection) {
        int sum = 0;
        int count = 0;

        for (int i = x - emptySpotsInDirection[0][x][y] - 1; i >= 0; i--) {
            if (floor[i][y] != 0) {
                sum += floor[i][y];
                count++;
                emptySpotsInDirection[0][x][y] = x - i - 1;
                break;
            }
            if (i == 0) {
                emptySpotsInDirection[0][x][y] = x;
            }
        }

        for (int i = x + 1 + emptySpotsInDirection[1][x][y]; i < floor.length; i++) {
            if (floor[i][y] != 0) {
                sum += floor[i][y];
                count++;
                emptySpotsInDirection[1][x][y] = i - x - 1;
                break;
            }
            if (i == floor.length - 1) {
                emptySpotsInDirection[1][x][y] = floor.length - x - 1;
            }
        }

        for (int j = y - 1 - emptySpotsInDirection[2][x][y]; j >= 0; j--) {
            if (floor[x][j] != 0) {
                sum += floor[x][j];
                count++;
                emptySpotsInDirection[2][x][y] = y - j - 1;
                break;
            }
            if (j == 0) {
                emptySpotsInDirection[2][x][y] = y;
            }
        }

        for (int j = y + 1 + emptySpotsInDirection[3][x][y]; j < floor[0].length; j++) {
            if (floor[x][j] != 0) {
                sum += floor[x][j];
                count++;
                emptySpotsInDirection[3][x][y] = j - y - 1;
                break;
            }
            if (j == floor[0].length - 1) {
                emptySpotsInDirection[3][x][y] = floor[0].length - y - 1;
            }
        }

        return floor[x][y] * count < sum;
    }
}