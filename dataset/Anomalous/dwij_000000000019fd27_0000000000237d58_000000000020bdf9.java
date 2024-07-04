import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = in.nextInt();
                intervals[i][1] = in.nextInt();
            }

            List<Job> cameronJobs = new ArrayList<>();
            List<Job> jamieJobs = new ArrayList<>();
            StringBuilder schedule = new StringBuilder("C");
            cameronJobs.add(new Job(intervals[0][0], intervals[0][1]));

            boolean possible = true;

            for (int i = 1; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];

                if (Job.isNonOverlapping(cameronJobs, start, end)) {
                    schedule.append("C");
                    cameronJobs.add(new Job(start, end));
                } else if (Job.isNonOverlapping(jamieJobs, start, end)) {
                    schedule.append("J");
                    jamieJobs.add(new Job(start, end));
                } else {
                    out.println(String.format("Case #%d: IMPOSSIBLE", testNumber));
                    possible = false;
                    break;
                }
            }

            if (possible) {
                out.println(String.format("Case #%d: %s", testNumber, schedule.toString()));
            }
        }

        static class Job {
            int start;
            int end;

            Job(int start, int end) {
                this.start = start;
                this.end = end;
            }

            static boolean isNonOverlapping(List<Job> jobs, int start, int end) {
                for (Job job : jobs) {
                    if (start < job.end && end > job.start) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public void println(String message) {
            writer.println(message);
        }

        public void close() {
            writer.close();
        }
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buffer[currentChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }
    }
}