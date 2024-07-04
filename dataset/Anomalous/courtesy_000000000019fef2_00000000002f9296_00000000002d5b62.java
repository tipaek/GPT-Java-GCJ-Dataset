import java.io.*;
import java.util.*;

public class Solution {

    public static FastReader fr = new FastReader();
    public static OutputWriter op = new OutputWriter();

    public static void main(String[] args) throws IOException {
        int lm = 500;
        Map<Pair, String> dp = new HashMap<>();
        Pair start = new Pair(0, 0);
        dp.put(start, "");
        Queue<Pair> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            String cur = dp.get(p);
            int nxt = 1 << cur.length();

            processNextStep(dp, queue, p, cur, nxt, lm, p.x + nxt, p.y, "E");
            processNextStep(dp, queue, p, cur, nxt, lm, p.x, p.y + nxt, "N");
            processNextStep(dp, queue, p, cur, nxt, lm, p.x - nxt, p.y, "W");
            processNextStep(dp, queue, p, cur, nxt, lm, p.x, p.y - nxt, "S");
        }

        int T = fr.nextInt();
        for (int cs = 1; cs <= T; cs++) {
            String result = dp.get(new Pair(fr.nextInt(), fr.nextInt()));
            System.out.print("Case #" + cs + ": ");
            System.out.println(result != null ? result : "IMPOSSIBLE");
        }
    }

    private static void processNextStep(Map<Pair, String> dp, Queue<Pair> queue, Pair p, String cur, int nxt, int lm, int newX, int newY, String direction) {
        if (Math.abs(newX) <= lm && Math.abs(newY) <= lm) {
            Pair newPair = new Pair(newX, newY);
            if (!dp.containsKey(newPair)) {
                dp.put(newPair, cur + direction);
                queue.add(newPair);
            }
        }
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair other = (Pair) obj;
            return x == other.x && y == other.y;
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter() {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }
    }

    static class FastReader {
        private final BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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
}