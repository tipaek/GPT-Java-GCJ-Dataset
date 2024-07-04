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
                int halfN = N /2;

                int sum = 1;
                int depth = 1;
                sb.append(1).append(' ').append(1).append(' ').append(1).append('\n');

                for (; true; depth++) {
                    int j = depth / 2;
                    int target = pascalTriangle[depth][j];
                    sum += target;
                    if (sum > halfN) {
                        sum -= target;
                        break;
                    }
                    sb.append(depth + 1).append(' ').append(j + 1).append(' ').append(sum).append('\n');
                }

                if(depth >= 2){
                    depth--;
                }

                for (; (depth + 2) / 2 < depth; depth--) {
                    int j = (depth + 2) / 2 ;
                    sum += pascalTriangle[depth][j];
                    sb.append(depth + 1).append(' ').append(j + 1).append(' ').append(sum).append('\n');
                }

                for (; sum < N; depth++) {
                    sum++;
                    sb.append(depth + 1).append(' ').append(depth + 1).append(' ').append(sum).append('\n');
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
