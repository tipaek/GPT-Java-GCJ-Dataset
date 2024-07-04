import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = scanner.nextInt();
            for (int i = 1; i <= t; ++i) {
                int n = scanner.nextInt();
                int[][] intervals = readIntervals(scanner, n, 2);
                String result = findSchedule(n, intervals);
                System.out.println("Case #" + i + ": " + (result == null ? "IMPOSSIBLE" : result));
            }
        }
    }

    private static String findSchedule(int n, int[][] intervals) {
        Event[] events = new Event[2 * n];
        int[] assignment = new int[n];
        for (int i = 0; i < n; i++) {
            events[i] = new Event(i, intervals[i][0], 1);
            events[n + i] = new Event(i, intervals[i][1], -1);
        }
        Arrays.sort(events, (a, b) -> a.time != b.time ? Integer.compare(a.time, b.time) : Integer.compare(a.type, b.type));

        int overlap = 0;
        int currentAssignment = 0;
        for (Event event : events) {
            if (event.type == -1) {
                overlap--;
            } else {
                overlap++;
                if (overlap <= 2) {
                    currentAssignment = 1 - currentAssignment;
                    assignment[event.id] = currentAssignment;
                } else {
                    return null;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int value : assignment) {
            result.append(value == 0 ? "C" : "J");
        }
        return result.toString();
    }

    static class Event {
        int id;
        int time;
        int type;

        public Event(int id, int time, int type) {
            this.id = id;
            this.time = time;
            this.type = type;
        }
    }

    private static int[][] readIntervals(Scanner scanner, int rows, int cols) {
        int[][] intervals = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                intervals[i][j] = scanner.nextInt();
            }
        }
        return intervals;
    }

    private static void addParentheses(StringBuilder sb, int diff) {
        int count = Math.abs(diff);
        for (int i = 0; i < count; i++) {
            sb.append(diff > 0 ? "(" : ")");
        }
    }

    static final long MOD = 1000000007;

    static long add(long a, long b) {
        long result = a + b;
        if (result < 0) {
            result += MOD;
        }
        return result % MOD;
    }

    static long multiply(long a, long b) {
        return (a * b) % MOD;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static String arrayToString(int[] array) {
        return Arrays.stream(array).mapToObj(String::valueOf).reduce((a, b) -> a + " " + b).orElse("");
    }

    static int[] readIntArray(Scanner scanner, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    static char[] readCharArray(Scanner scanner, int size) {
        return scanner.next().toCharArray();
    }

    static String[] readStringArray(Scanner scanner, int size) {
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.next();
        }
        return array;
    }

    static Map<Integer, List<Integer>> readEdges(Scanner scanner, int size, boolean directed) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            edges.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            if (!directed) {
                edges.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
            }
        }
        return edges;
    }

    static class FastScanner implements Closeable {
        BufferedReader reader;
        StringTokenizer tokenizer;

        FastScanner(File file) {
            try {
                reader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
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

        @Override
        public void close() throws IOException {
            reader.close();
        }
    }
}