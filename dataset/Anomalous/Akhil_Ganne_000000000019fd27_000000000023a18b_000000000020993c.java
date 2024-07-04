import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(reader.readLine());
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(input[j]);
                }
            }

            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            int duplicateRows = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            int duplicateColumns = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!columnSet.add(matrix[j][i])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }

            writer.write(String.format("Case #%d: %d %d %d%n", caseNumber, trace, duplicateRows, duplicateColumns));
            caseNumber++;
        }

        writer.flush();
    }
}