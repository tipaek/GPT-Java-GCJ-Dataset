import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int duplicateInRows = 0;
            int duplicateInColumns = 0;

            Map<Integer, Set<Integer>> rowValues = new HashMap<>();
            Map<Integer, Set<Integer>> columnValues = new HashMap<>();

            for (int row = 0; row < matrixSize; row++) {
                for (int column = 0; column < matrixSize; column++) {
                    int value = scanner.nextInt();

                    rowValues.putIfAbsent(row, new HashSet<>());
                    columnValues.putIfAbsent(column, new HashSet<>());

                    if (!rowValues.get(row).add(value)) {
                        duplicateInRows++;
                    }

                    if (!columnValues.get(column).add(value)) {
                        duplicateInColumns++;
                    }
                }
            }

            System.out.println(String.format("Case #%d: %d %d %d", caseNumber, matrixSize, duplicateInRows, duplicateInColumns));
        }
    }
}