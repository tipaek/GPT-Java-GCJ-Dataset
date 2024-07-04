import java.io.*;
import java.util.*;

public class Solution {
    FastScanner in;
    PrintWriter out;


    final int M = 100;

    class State {
        int[] cards;
        Change prev;

        public State(int[] cards) {
            this.cards = cards;
        }

        public State(int[] cards, Change prev) {
            this.cards = cards;
            this.prev = prev;
        }

        State makeMove(int a, int b) {
            int[] res = new int[cards.length];
            for (int i =0 ; i < a; i++) {
                res[b + i] = cards[i];
            }
            for (int i = 0; i < b; i++) {
                res[i] = cards[a + i];
            }
            for (int i = a + b; i < cards.length; i++) {
                res[i] = cards[i];
            }
            return new State(res, new Change(a, b, this));
        }

        boolean isWinningState() {
            for (int i = 1; i < cards.length; i++) {
                if (cards[i] < cards[i - 1]) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return Arrays.equals(cards, state.cards);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(cards);
        }
    }

    class Change {
        int a, b;
        State prev;

        public Change(int a, int b, State prev) {
            this.a = a;
            this.b = b;
            this.prev = prev;
        }
    }

    void solve() {
        int tc = in.nextInt();
        for (int t = 0; t < tc; t++) {
            int ranks = in.nextInt();
            int suits = in.nextInt();
            int[] cards = new int[ranks * suits];
            for (int s = 0; s < suits; s++) {
                for (int r = 0; r < ranks; r++) {
                    cards[s * ranks + r] = r;
                }
            }
            State s = new State(cards);
            List<State> queue = new ArrayList<>();
            Set<State> set = new HashSet<>();
            queue.add(s);
            set.add(s);
            int qIt = 0;
            while (qIt < queue.size()) {
                State st = queue.get(qIt++);
                if (st.isWinningState()) {
                    List<Change> changes = new ArrayList<>();
                    while (true) {
                        Change c = st.prev;
                        if (c == null) {
                            break;
                        }
                        changes.add(c);
                        st = c.prev;
                    }
                    Collections.reverse(changes);
                    out.println("Case #" + (t + 1) + ": " + changes.size());
                    for (Change c : changes) {
                        out.println(c.a + " " + c.b);
                    }
                    break;
                }
                for (int a = 1; a < st.cards.length; a++) {
                    for (int b = 1; a + b <= st.cards.length; b++) {
                        State nState = st.makeMove(a, b);
                        if (set.contains(nState)) {
                            continue;
                        }
                        set.add(nState);
                        queue.add(nState);
                    }
                }
            }
        }
    }

    void run() {
        try {
            in = new FastScanner(new File("Solution.in"));
            out = new PrintWriter(new File("Solution.out"));

            solve();

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void runIO() {

        in = new FastScanner(System.in);
        out = new PrintWriter(System.out);

        solve();

        out.close();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
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
    }

    public static void main(String[] args) {
        new Solution().runIO();
    }
}