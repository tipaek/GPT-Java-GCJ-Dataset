import java.io.*;
import java.util.*;

public class Solution {

    public static Scanner scanner = new Scanner(System.in);
    public static OutputWriter outputWriter = new OutputWriter();

    public static void main(String[] args) throws IOException {
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            if (d > 3) return;

            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextLong();
            }
            Arrays.sort(array);

            outputWriter.print("Case #" + testCase + ": ");

            if (d == 2) {
                boolean matchFound = false;
                for (int i = 1; i < n; i++) {
                    if (array[i] == array[i - 1]) {
                        matchFound = true;
                        break;
                    }
                }
                outputWriter.println(matchFound ? "0" : "1");
            } else {
                boolean zero = false;
                boolean one = false;
                Set<Long> set = new HashSet<>();
                for (int i = n - 1; i >= 0; i--) {
                    if (i + 2 < n && array[i] == array[i + 1] && array[i] == array[i + 2]) {
                        zero = true;
                        break;
                    }
                    if (i + 2 < n && array[i] == array[i + 1]) {
                        one = true;
                    }
                    if (set.contains(2 * array[i])) {
                        one = true;
                    }
                    set.add(array[i]);
                }
                if (zero) {
                    outputWriter.println("0");
                } else if (one) {
                    outputWriter.println("1");
                } else {
                    outputWriter.println("2");
                }
            }
        }
        outputWriter.flush();
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter() {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void flush() {
            writer.flush();
        }

        public void close() {
            writer.close();
        }
    }
}