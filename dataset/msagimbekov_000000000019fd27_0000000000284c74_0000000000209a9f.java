import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
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
            char[] c = readString().toCharArray();
            StringBuilder sb = new StringBuilder();
            int cur = 0;
            for (int i = 0; i < c.length; i++) {
                int val = c[i] - '0';
                int dif = val - cur;
                if (dif > 0) {
                    for (int j = 0; j < dif; j++) {
                        sb.append("(");
                        cur++;
                    }
                } else if (dif < 0) {
                    for (int j = dif; j < 0; j++) {
                        sb.append(")");
                        cur--;
                    }
                }
                sb.append(c[i]);
            }
            for (int i = 0; i < cur; i++) {
                sb.append(")");
            }
            out.write("Case #" + test + ": " + sb.toString() + "\n");
        }

        close();
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
