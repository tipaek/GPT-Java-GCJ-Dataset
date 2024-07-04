import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.next());
        for (int t = 0; t < testCases; t++) {
            int dimension = Integer.parseInt(scanner.next());
            int trace = Integer.parseInt(scanner.next());
            String[][] result = generateMatrix(dimension, trace);
            System.out.print("Case #" + (t + 1) + ": ");
            if (result.length > 60 || result[0].length > 60) {
                System.out.println(result[0][0]);
            } else {
                System.out.println("POSSIBLE");
                for (String[] row : result) {
                    for (String cell : row) {
                        System.out.print(cell + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    private static String[][] generateMatrix(int dimension, int trace) {
        Random random = new Random();
        int[][] matrix = new int[dimension][dimension];
        int attempts = 0;

        while (true) {
            attempts++;
            if (attempts >= 1000) {
                return new String[][]{{"IMPOSSIBLE"}};
            }

            matrix = new int[dimension][dimension];
            int[] diagonalValues = findDiagonalValues(trace, dimension);
            ArrayList<Integer> availableValues = new ArrayList<>();
            for (int value : diagonalValues) {
                availableValues.add(value);
            }

            for (int i = 0; i < dimension; i++) {
                int index = random.nextInt(availableValues.size());
                matrix[i][i] = availableValues.get(index);
                availableValues.remove(index);
            }

            if (fillMatrix(matrix, random)) {
                break;
            }
        }

        String[][] result = new String[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                result[i][j] = String.valueOf(matrix[i][j]);
            }
        }
        return result;
    }

    private static boolean fillMatrix(int[][] matrix, Random random) {
        int dimension = matrix.length;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (matrix[i][j] == 0) {
                    ArrayList<Integer> rowValues = new ArrayList<>();
                    ArrayList<Integer> colValues = new ArrayList<>();
                    for (int k = 0; k < dimension; k++) {
                        rowValues.add(matrix[i][k]);
                    }
                    for (int k = 0; k < dimension; k++) {
                        colValues.add(matrix[k][j]);
                    }

                    boolean placed = false;
                    int attempts = 0;
                    while (!placed) {
                        attempts++;
                        int value = random.nextInt(dimension) + 1;
                        if (attempts >= 1000) {
                            return false;
                        }
                        if (!rowValues.contains(value) && !colValues.contains(value)) {
                            matrix[i][j] = value;
                            placed = true;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static int[] findDiagonalValues(int trace, int dimension) {
        Random random = new Random();
        int[] values = new int[dimension];
        while (true) {
            int sum = 0;
            for (int i = 0; i < dimension; i++) {
                values[i] = random.nextInt(dimension) + 1;
                sum += values[i];
            }
            if (sum == trace) {
                return values;
            }
        }
    }
}