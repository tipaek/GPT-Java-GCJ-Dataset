import org.springframework.security.access.method.P;

import java.io.*;

public class Solution {
    private static final int MAX_STEP = 500;
    private static int[][] pascalTriangle = new int[MAX_STEP][MAX_STEP];

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder sb = new StringBuilder();
            int T = Integer.parseInt(br.readLine());

            makePascalTriangle();

            for (int t = 1; t <= T; t++) {
                sb.append(String.format("Case #%d:\n", t));
                int N = Integer.parseInt(br.readLine());
                int halfN = N * 11 / 20;

                int sum = 0;
                int depth = 0;
                for (; true; depth++) {
                    int j = depth / 2;
                    int target = pascalTriangle[depth][j];
                    sum += target;
                    if (sum > halfN) {
                        sum -= target;
                        break;
                    }
                    sb.append(depth + 1).append(' ').append(j + 1).append('\n');
                }

                for (depth--; (depth + 2) / 2 < depth; depth--) {
                    int j = (depth + 2) / 2 ;
                    sum += pascalTriangle[depth][j];
                    sb.append(depth + 1).append(' ').append(j + 1).append('\n');
                }

                for (; sum < N; depth++) {
                    sum++;
                    sb.append(depth + 1).append(' ').append(depth + 1).append('\n');
                }
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }


    private static void makePascalTriangle() {
        for (int i = 0; i < MAX_STEP; i++) {
            pascalTriangle[i][0] = 1;
            pascalTriangle[i][i] = 1;
        }

        for (int i = 1; i < MAX_STEP; i++) {
            for (int j = 1; j < i; j++) {
                pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];
            }
        }
    }
}
