import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            Integer[][] skills = new Integer[rows][cols];

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    skills[row][col] = scanner.nextInt();
                }
            }

            int roundLevel = calculateRoundLevel(skills, rows, cols);
            int competitionLevel = roundLevel;
            skills = eliminateDancers(skills, rows, cols);

            while (calculateRoundLevel(skills, rows, cols) != roundLevel) {
                roundLevel = calculateRoundLevel(skills, rows, cols);
                competitionLevel += roundLevel;
                skills = eliminateDancers(skills, rows, cols);
            }

            System.out.println("Case #" + testCase + ": " + competitionLevel);
        }

        scanner.close();
    }

    private static int calculateRoundLevel(Integer[][] skills, int rows, int cols) {
        int roundLevel = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (skills[row][col] != null) {
                    roundLevel += skills[row][col];
                }
            }
        }
        return roundLevel;
    }

    private static Integer[][] eliminateDancers(Integer[][] skills, int rows, int cols) {
        Integer[][] newSkills = new Integer[rows][cols];

        for (int row = 0; row < rows; row++) {
            System.arraycopy(skills[row], 0, newSkills[row], 0, cols);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (skills[row][col] == null) {
                    continue;
                }

                double sumNeighbours = 0;
                int numNeighbours = 0;

                // Check above
                for (int r = row - 1; r >= 0; r--) {
                    if (skills[r][col] != null) {
                        sumNeighbours += skills[r][col];
                        numNeighbours++;
                        break;
                    }
                }

                // Check below
                for (int r = row + 1; r < rows; r++) {
                    if (skills[r][col] != null) {
                        sumNeighbours += skills[r][col];
                        numNeighbours++;
                        break;
                    }
                }

                // Check left
                for (int c = col - 1; c >= 0; c--) {
                    if (skills[row][c] != null) {
                        sumNeighbours += skills[row][c];
                        numNeighbours++;
                        break;
                    }
                }

                // Check right
                for (int c = col + 1; c < cols; c++) {
                    if (skills[row][c] != null) {
                        sumNeighbours += skills[row][c];
                        numNeighbours++;
                        break;
                    }
                }

                double avgNeighbours = numNeighbours > 0 ? sumNeighbours / numNeighbours : 0;

                if (skills[row][col] < avgNeighbours) {
                    newSkills[row][col] = null;
                }
            }
        }

        return newSkills;
    }
}