import java.util.*;
import java.io.*;

public class Vestigium {

    public static int calculateTrace(int[][] matrix) {
        int traceSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            traceSum += matrix[i][i];
        }
        return traceSum;
    }

    public static int countRepeatedRows(int[][] matrix) {
        int repeatedRowCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> seenNumbers = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                if (seenNumbers.contains(matrix[i][j])) {
                    repeatedRowCount++;
                    break;
                } else {
                    seenNumbers.add(matrix[i][j]);
                }
            }
        }
        return repeatedRowCount;
    }

    public static int countRepeatedColumns(int[][] matrix) {
        int repeatedColumnCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> seenNumbers = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                if (seenNumbers.contains(matrix[j][i])) {
                    repeatedColumnCount++;
                    break;
                } else {
                    seenNumbers.add(matrix[j][i]);
                }
            }
        }
        return repeatedColumnCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int traceSum = calculateTrace(matrix);
            int repeatedRows = countRepeatedRows(matrix);
            int repeatedColumns = countRepeatedColumns(matrix);

            System.out.println("Case #" + testCase + ": " + traceSum + " " + repeatedRows + " " + repeatedColumns);
        }

        scanner.close();
    }
}