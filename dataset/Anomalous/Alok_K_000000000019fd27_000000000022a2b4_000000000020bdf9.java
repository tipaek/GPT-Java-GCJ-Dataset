import java.util.*;
import java.io.*;

class Solution {
    static BufferedReader reader;
    static BufferedWriter writer;

    static String readLine() throws IOException {
        String line = "";
        while (line.isEmpty()) {
            line = reader.readLine();
        }
        return line;
    }

    static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    static long parseLong(String s) {
        return Long.parseLong(s);
    }

    static int[] readIntArray() throws IOException {
        String[] tokens = readLine().split(" ");
        int[] array = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = parseInt(tokens[i]);
        }
        return array;
    }

    static long[] readLongArray() throws IOException {
        String[] tokens = readLine().split(" ");
        long[] array = new long[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = parseLong(tokens[i]);
        }
        return array;
    }

    static void initializeIO() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void main(String[] args) throws IOException {
        initializeIO();
        int testCases = parseInt(readLine());
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = parseInt(readLine());
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i] = readIntArray();
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            StringBuilder result = new StringBuilder();
            int cEnd = 0, jEnd = 0;
            boolean impossible = false;

            for (int[] interval : intervals) {
                if (cEnd <= interval[0]) {
                    cEnd = interval[1];
                    result.append('C');
                } else if (jEnd <= interval[0]) {
                    jEnd = interval[1];
                    result.append('J');
                } else {
                    impossible = true;
                    break;
                }
            }

            writer.write("Case #" + caseNumber + ": ");
            if (impossible) {
                writer.write("IMPOSSIBLE\n");
            } else {
                writer.write(result.toString() + "\n");
            }

            caseNumber++;
        }

        writer.flush();
    }
}