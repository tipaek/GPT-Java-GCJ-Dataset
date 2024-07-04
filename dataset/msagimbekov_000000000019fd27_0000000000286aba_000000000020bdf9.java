import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * @author madi.sagimbekov
 */
public class Solution {

    private static BufferedReader in;
    private static BufferedWriter out;

    private static List<Integer>[] list;
    private static int[] arr;
    private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static boolean[] used;

    public static void main(String[] args) throws IOException {
        open();

        int t = readInt();
        for (int test = 1; test <= t; test++) {
            int n = readInt();
            List<Task> tasks = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int[] ab = readInts();
                tasks.add(new Task(ab[0], ab[1]));
            }

            Collections.sort(tasks, (A, B) -> (A.begin == B.begin ? A.end - B.end : A.begin - B.begin));

            Stack<Task> first = new Stack<>();
            Stack<Task> second = new Stack<>();

            boolean possible = true;
            StringBuilder sb = new StringBuilder();
            for (Task task : tasks) {
                if (first.isEmpty()) {
                    first.push(task);
                    sb.append("C");
                } else {
                    Task last = first.peek();
                    if (!intersects(last, task)) {
                        first.push(task);
                        sb.append("C");
                    } else {
                        if (second.isEmpty()) {
                            second.push(task);
                            sb.append("J");
                        } else {
                            Task last2 = second.peek();
                            if (!intersects(last2, task)) {
                                second.push(task);
                                sb.append("J");
                            } else {
                                possible = false;
                                break;
                            }
                        }
                    }
                }
            }
            if (possible) {
                out.write("Case #" + test + ": " + sb.toString() + "\n");
            } else {
                out.write("Case #" + test + ": IMPOSSIBLE\n");
            }
        }

        close();
    }

    private static boolean intersects(Task a, Task b) {
        return a.end > b.begin;
    }

    private static int[] readInts() throws IOException {
        return Stream.of(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(in.readLine());
    }

    private static long[] readLongs() throws IOException {
        return Stream.of(in.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    }

    private static long readLong() throws IOException {
        return Long.parseLong(in.readLine());
    }

    private static double[] readDoubles() throws IOException {
        return Stream.of(in.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
    }

    private static double readDouble() throws IOException {
        return Double.parseDouble(in.readLine());
    }

    private static String readString() throws IOException {
        return in.readLine();
    }

    private static List<Integer>[] buildAdjacencyList(int n, int m) throws IOException {
        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int[] e = readInts();
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }

        return list;
    }

    private static void open() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter((System.out)));
    }

    private static void close() throws IOException {
        out.flush();
        out.close();
        in.close();
    }

}

class Task {
    int begin;
    int end;

    public Task(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }
}