import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        for (int i = 0; i < tests; i++) {
            helper(in, i + 1);
        }
    }

    private static void helper(Scanner in, int id) {
        int N = in.nextInt();
        int K = in.nextInt();
        if (K < N || K > N * N) {
            System.out.println("Case #" + id + ": IMPOSSIBLE");
            return;
        }
        System.out.println("Case #" + id + ": POSSIBLE");
        int digit;
        if (K % N == 0) {
            digit = K / N;
        } else {
            if (N % 2 == 1) {
                if (K != ((1 + N) * N / 2)) {
                    System.out.println("Case #" + id + ": IMPOSSIBLE");
                    return;
                } else {
                    digit = N;
                }
            } else {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int i = 1; i <= N; i++) {
                    int cur = i == 1 ? 2 : 1;
                    int sum = 0;
                    boolean add = true;
                    for (int j = 0; j < N - 1; j++) {
                        if (add) {
                            sum += cur;
                        }
                        cur++;
                        if (cur == i) cur++;
                        add = !add;
                    }
                    map.put(sum * 2, i);
                }
                if (!map.containsKey(K)) {
                    System.out.println("Case #" + id + ": IMPOSSIBLE");
                    return;
                }
                digit = map.get(K);
            }
        }

        int hi = digit == N ? N - 1 : N;
        int lo = digit == 1 ? 2 : 1;

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(digit);

            int cur = hi;
            for (int j = 0; j < i; j++) {
                sb.insert(0, cur + " ");
                cur--;
                if (cur == digit) cur--;
            }

            cur = lo;
            for (int j = 0; j < N - i - 1; j++) {
                sb.append(" ").append(cur);
                cur++;
                if (cur == digit) cur++;
            }

            System.out.println(sb.toString());
        }
    }
}