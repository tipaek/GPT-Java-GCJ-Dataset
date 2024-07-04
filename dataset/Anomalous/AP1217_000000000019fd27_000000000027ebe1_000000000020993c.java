import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        List<Integer[][]> matrices = new ArrayList<>();

        for (int caseIndex = 0; caseIndex < testCaseCount; caseIndex++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            if (matrixSize != 0) {
                Integer[][] matrix = new Integer[matrixSize][matrixSize];

                for (int row = 0; row < matrixSize; row++) {
                    String[] values = scanner.nextLine().split(" ");
                    for (int col = 0; col < matrixSize; col++) {
                        matrix[row][col] = values[col].isEmpty() ? 0 : Integer.parseInt(values[col]);
                    }
                }
                matrices.add(matrix);
            }
        }

        scanner.close();

        for (int i = 0; i < matrices.size(); i++) {
            Integer[][] matrix = matrices.get(i);

            int trace = 0;
            int rowRepetitions = 0;
            int colRepetitions = 0;

            // Calculate the trace
            for (int j = 0; j < matrix.length; j++) {
                trace += matrix[j][j];
            }

            // Calculate row repetitions
            for (int row = 0; row < matrix.length; row++) {
                Set<Integer> seen = new HashSet<>();
                for (int col = 0; col < matrix[row].length; col++) {
                    if (!seen.add(matrix[row][col])) {
                        rowRepetitions++;
                        break;
                    }
                }
            }

            // Calculate column repetitions
            for (int col = 0; col < matrix[0].length; col++) {
                Set<Integer> seen = new HashSet<>();
                for (int row = 0; row < matrix.length; row++) {
                    if (!seen.add(matrix[row][col])) {
                        colRepetitions++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRepetitions + " " + colRepetitions);
        }
    }
}