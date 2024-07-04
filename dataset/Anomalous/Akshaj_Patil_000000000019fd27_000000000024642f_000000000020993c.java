import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CodeJam {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        int testNum = 1;

        while (testCases-- > 0) {
            int trace = 0, row = 0, column = 0;
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(input[j]);
                }
            }

            // Calculate trace
            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }

            // Check for duplicate rows
            for (int i = 0; i < N; i++) {
                boolean[] rowHash = new boolean[N];
                boolean flag = false;
                for (int j = 0; j < N; j++) {
                    int num = matrix[i][j] - 1;
                    if (rowHash[num]) {
                        if (!flag) {
                            row++;
                            flag = true;
                        }
                    }
                    rowHash[num] = true;
                }
            }

            // Check for duplicate columns
            for (int i = 0; i < N; i++) {
                boolean[] colHash = new boolean[N];
                boolean flag = false;
                for (int j = 0; j < N; j++) {
                    int num = matrix[j][i] - 1;
                    if (colHash[num]) {
                        if (!flag) {
                            column++;
                            flag = true;
                        }
                    }
                    colHash[num] = true;
                }
            }

            System.out.println("#" + testNum + ": " + trace + " " + row + " " + column);
            testNum++;
        }
    }
}