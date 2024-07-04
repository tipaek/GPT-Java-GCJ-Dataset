import java.io.*;
import java.util.*;

public class Solution {

    public static class FastReader {
        private BufferedReader br;
        private StringTokenizer root;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (root == null || !root.hasMoreTokens()) {
                try {
                    root = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return root.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    private static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final FastReader sc = new FastReader();
    private static final int MOD = (int) (1e9 + 7);
    private static final int MAX = (int) (1e4);
    private static List<Integer>[] edges;
    private static int[][] dp;
    private static int[] a;
    private static List<Integer> order;

    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            boolean[] map = new boolean[26];
            int u = sc.nextInt();
            int[] range = new int[26];
            Arrays.fill(range, Integer.MAX_VALUE);
            for (int i = 0; i < 4; ++i) {
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
                for (char c : list) {
                    if (idx < i) {
                        ans[idx++] = c;
                        map[c - 'A'] = true;
                    }
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