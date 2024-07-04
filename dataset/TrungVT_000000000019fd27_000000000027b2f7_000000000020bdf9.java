import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Pair[] pairs = new Pair[n];
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                pairs[j] = new Pair(
                        j,
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()));
            }
            System.out.println(solve(new Input(pairs), i + 1));
        }
    }

    public static String solve(Input input, int index) {
        return "Case #"
                + index + ": "
                + input.schedule();
    }

    static class Input {
        Pair[] pairs;

        public Input(Pair[] pairs) {
            this.pairs = pairs;
            assert 2 <= pairs.length && pairs.length <= 1000;
        }

        public String schedule() {
            char[] str = new char[pairs.length];
            Arrays.sort(pairs);
            int c = 0;
            int j = 0;
            for (Pair pair : pairs) {
                if (c <= pair.s) {
                    c = pair.e;
                    str[pair.index] = 'C';
                } else if (j <= pair.s) {
                    j = pair.e;
                    str[pair.index] = 'J';
                } else {
                    return "IMPOSSIBLE";
                }
            }
            return new String(str);
        }
    }

    static class Pair implements Comparable<Pair> {
        int index;
        int s;
        int e;

        public Pair(int index, int s, int e) {
            this.index = index;
            this.s = s;
            this.e = e;
            assert 0 <= s && s < e && e <= 1440;
        }

        @Override
        public int compareTo(Pair that) {
            if (s != that.s) {
                return comp(s, that.s);
            }
            if (e != that.e) {
                return comp(e, that.e);
            }
            return comp(index, that.index);
        }

        private int comp(int a, int b) {
            return (a < b ? -1 : (a == b ? 0 : 1));
        }
    }
}
