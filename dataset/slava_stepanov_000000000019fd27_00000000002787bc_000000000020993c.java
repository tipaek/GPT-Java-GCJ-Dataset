import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseNum = in.nextInt();

        for (int caseIndex = 1; caseIndex <= caseNum; caseIndex++) {
            int n = in.nextInt();

            int[][] matrix = new int[n][n];
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    matrix[x][y] = in.nextInt();
                }
            }

            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            int rowsWithRepeated = 0;
            for (int y = 0; y < n; y++) {
                int[] met = new int[n + 1];
                for (int x = 0; x < n; x++) {
                    int c = matrix[x][y];
                    if (met[c] >= 1) {
                        rowsWithRepeated++;
                        break;
                    } else {
                        met[c]++;
                    }

                }
            }

            int columnsWithRepeated = 0;
            for (int x = 0; x < n; x++) {
                int[] met = new int[n + 1];
                for (int y = 0; y < n; y++) {
                    int c = matrix[x][y];
                    if (met[c] >= 1) {
                        columnsWithRepeated++;
                        break;
                    } else {
                        met[c]++;
                    }
                }
            }

            System.out.println(String.format("Case #%s: %s %s %s", caseIndex, trace, rowsWithRepeated, columnsWithRepeated));
        }
    }
    
}