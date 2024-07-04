import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    public void solve(InputReader in, PrintWriter out) {
        int max_digits = in.nextInt();
        res = new char[10];
        pool = new HashSet<>();
        rem = new Set[10];
        set_learned = false;
        zero_learned = false;
        learned = new boolean[10];
        taken = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            Set<Character> s = new HashSet<>();
            for (int j = 0; j < 26; j++) {
                s.add((char) ( 'A'+j));
            }
            rem[i] = s;
        }

        for (int i = 0; i < 10000; i++) {
            int mi = in.nextInt();
            char[] ri = in.next().toCharArray();
            if (taken.size() < 10) {
                reduce(mi, ri);
            }
        }
        boolean result_known = true;
        for(boolean f: learned) {
            if (!f) {
                result_known = false;
                break;
            }
        }
        if (!result_known) {
            for (int i = 0; i < 10; i++) {
                Set<Character> s = rem[i];
                char ch = s.stream().findFirst().get();
                res[i] = ch;
                remove(i, ch);
            }
        }
        for (char ch : res) out.print(ch);
        out.println();
    }
    char[] res;
    Set<Character> pool;
    Set<Character>[] rem;
    boolean set_learned;
    boolean zero_learned;
    boolean[] learned;
    Set<Character> taken;

    public void reduce(int m, char[] a) {
        String ms = String.valueOf(m);
        int len = ms.length();

        // add to pool
        if (!set_learned) {
            for (char ch : a) pool.add(ch);
            set_learned = pool.size() == 10;
            if (set_learned) {
                Set<Character> temp = new HashSet<>();
                for (int i = 0; i < 26; i++) {
                    char ch = (char) ('A' + i);
                    if (!pool.contains(ch)) temp.add(ch);
                }
                for (char ch: temp) {
                    for (Set<Character> s: rem) {
                        s.remove(ch);
                    }
                }
            }
        }

        if (len == a.length) {
            for (int i = 1; i < 10; i++) {
                if (!learned[i]) {
                    if ((ms.charAt(0)-'0') == i) {
                        if (!taken.contains(a[0])) {
                            res[i] = a[0];
                            learned[i] = true;
                            remove(i, a[0]);
                        }
                    }
                    break;
                }
            }
        }

        // TODO: check res[0] value
        if (!zero_learned) {
            rem[0].remove(a[0]);
            if (rem[0].size() == 1 && set_learned) {
                res[0] = rem[0].stream().findFirst().get();
                zero_learned = true;
                learned[0] = true;
                remove(0, res[0]);
            }
        }
    }

    public void remove(int except, char ch) {
        for (int j = 0; j < 10; j++) {
            if (j == except) continue;
            Set<Character> s = rem[j];
            s.remove(ch);
        }
        taken.add(ch);
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solution obj = new Solution();
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            obj.solve(in, out);
        }
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }

    }
}
