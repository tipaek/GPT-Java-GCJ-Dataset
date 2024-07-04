import java.util.*;
import java.io.*;

public class Solution {
     public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCase = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testCase = 1; testCase <= numberOfTestCase; ++testCase) {
            int matrixSize = in.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int numberOfRowRepeat = 0;
            int numberOfColumnRepeat = 0;
            int trace = 0;
            for (int row = 0; row < matrixSize; row++) {
                String[] line = in.next().split("\t");
                for (int column = 0; column < line.length; column++) {
                    if (column == row) trace = trace + Integer.parseInt(line[column]);
                    int value = NumberUtils.toInt(line[column]);
                    matrix[row][column] = value;
                }
            }
            System.out.println("Case #" + testCase + ": " + trace + " " + numberOfRowRepeat + " " + numberOfColumnRepeat);
        }
    }
}