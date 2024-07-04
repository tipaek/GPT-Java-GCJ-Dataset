import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(reader.readLine());
            int trace = 0, rowCount = 0, columnCount = 0;
            String[][] matrix = new String[n][n];
            boolean[] uniqueChecker = new boolean[n + 1];

            for (int i = 0; i < n; i++) {
                Arrays.fill(uniqueChecker, false);
                String[] row = reader.readLine().split("\\s+");
                matrix[i] = row;
                for (int j = 0; j < n; j++) {
                    int element = Integer.parseInt(row[j]);
                    if (!uniqueChecker[element]) {
                        uniqueChecker[element] = true;
                    } else {
                        rowCount++;
                        break;
                    }
                }
                trace += Integer.parseInt(row[i]);
            }

            for (int j = 0; j < n; j++) {
                Arrays.fill(uniqueChecker, false);
                for (int i = 0; i < n; i++) {
                    int element = Integer.parseInt(matrix[i][j]);
                    if (!uniqueChecker[element]) {
                        uniqueChecker[element] = true;
                    } else {
                        columnCount++;
                        break;
                    }
                }
            }

            writer.println("Case #" + testCase + ": " + trace + " " + rowCount + " " + columnCount);
        }

        reader.close();
        writer.close();
    }
}