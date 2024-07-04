import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfMatrices = scanner.nextInt();

        for (int i = 0; i < numberOfMatrices; i++) {
            int dimension = scanner.nextInt();
            ArrayList<int[]> matrix = new ArrayList<>();
            int maxRowCount = 0;
            int diagonalSum = 0;

            for (int row = 0; row < dimension; row++) {
                int[] values = new int[dimension];
                HashMap<Integer, Integer> rowFrequency = new HashMap<>();

                for (int col = 0; col < dimension; col++) {
                    int currentNumber = scanner.nextInt();
                    values[col] = currentNumber;
                    rowFrequency.put(currentNumber, rowFrequency.getOrDefault(currentNumber, 0) + 1);

                    if (row == col) {
                        diagonalSum += currentNumber;
                    }
                }

                maxRowCount = Math.max(maxRowCount, Collections.max(rowFrequency.values()));
                matrix.add(values);
            }

            maxRowCount = (maxRowCount == 1) ? 0 : maxRowCount;
            int maxColumnCount = 0;

            for (int col = 0; col < dimension; col++) {
                HashMap<Integer, Integer> columnFrequency = new HashMap<>();

                for (int row = 0; row < dimension; row++) {
                    int currentNumber = matrix.get(row)[col];
                    columnFrequency.put(currentNumber, columnFrequency.getOrDefault(currentNumber, 0) + 1);
                }

                maxColumnCount = Math.max(maxColumnCount, Collections.max(columnFrequency.values()));
            }

            maxColumnCount = (maxColumnCount == 1) ? 0 : maxColumnCount;

            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + maxRowCount + " " + maxColumnCount);
        }
    }
}