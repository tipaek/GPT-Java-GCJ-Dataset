import static java.lang.String.format;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static class Result {

        int dupRows, dupCols, trace;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int tests = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int testNum = 1; testNum <= tests; ++testNum) {
            int n = in.nextInt();

            final int[][] matrix = readMatrix(n, in);
            Result result = checkMatrix(matrix, n);


            System.out.println(format("Case #%s %s %s %s", testNum, result.trace, result.dupRows, result.dupCols));
        }
    }

    private static Result checkMatrix(int[][] matrix, int size) {
        Result result = new Result();


        for (int row = 0; row < size; row++) {
            Set<Integer> rowNums = new HashSet<>(size + 50);
            Set<Integer> colNums = new HashSet<>(size + 50);

            for (int col = 0; col < size; col++) {
                rowNums.add(matrix[row][col]);
                colNums.add(matrix[col][row]);
            }

            result.trace += matrix[row][row];

            if (rowNums.size() < size) {
                result.dupRows++;
            }

            if (colNums.size() < size) {
                result.dupCols++;
            }
        }

        return result;
    }

    private static int[][] readMatrix(int size, Scanner in) {
        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                matrix[row][column] = in.nextInt();
            }
        }

        return matrix;
    }
}
