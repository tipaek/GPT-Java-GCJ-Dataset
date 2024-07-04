import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        byte caseCount = scanner.nextByte();
        byte[][] matrix = new byte[100][100];
        int[] exists = new int[100];

        for (byte caseIndex = 1; caseIndex <= caseCount; caseIndex++) {
            byte n = scanner.nextByte();
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                boolean rowFlag = false;
                int rowCheckFlag = i + 1;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextByte();
                    if (!rowFlag && exists[matrix[i][j]] == rowCheckFlag) {
                        rowDuplicates++;
                        rowFlag = true;
                    } else {
                        exists[matrix[i][j]] = rowCheckFlag;
                    }
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for column duplicates
            for (int i = 0; i < n; i++) {
                int colCheckFlag = n + i + 1;
                for (int j = 0; j < n; j++) {
                    if (exists[matrix[j][i]] == colCheckFlag) {
                        colDuplicates++;
                        break;
                    } else {
                        exists[matrix[j][i]] = colCheckFlag;
                    }
                }
            }

            // Reset the exists array
            Arrays.fill(exists, 0);

            System.out.printf("Case #%d: %d %d %d\n", caseIndex, trace, rowDuplicates, colDuplicates);
        }
        scanner.close();
    }
}