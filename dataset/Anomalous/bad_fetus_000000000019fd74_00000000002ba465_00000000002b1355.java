import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static long totalInterestLevel = 0;
    private static long currentInterestLevel = 0;
    private static final List<Coordinate> coordinatesToKill = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCount = Integer.parseInt(scanner.nextLine());
            for (int testCase = 1; testCase <= testCount; testCase++) {
                totalInterestLevel = 0;
                currentInterestLevel = 0;

                String[] rcLine = scanner.nextLine().split("\\s+");
                int rowCount = Integer.parseInt(rcLine[0]);
                int columnCount = Integer.parseInt(rcLine[1]);

                int[][] skillLevels = new int[rowCount][columnCount];
                for (int row = 0; row < rowCount; row++) {
                    String[] skillLevelsInRow = scanner.nextLine().split("\\s+");
                    for (int col = 0; col < columnCount; col++) {
                        int skill = Integer.parseInt(skillLevelsInRow[col]);
                        skillLevels[row][col] = skill;
                        currentInterestLevel += skill;
                    }
                }

                runRound(skillLevels);

                System.out.println("Case #" + testCase + ": " + totalInterestLevel);
            }
        }
    }

    private static void runRound(int[][] skillLevels) {
        int killsThisRound = 0;
        coordinatesToKill.clear();
        totalInterestLevel += currentInterestLevel;

        for (int x = 0; x < skillLevels.length; x++) {
            for (int y = 0; y < skillLevels[x].length; y++) {
                if (skillLevels[x][y] != 0) {
                    double avgAdjacentInterestLevel = getAvgAdjacentSkillLevel(x, y, skillLevels);
                    if (skillLevels[x][y] < avgAdjacentInterestLevel) {
                        killsThisRound++;
                        skillLevels[x][y] *= -1;
                        currentInterestLevel += skillLevels[x][y];
                        coordinatesToKill.add(new Coordinate(x, y));
                    }
                }
            }
        }

        if (killsThisRound > 0) {
            for (Coordinate coordinate : coordinatesToKill) {
                skillLevels[coordinate.xPos][coordinate.yPos] = 0;
            }
            runRound(skillLevels);
        }
    }

    private static double getAvgAdjacentSkillLevel(int x, int y, int[][] skillLevels) {
        int divisor = 0;
        double total = 0;

        for (int direction = 0; direction < 4; direction++) {
            int adjSkillLevel = getAdjacentSkillLevel(x, y, skillLevels, direction);
            if (adjSkillLevel != 0) {
                divisor++;
                total += adjSkillLevel;
            }
        }
        return divisor == 0 ? -1 : total / divisor;
    }

    private static int getAdjacentSkillLevel(int x, int y, int[][] skillLevels, int direction) {
        switch (direction) {
            case 0: // left
                for (int yPos = y - 1; yPos >= 0; yPos--) {
                    int adjSkillLevel = skillLevels[x][yPos];
                    if (adjSkillLevel != 0) return Math.abs(adjSkillLevel);
                }
                break;
            case 1: // up
                for (int xPos = x - 1; xPos >= 0; xPos--) {
                    int adjSkillLevel = skillLevels[xPos][y];
                    if (adjSkillLevel != 0) return Math.abs(adjSkillLevel);
                }
                break;
            case 2: // right
                for (int yPos = y + 1; yPos < skillLevels[x].length; yPos++) {
                    int adjSkillLevel = skillLevels[x][yPos];
                    if (adjSkillLevel != 0) return Math.abs(adjSkillLevel);
                }
                break;
            case 3: // down
                for (int xPos = x + 1; xPos < skillLevels.length; xPos++) {
                    int adjSkillLevel = skillLevels[xPos][y];
                    if (adjSkillLevel != 0) return Math.abs(adjSkillLevel);
                }
                break;
        }
        return 0;
    }

    private static class Coordinate {
        final int xPos;
        final int yPos;

        Coordinate(int x, int y) {
            this.xPos = x;
            this.yPos = y;
        }
    }
}