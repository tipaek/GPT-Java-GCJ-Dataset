import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCases = Integer.parseInt(reader.readLine());
        int caseNumber = 1;

        while (testCases-- > 0) {
            int matrixSize = Integer.parseInt(reader.readLine());
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            int[][] colMemory = new int[matrixSize + 1][matrixSize + 1];

            for (int i = 0; i < matrixSize; i++) {
                String[] row = reader.readLine().split(" ");
                Set<Integer> uniqueElements = new HashSet<>();
                boolean hasDuplicate = false;

                for (int j = 0; j < matrixSize; j++) {
                    int element = Integer.parseInt(row[j]);

                    if (i == j) {
                        trace += element;
                    }

                    colMemory[j][element]++;

                    if (!hasDuplicate) {
                        if (uniqueElements.contains(element)) {
                            rowDuplicates++;
                            hasDuplicate = true;
                        }
                        uniqueElements.add(element);
                    }
                }
            }

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 1; j <= matrixSize; j++) {
                    if (colMemory[i][j] > 1) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            writer.append("Case #").append(String.valueOf(caseNumber++)).append(": ")
                  .append(String.valueOf(trace)).append(" ")
                  .append(String.valueOf(rowDuplicates)).append(" ")
                  .append(String.valueOf(colDuplicates));

            if (testCases > 0) {
                writer.append("\n");
            }
        }

        writer.close();
    }
}