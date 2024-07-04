import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(reader.readLine());

        for (int cc = 1; cc <= cases; cc++) {
            int d = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[d][d];

            for (int i = 0; i < d; i++) {
                String[] row = reader.readLine().split(" ");
                for (int j = 0; j < d; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }

            int trace = calculateTrace(matrix, d);
            int rowDuplicates = countRowDuplicates(matrix, d);
            int columnDuplicates = countColumnDuplicates(matrix, d);

            System.out.printf("Case #%d: %d %d %d\n", cc, trace, rowDuplicates, columnDuplicates);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix, int size) {
        int rowDuplicates = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!seen.add(matrix[i][j])) {
                    rowDuplicates++;
                    break;
                }
            }
        }
        return rowDuplicates;
    }

    private static int countColumnDuplicates(int[][] matrix, int size) {
        int columnDuplicates = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!seen.add(matrix[j][i])) {
                    columnDuplicates++;
                    break;
                }
            }
        }
        return columnDuplicates;
    }
}