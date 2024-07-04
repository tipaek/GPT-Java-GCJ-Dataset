
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        for (int i = 1; i <= testCases; i++) {
            testCase(i, in);
        }
    }

    private static void testCase(int testCaseNumber, Scanner in) {
        int squareSize = in.nextInt();
        int diagonalSum = 0;
        Set<Integer>[] rowsSets = new Set[squareSize];
        Set<Integer>[] colsSets = new Set[squareSize];
        for (int i = 0; i < squareSize; i++) {
            rowsSets[i] = new HashSet<>();
            colsSets[i] = new HashSet<>();
        }
        int[] rowCounter = new int[squareSize];
        int[] colCounter = new int[squareSize];
        for (int i = 0; i < squareSize; i++) {
            for (int j = 0; j < squareSize; j++) {
                int element = in.nextInt();
                if (i == j) {
                    diagonalSum += element;
                }
                if (rowsSets[i].contains(element)) {
                    rowCounter[i] = 1;
                } else {
                    rowsSets[i].add(element);
                }
                if (colsSets[j].contains(element)) {
                    colCounter[j] = 1;
                } else {
                    colsSets[j].add(element);
                }
            }
        }
        int totalRows = 0;
        for (int count: rowCounter) {
            totalRows += count;
        }
        int totalCols = 0;
        for (int count: colCounter) {
            totalCols += count;
        }
        System.out.printf("Case #%d: %d %d %d%n", testCaseNumber, diagonalSum, totalRows, totalCols);
    }
}
