import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int size = in.nextInt();
            in.nextLine();
            int rowRepetition = 0;
            int colRepetition = 0;
            int trace = 0;
            int[][] matrix = populateMatrix(in, size);

            for(int pivot = 0; pivot < size; pivot++) {
                    trace+=matrix[pivot][pivot];
                    int[] column = matrix[pivot];
                    int[] row = getRow(matrix, pivot);
                    if(hasRepetition(column)) {
                        colRepetition++;
                    }
                    if (hasRepetition(row)){
                        rowRepetition++;
                    }
            }
            buildOutput(caseNumber, trace, rowRepetition, colRepetition);
        }
    }

    private static int[] getRow(int[][] matrix, int i) {
        int length = matrix[0].length;
        int[] column = new int[length];
        for(int k = 0; k < length; k++) {
            column[k] = matrix[k][i];
        }
        return column;
    }



    private static int[][] populateMatrix(Scanner in, int size) {
        // [column][row]
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] s = in.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                matrix[j][i] = Integer.valueOf(s[j]);
            }
        }
        return matrix;
    }

    private static boolean hasRepetition(int[] line) {
        boolean[] hitmap = new boolean[101];
        for (int val : line) {
            if (hitmap[val]) {
                return true;
            } else {
                hitmap[val] = true;
            }
        }
        return false;
    }

    private static void buildOutput(int caseNumber, int trace, int rowRepetitions, int columnRepetitions) {
        System.out.println(String.format("Case #%s %s %s %s", caseNumber, trace, rowRepetitions, columnRepetitions));
    }
}