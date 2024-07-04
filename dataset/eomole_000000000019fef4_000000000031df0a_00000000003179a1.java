import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class B {
    static class Pair implements Comparable<Pair> {
        final char c;
        final int count;

        public Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            return count - o.count;
        }
    }

    static final int[] map = {0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    static final int S = 10000;

    public static void main(String... args) throws Exception {
        try (final Scanner sc = new Scanner(System.in)) {
            final int T = sc.nextInt();
            for (int t = 1; t <= T; t++) {
                final int U = sc.nextInt();
                final long[] Q = new long[S];
                final char[][] R = new char[S][];
                for (int i = 0; i < S; i++) {
                    Q[i] = sc.nextLong();
                    R[i] = sc.next().toCharArray();
                }
                final int[] cnt = new int[128];
                for (int i = 0; i < S; i++)
                    for (char c : R[i])
                        cnt[c]++;
                final ArrayList<Pair> list = new ArrayList<>();
                for (int i = 0; i < cnt.length; i++)
                    if (cnt[i] > 0)
                        list.add(new Pair((char) i, cnt[i]));
                if (list.size() != 10)
                    throw null;
                Collections.sort(list);
                final char[] ans = new char[10];
                for (int i = 0; i < 10; i++)
                    ans[map[i]] = list.get(i).c;
                System.out.printf("Case #%s: %s\n", t, new String((ans)));
            }
        }
    }
}
public class Solution {
    public static void main(String...args) throws Exception {
        B.main();
    }
}
