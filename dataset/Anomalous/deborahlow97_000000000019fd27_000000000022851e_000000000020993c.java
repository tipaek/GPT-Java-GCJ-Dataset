import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Vesticum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            List<Set<String>> columns = new ArrayList<>(matrixSize);
            for (int i = 0; i < matrixSize; i++) {
                columns.add(new HashSet<>());
            }

            for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                String[] rowValues = scanner.nextLine().split(" ");
                Set<String> rowSet = new HashSet<>(Arrays.asList(rowValues));

                if (rowSet.size() < matrixSize) {
                    rowRepeats++;
                }

                for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                    String value = rowValues[colIndex];
                    columns.get(colIndex).add(value);

                    if (rowIndex == colIndex) {
                        trace += Integer.parseInt(value);
                    }
                }
            }

            for (Set<String> columnSet : columns) {
                if (columnSet.size() < matrixSize) {
                    colRepeats++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseIndex, trace, rowRepeats, colRepeats);
        }
    }
}