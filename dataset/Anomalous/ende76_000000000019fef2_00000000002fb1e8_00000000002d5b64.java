import java.util.*;

public class Solution {

    private static List<int[]> solve(int R, int S) {
        List<int[]> result = new ArrayList<>();

        if (R == 1) return result;

        for (int i = 0; i < S - 1; i++) {
            result.add(new int[] { (S - 1) * R - i, R - 1 });
        }

        result.addAll(solve(R - 1, S));

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int R = scanner.nextInt();
            int S = scanner.nextInt();

            List<int[]> result = solve(R, S);

            System.out.printf("Case #%d: %d\n", t, result.size());

            for (int[] p : result) {
                System.out.printf("%d %d\n", p[0], p[1]);
            }
        }
        scanner.close();
    }
}

/*

2 3

121212

112122

111222

2 2

1212

3 2

123123

121233

112233

3 4

123123123123

121231231233

121212312333

121212123333

4 3

123412341234

123123412344

123123123444

121231233444

121212333444

112122333444

111222333444

 */