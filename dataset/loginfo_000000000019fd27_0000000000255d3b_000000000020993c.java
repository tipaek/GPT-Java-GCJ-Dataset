import java.io.*;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder sb = new StringBuilder();

            int T = Integer.parseInt(br.readLine());

            for (int t = 1; t <= T; t++) {
                int N = Integer.parseInt(br.readLine());
                int[][] square = new int[N][N];

                for (int i = 0; i < N; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < N; j++) {
                        square[i][j] = Integer.parseInt(st.nextToken());
                    }
                }


                int k = getTrace(square, N);
                int r = getRepeatableRow(square, N);
                int c = getRepeatableColumn(square, N);

                sb.append(String.format("Case #%d: %d %d %d\n", t, k, r, c));
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }

    private static int getTrace(int[][] square, int N) {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += square[i][i];
        }
        return trace;
    }

    private static int getRepeatableRow(int[][] square, int N) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            boolean[] check = new boolean[N + 1];
            boolean isRepeatable = false;
            for (int j = 0; j < N; j++) {
                int num = square[i][j];
                if (check[num]) {
                    isRepeatable = true;
                    break;
                }
                check[num] = true;
            }
            if (isRepeatable) {
                cnt++;
            }
        }
        return cnt;
    }

    private static int getRepeatableColumn(int[][] square, int N) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            boolean[] check = new boolean[N + 1];
            boolean isRepeatable = false;
            for (int j = 0; j < N; j++) {
                int num = square[j][i];
                if (check[num]) {
                    isRepeatable = true;
                    break;
                }
                check[num] = true;
            }
            if (isRepeatable) {
                cnt++;
            }
        }
        return cnt;
    }
}