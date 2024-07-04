import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TN = sc.nextInt();
        for (int tc = 1; tc <= TN; ++tc) {
            int K = sc.nextInt();
            int N = sc.nextInt();
            int[] X = new int[N];
            for (int i = 0; i < X.length; ++i) {
                X[i] = sc.nextInt();
            }
            int[] T = new int[N];
            for (int i = 0; i < T.length; ++i) {
                T[i] = sc.nextInt();
            }

            System.out.println(String.format("Case #%d: %d", tc, solve(K, X, T)));
        }

        sc.close();
    }

    static int solve(int K, int[] X, int[] T) {
        K *= 2;

        for (int i = 0; i < X.length; ++i) {
            X[i] *= 2;
        }

        int result = Integer.MAX_VALUE;
        for (int code = 0; code < 1 << K; ++code) {
            List<Integer> thermometers = new ArrayList<>();
            for (int rest = code, thermometer = 0; rest != 0; rest /= 2, ++thermometer) {
                if (rest % 2 != 0) {
                    thermometers.add(thermometer);
                }
            }

            Set<Integer> bounds = new HashSet<>();
            for (int i = 0; i < thermometers.size(); ++i) {
                int current = thermometers.get(i);
                int next = thermometers.get((i + 1) % thermometers.size());
                if (next < current) {
                    next += K;
                }

                if ((current + next) % 2 == 0) {
                    bounds.add((current + next) / 2 % K);
                }
            }

            if (Arrays.stream(X).allMatch(bounds::contains)) {
                result = Math.min(result, thermometers.size());
            }
        }

        return result;
    }
}