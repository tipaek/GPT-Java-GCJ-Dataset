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
        //print(skillLevels);
        //System.out.println("Curr total interest: " + totalInterestLevel);
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
                for (int yPos = y - 1; yPos >= 0; yPos--) {
                    int adjSkillLevel = skillLevels[x][yPos];
                    if (adjSkillLevel != 0) {
                        return Math.abs(adjSkillLevel);
                    }
                }
                break;
            case 1:
                for (int xPos = x - 1; xPos >= 0; xPos--) {
                    int adjSkillLevel = skillLevels[xPos][y];
                    if (adjSkillLevel != 0) {
                        return Math.abs(adjSkillLevel);
                    }
                }
                break;
            case 2:
                for (int yPos = y + 1; yPos < skillLevels[x].length; yPos++) {
                    int adjSkillLevel = skillLevels[x][yPos];
                    if (adjSkillLevel != 0) {
                        return Math.abs(adjSkillLevel);
                    }
                }
                break;
            default:
                for (int xPos = x + 1; xPos < skillLevels.length; xPos++) {
                    int adjSkillLevel = skillLevels[xPos][y];
                    if (adjSkillLevel != 0) {
                        return Math.abs(adjSkillLevel);
                    }
                }
                break;
        }

        return 0;
    }

    static void print(int[][] ints){
        for(int[] i: ints){
            System.out.println(Arrays.toString(i));
        }
    }

    static class Coordinate {
        int xPos;
        int yPos;

        Coordinate(int x, int y) {
            yPos = y;
            xPos = x;
        }
    }
}
