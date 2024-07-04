import java.util.*;
import java.io.*;

public class Vesticum {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numCases = Integer.parseInt(input.nextLine());

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int trace = 0, rowIssues = 0, colIssues = 0;
            int matrixSize = Integer.parseInt(input.nextLine());
            List<Set<String>> columns = new ArrayList<>(matrixSize);

            for (int i = 0; i < matrixSize; i++) {
                columns.add(new HashSet<>());
            }

            for (int row = 0; row < matrixSize; row++) {
                String[] values = input.nextLine().split(" ");
                Set<String> rowSet = new HashSet<>();

                for (int col = 0; col < matrixSize; col++) {
                    String value = values[col];
                    if (row == col) {
                        trace += Integer.parseInt(value);
                    }
                    columns.get(col).add(value);
                    rowSet.add(value);
                }

                if (rowSet.size() < matrixSize) {
                    rowIssues++;
                }
            }

            for (Set<String> colSet : columns) {
                if (colSet.size() < matrixSize) {
                    colIssues++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNum, trace, rowIssues, colIssues);
        }
    }
}