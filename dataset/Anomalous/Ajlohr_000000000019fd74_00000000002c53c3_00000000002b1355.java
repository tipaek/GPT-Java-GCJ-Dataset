import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int cc = 1; cc <= t; ++cc) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int[][] floor = new int[r][c];
            int[][][] emptySpotsInDirection = new int[4][r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    floor[i][j] = scanner.nextInt();
                }
            }

            long totalInterest = 0;
            long currentInterest = sumAll(floor);
            boolean changed = true;
            Set<IntPair> checkThese = new HashSet<>();

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    checkThese.add(new IntPair(i, j));
                }
            }

            while (changed) {
                changed = false;
                totalInterest += currentInterest;
                Set<IntPair> newCheckThese = new HashSet<>();
                Set<IntPair> changedPositions = new HashSet<>();

                for (IntPair pair : checkThese) {
                    int i = pair.a;
                    int j = pair.b;
                    if (floor[i][j] != 0 && checkIfOut(i, j, floor, emptySpotsInDirection)) {
                        changed = true;
                        newCheckThese.addAll(neighbors(i, j, floor, emptySpotsInDirection));
                        changedPositions.add(pair);
                        currentInterest -= floor[i][j];
                    }
                }

                for (IntPair pair : changedPositions) {
                    floor[pair.a][pair.b] = 0;
                }

                checkThese = newCheckThese;
            }

            System.out.println("Case #" + cc + ": " + totalInterest);
        }
    }

    public static class IntPair {
        public int a;
        public int b;

        public IntPair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof IntPair) {
                IntPair pair = (IntPair) o;
                return pair.a == a && pair.b == b;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    public static long sumAll(int[][] floor) {
        long sum = 0;
        for (int[] row : floor) {
            for (int value : row) {
                sum += value;
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

        return (floor[x][y] * count < sum);
    }

    public static Set<IntPair> neighbors(int x, int y, int[][] floor, int[][][] emptySpotsInDirection) {
        Set<IntPair> neighbors = new HashSet<>();

        for (int i = x - emptySpotsInDirection[0][x][y] - 1; i >= 0; i--) {
            if (floor[i][y] != 0) {
                neighbors.add(new IntPair(i, y));
                emptySpotsInDirection[0][x][y] = x - i - 1;
                break;
            }
            if (i == 0) {
                emptySpotsInDirection[0][x][y] = x;
            }
        }

        for (int i = x + 1 + emptySpotsInDirection[1][x][y]; i < floor.length; i++) {
            if (floor[i][y] != 0) {
                neighbors.add(new IntPair(i, y));
                emptySpotsInDirection[1][x][y] = i - x - 1;
                break;
            }
            if (i == floor.length - 1) {
                emptySpotsInDirection[1][x][y] = floor.length - x - 1;
            }
        }

        for (int j = y - 1 - emptySpotsInDirection[2][x][y]; j >= 0; j--) {
            if (floor[x][j] != 0) {
                neighbors.add(new IntPair(x, j));
                emptySpotsInDirection[2][x][y] = y - j - 1;
                break;
            }
            if (j == 0) {
                emptySpotsInDirection[2][x][y] = y;
            }
        }

        for (int j = y + 1 + emptySpotsInDirection[3][x][y]; j < floor[0].length; j++) {
            if (floor[x][j] != 0) {
                neighbors.add(new IntPair(x, j));
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