import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine().trim());
        int b = Integer.parseInt(br.readLine().trim());
        
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            int D = Integer.parseInt(br.readLine().trim());
            int ans = D - 1;

            BigInteger[] cakes = new BigInteger[N];
            for (int i = 0; i < N; i++) {
                cakes[i] = new BigInteger(br.readLine().trim());
            }

            outerLoop:
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (cakes[i].equals(cakes[j]) && D == 2) {
                        ans = 0;
                        break outerLoop;
                    }
                }
            }

            outerLoop:
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    for (int k = j + 1; k < N; k++) {
                        if (cakes[i].equals(cakes[j]) && cakes[j].equals(cakes[k]) && D == 3) {
                            ans = 0;
                            break outerLoop;
                        }
                    }
                    if ((cakes[i].compareTo(cakes[j].multiply(BigInteger.valueOf(2))) == 0
                            || cakes[j].compareTo(cakes[i].multiply(BigInteger.valueOf(2))) == 0) && D == 3 && ans != 0) {
                        ans = 1;
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + ans);
        }
    }
}