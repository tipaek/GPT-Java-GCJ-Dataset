package codejam.jam2020.qualification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            System.out.print("Case #" + caseNumber + ":");
            processTestCase(scanner);
        }
    }

    private static void processTestCase(Scanner scanner) {
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];

        int trace = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
        }

        int rowCount = countDuplicateRows(matrix, size);
        int colCount = countDuplicateColumns(matrix, size);

        System.out.println(" " + trace + " " + rowCount + " " + colCount);
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int rowCount = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowCount++;
                    break;
                }
            }
        }
        return rowCount;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int colCount = 0;
        for (int j = 0; j < size; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (!colSet.add(matrix[i][j])) {
                    colCount++;
                    break;
                }
            }
        }
        return colCount;
    }
}