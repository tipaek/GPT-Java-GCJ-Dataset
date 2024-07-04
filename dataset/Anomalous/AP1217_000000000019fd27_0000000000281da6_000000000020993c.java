import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        List<Integer[][]> matrices = new ArrayList<>();

        for (int i = 0; i < testCaseCount; i++) {
            int size = Integer.parseInt(scanner.nextLine());
            if (size > 0) {
                Integer[][] matrix = new Integer[size][size];
                for (int row = 0; row < size; row++) {
                    String[] values = scanner.nextLine().split(" ");
                    for (int col = 0; col < size; col++) {
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
            int colDuplicates = countColumnDuplicates(matrix);

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
        for (Integer[] row : matrix) {
            Set<Integer> seen = new HashSet<>();
            for (int value : row) {
                if (!seen.add(value)) {
                    duplicates++;
                    break;
                }
            }
        }
        return duplicates;
    }

    private static int countColumnDuplicates(Integer[][] matrix) {
        int duplicates = 0;
        int size = matrix.length;
        for (int col = 0; col < size; col++) {
            Set<Integer> seen = new HashSet<>();
            for (int row = 0; row < size; row++) {
                int value = matrix[row][col];
                if (!seen.add(value)) {
                    duplicates++;
                    break;
                }
            }
        }
        return duplicates;
    }
}