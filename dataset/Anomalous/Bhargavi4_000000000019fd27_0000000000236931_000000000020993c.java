import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

class TraceMatrix {

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
                String row = br.readLine();
                matrix[j] = Stream.of(row.split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int trace = calculateTrace(matrix, n);
            int rowDuplicates = countDuplicatesInRows(matrix, n);
            int columnDuplicates = countDuplicatesInColumns(matrix, n);

            sb.append("Case #").append(i).append(": ").append(trace).append(" ").append(rowDuplicates).append(" ").append(columnDuplicates).append("\n");
        }

        System.out.print(sb.toString().trim());
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicatesInRows(int[][] matrix, int n) {
        int duplicateRows = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    duplicateRows++;
                    break;
                }
            }
        }
        return duplicateRows;
    }

    private static int countDuplicatesInColumns(int[][] matrix, int n) {
        int duplicateColumns = 0;
        for (int j = 0; j < n; j++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    duplicateColumns++;
                    break;
                }
            }
        }
        return duplicateColumns;
    }
}