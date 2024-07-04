import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            long[][] matrix = new long[rows][columns];
            
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    matrix[row][column] = scanner.nextLong();
                }
            }
            
            long result = calculateInterest(matrix);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static long calculateInterest(long[][] matrix) {
        List<Long> interestList = new ArrayList<>();
        long currentInterest = calculateSum(matrix);
        
        while (interestList.isEmpty() || currentInterest != interestList.get(interestList.size() - 1)) {
            interestList.add(currentInterest);
            eliminateCells(matrix);
            currentInterest = calculateSum(matrix);
        }
        
        long totalInterest = 0;
        for (long interest : interestList) {
            totalInterest += interest;
        }
        
        return totalInterest;
    }

    private static void eliminateCells(long[][] matrix) {
        List<List<Integer>> neighbors = new ArrayList<>();
        int columns = matrix[0].length;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < columns; j++) {
                neighbors.add(new ArrayList<>());
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            int previousColumn = -1;
            for (int column = 0; column < columns; column++) {
                if (matrix[row][column] > 0) {
                    if (previousColumn != -1) {
                        neighbors.get(row * columns + previousColumn).add(row * columns + column);
                        neighbors.get(row * columns + column).add(row * columns + previousColumn);
                    }
                    previousColumn = column;
                }
            }
        }

        for (int column = 0; column < columns; column++) {
            int previousRow = -1;
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][column] > 0) {
                    if (previousRow != -1) {
                        neighbors.get(previousRow * columns + column).add(row * columns + column);
                        neighbors.get(row * columns + column).add(previousRow * columns + column);
                    }
                    previousRow = row;
                }
            }
        }

        List<Integer> cellsToRemove = new ArrayList<>();
        for (int index = 0; index < neighbors.size(); index++) {
            int row = index / columns;
            int column = index % columns;
            if (matrix[row][column] > 0) {
                double average = 0;
                for (Integer neighbor : neighbors.get(index)) {
                    int neighborRow = neighbor / columns;
                    int neighborColumn = neighbor % columns;
                    average += matrix[neighborRow][neighborColumn];
                }
                average /= neighbors.get(index).size();
                if (average > matrix[row][column]) {
                    cellsToRemove.add(index);
                }
            }
        }

        for (int index : cellsToRemove) {
            int row = index / columns;
            int column = index % columns;
            matrix[row][column] = 0;
        }
    }

    private static long calculateSum(long[][] matrix) {
        long sum = 0;
        for (long[] row : matrix) {
            for (long value : row) {
                sum += value;
            }
        }
        return sum;
    }
}