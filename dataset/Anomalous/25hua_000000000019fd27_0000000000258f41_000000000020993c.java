import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        byte caseCount = scanner.nextByte();
        byte[][] matrix = new byte[100][100];
        int[] exists = new int[101];

        for (byte caseIndex = 1; caseIndex <= caseCount; caseIndex++) {
            byte n = scanner.nextByte();
            short trace = 0;
            byte rowRepeats = 0;
            byte colRepeats = 0;

            for (int i = 0; i < n; i++) {
                boolean rowFlag = false;
                int rowFlagValue = i + 1;

                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextByte();
                    if (!rowFlag && exists[matrix[i][j]] == rowFlagValue) {
                        rowRepeats++;
                        rowFlag = true;
                    } else {
                        exists[matrix[i][j]] = rowFlagValue;
                    }
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                int colFlagValue = n + i + 1;

                for (int j = 0; j < n; j++) {
                    if (exists[matrix[j][i]] == colFlagValue) {
                        colRepeats++;
                        break;
                    } else {
                        exists[matrix[j][i]] = colFlagValue;
                    }
                }
            }

            Arrays.fill(exists, 0, n + 1, 0);

            System.out.printf("Case #%d: %d %d %d\n", caseIndex, trace, rowRepeats, colRepeats);
        }

        scanner.close();
    }
}