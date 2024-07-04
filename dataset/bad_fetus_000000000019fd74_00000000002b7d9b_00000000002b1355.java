import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static int totalInterestLevel = 0;
    public static int currentInterestLevel = 0;
    public static List<Coordinate> coordinatesToKill = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(sc.nextLine());
        for (int testCase = 0; testCase < testCount; testCase++) {
            totalInterestLevel = 0;
            currentInterestLevel = 0;
            String[] rcLine = sc.nextLine().split("\\s+");
            int rowCount = Integer.parseInt(rcLine[0]);
            int columnCount = Integer.parseInt(rcLine[1]);
            int[][] skillLevels = new int[rowCount][columnCount];
            for (int[] skillLevelPerRow : skillLevels) {
                String[] skillLevelsInRow = sc.nextLine().split("\\s+");
                for (int i = 0; i < skillLevelsInRow.length; i++) {
                    int skill = Integer.parseInt(skillLevelsInRow[i]);
                    skillLevelPerRow[i] = skill;
                    currentInterestLevel += skill;
                }
            }

            runRound(skillLevels);

            System.out.println("Case #" + (testCase + 1) + ": " + totalInterestLevel);

        }
        sc.close();
    }

    private static void runRound(int[][] skillLevels) {
        int killsThisRound = 0;
        coordinatesToKill.clear();
        totalInterestLevel += currentInterestLevel;
        for (int y = 0; y < skillLevels.length; y++) {
            for (int x = 0; x < skillLevels[y].length; x++) {
                if (skillLevels[y][x] != 0) {
                    double avgAdjacentInterestLevel = getAvgAdjacentSkillLevel(y, x, skillLevels);
                    if (skillLevels[y][x] < avgAdjacentInterestLevel) {
                        killsThisRound++;
                        skillLevels[y][x] *= -1;
                        currentInterestLevel += skillLevels[y][x];
                        coordinatesToKill.add(new Coordinate(y, x));
                    }
                }
            }
        }

        if (killsThisRound > 0) {
            for (Coordinate coordinate : coordinatesToKill) {
                skillLevels[coordinate.yPos][coordinate.xPos] = 0;
            }
            runRound(skillLevels);
        }
    }

    private static double getAvgAdjacentSkillLevel(int y, int x, int[][] skillLevels) {
        int divisor = 0;
        double total = 0;

        for (int i = 0; i < 4; i++) {
            int val = getAdjacentSkillLevel(y, x, skillLevels, i);
            if (val != 0) {
                divisor++;
                total += val;
            }
        }
        return divisor == 0 ? -1 : total / divisor;
    }

    private static int getAdjacentSkillLevel(int y, int x, int[][] skillLevels, int direction) {
        switch (direction) {
            case 0:
                for (int yPos = y - 1; yPos >= 0; yPos--) {
                    int adjSkillLevel = skillLevels[yPos][x];
                    if (adjSkillLevel != 0) {
                        return Math.abs(adjSkillLevel);
                    }
                }
                break;
            case 1:
                for (int xPos = x - 1; xPos >= 0; xPos--) {
                    int adjSkillLevel = skillLevels[y][xPos];
                    if (adjSkillLevel != 0) {
                        return Math.abs(adjSkillLevel);
                    }
                }
                break;
            case 2:
                for (int yPos = y + 1; yPos < skillLevels.length; yPos++) {
                    int adjSkillLevel = skillLevels[yPos][x];
                    if (adjSkillLevel != 0) {
                        return Math.abs(adjSkillLevel);
                    }
                }
                break;
            default:
                for (int xPos = x + 1; xPos < skillLevels[y].length; xPos++) {
                    int adjSkillLevel = skillLevels[y][xPos];
                    if (adjSkillLevel != 0) {
                        return Math.abs(adjSkillLevel);
                    }
                }
                break;
        }

        return 0;
    }

    static class Coordinate {
        int xPos;
        int yPos;

        Coordinate(int y, int x) {
            yPos = y;
            xPos = x;
        }
    }
}
