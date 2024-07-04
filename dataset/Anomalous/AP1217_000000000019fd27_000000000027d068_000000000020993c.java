import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        List<Integer[][]> matrices = new ArrayList<>();

        scanner.nextLine(); // consume the remaining newline

        for (int i = 0; i < testCaseCount; i++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            if (matrixSize > 0) {
                Integer[][] matrix = new Integer[matrixSize][matrixSize];
                for (int row = 0; row < matrixSize; row++) {
                    String[] values = scanner.nextLine().split(" ");
                    for (int col = 0; col < matrixSize; col++) {
                        matrix[row][col] = Integer.parseInt(values[col]);
                    }
                }
                matrices.add(matrix);
            }
        }

        scanner.close();

        for (int i = 0; i < matrices.size(); i++) {
            Integer[][] matrix = matrices.get(i);
            int trace = calculateTrace(matrix);
            int rowDuplicates = countRowDuplicates(matrix);
            int colDuplicates = countColDuplicates(matrix);

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static int calculateTrace(Integer[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(Integer[][] matrix) {
        int duplicates = 0;
        for (int row = 0; row < matrix.length; row++) {
            Set<Integer> uniqueValues = new HashSet<>();
            for (int col = 0; col < matrix[row].length; col++) {
                if (!uniqueValues.add(matrix[row][col])) {
                    duplicates++;
                    break;
                }
            }
        }
        return duplicates;
    }

    private static int countColDuplicates(Integer[][] matrix) {
        int duplicates = 0;
        for (int col = 0; col < matrix[0].length; col++) {
            Set<Integer> uniqueValues = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                if (!uniqueValues.add(matrix[row][col])) {
                    duplicates++;
                    break;
                }
            }
        }
        return duplicates;
    }
}