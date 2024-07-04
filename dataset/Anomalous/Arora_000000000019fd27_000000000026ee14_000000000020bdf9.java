import java.io.*;
import java.util.*;

public class Solution {
    static class Pair {
        int start, end, index;

        Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair a, Pair b) {
            return Integer.compare(a.start, b.start);
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int testCases = sc.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            Pair[] pairs = new Pair[n];
            
            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                pairs[i] = new Pair(start, end, i);
            }
            
            Arrays.sort(pairs, new PairComparator());
            char[] schedule = new char[n];
            int jEnd = 0, cEnd = 0;
            boolean impossible = false;
            
            for (Pair pair : pairs) {
                if (pair.start >= jEnd) {
                    schedule[pair.index] = 'J';
                    jEnd = pair.end;
                } else if (pair.start >= cEnd) {
                    schedule[pair.index] = 'C';
                    cEnd = pair.end;
                } else {
                    impossible = true;
                    break;
                }
            }
            
            if (impossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (t + 1) + ": " + new String(schedule));
            }
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
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

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }
    }
}