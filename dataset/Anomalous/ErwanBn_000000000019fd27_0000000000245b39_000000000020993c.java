import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfMatrices = scanner.nextInt();

        for (int i = 0; i < numberOfMatrices; i++) {
            int dimension = scanner.nextInt();
            ArrayList<int[]> matrix = new ArrayList<>();
            int maxLineRepetition = 0;
            int diagonalSum = 0;

            // Read matrix and calculate diagonal sum and max line repetitions
            for (int row = 0; row < dimension; row++) {
                int[] currentRow = new int[dimension];
                HashMap<Integer, Integer> frequencyMap = new HashMap<>();
                for (int col = 0; col < dimension; col++) {
                    int number = scanner.nextInt();
                    currentRow[col] = number;
                    frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
                    if (row == col) {
                        diagonalSum += number;
                    }
                }
                matrix.add(currentRow);
                maxLineRepetition = Math.max(maxLineRepetition, frequencyMap.values().stream().max(Integer::compare).orElse(0));
            }

            // Calculate max column repetitions
            int maxColumnRepetition = 0;
            for (int col = 0; col < dimension; col++) {
                HashMap<Integer, Integer> frequencyMap = new HashMap<>();
                for (int row = 0; row < dimension; row++) {
                    int number = matrix.get(row)[col];
                    frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
                }
                maxColumnRepetition = Math.max(maxColumnRepetition, frequencyMap.values().stream().max(Integer::compare).orElse(0));
            }

            if (maxLineRepetition == 1) maxLineRepetition = 0;
            if (maxColumnRepetition == 1) maxColumnRepetition = 0;

            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + maxLineRepetition + " " + maxColumnRepetition);
        }
    }
}