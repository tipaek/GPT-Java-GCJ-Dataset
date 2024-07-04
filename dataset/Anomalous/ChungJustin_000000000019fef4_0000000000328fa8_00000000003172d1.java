import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().trim().split(" ");
            int b = Integer.parseInt(input[0]);
            int N = Integer.parseInt(input[1]);
            int D = Integer.parseInt(input[2]);

            BigInteger[] cakes = new BigInteger[N];
            for (int i = 0; i < N; i++) {
                cakes[i] = new BigInteger(br.readLine().trim());
            }

            int ans = D - 1;

            if (D == 2) {
                for (int i = 0; i < N; i++) {
                    for (int j = i + 1; j < N; j++) {
                        if (cakes[i].equals(cakes[j])) {
                            ans = 0;
                        }
                    }
                }
            } else if (D == 3) {
                for (int i = 0; i < N; i++) {
                    for (int j = i + 1; j < N; j++) {
                        for (int k = j + 1; k < N; k++) {
                            if (cakes[i].equals(cakes[j]) && cakes[j].equals(cakes[k])) {
                                ans = 0;
                            }
                        }
                        if (ans != 0 && (cakes[i].equals(cakes[j].multiply(BigInteger.valueOf(2))) || cakes[j].equals(cakes[i].multiply(BigInteger.valueOf(2))))) {
                            ans = 1;
                        }
                    }
                }
            }

            System.out.printf("Case #%d: %d%n", t + 1, ans);
        }
    }
}