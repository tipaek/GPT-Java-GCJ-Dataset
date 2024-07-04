import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Solution {

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        open();

        int t = readInt();
        for (int test = 1; test <= t; test++) {
            int trace = 0;
            int dupRows = 0;
            int dupCols = 0;

            int n = readInt();
            String[][] matrix = new String[n][n];
            for (int i = 0; i < n; i++) {
                matrix[i] = readString().split(" ");
            }

            boolean[] rows = new boolean[n];
            boolean[] cols = new boolean[n];
            Set<String> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        trace += Integer.parseInt(matrix[i][j]);
                    }
                    if (!set.add("row " + i + " contains " + matrix[i][j])) {
                        rows[i] = true;
                    }
                    if (!set.add("column " + j + " contains " + matrix[i][j])) {
                        cols[j] = true;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                dupRows += rows[i] ? 1 : 0;
                dupCols += cols[i] ? 1 : 0;
            }

            out.write("Case #" + test + ": " + trace + " " + dupRows + " " + dupCols + "\n");
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
