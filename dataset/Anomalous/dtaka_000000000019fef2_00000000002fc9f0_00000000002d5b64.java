import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= T; t++) {
            String[] inputs = reader.readLine().split(" ");
            int R = Integer.parseInt(inputs[0]);
            int S = Integer.parseInt(inputs[1]);

            int result = (R - 1) * (S - 1);
            System.out.printf("Case #%d: %d%n", t, result);

            int n = R * S - 1 - R;
            for (int i = R; i > 1; i--) {
                for (int j = 0; j < S - 1; j++) {
                    System.out.printf("%d %d%n", i, n);
                    n--;
                }
            }
        }
    }
}