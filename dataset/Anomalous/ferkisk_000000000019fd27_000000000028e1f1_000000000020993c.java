package gcj2020;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

    public static void main(String[] args) {
        new Vestigium().run();
    }

    private Scanner scanner;

    public void run() {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            solve(i);
        }
    }

    private void solve(int testCaseNumber) {
        int matrixSize = scanner.nextInt();
        int diagonalSum = 0;
        
        Set<Integer> rowsWithDuplicates = new HashSet<>();
        Set<Integer> columnsWithDuplicates = new HashSet<>();
        Map<Integer, Set<Integer>> columnValuesMap = new HashMap<>();

        for (int row = 0; row < matrixSize; row++) {
            Set<Integer> currentRowValues = new HashSet<>();
            for (int col = 0; col < matrixSize; col++) {
                int value = scanner.nextInt();

                if (!currentRowValues.add(value)) {
                    rowsWithDuplicates.add(row);
                }

                columnValuesMap.computeIfAbsent(col, k -> new HashSet<>());
                if (!columnValuesMap.get(col).add(value)) {
                    columnsWithDuplicates.add(col);
                }

                if (row == col) {
                    diagonalSum += value;
                }
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + diagonalSum + " " + rowsWithDuplicates.size() + " " + columnsWithDuplicates.size());
    }
}