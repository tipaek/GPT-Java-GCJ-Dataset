import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    public static void main(String[] args) {
        new Thread(null, new Solution(), "process", 1 << 26).start();
    }

    public void run() {
        FastReader scan = new FastReader();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        Task solver = new Task();
        int t = scan.nextInt();
        for (int i = 1; i <= t; i++) {
            solver.solve(i, scan, out);
        }
        out.close();
    }

    static class Task {
        static final int INF = Integer.MAX_VALUE;
        long targetDifference;
        long n, m;

        public void solve(int testNumber, FastReader sc, PrintWriter pw) {
            n = sc.nextLong();
            m = sc.nextLong();
            long difference = Math.abs(n - m);
            targetDifference = difference;
            long x = findInitialX();
            if (n < m) {
                m -= calculateSum(x);
            } else {
                n -= calculateSum(x);
            }
            if (n <= m) {
                long moves = findMoves(m, n, x);
                adjustValuesForMoves(n, m, x, moves);
                pw.printf("Case #%d: %d %d %d%n", testNumber, moves, n, m);
            } else {
                long moves = findMoves(n, m, x);
                adjustValuesForMoves(m, n, x, moves);
                pw.printf("Case #%d: %d %d %d%n", testNumber, moves, n, m);
            }
        }

        public long findInitialX() {
            long low = 0, high = 1_000_000_003;
            for (int i = 0; i < 64; i++) {
                long mid = (low + high) / 2;
                if (calculateSum(mid) >= targetDifference) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return calculateSum(Math.max(low, high)) <= targetDifference ? Math.max(low, high) : Math.min(low, high);
        }

        public long findMoves(long larger, long smaller, long offset) {
            long low = offset, high = 1_000_000_003;
            for (int i = 0; i < 64; i++) {
                long mid = (low + high) / 2;
                if (canMakeMove(larger, smaller, offset, mid)) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
            long mid = Math.max(low, high);
            return canMakeMove(larger, smaller, offset, mid) ? mid : Math.min(low, high);
        }

        public boolean canMakeMove(long larger, long smaller, long offset, long mid) {
            long oddSteps = (mid + 1) / 2;
            long evenSteps = mid / 2;
            long oddOffset = (offset + 1) / 2;
            long evenOffset = offset / 2;
            return larger - calculateOddSum(oddSteps) + calculateOddSum(oddOffset) >= 0 &&
                   smaller - calculateEvenSum(evenSteps) + calculateEvenSum(evenOffset) >= 0;
        }

        public void adjustValuesForMoves(long larger, long smaller, long offset, long moves) {
            if (offset % 2 == 0) {
                larger -= calculateOddSum((moves + 1) / 2) - calculateOddSum((offset + 1) / 2);
                smaller -= calculateEvenSum(moves / 2) - calculateEvenSum(offset / 2);
            } else {
                smaller -= calculateOddSum((moves + 1) / 2) - calculateOddSum((offset + 1) / 2);
                larger -= calculateEvenSum(moves / 2) - calculateEvenSum(offset / 2);
            }
            if (larger < 0) {
                larger += moves;
                moves--;
            }
            if (smaller < 0) {
                smaller += moves;
                moves--;
            }
        }

        long calculateSum(long a) {
            return a * (a + 1) / 2;
        }

        long calculateEvenSum(long a) {
            return a * (a + 1);
        }

        long calculateOddSum(long a) {
            return a * a;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(fileName)));
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
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}