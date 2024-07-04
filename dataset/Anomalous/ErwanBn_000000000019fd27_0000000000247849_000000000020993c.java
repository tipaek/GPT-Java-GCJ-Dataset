import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfMatrices = scanner.nextInt();

        for (int matrixIndex = 0; matrixIndex < numberOfMatrices; matrixIndex++) {
            int dimension = scanner.nextInt();
            ArrayList<int[]> matrix = new ArrayList<>();

            int maxLineDuplicates = 0;
            int diagonalSum = 0;

            for (int rowIndex = 0; rowIndex < dimension; rowIndex++) {
                int[] row = new int[dimension];
                HashMap<Integer, Integer> frequencyMap = new HashMap<>();

                for (int colIndex = 0; colIndex < dimension; colIndex++) {
                    int currentNumber = scanner.nextInt();
                    row[colIndex] = currentNumber;

                    frequencyMap.put(currentNumber, frequencyMap.getOrDefault(currentNumber, 0) + 1);

                    if (rowIndex == colIndex) {
                        diagonalSum += currentNumber;
                    }
                }

                int maxRowDuplicates = frequencyMap.values().stream().max(Integer::compare).orElse(0);
                if (maxRowDuplicates > maxLineDuplicates) {
                    maxLineDuplicates = maxRowDuplicates;
                }

                matrix.add(row);
            }

            if (maxLineDuplicates == 1) {
                maxLineDuplicates = 0;
            }

            int maxColumnDuplicates = 0;

            for (int colIndex = 0; colIndex < dimension; colIndex++) {
                HashMap<Integer, Integer> frequencyMap = new HashMap<>();

                for (int rowIndex = 0; rowIndex < dimension; rowIndex++) {
                    int currentNumber = matrix.get(rowIndex)[colIndex];
                    frequencyMap.put(currentNumber, frequencyMap.getOrDefault(currentNumber, 0) + 1);
                }

                int maxColDuplicates = frequencyMap.values().stream().max(Integer::compare).orElse(0);
                if (maxColDuplicates > maxColumnDuplicates) {
                    maxColumnDuplicates = maxColDuplicates;
                }
            }

            if (maxColumnDuplicates == 1) {
                maxColumnDuplicates = 0;
            }

            if (matrixIndex != 0) {
                System.out.println();
            }
            System.out.printf("Case #%d: %d %d %d", matrixIndex + 1, diagonalSum, maxLineDuplicates, maxColumnDuplicates);
        }
    }
}