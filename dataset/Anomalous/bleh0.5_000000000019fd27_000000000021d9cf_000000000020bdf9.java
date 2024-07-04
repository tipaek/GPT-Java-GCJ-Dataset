import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter writer = new PrintWriter(System.out);
        Task solver = new Task();
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            solver.solve(i, scanner, writer);
        }
        writer.close();
    }

    static class Task {

        public void solve(int testNumber, FastReader scanner, PrintWriter writer) {
            int n = scanner.nextInt();
            PriorityQueue<Interval> intervals = new PriorityQueue<>();
            int[] assignments = new int[n];
            for (int i = 0; i < n; i++) {
                intervals.add(new Interval(scanner.nextInt(), i + 1));
                intervals.add(new Interval(scanner.nextInt(), -i - 1));
            }
            int cameron = -2, jamie = -2;
            while (!intervals.isEmpty()) {
                Interval interval = intervals.poll();
                if (interval.index > 0) {
                    if (cameron == -2) {
                        cameron = interval.index;
                    } else if (jamie == -2) {
                        jamie = interval.index;
                        assignments[interval.index - 1] = 1;
                    } else {
                        writer.printf("Case #%d: IMPOSSIBLE%n", testNumber);
                        return;
                    }
                } else {
                    if (cameron == -interval.index) {
                        cameron = -2;
                    }
                    if (jamie == -interval.index) {
                        jamie = -2;
                    }
                }
            }
            writer.printf("Case #%d: ", testNumber);
            for (int assignment : assignments) {
                writer.print(assignment == 0 ? 'C' : 'J');
            }
            writer.println();
        }
    }

    static class Interval implements Comparable<Interval> {
        int time;
        int index;

        Interval(int time, int index) {
            this.time = time;
            this.index = index;
        }

        @Override
        public int compareTo(Interval other) {
            if (this.time == other.time) {
                return Integer.compare(this.index, other.index);
            } else {
                return Integer.compare(this.time, other.time);
            }
        }
    }

    static class FastReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public FastReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String fileName) throws FileNotFoundException {
            reader = new BufferedReader(new FileReader(new File(fileName)));
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
            String line = "";
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }
    }
}