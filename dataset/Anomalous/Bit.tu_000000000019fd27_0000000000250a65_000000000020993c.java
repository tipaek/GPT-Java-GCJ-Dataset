import java.util.*;
import java.io.*;

class CodeJam {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int[][] results = new int[testCases][3];

        for (int i = 0; i < testCases; i++) {
            int matrixSize = scanner.nextInt();
            int diagonalSum = 0, rowRepeats = 0, colRepeats = 0;
            int[][] matrix = new int[matrixSize][matrixSize];
            Set<Integer> uniqueElements = new HashSet<>();

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    uniqueElements.add(matrix[row][col]);
                }
                if (uniqueElements.size() < matrixSize) rowRepeats++;
                uniqueElements.clear();
                diagonalSum += matrix[row][row];
            }

            results[i][0] = diagonalSum;
            results[i][1] = rowRepeats;

            for (int col = 0; col < matrixSize; col++) {
                for (int row = 0; row < matrixSize; row++) {
                    uniqueElements.add(matrix[row][col]);
                }
                if (uniqueElements.size() < matrixSize) colRepeats++;
                uniqueElements.clear();
            }

            results[i][2] = colRepeats;
            System.out.println("case #" + (i + 1) + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
        System.exit(0);
    }
}