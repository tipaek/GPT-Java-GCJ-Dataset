import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; ++tc) {
            int N = sc.nextInt();
            int[] S = new int[N];
            int[] E = new int[N];
            for (int i = 0; i < N; ++i) {
                S[i] = sc.nextInt();
                E[i] = sc.nextInt();
            }

            System.out.println(String.format("Case #%d: %s", tc, solve(S, E)));
        }

        sc.close();
    }

    static String solve(int[] S, int[] E) {
        int[] sortedIndices = IntStream.range(0, S.length).boxed().sorted((i1, i2) -> Integer.compare(S[i1], S[i2]))
                .mapToInt(x -> x).toArray();

        int cEnd = -1;
        int jEnd = -1;
        char[] result = new char[S.length];
        for (int index : sortedIndices) {
            if (S[index] >= cEnd) {
                result[index] = 'C';
                cEnd = E[index];
            } else if (S[index] >= jEnd) {
                result[index] = 'J';
                jEnd = E[index];
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(result);
    }
}