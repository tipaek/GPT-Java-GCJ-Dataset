import java.util.Scanner;

public class Solution {
    private static int solve(int rows, int cols, int[][] skills) {
        int result = 0;
        boolean eliminated = true;

        while (eliminated) {
            eliminated = false;
            int[][][] neighbors = new int[rows][cols][2];

            for (int r = 0; r < rows; r++) {
                int west = 0, east = 0;
                for (int c = 0; c < cols; c++) {
                    if (west > 0) {
                        neighbors[r][c][0]++;
                        neighbors[r][c][1] += west;
                    }
                    if (skills[r][c] > 0) west = skills[r][c];
                }
                for (int c = cols - 1; c >= 0; c--) {
                    if (east > 0) {
                        neighbors[r][c][0]++;
                        neighbors[r][c][1] += east;
                    }
                    if (skills[r][c] > 0) east = skills[r][c];
                }
            }

            for (int c = 0; c < cols; c++) {
                int north = 0, south = 0;
                for (int r = 0; r < rows; r++) {
                    if (north > 0) {
                        neighbors[r][c][0]++;
                        neighbors[r][c][1] += north;
                    }
                    if (skills[r][c] > 0) north = skills[r][c];
                }
                for (int r = rows - 1; r >= 0; r--) {
                    if (south > 0) {
                        neighbors[r][c][0]++;
                        neighbors[r][c][1] += south;
                    }
                    if (skills[r][c] > 0) south = skills[r][c];
                }
            }

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    result += skills[r][c];
                    if (neighbors[r][c][0] == 0 || skills[r][c] == 0) continue;
                    if (skills[r][c] * neighbors[r][c][0] < neighbors[r][c][1]) {
                        skills[r][c] = 0;
                        eliminated = true;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int R = scanner.nextInt();
            int C = scanner.nextInt();
            int[][] skills = new int[R][C];

            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    skills[r][c] = scanner.nextInt();
                }
            }

            int result = solve(R, C, skills);
            System.out.printf("Case #%d: %d\n", t, result);
        }

        scanner.close();
    }
}