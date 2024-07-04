
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.math.BigInteger;
import java.util.*;

public class Solution {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        for (int cn = 1; cn <= t; cn++) {
            int n = nextInt();

            List<Activity> acts = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                acts.add(new Activity(nextInt(), nextInt(), i));
            }

            acts.sort(Comparator.comparing(a -> a.start));

            boolean possible = true;

            int cfree = 0;
            int jfree = 0;
            char[] res = new char[n];
            for (Activity act : acts) {
                if (cfree <= act.start) {
                    res[act.order] = 'C';
                    cfree = act.end;
                } else if (jfree <= act.start) {
                    res[act.order] = 'J';
                    jfree = act.end;
                } else {
                    possible = false;
                    break;
                }
            }
            System.out.print("Case #");
            System.out.print(cn);
            System.out.print(": ");

            if (possible) {
                System.out.println(res);
            } else {
                System.out.println("IMPOSSIBLE");
            }
            System.out.flush();
        }
    }

    static class Activity {
        public int start;
        public int end;

        public int order;

        public Activity(int start, int end, int order) {
            this.start = start;
            this.end = end;
            this.order = order;
        }
    }


    static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    static String next() throws IOException {
        in.nextToken();
        return in.sval;
    }
}
