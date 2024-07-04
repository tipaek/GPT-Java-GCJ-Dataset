import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int matrixSize = scanner.nextInt();
            int trace = 0;

            Map<Integer, Set<Integer>> columns = new HashMap<>();
            Map<Integer, Set<Integer>> rows = new HashMap<>();

            for (int i = 0; i < matrixSize; i++) {
                columns.put(i, new HashSet<>());
                rows.put(i, new HashSet<>());
                for (int j = 1; j <= matrixSize; j++) {
                    columns.get(i).add(j);
                    rows.get(i).add(j);
                }
            }

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();

                    columns.get(col).remove(value);
                    rows.get(row).remove(value);

                    if (row == col) {
                        trace += value;
                    }
                }
            }

            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 0; i < matrixSize; i++) {
                if (!rows.get(i).isEmpty()) {
                    duplicateRows++;
                }
                if (!columns.get(i).isEmpty()) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}