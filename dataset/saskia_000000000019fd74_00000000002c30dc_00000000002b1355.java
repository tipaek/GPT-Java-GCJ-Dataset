import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();

        for (int i = 0; i < testCases; i++)
        {
            int countAllRounds = 0;
            int countCurrRound = 0;
            int rows = in.nextInt();
            int columns = in.nextInt();
            int[][] skills = new int[rows][columns];
            int[][] countAt = new int[rows][columns];

            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    int newSk = in.nextInt();
                    skills[j][k] = newSk;
                    countAllRounds += newSk;
                }
            }
            boolean neighborsExist = true;
            int rounds = -1;
            while (neighborsExist) {
                countCurrRound = 0;
                rounds++;
                neighborsExist = false;
                for (int j = 0; j < rows; j++) {
                    for (int k = 0; k < columns; k++) {
                        if (skills[j][k] > 0) {
                            int neighLeft = 0;
                            int neighRight = 0;
                            int neighTop = 0;
                            int neighBottom = 0;

                            int curPos = k - 1;
                            while (curPos >= 0 && neighLeft == 0) {
                                if (skills[j][curPos] > 0) {
                                    neighLeft = skills[j][curPos];
                                    neighborsExist = true;
                                 }
                                else
                                    curPos--;
                            }

                            curPos = k + 1;
                            while (curPos < columns && neighRight == 0) {
                                if (skills[j][curPos] > 0) {
                                    neighRight = skills[j][curPos];
                                    neighborsExist = true;
                                }
                                else
                                    curPos++;
                            }

                            curPos = j - 1;
                            while (curPos >= 0 && neighTop == 0) {
                                if (skills[curPos][k] > 0) {
                                    neighTop = skills[curPos][k];
                                    neighborsExist = true;
                                }
                                else
                                    curPos--;
                            }

                            curPos = j + 1;
                            while (curPos < rows && neighBottom == 0) {
                                if (skills[curPos][k] > 0) {
                                    neighBottom = skills[curPos][k];
                                    neighborsExist = true;
                                }
                                else
                                    curPos++;
                            }

                            countAt[j][k] = neighLeft + neighRight + neighBottom + neighTop - skills[j][k];
                            countCurrRound += skills[j][k];
                            System.out.println("Runde: " + rounds + " j: " + j + " k: " + k + " " + skills[j][k] + " " + countCurrRound);
                            //System.out.println("left: " + neighLeft + " right: " + neighRight + " bottom: " + neighBottom + " top: " + neighTop + " count: " + countAt[j][k]);
                        }
                    }
                }


                //if (neighborsExist) {
                    if (rounds > 0)
                        countAllRounds += countCurrRound;

                    int[] biggestPositionRow = new int[rows*columns];
                    int[] biggestPositionCol = new int[rows*columns];
                    int arrayCounter = 0;
                    int biggestValue = 0;
                    int smallestSkill = 0;

                    for (int j = 0; j < rows; j++) {
                        for (int k = 0; k < columns; k++) {
                            //System.out.println(rounds + " " + skills[j][k] + " " + biggestValue + " " + countAt[j][k]);
                            if (skills[j][k] > 0) {
                                if (countAt[j][k] > biggestValue  && ((smallestSkill >= skills[j][k] && smallestSkill > 0) || smallestSkill == 0)) {
                                    biggestValue = countAt[j][k];
                                    biggestPositionRow = new int[rows*columns];
                                    biggestPositionCol = new int[rows*columns];
                                    arrayCounter = 0;
                                    biggestPositionRow[arrayCounter] = j;
                                    biggestPositionCol[arrayCounter] = k;
                                    smallestSkill = skills[j][k];
                                } else if (countAt[j][k] == biggestValue  && ((smallestSkill >= skills[j][k] && smallestSkill > 0) || smallestSkill == 0)) {
                                    arrayCounter++;
                                    biggestPositionRow[arrayCounter] = j;
                                    biggestPositionCol[arrayCounter] = k;
                                    smallestSkill = skills[j][k];
                                }
                            }
                        }
                    }

                    for(int j = 0; j <= arrayCounter; j++) {
                        int r = biggestPositionRow[j];
                        int c = biggestPositionCol[j];
                        skills[r][c] = 0;
                    }
                //}
            }

            int caseNo = i+1;
            System.out.println("Case #" + caseNo + ": " + countAllRounds);
        }




    }
}
