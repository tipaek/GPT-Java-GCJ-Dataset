import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            processTestCase(i + 1, scanner, writer);
        }
        writer.close();
    }

    public static void processTestCase(int testCaseNumber, FastReader scanner, PrintWriter writer) {
        int n = scanner.nextInt();
        PriorityQueue<Interval> intervals = new PriorityQueue<>();
        int[] assignments = new int[n];
        int firstAvailable = -2;
        int secondAvailable = -2;

        for (int i = 0; i < n; i++) {
            intervals.add(new Interval(scanner.nextInt(), i + 1));
            intervals.add(new Interval(scanner.nextInt(), -i - 1));
        }

        while (!intervals.isEmpty()) {
            Interval current = intervals.poll();
            if (current.index > 0) {
                if (firstAvailable == -2) {
                    firstAvailable = current.index;
                } else if (secondAvailable == -2) {
                    secondAvailable = current.index;
                    assignments[current.index - 1] = 1;
                } else {
                    writer.printf("Case #%d: IMPOSSIBLE%n", testCaseNumber);
                    return;
                }
            } else {
                if (firstAvailable == -current.index) {
                    firstAvailable = -2;
                }
                if (secondAvailable == -current.index) {
                    secondAvailable = -2;
                }
            }
        }

        writer.printf("Case #%d: ", testCaseNumber);
        for (int assignment : assignments) {
            writer.print(assignment == 0 ? 'C' : 'J');
        }
        writer.println();
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
            }
            return Integer.compare(this.time, other.time);
        }
    }

    static class FastReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public FastReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String filePath) throws FileNotFoundException {
            reader = new BufferedReader(new FileReader(new File(filePath)));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
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
            String str = "";
            try {
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}