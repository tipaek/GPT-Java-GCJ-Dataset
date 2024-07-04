import java.io.*;
import java.util.*;

public class Solution {

    private static final InputReader inputReader = new InputReader();
    private static Scanner scanner = new Scanner(System.in);
    private static List<Long> facs = new ArrayList<>();

    public static void main(String[] args) {
        precalc();
        int k = inputReader.nextInt();
        for (int i = 0; i < k; i++) {
            solve(i + 1);
        }
    }

    private static ArrayDeque<Pair> path = new ArrayDeque<>();
    private static Set<Pair> visited = new HashSet<>();
    private static long rest = 0;
    private static Pair[] diffs = new Pair[] {new Pair(1, 1), new Pair(-1, -1), new Pair(1, 0), new Pair(0, 1), new Pair(-1, 0), new Pair(0, -1)};

    private static void solve(int caseN) {
        int n = inputReader.nextInt();
        rest = n - 1;
        path.clear();
        visited.clear();
        visited.add(new Pair(1, 1));
        path.push(new Pair(1, 1));
        dfs(new Pair(1, 1));
        System.out.println("Case #" + caseN + ": ");
        ArrayDeque<Pair> t = new ArrayDeque<>();
        path.forEach(t::push);
        t.forEach(p -> System.out.println(p.x + " " + p.y));
    }

    private static void dfs(Pair pos) {
        if (rest == 0) return;
        List<Pair> valid = new ArrayList<>();
        for (int i = 0; i < diffs.length; i++) {
            Pair next = new Pair(pos.x + diffs[i].x, pos.y + diffs[i].y);
            if (!visited.contains(next) && !notValid(next)) {
                valid.add(next);
            }
        }
        valid.sort(Comparator.<Pair>comparingLong(p -> cnk(p.x, p.y)).reversed());
        for (Pair next : valid) {
            long cnk = cnk(next.x, next.y);
            if (cnk <= rest) {
                rest -= cnk;
                visited.add(next);
                path.push(next);
                dfs(next);
                if (rest == 0) return;
                path.pop();
                visited.remove(next);
                rest += cnk;
            }
        }
    }

    private static boolean notValid(Pair next) {
        return next.x < 1 || next.y < 1 || next.x > facs.size() || next.y > next.x;
    }

    private static void precalc() {
        long fac = 1;
        long c = 1;
        facs.add(1L);
        while (fac < Long.MAX_VALUE / (c + 1)) {
            facs.add(fac);
            ++c;
            fac *= c;
        }
    }

    private static long cnk(int n, int k) {
        --n;
        --k;
        return facs.get(n) / facs.get(k) / facs.get(n - k);
    }

    static class Pair {
        private final int x;
        private final int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer st;

        public InputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}