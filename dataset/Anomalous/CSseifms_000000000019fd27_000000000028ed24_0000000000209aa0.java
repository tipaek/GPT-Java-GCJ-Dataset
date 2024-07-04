import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {

    static ConcurrentHashMap<Integer, String> output = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        int T, N, K;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            T = Integer.parseInt(br.readLine().trim());
            for (int t = 0; t < T; t++) {
                String[] NK = br.readLine().split("\\s+");
                N = Integer.parseInt(NK[0]);
                K = Integer.parseInt(NK[1]);
                if (K % N == 0 && K <= (N * N)) {
                    Solver solver = new Solver(t, N, K);
                    new Thread(solver).start();
                } else {
                    output.put(t, "IMPOSSIBLE");
                }
            }

            // Wait for all threads to complete
            while (output.size() != T) {
                Thread.yield();
            }

            // Output results
            for (int i = 0; i < T; i++) {
                System.out.println("Case #" + (i + 1) + ": " + output.get(i));
            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    static class Solver implements Runnable {
        int index, N, K;

        public Solver(int index, int N, int K) {
            this.index = index;
            this.N = N;
            this.K = K;
        }

        @Override
        public void run() {
            output.put(index, solve(N, K));
        }
    }

    static String solve(int N, int K) {
        StringBuilder result = new StringBuilder("POSSIBLE\n");
        int factor = K / N;
        for (int i = 0; i < N; i++) {
            int j = factor - i, c = 0;
            while (c < N) {
                if (j <= 0) j += N;
                else if (j > N) j = 1;

                result.append(j++).append(" ");
                c++;
            }
            result.setLength(result.length() - 1);  // Remove trailing space
            result.append("\n");
        }
        result.setLength(result.length() - 1);  // Remove trailing newline
        return result.toString();
    }
}