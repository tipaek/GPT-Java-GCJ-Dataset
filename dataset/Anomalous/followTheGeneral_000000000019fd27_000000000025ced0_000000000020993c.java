import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Vestigium {

    public static void main(String[] args) {
        new Vestigium().execute();
    }

    private void execute() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(reader.readLine());
            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                int n = Integer.parseInt(reader.readLine());
                int[][] matrix = new int[n][n];
                int rowDuplicates = 0;

                for (int i = 0; i < n; i++) {
                    String[] rowItems = reader.readLine().split(" ");
                    Set<Integer> rowSet = new HashSet<>();
                    boolean hasRowDuplicate = false;

                    for (int j = 0; j < n; j++) {
                        int value = Integer.parseInt(rowItems[j]);
                        matrix[i][j] = value;
                        if (!hasRowDuplicate && !rowSet.add(value)) {
                            rowDuplicates++;
                            hasRowDuplicate = true;
                        }
                    }
                }

                int diagonalSum = calculateDiagonalSum(matrix);
                int columnDuplicates = countColumnDuplicates(matrix);

                System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private int countColumnDuplicates(int[][] matrix) {
        int columnDuplicates = 0;
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            Set<Integer> columnSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!columnSet.add(matrix[j][i])) {
                    columnDuplicates++;
                    break;
                }
            }
        }
        return columnDuplicates;
    }
}