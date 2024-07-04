import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static int totalInterestLevel = 0;
    private static int currentInterestLevel = 0;
    private static final List<Coordinate> coordinatesToKill = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCount = Integer.parseInt(sc.nextLine());
            for (int testCase = 0; testCase < testCount; testCase++) {
                resetInterestLevels();
                int[][] skillLevels = readSkillLevels(sc);
                runRounds(skillLevels);
                System.out.println("Case #" + (testCase + 1) + ": " + totalInterestLevel);
            }
        }
    }

    private static void resetInterestLevels() {
        totalInterestLevel = 0;
        currentInterestLevel = 0;
    }

    private static int[][] readSkillLevels(Scanner sc) {
        String[] rcLine = sc.nextLine().split("\\s+");
        int rowCount = Integer.parseInt(rcLine[0]);
        int columnCount = Integer.parseInt(rcLine[1]);
        int[][] skillLevels = new int[rowCount][columnCount];
        for (int row = 0; row < rowCount; row++) {
            String[] skillLevelsInRow = sc.nextLine().split("\\s+");
            for (int col = 0; col < columnCount; col++) {
                int skill = Integer.parseInt(skillLevelsInRow[col]);
                skillLevels[row][col] = skill;
                currentInterestLevel += skill;
            }
        }
        return skillLevels;
    }

    private static void runRounds(int[][] skillLevels) {
        while (true) {
            coordinatesToKill.clear();
            totalInterestLevel += currentInterestLevel;

            boolean hasKills = markCoordinatesToKill(skillLevels);

            if (!hasKills) break;

            executeKills(skillLevels);
        }
    }

    private static boolean markCoordinatesToKill(int[][] skillLevels) {
        boolean hasKills = false;
        for (int x = 0; x < skillLevels.length; x++) {
            for (int y = 0; y < skillLevels[x].length; y++) {
                if (skillLevels[x][y] != 0 && skillLevels[x][y] < getAvgAdjacentSkillLevel(x, y, skillLevels)) {
                    hasKills = true;
                    skillLevels[x][y] *= -1;
                    currentInterestLevel += skillLevels[x][y];
                    coordinatesToKill.add(new Coordinate(x, y));
                }
            }
        }
        return hasKills;
    }

    private static void executeKills(int[][] skillLevels) {
        for (Coordinate coordinate : coordinatesToKill) {
            skillLevels[coordinate.xPos][coordinate.yPos] = 0;
        }
    }

    private static double getAvgAdjacentSkillLevel(int x, int y, int[][] skillLevels) {
        int divisor = 0;
        double total = 0;

        for (int i = 0; i < 4; i++) {
            int val = getAdjacentSkillLevel(x, y, skillLevels, i);
            if (val != 0) {
                divisor++;
                total += val;
            }
        }
        return divisor == 0 ? -1 : total / divisor;
    }

    private static int getAdjacentSkillLevel(int x, int y, int[][] skillLevels, int direction) {
        switch (direction) {
            case 0:
                return getVerticalSkillLevel(x, y, skillLevels, -1);
            case 1:
                return getHorizontalSkillLevel(x, y, skillLevels, -1);
            case 2:
                return getVerticalSkillLevel(x, y, skillLevels, 1);
            case 3:
                return getHorizontalSkillLevel(x, y, skillLevels, 1);
            default:
                return 0;
        }
    }

    private static int getVerticalSkillLevel(int x, int y, int[][] skillLevels, int step) {
        for (int yPos = y + step; yPos >= 0 && yPos < skillLevels[x].length; yPos += step) {
            int adjSkillLevel = skillLevels[x][yPos];
            if (adjSkillLevel != 0) return Math.abs(adjSkillLevel);
        }
        return 0;
    }

    private static int getHorizontalSkillLevel(int x, int y, int[][] skillLevels, int step) {
        for (int xPos = x + step; xPos >= 0 && xPos < skillLevels.length; xPos += step) {
            int adjSkillLevel = skillLevels[xPos][y];
            if (adjSkillLevel != 0) return Math.abs(adjSkillLevel);
        }
        return 0;
    }

    static class Coordinate {
        final int xPos;
        final int yPos;

        Coordinate(int x, int y) {
            this.xPos = x;
            this.yPos = y;
        }
    }
}