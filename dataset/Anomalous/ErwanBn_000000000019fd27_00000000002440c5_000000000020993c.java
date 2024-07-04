import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test1.txt"))) {
            int numberOfMatrices = Integer.parseInt(reader.readLine());

            for (int i = 0; i < numberOfMatrices; i++) {
                int dimension = Integer.parseInt(reader.readLine());
                ArrayList<int[]> matrix = new ArrayList<>();
                int diagonalSum = 0;
                int maxRowCount = 0;

                for (int row = 0; row < dimension; row++) {
                    String[] numbers = reader.readLine().split(" ");
                    int[] rowValues = new int[dimension];
                    HashMap<Integer, Integer> countMap = new HashMap<>();

                    for (int col = 0; col < numbers.length; col++) {
                        int value = Integer.parseInt(numbers[col]);
                        rowValues[col] = value;
                        countMap.put(value, countMap.getOrDefault(value, 0) + 1);
                        if (row == col) {
                            diagonalSum += value;
                        }
                    }

                    for (int count : countMap.values()) {
                        if (count > maxRowCount) {
                            maxRowCount = count;
                        }
                    }
                    if (maxRowCount == 1) {
                        maxRowCount = 0;
                    }

                    matrix.add(rowValues);
                }

                int maxColCount = 0;

                for (int col = 0; col < dimension; col++) {
                    HashMap<Integer, Integer> countMap = new HashMap<>();
                    for (int row = 0; row < dimension; row++) {
                        int value = matrix.get(row)[col];
                        countMap.put(value, countMap.getOrDefault(value, 0) + 1);
                    }

                    for (int count : countMap.values()) {
                        if (count > maxColCount) {
                            maxColCount = count;
                        }
                    }
                    if (maxColCount == 1) {
                        maxColCount = 0;
                    }
                }

                System.out.println("Case #" + i + " " + diagonalSum + " " + maxRowCount + " " + maxColCount);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}