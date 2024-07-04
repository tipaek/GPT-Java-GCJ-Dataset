import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class Vestigium {

    public static void main(String[] args) throws IOException {
        new Vestigium().execute();
    }

    private void execute() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out, true);

        int numberOfTestCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            int rowDuplicates = 0;

            for (int i = 0; i < matrixSize; i++) {
                String[] rowElements = reader.readLine().split(" ");
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicate = false;

                for (int j = 0; j < matrixSize; j++) {
                    int element = Integer.parseInt(rowElements[j]);
                    matrix[i][j] = element;

                    if (!hasDuplicate && !rowSet.add(element)) {
                        rowDuplicates++;
                        hasDuplicate = true;
                    }
                }
            }

            int diagonalSumResult = calculateDiagonalSum(matrix);
            int columnDuplicates = calculateColumnDuplicates(matrix);

            writer.printf("Case #%d: %d %d %d%n", testCase, diagonalSumResult, rowDuplicates, columnDuplicates);
        }
    }

    private int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private int calculateColumnDuplicates(int[][] matrix) {
        int columnDuplicates = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> columnSet = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                if (!columnSet.add(matrix[j][i])) {
                    columnDuplicates++;
                    break;
                }
            }
        }
        return columnDuplicates;
    }
}