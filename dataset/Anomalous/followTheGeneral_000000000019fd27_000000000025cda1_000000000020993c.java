import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        new Main().execute();
    }

    private void execute() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(reader.readLine());

            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                int n = Integer.parseInt(reader.readLine());
                int[][] matrix = new int[n][n];

                int rowDuplicates = 0;

                for (int i = 0; i < n; i++) {
                    String[] rowItems = reader.readLine().split(" ");
                    Set<Integer> rowSet = new HashSet<>();
                    boolean hasRowDup = false;

                    for (int j = 0; j < n; j++) {
                        int value = Integer.parseInt(rowItems[j]);
                        matrix[i][j] = value;

                        if (!hasRowDup && !rowSet.add(value)) {
                            rowDuplicates++;
                            hasRowDup = true;
                        }
                    }
                }

                int diagonalSum = calculateDiagonalSum(matrix);
                int columnDuplicates = countColumnDuplicates(matrix);

                System.out.printf("Case #%d: %d %d %d%n", caseNum, diagonalSum, rowDuplicates, columnDuplicates);
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
        int colDuplicates = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                if (!colSet.add(matrix[j][i])) {
                    colDuplicates++;
                    break;
                }
            }
        }
        return colDuplicates;
    }
}