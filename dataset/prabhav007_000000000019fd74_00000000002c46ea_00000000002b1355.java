import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        List<int[][]> squareList = new ArrayList<>();
        for (int i = 1; i <= t; ++i) {
            int m = in.nextInt();
            int n = in.nextInt();
            int[][] square = new int[m][n];
            int[][] tempSquare = new int[m][n];
            int interestLevel = 0;
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    square[j][k] = in.nextInt();
                }
            }
            squareList.add(square);
        }
        for (int i = 0; i < t; ++i) {
            int[][] square = squareList.get(i);
            int m = square.length;
            int n = square[0].length;
            int[][] tempSquare = new int[m][n];
            int interestLevel = 0;
            boolean stopRound = false;
            while (!stopRound) {
                boolean changedFlag = false;
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        int skill = square[j][k];
                        if(0==skill) {
                            continue;
                        }
                        interestLevel += skill;
                        int sumOfSkill = 0;
                        int count = 0;
                        int x = 1;
                        while (j - x >= 0) {
                            if (square[j - x][k] == 0) {
                                x++;
                                continue;
                            }
                            sumOfSkill += square[j - x][k];
                            count++;
                            break;
                        }
                        x=1;
                        while (k - x >= 0) {
                            if (square[j][k-x] == 0) {
                                x++;
                                continue;
                            }
                            sumOfSkill += square[j][k - x];
                            count++;
                            break;
                        }
                        x=1;
                        while (j + x < m) {
                            if (square[j+x][k] == 0) {
                                x++;
                                continue;
                            }
                            sumOfSkill += square[j + x][k];
                            count++;
                            break;
                        }
                        x=1;
                        while (k + x < n) {
                            if (square[j][k+x] == 0) {
                                x++;
                                continue;
                            }
                            sumOfSkill += square[j][k + x];
                            count++;
                            break;
                        }
                        double avgSkill = (double) sumOfSkill / count;
                        if ((double) skill < avgSkill) {
                            changedFlag = true;
                            tempSquare[j][k] = 0;
                        } else {
                            tempSquare[j][k] = square[j][k];
                        }
                    }
                }
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        square[j][k] = tempSquare[j][k];
                    }
                }
                if (!changedFlag) {
                    stopRound = true;
                }
            }
            System.out.println("Case #" + (i+1) + ": " + interestLevel);
        }
    }
}
