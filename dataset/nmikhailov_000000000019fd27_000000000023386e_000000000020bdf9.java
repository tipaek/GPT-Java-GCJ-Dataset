import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {

            int n = in.readInt();
            TaskC.Job time[] = new TaskC.Job[n];

            for (int i = 0; i < n; i++) {
                time[i] = new TaskC.Job(i, in.readInt(), in.readInt());
            }

            Arrays.sort(time, (o1, o2) -> o1.from - o2.from);

            TreeSet<String> freePeople = new TreeSet<>();
            freePeople.add("C");
            freePeople.add("J");

            LinkedList<Pair<String, Integer>> jobEndQueue = new LinkedList<>();


            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                TaskC.Job task = time[i];
                int curTime = task.from;

                // End jobs
                for (Pair<String, Integer> job : jobEndQueue) {
                    if (job.getSecond() <= curTime) {
                        freePeople.add(job.getFirst());
                        jobEndQueue.remove(job);
                    }
                }

                if (freePeople.size() <= 0) {
                    out.println("Case #" + testNumber + ": IMPOSSIBLE");
                    return;
                }
                String ppl = freePeople.pollFirst();
                sb.append(ppl);

                jobEndQueue.add(new Pair<String, Integer>(ppl, task.to));
            }
            char[] res = new char[n];
            for (int i = 0; i < n; i++) {
                res[time[i].id] = sb.charAt(i);
            }

            out.println("Case #" + testNumber + ": " + new String(res));
        }

        static class Job {
            int id;
            int from;
            int to;

            public Job(int id, int from, int to) {
                this.id = id;
                this.from = from;
                this.to = to;
            }

        }

    }

    static class FastScanner {
        private StringTokenizer st;
        private BufferedReader in;

        public FastScanner(final InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
        }

        public String readToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (final IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int readInt() {
            return Integer.parseInt(readToken());
        }

        public String next() {
            return readToken();
        }

    }

    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K k, V v) {
            key = k;
            value = v;
        }

        public Pair(Pair<? extends K, ? extends V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public K getFirst() {
            return key;
        }

        public V getSecond() {
            return value;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Pair)) {
                return false;
            } else {
                Pair<?, ?> oP = (Pair<?, ?>) o;
                return (key == null ?
                        oP.key == null :
                        key.equals(oP.key)) &&
                        (value == null ?
                                oP.value == null :
                                value.equals(oP.value));
            }
        }

        public int hashCode() {
            int result = key == null ? 0 : key.hashCode();

            final int h = value == null ? 0 : value.hashCode();
            result = 37 * result + h ^ (h >>> 16);

            return result;
        }

        public String toString() {
            return "[" + getKey() + ", " + getValue() + "]";
        }

    }
}

