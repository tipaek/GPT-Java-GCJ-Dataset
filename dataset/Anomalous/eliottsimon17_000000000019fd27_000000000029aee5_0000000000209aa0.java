import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(scanner.next());
        
        for (int i = 0; i < testCount; i++) {
            int dimension = Integer.parseInt(scanner.next());
            int trace = Integer.parseInt(scanner.next());
            String[][] result = generateMatrix(dimension, trace);
            
            System.out.print("Case #" + (i + 1) + ": ");
            if (result.length > 60 || result[0].length > 60) {
                System.out.print(result[0][0]);
            } else {
                System.out.println("POSSIBLE");
                for (String[] row : result) {
                    for (String value : row) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    private static String[][] generateMatrix(int dimension, int trace) {
        Random rand = new Random();
        int[][] matrix = new int[dimension][dimension];
        int attempts = 0;
        
        while (true) {
            attempts++;
            if (attempts >= 1000) {
                return new String[][] { { "IMPOSSIBLE" } };
            }
            
            matrix = new int[dimension][dimension];
            int[] candidates = findCandidates(trace, dimension);
            ArrayList<Integer> candidateList = new ArrayList<>();
            for (int candidate : candidates) {
                candidateList.add(candidate);
            }
            
            for (int i = 0; i < dimension; i++) {
                int index = rand.nextInt(candidateList.size());
                matrix[i][i] = candidateList.get(index);
                candidateList.remove(index);
            }
            
            if (fillMatrix(matrix, rand)) {
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

    private static boolean fillMatrix(int[][] matrix, Random rand) {
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
                    
                    boolean found = false;
                    int attempts = 0;
                    while (!found) {
                        attempts++;
                        int randomValue = rand.nextInt(dimension) + 1;
                        if (attempts >= 1000) {
                            return false;
                        }
                        if (!rowValues.contains(randomValue) && !colValues.contains(randomValue)) {
                            matrix[i][j] = randomValue;
                            found = true;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static int[] findCandidates(int trace, int dimension) {
        Random rand = new Random();
        int[] candidates = new int[dimension];
        
        while (true) {
            int sum = 0;
            for (int i = 0; i < dimension; i++) {
                candidates[i] = rand.nextInt(dimension) + 1;
                sum += candidates[i];
            }
            if (sum == trace) {
                return candidates;
            }
        }
    }
}