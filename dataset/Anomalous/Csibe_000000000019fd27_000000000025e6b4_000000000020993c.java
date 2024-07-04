import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            int[][] matrix = new int[matrixSize][matrixSize];
            Set<Integer>[] columnSets = new Set[matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                columnSets[i] = new HashSet<>();
            }

            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    int number = scanner.nextInt();
                    matrix[row][col] = number;

                    if (row == col) {
                        trace += number;
                    }

                    rowSet.add(number);
                    columnSets[col].add(number);
                }

                if (rowSet.size() < matrixSize) {
                    duplicateRows++;
                }
            }

            for (Set<Integer> columnSet : columnSets) {
                if (columnSet.size() < matrixSize) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }

        scanner.close();
    }
}