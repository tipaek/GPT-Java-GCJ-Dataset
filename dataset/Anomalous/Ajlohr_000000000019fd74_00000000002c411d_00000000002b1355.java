import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int caseNum = 1; caseNum <= t; ++caseNum) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] floor = new int[rows][cols];
            emptySpotsInDirection = new int[4][rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    floor[i][j] = scanner.nextInt();
                }
            }

            long totalInterest = 0;
            boolean changed = true;
            Set<Pair> toCheck = new HashSet<>();

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    toCheck.add(new Pair(i, j));
                }
            }

            while (changed) {
                changed = false;
                totalInterest += sumAll(floor);
                Set<Pair> newToCheck = new HashSet<>();
                Set<Pair> changedPositions = new HashSet<>();

                for (Pair pair : toCheck) {
                    int i = pair.x;
                    int j = pair.y;
                    if (floor[i][j] != 0 && shouldRemove(i, j, floor)) {
                        changed = true;
                        newToCheck.addAll(getNeighbors(i, j, floor));
                        changedPositions.add(pair);
                    }
                }

                for (Pair pair : changedPositions) {
                    floor[pair.x][pair.y] = 0;
                }

                toCheck = newToCheck;
            }

            System.out.println("Case #" + caseNum + ": " + totalInterest);
        }
    }

    public static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static long sumAll(int[][] floor) {
        long sum = 0;
        for (int[] row : floor) {
            for (int value : row) {
                sum += value;
            }
        }
        return sum;
    }

    private static int[][][] emptySpotsInDirection;

    private static boolean shouldRemove(int x, int y, int[][] floor) {
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

    private static Set<Pair> getNeighbors(int x, int y, int[][] floor) {
        Set<Pair> neighbors = new HashSet<>();

        for (int i = x - emptySpotsInDirection[0][x][y] - 1; i >= 0; i--) {
            if (floor[i][y] != 0) {
                neighbors.add(new Pair(i, y));
                emptySpotsInDirection[0][x][y] = x - i - 1;
                break;
            }
            if (i == 0) {
                emptySpotsInDirection[0][x][y] = x;
            }
        }

        for (int i = x + 1 + emptySpotsInDirection[1][x][y]; i < floor.length; i++) {
            if (floor[i][y] != 0) {
                neighbors.add(new Pair(i, y));
                emptySpotsInDirection[1][x][y] = i - x - 1;
                break;
            }
            if (i == floor.length - 1) {
                emptySpotsInDirection[1][x][y] = floor.length - x - 1;
            }
        }

        for (int j = y - 1 - emptySpotsInDirection[2][x][y]; j >= 0; j--) {
            if (floor[x][j] != 0) {
                neighbors.add(new Pair(x, j));
                emptySpotsInDirection[2][x][y] = y - j - 1;
                break;
            }
            if (j == 0) {
                emptySpotsInDirection[2][x][y] = y;
            }
        }

        for (int j = y + 1 + emptySpotsInDirection[3][x][y]; j < floor[0].length; j++) {
            if (floor[x][j] != 0) {
                neighbors.add(new Pair(x, j));
                emptySpotsInDirection[3][x][y] = j - y - 1;
                break;
            }
            if (j == floor[0].length - 1) {
                emptySpotsInDirection[3][x][y] = floor[0].length - y - 1;
            }
        }

        return neighbors;
    }
}