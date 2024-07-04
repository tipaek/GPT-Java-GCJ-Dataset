import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MatrixProcessor {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test1.txt"))) {
            int numberOfMatrices = Integer.parseInt(reader.readLine());

            for (int i = 0; i < numberOfMatrices; i++) {
                int dimension = Integer.parseInt(reader.readLine());
                ArrayList<int[]> matrix = new ArrayList<>();

                int maxLineRepetitions = 0;
                int diagonalSum = 0;

                for (int row = 0; row < dimension; row++) {
                    String[] numbers = reader.readLine().split(" ");
                    int[] rowValues = new int[dimension];
                    HashMap<Integer, Integer> frequencyCount = new HashMap<>();

                    for (int col = 0; col < numbers.length; col++) {
                        int currentNumber = Integer.parseInt(numbers[col]);
                        rowValues[col] = currentNumber;

                        frequencyCount.put(currentNumber, frequencyCount.getOrDefault(currentNumber, 0) + 1);

                        if (row == col) {
                            diagonalSum += currentNumber;
                        }
                    }

                    for (int count : frequencyCount.values()) {
                        if (count > maxLineRepetitions) {
                            maxLineRepetitions = count;
                        }
                    }

                    if (maxLineRepetitions == 1) {
                        maxLineRepetitions = 0;
                    }

                    matrix.add(rowValues);
                }

                int maxColumnRepetitions = 0;

                for (int col = 0; col < dimension; col++) {
                    HashMap<Integer, Integer> frequencyCount = new HashMap<>();

                    for (int row = 0; row < dimension; row++) {
                        int currentNumber = matrix.get(row)[col];
                        frequencyCount.put(currentNumber, frequencyCount.getOrDefault(currentNumber, 0) + 1);
                    }

                    for (int count : frequencyCount.values()) {
                        if (count > maxColumnRepetitions) {
                            maxColumnRepetitions = count;
                        }
                    }

                    if (maxColumnRepetitions == 1) {
                        maxColumnRepetitions = 0;
                    }
                }

                System.out.println("Case #" + i + " " + diagonalSum + " " + maxLineRepetitions + " " + maxColumnRepetitions);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}