import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = in.nextInt();
        StringBuilder solution = new StringBuilder();

        for (int currentCase = 1; currentCase <= numCases; currentCase++) {
            int matrixSize = in.nextInt();
            int trace = 0;
            int duplicateRowsCount = 0;
            int duplicateColumnsCount = 0;

            List<Set<Integer>> columns = new ArrayList<>(Collections.nCopies(matrixSize, new HashSet<>()));
            Set<Integer> duplicateColumns = new HashSet<>();

            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> currentRow = new HashSet<>();
                boolean isDuplicateRow = false;

                for (int j = 0; j < matrixSize; j++) {
                    int element = in.nextInt();

                    if (i == j) {
                        trace += element;
                    }

                    if (!isDuplicateRow && !currentRow.add(element)) {
                        isDuplicateRow = true;
                        duplicateRowsCount++;
                    }

                    if (!duplicateColumns.contains(j) && !columns.get(j).add(element)) {
                        duplicateColumns.add(j);
                        duplicateColumnsCount++;
                    }
                }
            }

            solution.append("Case #").append(currentCase).append(": ")
                    .append(trace).append(" ")
                    .append(duplicateRowsCount).append(" ")
                    .append(duplicateColumnsCount).append("\n");
        }

        System.out.print(solution.toString());
    }
}