import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static int solve(int rows, int cols, int[][] skills) {
        int result = 0;

        int[][] east = new int[rows][cols];
        int[][] west = new int[rows][cols];
        int[][] south = new int[rows][cols];
        int[][] north = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            Arrays.fill(east[r], 1);
            east[r][0] = 0;
            Arrays.fill(west[r], 1);
            west[r][cols - 1] = 0;
            Arrays.fill(south[r], 1);
            Arrays.fill(north[r], 1);
        }

        Arrays.fill(north[0], 0);
        Arrays.fill(south[rows - 1], 0);

        boolean eliminated = true;

        while (eliminated) {
            eliminated = false;
            int[][] nextSkills = new int[rows][cols];

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (skills[r][c] == 0) continue;
                    result += skills[r][c];

                    int nSum = 0;
                    int nCount = 0;

                    if (east[r][c] > 0) {
                        nCount++;
                        nSum += skills[r][c - east[r][c]];
                    }
                    if (west[r][c] > 0) {
                        nCount++;
                        nSum += skills[r][c + west[r][c]];
                    }
                    if (north[r][c] > 0) {
                        nCount++;
                        nSum += skills[r - north[r][c]][c];
                    }
                    if (south[r][c] > 0) {
                        nCount++;
                        nSum += skills[r + south[r][c]][c];
                    }

                    if (skills[r][c] * nCount >= nSum) {
                        nextSkills[r][c] = skills[r][c];
                    } else {
                        eliminated = true;
                    }
                }
            }

            skills = nextSkills;

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (skills[r][c] == 0) continue;
                    while (east[r][c] > 0 && skills[r][c - east[r][c]] == 0) {
                        if (c == east[r][c]) {
                            east[r][c] = 0;
                            break;
                        }
                        east[r][c]++;
                    }
                    while (west[r][c] > 0 && skills[r][c + west[r][c]] == 0) {
                        if (c + west[r][c] == cols - 1) {
                            west[r][c] = 0;
                            break;
                        }
                        west[r][c]++;
                    }
                    while (north[r][c] > 0 && skills[r - north[r][c]][c] == 0) {
                        if (c == north[r][c]) {
                            north[r][c] = 0;
                            break;
                        }
                        north[r][c]++;
                    }
                    while (south[r][c] > 0 && skills[r + south[r][c]][c] == 0) {
                        if (c + south[r][c] == cols - 1) {
                            south[r][c] = 0;
                            break;
                        }
                        south[r][c]++;
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
    }
}