import java.util.*;

public class Solution {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                String[] line = scanner.nextLine().trim().split(" ");
                for (int j = 0; j < line.length; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }

            computeTrace(matrix, caseNumber);
        }
    }

    public static void computeTrace(int[][] matrix, int caseNumber) {
        int trace = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;

        int size = matrix.length;
        List<Set<Integer>> rowSets = new ArrayList<>();
        List<Set<Integer>> columnSets = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                rowSet.add(matrix[i][j]);
            }
            rowSets.add(rowSet);
        }

        for (int j = 0; j < size; j++) {
            Set<Integer> columnSet = new HashSet<>();
            for (int i = 0; i < size; i++) {
                columnSet.add(matrix[i][j]);
            }
            columnSets.add(columnSet);
        }

        for (Set<Integer> rowSet : rowSets) {
            if (rowSet.size() != size) {
                duplicateRows++;
            }
        }

        for (Set<Integer> columnSet : columnSets) {
            if (columnSet.size() != size) {
                duplicateColumns++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }
}