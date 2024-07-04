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
                processTestCase(skillLevels);
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
        for (int y = 0; y < rowCount; y++) {
            String[] skillLevelsInRow = sc.nextLine().split("\\s+");
            for (int x = 0; x < columnCount; x++) {
                int skill = Integer.parseInt(skillLevelsInRow[x]);
                skillLevels[y][x] = skill;
                currentInterestLevel += skill;
            }
        }
        return skillLevels;
    }

    private static void processTestCase(int[][] skillLevels) {
        do {
            totalInterestLevel += currentInterestLevel;
            coordinatesToKill.clear();
        } while (executeRound(skillLevels));
    }

    private static boolean executeRound(int[][] skillLevels) {
        boolean anyKilled = false;
        for (int y = 0; y < skillLevels.length; y++) {
            for (int x = 0; x < skillLevels[y].length; x++) {
                if (skillLevels[y][x] != 0 && shouldKill(y, x, skillLevels)) {
                    markForKill(y, x);
                    anyKilled = true;
                }
            }
        }
        applyKills(skillLevels);
        return anyKilled;
    }

    private static boolean shouldKill(int y, int x, int[][] skillLevels) {
        double avgAdjacentSkillLevel = calculateAvgAdjacentSkillLevel(y, x, skillLevels);
        return skillLevels[y][x] < avgAdjacentSkillLevel;
    }

    private static double calculateAvgAdjacentSkillLevel(int y, int x, int[][] skillLevels) {
        int[] directions = {-1, 1};
        double total = 0;
        int count = 0;

        for (int dy : directions) {
            int adjSkill = getSkillLevel(y + dy, x, skillLevels);
            if (adjSkill != 0) {
                total += adjSkill;
                count++;
            }
        }

        for (int dx : directions) {
            int adjSkill = getSkillLevel(y, x + dx, skillLevels);
            if (adjSkill != 0) {
                total += adjSkill;
                count++;
            }
        }

        return count == 0 ? -1 : total / count;
    }

    private static int getSkillLevel(int y, int x, int[][] skillLevels) {
        return (y >= 0 && y < skillLevels.length && x >= 0 && x < skillLevels[y].length) ? Math.abs(skillLevels[y][x]) : 0;
    }

    private static void markForKill(int y, int x) {
        currentInterestLevel -= Math.abs(skillLevels[y][x]);
        coordinatesToKill.add(new Coordinate(y, x));
    }

    private static void applyKills(int[][] skillLevels) {
        for (Coordinate coordinate : coordinatesToKill) {
            skillLevels[coordinate.yPos][coordinate.xPos] = 0;
        }
    }

    private static class Coordinate {
        final int xPos;
        final int yPos;

        Coordinate(int y, int x) {
            this.yPos = y;
            this.xPos = x;
        }
    }
}