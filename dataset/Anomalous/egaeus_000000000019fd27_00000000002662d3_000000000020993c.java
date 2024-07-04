import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeJam2020QRA {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int i = 0; i < N; i++) {
                boolean[] rowCheck = new boolean[N];
                boolean[] colCheck = new boolean[N];
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int j = 0; j < N; j++) {
                    // Calculate trace
                    if (i == j) {
                        trace += matrix[i][j];
                    }

                    // Check for duplicates in rows
                    if (rowCheck[matrix[i][j] - 1]) {
                        rowHasDuplicate = true;
                    } else {
                        rowCheck[matrix[i][j] - 1] = true;
                    }

                    // Check for duplicates in columns
                    if (colCheck[matrix[j][i] - 1]) {
                        colHasDuplicate = true;
                    } else {
                        colCheck[matrix[j][i] - 1] = true;
                    }
                }

                if (rowHasDuplicate) {
                    rowRepeats++;
                }

                if (colHasDuplicate) {
                    colRepeats++;
                }
            }

            result.append("Case #").append(t).append(": ")
                  .append(trace).append(" ")
                  .append(rowRepeats).append(" ")
                  .append(colRepeats).append("\n");
        }

        System.out.print(result.toString());
    }
}