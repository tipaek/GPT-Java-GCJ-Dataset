import java.util.Arrays;
import java.util.Scanner;

class C {
    static class Activity implements Comparable<Activity> {
        final int S, E, idx;

        public Activity(int idx, int s, int e) {
            this.idx = idx;
            S = s;
            E = e;
        }

        @Override
        public int compareTo(Activity o) {
            return S == o.S ? E - o.E : S - o.S;
        }
    }

    public static void main(String... args) throws Exception {
        try (final Scanner sc = new Scanner(System.in)) {
            final int T = sc.nextInt();
            for (int t = 1; t <= T; t++) {
                final int N = sc.nextInt();
                final Activity[] as = new Activity[N];
                Arrays.setAll(as, i -> new Activity(i, sc.nextInt(), sc.nextInt()));
                Arrays.sort(as);
                boolean success = true;
                final char[] cs = new char[N];
                int c = 0;
                int j = 0;
                for (Activity activity : as)
                    if (c <= activity.S) {
                        c = activity.E;
                        cs[activity.idx] = 'C';
                    } else if (j <= activity.S) {
                        j = activity.E;
                        cs[activity.idx] = 'J';
                    } else
                        success = false;
                System.out.printf("Case #%s: %s\n", t, success ? new String(cs) : "IMPOSSIBLE");
            }
        }
    }
}
public class Solution {
    public static void main(String...args) throws Exception {
        C.main();
    }
}
