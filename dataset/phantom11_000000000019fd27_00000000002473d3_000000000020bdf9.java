import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.util.Comparator;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskC solver = new TaskC();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            Event events[] = new Event[2 * N];
            char activities[] = new char[N];
            for (int i = 0; i < N; i++) {
                events[2 * i] = new Event(i, in.nextInt(), 0);
                events[2 * i + 1] = new Event(i, in.nextInt(), 1);
            }
            Arrays.sort(events, new Comparator<Event>() {

                public int compare(Event o1, Event o2) {
                    if (o1.time != o2.time) {
                        return o1.time - o2.time;
                    }
                    if (o1.isClosing != o2.isClosing) {
                        return o2.isClosing - o1.isClosing;
                    }
                    return o1.index - o2.index;
                }
            });
            int j = -1, c = -1;
            boolean impossible = false;
            for (Event event : events) {
                if (event.isClosing == 0) {
                    if (j == -1) {
                        activities[event.index] = 'J';
                        j = event.index;
                    } else if (c == -1) {
                        activities[event.index] = 'C';
                        c = event.index;
                    } else {
                        impossible = true;
                        break;
                    }
                } else {
                    if (activities[event.index] == 'J') {
                        j = -1;
                    } else if (activities[event.index] == 'C') {
                        c = -1;
                    }
                }
            }
            StringBuilder result = new StringBuilder();
            if (impossible) {
                result.append("IMPOSSIBLE");
            } else {
                for (int i = 0; i < N; i++) {
                    result.append(activities[i]);
                }
            }
            out.printLine("Case #" + testNumber + ": " + result);
        }

        class Event {
            int index;
            int time;
            int isClosing;

            public Event(int index, int time, int isClosing) {
                this.time = time;
                this.index = index;
                this.isClosing = isClosing;
            }

        }

    }

    static class InputReader {
        BufferedReader in;
        StringTokenizer tokenizer = null;

        public InputReader(InputStream inputStream) {
            in = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String next() {
            try {
                while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                    tokenizer = new StringTokenizer(in.readLine());
                }
                return tokenizer.nextToken();
            } catch (IOException e) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }

    static class OutputWriter {
        PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }
}

