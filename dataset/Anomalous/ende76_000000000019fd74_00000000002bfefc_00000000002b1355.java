import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static int calculateTotalSkill(int rows, int cols, int[][] skills) {
        int totalSkill = 0;

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

        boolean hasEliminated = true;

        while (hasEliminated) {
            hasEliminated = false;

            int[][] nextSkills = new int[rows][cols];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (skills[r][c] == 0) continue;
                    totalSkill += skills[r][c];

                    int neighborSum = 0;
                    int neighborCount = 0;

                    if (east[r][c] > 0) {
                        neighborCount++;
                        neighborSum += skills[r][c - east[r][c]];
                    }
                    if (west[r][c] > 0) {
                        neighborCount++;
                        neighborSum += skills[r][c + west[r][c]];
                    }
                    if (north[r][c] > 0) {
                        neighborCount++;
                        neighborSum += skills[r - north[r][c]][c];
                    }
                    if (south[r][c] > 0) {
                        neighborCount++;
                        neighborSum += skills[r + south[r][c]][c];
                    }

                    if (skills[r][c] * neighborCount >= neighborSum) {
                        nextSkills[r][c] = skills[r][c];
                    } else {
                        hasEliminated = true;
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
                        if (r == north[r][c]) {
                            north[r][c] = 0;
                            break;
                        }
                        north[r][c]++;
                    }
                    while (south[r][c] > 0 && skills[r + south[r][c]][c] == 0) {
                        if (r + south[r][c] == rows - 1) {
                            south[r][c] = 0;
                            break;
                        }
                        south[r][c]++;
                    }
                }
            }
        }

        return totalSkill;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();

            int[][] skills = new int[rows][cols];

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    skills[r][c] = scanner.nextInt();
                }
            }

            int result = calculateTotalSkill(rows, cols, skills);

            System.out.printf("Case #%d: %d\n", t, result);
        }

        scanner.close();
    }
}