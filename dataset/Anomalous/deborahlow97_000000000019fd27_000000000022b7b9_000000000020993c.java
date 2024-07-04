import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < testCases; t++) {
            int trace = 0, duplicateRows = 0, duplicateCols = 0;
            int matrixSize = Integer.parseInt(scanner.nextLine());
            ArrayList<HashSet<String>> columns = new ArrayList<>(matrixSize);

            for (int i = 0; i < matrixSize; i++) {
                columns.add(new HashSet<>());
            }

            for (int i = 0; i < matrixSize; i++) {
                String line = scanner.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(line, " ");
                HashSet<String> rowSet = new HashSet<>();
                int colIndex = 0;

                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken();
                    if (colIndex == i) {
                        trace += Integer.parseInt(token);
                    }
                    columns.get(colIndex).add(token);
                    rowSet.add(token);
                    colIndex++;
                }

                if (rowSet.size() < matrixSize) {
                    duplicateRows++;
                }
            }

            for (HashSet<String> columnSet : columns) {
                if (columnSet.size() < matrixSize) {
                    duplicateCols++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", t + 1, trace, duplicateRows, duplicateCols);
        }
    }
}