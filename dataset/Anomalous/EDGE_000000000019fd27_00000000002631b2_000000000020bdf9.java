import java.io.*;
import java.util.*;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * 
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int t = in.nextInt();
            int caseNumber = 1;

            while (t-- > 0) {
                int n = in.nextInt();
                Pair[] pairs = new Pair[n];
                boolean[] assigned = new boolean[n];
                boolean isPossible = true;

                for (int i = 0; i < n; i++) {
                    int x = in.nextInt();
                    int y = in.nextInt();
                    pairs[i] = new Pair(x, y, i);
                }

                Arrays.sort(pairs, Comparator.comparingInt(pair -> pair.x));

                assigned[pairs[0].index] = true;
                ArrayList<Pair> conflicts = new ArrayList<>();
                int lastSelected = 0;

                for (int j = 1; j < n; j++) {
                    if (pairs[j].x >= pairs[lastSelected].y) {
                        assigned[pairs[j].index] = true;
                        lastSelected = j;
                    } else {
                        conflicts.add(pairs[j]);
                    }
                }

                if (conflicts.size() > 1) {
                    int conflictSize = conflicts.size();
                    assigned[conflicts.get(0).index] = false;
                    lastSelected = 0;

                    for (int j = 1; j < conflictSize; j++) {
                        if (conflicts.get(j).x >= conflicts.get(lastSelected).y) {
                            assigned[conflicts.get(j).index] = false;
                            lastSelected = j;
                        } else {
                            isPossible = false;
                            break;
                        }
                    }
                }

                StringBuilder result = new StringBuilder();
                if (isPossible) {
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
            int x;
            int y;
            int index;

            Pair(int x, int y, int index) {
                this.x = x;
                this.y = y;
                this.index = index;
            }

            @Override
            public String toString() {
                return "(" + x + "," + y + " " + index + ")";
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