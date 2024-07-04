import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int size = scanner.nextInt();
            List<Integer> matrix = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix.add(scanner.nextInt());
                }
            }

            int trace = calculateTrace(matrix, size);
            int duplicateRows = countDuplicateRows(matrix, size);
            int duplicateCols = countDuplicateCols(matrix, size);

            System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }

    private static int calculateTrace(List<Integer> matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix.get(i * size + i);
        }
        return trace;
    }

    private static int countDuplicateRows(List<Integer> matrix, int size) {
        int duplicateRows = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                rowSet.add(matrix.get(i * size + j));
            }
            if (rowSet.size() < size) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateCols(List<Integer> matrix, int size) {
        int duplicateCols = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                colSet.add(matrix.get(j * size + i));
            }
            if (colSet.size() < size) {
                duplicateCols++;
            }
        }
        return duplicateCols;
    }
}