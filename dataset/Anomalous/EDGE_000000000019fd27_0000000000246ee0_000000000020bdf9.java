import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskSolver solver = new TaskSolver();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskSolver {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int t = in.nextInt();
            int caseNumber = 1;

            while (t-- > 0) {
                int n = in.nextInt();
                Pair[] pairs = new Pair[n];
                boolean[] result = new boolean[n];

                for (int i = 0; i < n; i++) {
                    int start = in.nextInt();
                    int end = in.nextInt();
                    pairs[i] = new Pair(start, end, i);
                }

                Arrays.fill(result, false);
                Arrays.sort(pairs, Comparator.comparingInt(pair -> pair.end));

                boolean isPossible = true;
                result[pairs[0].index] = true;
                List<Pair> conflicts = new ArrayList<>();
                int lastIndex = 0;

                for (int j = 1; j < n; j++) {
                    if (pairs[j].start >= pairs[lastIndex].end) {
                        result[pairs[j].index] = true;
                        lastIndex = j;
                    } else {
                        conflicts.add(pairs[j]);
                    }
                }

                if (conflicts.size() > 1) {
                    result[conflicts.get(0).index] = false;
                    for (int j = 1; j < conflicts.size(); j++) {
                        if (conflicts.get(j).start >= conflicts.get(j - 1).end) {
                            result[conflicts.get(j).index] = false;
                        } else {
                            isPossible = false;
                            break;
                        }
                    }
                }

                StringBuilder output = new StringBuilder();
                if (isPossible) {
                    for (boolean res : result) {
                        output.append(res ? 'C' : 'J');
                    }
                } else {
                    output.append("IMPOSSIBLE");
                }

                out.println("case #" + caseNumber + ": " + output.toString());
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
        }
    }

    static class FastReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public FastReader(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}