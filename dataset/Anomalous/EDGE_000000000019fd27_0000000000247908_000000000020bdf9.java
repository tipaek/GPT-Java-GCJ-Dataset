import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    static class Task {
        public void solve(FastReader in, PrintWriter out) {
            int t = in.nextInt();
            int caseNumber = 1;

            while (t-- > 0) {
                int n = in.nextInt();
                Pair[] activities = new Pair[n];
                boolean[] assigned = new boolean[n];

                for (int i = 0; i < n; i++) {
                    int start = in.nextInt();
                    int end = in.nextInt();
                    activities[i] = new Pair(start, end, i);
                }

                Arrays.fill(assigned, false);
                Arrays.sort(activities, Comparator.comparingInt(p -> p.end));

                boolean possible = true;
                assigned[activities[0].index] = true;
                List<Pair> remaining = new ArrayList<>();
                int lastSelected = 0;

                for (int j = 1; j < n; j++) {
                    if (activities[j].start >= activities[lastSelected].end) {
                        assigned[activities[j].index] = true;
                        lastSelected = j;
                    } else {
                        remaining.add(activities[j]);
                    }
                }

                if (remaining.size() > 1) {
                    assigned[remaining.get(0).index] = false;
                    lastSelected = 0;

                    for (int j = 1; j < remaining.size(); j++) {
                        if (remaining.get(j).start >= remaining.get(lastSelected).end) {
                            assigned[remaining.get(j).index] = false;
                            lastSelected = j;
                        } else {
                            possible = false;
                            break;
                        }
                    }
                }

                StringBuilder result = new StringBuilder();
                if (possible) {
                    for (boolean assign : assigned) {
                        result.append(assign ? 'C' : 'J');
                    }
                } else {
                    result.append("IMPOSSIBLE");
                }

                out.println("Case #" + caseNumber + ": " + result.toString());
                caseNumber++;
            }
        }

        static class Pair {
            int start;
            int end;
            int index;

            Pair(int start, int end, int index) {
                this.start = start;
                this.end = end;
                this.index = index;
            }

            @Override
            public String toString() {
                return "(" + start + "," + end + " " + index + ")";
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
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

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}