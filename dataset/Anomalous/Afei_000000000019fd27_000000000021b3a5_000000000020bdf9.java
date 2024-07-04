import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = in.nextInt();
            for (int i = 1; i <= t; ++i) {
                int n = in.nextInt();
                int[][] intervals = getIntMatrix(in, n, 2);
                String result = assignActivities(n, intervals);
                System.out.println("Case #" + i + ": " + (result == null ? "IMPOSSIBLE" : result));
            }
        }
    }

    private static String assignActivities(int n, int[][] intervals) {
        Event[] events = new Event[2 * n];
        int[] assignments = new int[n];

        for (int i = 0; i < n; i++) {
            events[i] = new Event(i, intervals[i][0], 1);
            events[n + i] = new Event(i, intervals[i][1], -1);
        }

        Arrays.sort(events, (e1, e2) -> e1.time != e2.time ? Integer.compare(e1.time, e2.time) : Integer.compare(e1.type, e2.type));

        Set<Integer> active = new HashSet<>();
        for (Event event : events) {
            if (event.type == -1) {
                active.remove(event.id);
            } else {
                if (active.size() <= 1) {
                    assignments[event.id] = active.isEmpty() ? 0 : 1 - assignments[active.iterator().next()];
                    active.add(event.id);
                } else {
                    return null;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int assignment : assignments) {
            result.append(assignment == 0 ? "C" : "J");
        }
        return result.toString();
    }

    static class Event {
        int id, time, type;

        Event(int id, int time, int type) {
            this.id = id;
            this.time = time;
            this.type = type;
        }
    }

    static int[][] getIntMatrix(Scanner in, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        return matrix;
    }

    static long mod = 1_000_000_007;

    static long add(long a, long b) {
        return (a + b) % mod;
    }

    static long multiply(long a, long b) {
        return (a * b) % mod;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static String arrayToString(int[] array) {
        return Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    static int[] getIntArray(Scanner in, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        return array;
    }

    static char[] getCharArray(Scanner in, int size) {
        return in.next().toCharArray();
    }

    static String[] getStringArray(Scanner in, int size) {
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.next();
        }
        return array;
    }

    static Map<Integer, List<Integer>> getEdges(Scanner in, int size, boolean directed) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            edges.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            if (!directed) {
                edges.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
            }
        }
        return edges;
    }

    static class FastScanner implements Closeable {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(File file) {
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        @Override
        public void close() throws IOException {
            br.close();
        }
    }
}