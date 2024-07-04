import java.util.HashSet;
import java.util.Scanner;

public class MatrixProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = 0;
        if (scanner.hasNextLine()) {
            cases = Integer.parseInt(scanner.nextLine());
        }
        for (int i = 0; i < cases; i++) {
            int size = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[size][size];
            for (int j = 0; j < size; j++) {
                String[] rowValues = scanner.nextLine().split(" ");
                for (int k = 0; k < rowValues.length; k++) {
                    matrix[j][k] = Integer.parseInt(rowValues[k]);
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + calculateMatrixProperties(matrix));
        }
    }

    public static String calculateMatrixProperties(int[][] matrix) {
        int trace = 0;
        int rowRepetitions = 0;
        int colRepetitions = 0;
        HashSet<String> colValues = new HashSet<>();
        HashSet<Integer> colRepetitionCheck = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            HashSet<Integer> rowValues = new HashSet<>();
            boolean foundRowRepetition = false;
            for (int j = 0; j < matrix[i].length; j++) {
                int currentValue = matrix[i][j];
                if (i == j) {
                    trace += currentValue;
                }
                String colKey = j + "," + currentValue;
                if (colValues.contains(colKey) && !colRepetitionCheck.contains(j)) {
                    colRepetitions++;
                    colRepetitionCheck.add(j);
                } else {
                    colValues.add(colKey);
                }
                if (rowValues.contains(currentValue) && !foundRowRepetition) {
                    rowRepetitions++;
                    foundRowRepetition = true;
                } else {
                    rowValues.add(currentValue);
                }
            }
        }
        return trace + " " + rowRepetitions + " " + colRepetitions;
    }
}