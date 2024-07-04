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
            int trace = 0, rowRepeatCount = 0, colRepeatCount = 0;
            int[][] colMemory = new int[n + 1][n + 1];

            for (int i = 0; i < n; i++) {
                String[] row = reader.readLine().split(" ");
                Set<Integer> uniqueRowElements = new HashSet<>();
                boolean rowHasDuplicates = false;

                for (int j = 0; j < n; j++) {
                    int value = Integer.parseInt(row[j]);
                    if (i == j) trace += value;
                    colMemory[j][value]++;
                    if (!rowHasDuplicates && !uniqueRowElements.add(value)) {
                        rowRepeatCount++;
                        rowHasDuplicates = true;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (colMemory[i][j] > 1) {
                        colRepeatCount++;
                        break;
                    }
                }
            }

            writer.append(String.format("Case #%d: %d %d %d", caseNumber++, trace, rowRepeatCount, colRepeatCount));
            if (testCases > 0) writer.append("\n");
        }

        writer.close();
    }
}