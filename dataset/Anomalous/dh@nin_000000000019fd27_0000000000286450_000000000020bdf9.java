import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.AbstractCollection;
import java.util.PriorityQueue;
import java.util.InputMismatchException;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, InputReader in, PrintWriter w) {
            int n = in.nextInt();
            ArrayList<Activity> activities = new ArrayList<>();
            char[] result = new char[n];

            for (int i = 0; i < n; i++) {
                activities.add(new Activity(in.nextInt(), in.nextInt(), i));
            }

            Collections.sort(activities, new ActivityComparator());

            PriorityQueue<EndTime> pq = new PriorityQueue<>(new EndTimeComparator());

            pq.add(new EndTime(0, activities.get(0).end, 'C'));
            result[activities.get(0).index] = 'C';

            pq.add(new EndTime(1, activities.get(1).end, 'J'));
            result[activities.get(1).index] = 'J';

            int i = 2;
            boolean possible = true;
            while (!pq.isEmpty() && i < n) {
                Activity currentActivity = activities.get(i);
                EndTime earliestEndTime = pq.poll();

                if (currentActivity.start >= earliestEndTime.endTime) {
                    result[currentActivity.index] = earliestEndTime.character;
                    pq.add(new EndTime(i, currentActivity.end, earliestEndTime.character));
                } else {
                    possible = false;
                    break;
                }
                i++;
            }

            if (!possible) {
                w.println("Case #" + testNumber + ": IMPOSSIBLE");
            } else {
                w.println("Case #" + testNumber + ": " + String.valueOf(result));
            }
        }

        class Activity {
            int start;
            int end;
            int index;

            public Activity(int start, int end, int index) {
                this.start = start;
                this.end = end;
                this.index = index;
            }
        }

        class ActivityComparator implements Comparator<Activity> {
            public int compare(Activity a1, Activity a2) {
                if (a1.start != a2.start) {
                    return Integer.compare(a1.start, a2.start);
                }
                return Integer.compare(a1.end, a2.end);
            }
        }

        class EndTime {
            int index;
            int endTime;
            char character;

            public EndTime(int index, int endTime, char character) {
                this.index = index;
                this.endTime = endTime;
                this.character = character;
            }
        }

        class EndTimeComparator implements Comparator<EndTime> {
            public int compare(EndTime e1, EndTime e2) {
                return Integer.compare(e1.endTime, e2.endTime);
            }
        }
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
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
            return readString();
        }

        public String readString() {
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

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }
}