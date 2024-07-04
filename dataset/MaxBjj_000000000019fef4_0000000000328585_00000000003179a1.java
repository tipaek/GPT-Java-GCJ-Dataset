import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastReader reader = new FastReader();

        int tests = Integer.parseInt(reader.nextLine());

        for (int test = 1; test <= tests; test++) {
            int u = Integer.parseInt(reader.nextLine());
            Map<Integer, Set<String>> m = new HashMap<>();

            for (int i = 0; i < 10000; i++) {
                String[] s = reader.nextLine().split(" ");
                int v = Integer.parseInt(s[0]);
                String letters = s[1];

                m.putIfAbsent(v, new HashSet<>());
                m.get(v).add(letters);
            }

            char[] letters = new char[10];
            letters[1] = m.get(1).iterator().next().charAt(0);
            Set<Character> ignored = new HashSet<>();
            ignored.add(letters[1]);

            for (int i = 2; i < 10; i++) {
                String next = null;
                for (String s : m.get(i)) {
                    if (!ignored.contains(s.charAt(0))) {
                        next = s;
                        break;
                    }
                }
                letters[i] = next.charAt(0);
                ignored.add(letters[i]);
            }

            main: for (String s : m.get(10)) {
                for (char c : s.toCharArray()) {
                    if (!ignored.contains(c)) {
                        letters[0] = c;
                        break main;
                    }
                }
            }

            System.out.println("Case #" + test + ": " + new String(letters));
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
    }
}
