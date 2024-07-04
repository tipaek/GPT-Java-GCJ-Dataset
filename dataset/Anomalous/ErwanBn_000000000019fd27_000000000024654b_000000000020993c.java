import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfMatrices = scanner.nextInt();

        for (int i = 0; i < numberOfMatrices; i++) {
            int dimension = scanner.nextInt();
            List<int[]> matrix = new ArrayList<>();

            int maxRowDuplicates = 0;
            int diagonalSum = 0;

            for (int row = 0; row < dimension; row++) {
                int[] rowData = new int[dimension];
                Map<Integer, Integer> frequencyMap = new HashMap<>();

                for (int col = 0; col < dimension; col++) {
                    int number = scanner.nextInt();
                    rowData[col] = number;
                    frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);

                    if (row == col) {
                        diagonalSum += number;
                    }
                }

                int rowMax = frequencyMap.values().stream().max(Integer::compareTo).orElse(0);
                if (rowMax > maxRowDuplicates) {
                    maxRowDuplicates = rowMax;
                }

                matrix.add(rowData);
            }

            if (maxRowDuplicates == 1) {
                maxRowDuplicates = 0;
            }

            int maxColumnDuplicates = 0;

            for (int col = 0; col < dimension; col++) {
                Map<Integer, Integer> frequencyMap = new HashMap<>();

                for (int row = 0; row < dimension; row++) {
                    int number = matrix.get(row)[col];
                    frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
                }

                int colMax = frequencyMap.values().stream().max(Integer::compareTo).orElse(0);
                if (colMax > maxColumnDuplicates) {
                    maxColumnDuplicates = colMax;
                }
            }

            if (maxColumnDuplicates == 1) {
                maxColumnDuplicates = 0;
            }

            System.out.println("Case #" + i + " " + diagonalSum + " " + maxRowDuplicates + " " + maxColumnDuplicates);
        }
    }
}