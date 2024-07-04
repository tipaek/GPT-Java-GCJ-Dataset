import java.util.*;
import java.io.*;
public class Solution {


    public static String vestigium(int caseNum, int[][] matrix) {
        int trace = 0;
        int r = 0;
        int c = 0;
        for (int row = 0, col = 0; row < matrix.length; row++, col++) {
            trace += matrix[row][col];
        }

        Set<Integer> values;
        for (int row = 0; row < matrix.length; row++) {
            values = new HashSet<>();
            for (int col = 0; col < matrix.length; col++) {
                values.add(matrix[row][col]);
                if (values.size() < col + 1) {
                    r++;
                    break;
                }
            }
        }

        for (int col = 0; col < matrix.length; col++) {
            values = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                values.add(matrix[row][col]);
                if (values.size() < row + 1) {
                    c++;
                    break;
                }
            }
        }

        return "Case #" + caseNum + ": " + trace + " " + r + " " + c;
    }

    public static void main(String[] args) {



        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int matrixSize = in.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int r = 0; r < matrixSize; r++) {
                for (int c = 0; c < matrixSize; c++) {
                    matrix[r][c] = in.nextInt();
                }
            }

            System.out.println(vestigium(i, matrix));
        }
    }
}