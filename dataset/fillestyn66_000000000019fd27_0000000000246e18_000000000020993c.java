import java.util.*;
import java.io.*;

public class Solution {

    public static StringBuilder result;

    public static void findSolution(String testValue) {
        result = new StringBuilder();
        testValue.chars().forEach(c -> {
            if (c == 'S') {
                result.append('E');
            } else {
                result.append('S');
            }
        });
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int size = in.nextInt();
            int dupRows = 0;
            int dupCols = 0;
            int tracePos = 1;
            int[][] dupRowMatrixCounter = new int[size][size];
            int[] dupRowCounter = new int[size];
            int[][] dupColMatrixCounter = new int[size][size];
            int[] dupColCounter = new int[size];
            int trace = 0;
            int xPos = 1;
            for (int matrixSize = 1; matrixSize <= size; matrixSize++) {

                for (int yPos = 1; yPos <= size; yPos++) {
                    int value = in.nextInt();
                    if (yPos == tracePos) {
                        trace += value;
                    }
                    if (dupRowMatrixCounter[xPos - 1][value - 1] == 0) {
                        dupRowMatrixCounter[xPos - 1][value - 1]++;
                    } else if (dupRowMatrixCounter[xPos - 1][value - 1] == 1) {
                        dupRowMatrixCounter[xPos - 1][value - 1]++;
                        if (dupRowCounter[xPos - 1] == 0) {
                            dupRowCounter[xPos - 1]++;
                            dupRows++;
                        }
                    }

                    if (dupColMatrixCounter[yPos - 1][value - 1] == 0) {
                        dupColMatrixCounter[yPos - 1][value - 1]++;
                    } else if (dupColMatrixCounter[yPos - 1][value - 1] == 1) {
                        dupColMatrixCounter[yPos - 1][value - 1]++;
                        if (dupColCounter[yPos - 1] == 0) {
                            dupColCounter[yPos - 1]++;
                            dupCols++;
                        }
                    }
                }
                xPos += 1;
                tracePos++;
            }

            System.out.println("Case #" + i + ": " + trace + " " + dupRows + " " + dupCols);
        }
    }
}