import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            System.out.printf("Case #%d: ", t);
            solve(scanner);
        }

        scanner.close();
    }

    private static void solve(Scanner scanner) {
        final int[] dx = {0, 1, 0, -1};
        final int[] dy = {1, 0, -1, 0};

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        long[][] grid = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = scanner.nextLong();
            }
        }

        long totalSum = 0;
        boolean hasUpdates = true;
        int[][][] directionCheck = new int[rows][cols][4];

        while (hasUpdates) {
            hasUpdates = false;
            long[][] nextGrid = new long[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 0) continue;

                    totalSum += grid[i][j];
                    long neighborCount = 0;
                    long neighborSum = 0;

                    for (int d = 0; d < 4; d++) {
                        int ny = i + dy[d] * directionCheck[i][j][d];
                        int nx = j + dx[d] * directionCheck[i][j][d];

                        while (true) {
                            ny += dy[d];
                            nx += dx[d];

                            if (ny < 0 || ny >= rows || nx < 0 || nx >= cols) {
                                break;
                            }

                            if (grid[ny][nx] > 0) {
                                neighborCount++;
                                neighborSum += grid[ny][nx];
                                break;
                            }

                            directionCheck[i][j][d]++;
                        }
                    }

                    if (neighborSum >= 1 && grid[i][j] * neighborCount < neighborSum) {
                        hasUpdates = true;
                    } else {
                        nextGrid[i][j] = grid[i][j];
                    }
                }
            }

            grid = nextGrid;
        }

        System.out.println(totalSum);
    }
}