import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Vestigium vestigium = new Vestigium();
    }
}

class Vestigium {
    int amountTests = 0;
    int[][][] testCases;

    public Vestigium() {
        readInput();
        createOutput();
    }

    private void readInput() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        amountTests = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        testCases = new int[amountTests][][];
        int size = 0;
        for (int i = 0; i < amountTests; ++i) {
            size = in.nextInt();
            testCases[i] = new int[size][size];
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    testCases[i][j][k] = in.nextInt();
                }
            }
        }
        in.close();
    }

    private void createOutput() {
        for (int i = 1; i <= amountTests; i++) {
            int trace = 0;
            int rows = 0;
            int columns = 0;

            for (int j = 0; j < testCases[i - 1].length; j++) {

                int counterColumn = 0;
                int counterRow = 0;

                trace += testCases[i - 1][j][j];

                for (int k = 0; k < testCases[i - 1].length; k++) {
                    for (int m = j + 1; m < testCases[i - 1].length; m++) {
                        System.out.println(testCases[i - 1][j][k] + " und " + testCases[i - 1][m][k]);
                        if (testCases[i - 1][j][k] == testCases[i - 1][m][k]) {
                            counterColumn++;
                            System.out.println("added");
                            break;
                        }
                    }
                    for (int l = k + 1; l < testCases[i - 1][j].length; l++) {
                        if (testCases[i - 1][j][k] == testCases[i - 1][j][l]) {
                            counterRow++;
                        }
                    }
                }
                if (counterRow > 0) {
                    rows += 1;
                }

                if (counterColumn > 0) {
                    columns += 1;
                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + rows + " " + columns);
        }
    }
}
