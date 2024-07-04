import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedReader rd;
    private PrintWriter wr;
    private StringTokenizer tok;

    private String nextToken() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(rd.readLine());
        }
        return tok.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private void solve() throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
//        rd = new BufferedReader(new FileReader("b.txt"));
        wr = new PrintWriter(System.out);

        int t = nextInt();
        for (int i = 0; i < t; ++i) {
            wr.print(String.format("Case #%d: ", i + 1));
            subsolve();
        }

        rd.close();
        wr.close();
    }

    public static class Pair {
        char ch;
        int cnt;

        public Pair(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }

    private void subsolve() throws IOException {
        int u = nextInt();

        int[] freq = new int[27];
        boolean[] used = new boolean[26];
        Arrays.fill(freq, 0);
        Arrays.fill(used, false);

        for (int i = 0; i < 10000; ++i) {
            long q = nextLong();
            String s = nextToken().trim();
            for (int j = 0; j < s.length(); ++j) {
                int idx = Character.toUpperCase(s.charAt(j)) - 'A';
                used[idx] = true;
            }
            if (s.length() != u) {
                freq[26] += 1;
            } else {
                int idx = Character.toUpperCase(s.charAt(0)) - 'A';
                freq[idx] += 1;
            }
        }

        ArrayList<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            if (used[i]) {
                pairs.add(new Pair((char) ('A' + i), freq[i]));
            }
        }
        pairs.sort(Comparator.comparingInt((Pair lhv) -> lhv.cnt));
        char[] digits = new char[10];
        for (int i = 0; i < 10; ++i) {
            if (i == 0) {
                digits[0] = pairs.get(i).ch;
            } else {
                digits[10 - i] = pairs.get(i).ch;
            }
        }

        for (int i = 0; i < 10; ++i) {
            wr.print(digits[i]);
        }
        wr.println();
    }

    private void gen() {
        int u = 16;
        long low = 1;
        long high = 1;
        for (int i = 0; i < u; ++i) {
            high *= 10L;
        }
        high -= 1L;
        Random rng = new Random();

        int[][] freq = new int[u][11];
        for (int i = 0; i < 10000; ++i) {
            long curHigh = genLong(rng, low, high);
            long num = genLong(rng, low, curHigh);
            System.out.println(String.format("i = %d, m = %d, x = %d", i, curHigh, num));
            for (int j = 0; j < u; ++j) {
                if (num == 0) {
                    ++freq[j][10];
                } else {
                    ++freq[j][(int)(num % 10)];
                }
                num /= 10;
            }
        }

        for (int i = 0; i < u; ++i) {
            System.out.println(String.format("u = %d", i));
            for (int j = 0; j <= 10; ++j) {
                System.out.println(String.format("  f[%d] = %d", j, freq[i][j]));
            }
        }
    }

    private long genLong(Random rng, long low, long high) {
        long delta = high - low + 1;
        if (delta < Integer.MAX_VALUE) {
            return low + rng.nextInt((int)delta);
        } else {
            while (true) {
                long genDelta = rng.nextLong();
                if (genDelta >= 0 && genDelta < delta) {
                    return low + genDelta;
                }
            }
        }
    }
}
