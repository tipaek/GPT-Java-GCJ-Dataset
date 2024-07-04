import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {
    private static int trace = 0, rowRepeats = 0, colRepeats = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            calculateVestigium(matrix, t);
            resetCounters();
        }
        
        scanner.close();
    }

    private static void calculateVestigium(int[][] matrix, int caseNumber) {
        computeTrace(matrix);
        computeRepeats(matrix, true); // Check rows for repeats
        computeRepeats(matrix, false); // Check columns for repeats
        
        System.out.printf("Case #%d: %d %d %d%n", caseNumber + 1, trace, rowRepeats, colRepeats);
    }

    private static void computeTrace(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
    }

    private static void computeRepeats(int[][] matrix, boolean checkRows) {
        for (int i = 0; i < matrix.length; i++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                int element = checkRows ? matrix[i][j] : matrix[j][i];
                uniqueElements.add(element);
            }
            if (uniqueElements.size() < matrix.length) {
                if (checkRows) {
                    rowRepeats++;
                } else {
                    colRepeats++;
                }
            }
        }
    }

    private static void resetCounters() {
        trace = 0;
        rowRepeats = 0;
        colRepeats = 0;
    }
}