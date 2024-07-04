import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCases = Integer.parseInt(br.readLine());
        int caseNumber = testCases;

        while (testCases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int expectedSum = (n * (n + 1)) / 2;
            int[][] matrix = new int[n][n];
            int[] columnSums = new int[n];
            int duplicateRows = 0;
            int duplicateColumns = 0;
            int trace = 0;

            for (int i = 0; i < n; i++) {
                String[] rowInput = br.readLine().trim().split("\\s+");
                trace += Integer.parseInt(rowInput[i]);
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(rowInput[j]);
                }
            }

            for (int i = 0; i < n; i++) {
                int rowSum = 0;
                boolean[] rowElements = new boolean[n];
                boolean rowHasDuplicates = false;

                for (int j = 0; j < n; j++) {
                    rowSum += matrix[i][j];
                    columnSums[j] += matrix[i][j];

                    if (rowElements[matrix[i][j] - 1]) {
                        rowHasDuplicates = true;
                    } else {
                        rowElements[matrix[i][j] - 1] = true;
                    }
                }

                if (rowSum != expectedSum || rowHasDuplicates) {
                    duplicateRows++;
                }
            }

            for (int j = 0; j < n; j++) {
                boolean[] colElements = new boolean[n];
                boolean colHasDuplicates = false;

                if (columnSums[j] != expectedSum) {
                    duplicateColumns++;
                } else {
                    for (int i = 0; i < n; i++) {
                        if (colElements[matrix[i][j] - 1]) {
                            colHasDuplicates = true;
                            break;
                        } else {
                            colElements[matrix[i][j] - 1] = true;
                        }
                    }

                    if (colHasDuplicates) {
                        duplicateColumns++;
                    }
                }
            }

            sb.append("Case #").append(caseNumber - testCases).append(": ")
              .append(trace).append(" ").append(duplicateRows).append(" ")
              .append(duplicateColumns).append("\n");
        }

        System.out.print(sb);
    }
}