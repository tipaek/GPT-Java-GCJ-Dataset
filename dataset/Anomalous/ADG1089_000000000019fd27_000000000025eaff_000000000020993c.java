import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int matrixSize = sc.nextInt();
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            List<Set<Integer>> columns = new ArrayList<>();
            List<Set<Integer>> rows = new ArrayList<>();
            for (int i = 0; i < matrixSize; i++) {
                columns.add(new HashSet<>());
                rows.add(new HashSet<>());
            }

            Set<Integer> duplicateRows = new HashSet<>();
            Set<Integer> duplicateCols = new HashSet<>();

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    int value = sc.nextInt();
                    if (i == j) {
                        trace += value;
                    }
                    if (!columns.get(i).add(value)) {
                        duplicateCols.add(i);
                    }
                    if (!rows.get(j).add(value)) {
                        duplicateRows.add(j);
                    }
                }
            }

            colDuplicates = duplicateRows.size();
            rowDuplicates = duplicateCols.size();

            System.out.printf("Case #%d: %d %d %d\n", caseNumber, trace, rowDuplicates, colDuplicates);
            caseNumber++;
        }
    }
}