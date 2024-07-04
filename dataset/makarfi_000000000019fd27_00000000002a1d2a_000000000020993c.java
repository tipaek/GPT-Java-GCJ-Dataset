
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = in.nextInt();

            int trace = 0;
            HashSet<Integer>[] rows = new HashSet[N], cols = new HashSet[N];
            for (int i = 0; i < N; i++) {
                rows[i] = new HashSet<>();
                cols[i] = new HashSet<>();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int num = in.nextInt();
                    if (i == j) trace += num;

                    rows[i].add(num);
                    cols[j].add(num);
                }
            }

            int rCount = 0, cCount = 0;
            for (int i = 0; i < N; i++) {
                if (rows[i].size() < N) rCount += 1;
                if (cols[i].size() < N) cCount += 1;
            }

            System.out.printf("Case #%d: %d %d %d\n", testCase, trace, rCount, cCount);
        }
    }
}
