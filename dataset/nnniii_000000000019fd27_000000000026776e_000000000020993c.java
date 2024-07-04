import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(reader.readLine());

            int square = 0;
            int rowResult = 0;
            int colResult = 0;

            int[][] horizontal = new int[N][N + 1];
            int[][] vertical = new int[N][N + 1];

            for (int row = 0; row < N; row++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());

                int col = 0;
                while (st.hasMoreTokens()) {
                    int value = Integer.parseInt(st.nextToken());
                    if (row == col) square += value;

                    if (horizontal[row][0] != -1 && horizontal[row][value] != 0) {
                        rowResult++;
                        horizontal[row][0] = -1;
                    } else {
                        horizontal[row][value] = value;
                    }

                    if (vertical[col][0] != -1 && vertical[col][value] != 0) {
                        colResult++;
                        vertical[col][0] = -1;
                    } else {
                        vertical[col][value] = value;
                    }
                    col++;
                }
            }

            result.append(String.format("Case #%d: %d %d %d\n", i, square, rowResult, colResult));
        }

        writer.println(result.toString());

        reader.close();
        writer.close();
    }
}
