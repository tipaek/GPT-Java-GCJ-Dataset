import java.util.*;
import java.util.stream.Collectors;

public class MatrixTrace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = 0;
        int x = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < x; i++) {
            int y = Integer.parseInt(scanner.nextLine().trim());

            // List to store the matrix
            List<List<Integer>> matrix = new ArrayList<>();
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            // Read the matrix
            for (int j = 0; j < y; j++) {
                List<Integer> row = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                                          .map(Integer::parseInt)
                                          .collect(Collectors.toList());
                matrix.add(row);

                // Check for duplicate rows
                Set<Integer> rowSet = new HashSet<>(row);
                if (rowSet.size() < row.size()) {
                    duplicateRows++;
                }
            }

            // Check for duplicate columns
            for (int j = 0; j < y; j++) {
                List<Integer> column = new ArrayList<>();
                for (int k = 0; k < y; k++) {
                    column.add(matrix.get(k).get(j));
                }
                Set<Integer> columnSet = new HashSet<>(column);
                if (columnSet.size() < column.size()) {
                    duplicateColumns++;
                }
            }

            // Calculate the trace
            for (int j = 0; j < y; j++) {
                trace += matrix.get(j).get(j);
            }

            caseNumber++;
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, duplicateRows, duplicateColumns);
        }
        scanner.close();
    }
}