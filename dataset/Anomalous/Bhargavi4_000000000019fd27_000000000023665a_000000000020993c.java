import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class TraceMatrix {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tests = br.readLine();
        if (tests == null) return;

        int t = Integer.parseInt(tests);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {
                matrix[j] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int trace = calculateTrace(matrix, n);
            int rowDuplicates = countRowDuplicates(matrix, n);
            int columnDuplicates = countColumnDuplicates(matrix, n);

            sb.append(String.format("Case #%d: %d %d %d\n", i, trace, rowDuplicates, columnDuplicates));
        }

        System.out.print(sb.toString().trim());
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    duplicateRows++;
                    break;
                }
            }
        }
        return duplicateRows;
    }

    private static int countColumnDuplicates(int[][] matrix, int size) {
        int duplicateColumns = 0;
        for (int j = 0; j < size; j++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    duplicateColumns++;
                    break;
                }
            }
        }
        return duplicateColumns;
    }
}