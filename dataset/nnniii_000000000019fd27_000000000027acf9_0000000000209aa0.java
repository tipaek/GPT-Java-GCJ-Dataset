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
            StringBuilder caseResult = new StringBuilder();

            StringTokenizer st = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            if (K % N != 0) {
                caseResult.append("IMPOSSIBLE");
            } else {
                caseResult.append("POSSIBLE");
                int num = K / N;
                for (int row = 0; row < N; row++) {
                    caseResult.append("\n");
                    for (int col = 0; col < N; col++) {
                        caseResult.append(num);
                        num = num + 1 > N ? 1 : num + 1;
                    }
                    num = num == 1 ? N : num - 1;
                }
            }

            result.append(String.format("Case #%d: %s\n", i, caseResult.toString()));
        }

        writer.println(result.toString());

        reader.close();
        writer.close();
    }
}
