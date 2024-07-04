import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numberOfTestcases = Integer.parseInt(in.nextLine());

        for(int i = 1; i <= numberOfTestcases; i++) {
            findSolution(i, in);
        }
    }

    private static void findSolution(int i, Scanner in) {
        int matrixSize = Integer.parseInt(in.nextLine());

        int[][] matrix = new int[matrixSize][matrixSize];

        for(int row = 0; row < matrixSize; row++) {
            String[] input = in.nextLine().split(" ");

            for(int col = 0; col < matrixSize; col++) {
                matrix[row][col] = Integer.parseInt(input[col]);
            }
        }

        int trace = findTrace(matrix);
        int repeatedRows = findRepeatedRows(matrix);
        int repeatedCols = findRepeatedCols(matrix);

        System.out.println(String.format("Case #%s: %s %s %s", i, trace, repeatedRows, repeatedCols));
    }

    private static int findTrace(int[][] matrix) {
        int trace = 0;

        for(int row = 0; row < matrix.length; row++) {
            int col = row;
            trace += matrix[row][col];
        }

        return trace;
    }

    private static int findRepeatedRows(int[][] matrix) {
        int repeatedRows = 0;

        for(int row = 0; row < matrix.length; row++) {

            Set<Integer> dictionary = new HashSet<>();
            for(int col = 0; col < matrix.length; col++) {
                if(dictionary.contains(matrix[row][col])) {
                    repeatedRows++;
                    break;
                } else {
                    dictionary.add(matrix[row][col]);
                }
            }
        }

        return repeatedRows;
    }

    private static int findRepeatedCols(int[][] matrix) {
        int repeatedCols = 0;

        for(int col = 0; col < matrix.length; col++) {

            Set<Integer> dictionary = new HashSet<>();
            for(int row = 0; row < matrix.length; row++) {
                if(dictionary.contains(matrix[row][col])) {
                    repeatedCols++;
                    break;
                } else {
                    dictionary.add(matrix[row][col]);
                }
            }
        }

        return repeatedCols;
    }
}