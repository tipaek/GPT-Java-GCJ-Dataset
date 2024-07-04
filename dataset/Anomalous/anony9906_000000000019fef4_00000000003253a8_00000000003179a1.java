import java.io.*;
import java.util.*;

public class Solution {

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    public static FastReader sc = new FastReader();

    static final int MOD = (int) (1e9 + 7), MAX = (int) (1e4);
    static List<Integer>[] edges;
    static int[][] dp;
    static int[] a;
    static List<Integer> order;

    public static void main(String[] args) throws IOException {
        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            boolean[] map = new boolean[26];
            int u = sc.nextInt();
            int[] range = new int[26];
            Arrays.fill(range, Integer.MAX_VALUE);
            for (int i = 0; i < MAX; ++i) {
                int num = sc.nextInt();
                char[] s = sc.next().toCharArray();
                for (char c : s) {
                    range[c - 'A'] = Math.min(num, range[c - 'A']);
                }
            }
            char[] ans = new char[10];
            int idx = 0;
            for (int i = 1; i <= 10; ++i) {
                List<Character> list = new ArrayList<>();
                for (int j = 0; j < range.length; ++j) {
                    if (range[j] == i) {
                        list.add((char) ('A' + j));
                    }
                }
                for (int j = 0; idx < i && j < list.size(); ++j, ++idx) {
                    ans[idx] = list.get(j);
                    map[list.get(j) - 'A'] = true;
                }
            }

            for (int i = 0; idx < 10 && i < map.length; ++i) {
                if (!map[i]) {
                    ans[idx++] = (char) (i + 'A');
                }
            }
            out.println("Case #" + t + ": " + new String(ans));
        }
        out.close();
    }
}