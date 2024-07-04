import java.util.*;

class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            System.out.println("Case #" + caseNum + ": " + solveVestigium(matrixSize, scanner));
        }
    }

    public static String solveVestigium(int size, Scanner scanner) {
        int trace = 0, rowRepeats = 0, colRepeats = 0;
        int[][] matrix = new int[size][size];

        // Read the matrix and calculate the trace
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
        }

        // Check for repeated elements in rows
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    rowRepeats++;
                    break;
                }
            }
        }

        // Check for repeated elements in columns
        for (int j = 0; j < size; j++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    colRepeats++;
                    break;
                }
            }
        }

        return trace + " " + rowRepeats + " " + colRepeats;
    }
}