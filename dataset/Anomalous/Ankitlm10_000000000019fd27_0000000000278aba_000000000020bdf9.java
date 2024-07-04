import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static class FastReader {
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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

    static class Pair {
        int start;
        int end;
        int index;
        int turn;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int tcs = sc.nextInt();

        for (int p = 0; p < tcs; p++) {
            int n = sc.nextInt();
            List<Pair> pairs = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                Pair pair = new Pair();
                pair.start = sc.nextInt();
                pair.end = sc.nextInt();
                pair.index = i + 1;
                pairs.add(pair);
            }

            pairs.sort(Comparator.comparingInt(o -> o.start));

            int jEnd = -1;
            int cEnd = -1;
            boolean impossible = false;

            for (Pair pair : pairs) {
                if (pair.start >= jEnd) {
                    pair.turn = 0; // J's turn
                    jEnd = pair.end;
                } else if (pair.start >= cEnd) {
                    pair.turn = 1; // C's turn
                    cEnd = pair.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + (p + 1) + ": IMPOSSIBLE");
            } else {
                pairs.sort(Comparator.comparingInt(o -> o.index));
                StringBuilder result = new StringBuilder();
                for (Pair pair : pairs) {
                    result.append(pair.turn == 0 ? 'C' : 'J');
                }
                System.out.println("Case #" + (p + 1) + ": " + result);
            }
        }
    }
}