import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        for(int j = 1; j<=M; j++) {
            int N = Integer.parseInt(br.readLine());

            int trace = 0;
            int r = 0;
            int c = 0;
            boolean[][] xUsed = new boolean[N][N];
            boolean[][] yUsed = new boolean[N][N];

            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                trace += matrix[i][i];
                if (Arrays.stream(matrix[i]).distinct().toArray().length < N) {
                    r++;
                }
            }
            for (int i = 0; i < N; i++) {
                final int column = i;
                if (Arrays.stream(matrix).mapToInt(row -> row[column]).distinct().toArray().length < N) {
                    c++;
                }
            }
            System.out.format("Case #%d: %d %d %d\n", j, trace, r, c);
        }
    }
}
