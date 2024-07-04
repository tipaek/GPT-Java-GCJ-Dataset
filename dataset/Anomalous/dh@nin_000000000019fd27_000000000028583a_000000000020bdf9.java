import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = in.nextInt();
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            ArrayList<Task> tasks = new ArrayList<>();
            char[] ans = new char[n];

            for (int i = 0; i < n; i++) {
                tasks.add(new Task(in.nextInt(), in.nextInt()));
            }

            Collections.sort(tasks, new TaskComparator());

            PriorityQueue<Worker> pq = new PriorityQueue<>(new WorkerComparator());
            pq.add(new Worker(0, tasks.get(0).end, 'C'));
            ans[0] = 'C';

            if (n > 1) {
                pq.add(new Worker(1, tasks.get(1).end, 'J'));
                ans[1] = 'J';
            }

            int i = 2;
            boolean possible = true;

            while (i < n && possible) {
                Task currentTask = tasks.get(i);
                Worker currentWorker = pq.poll();

                if (currentTask.start >= currentWorker.endTime) {
                    ans[i] = currentWorker.id;
                    pq.add(new Worker(i, currentTask.end, currentWorker.id));
                } else {
                    possible = false;
                }
                i++;
            }

            if (!possible) {
                out.println("Case #" + testNumber + ": IMPOSSIBLE");
            } else {
                out.println("Case #" + testNumber + ": " + new String(ans));
            }
        }

        class Task {
            int start, end;

            Task(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        class TaskComparator implements Comparator<Task> {
            public int compare(Task t1, Task t2) {
                if (t1.start != t2.start) {
                    return Integer.compare(t1.start, t2.start);
                }
                return Integer.compare(t1.end, t2.end);
            }
        }

        class Worker {
            int index, endTime;
            char id;

            Worker(int index, int endTime, char id) {
                this.index = index;
                this.endTime = endTime;
                this.id = id;
            }
        }

        class WorkerComparator implements Comparator<Worker> {
            public int compare(Worker w1, Worker w2) {
                return Integer.compare(w1.endTime, w2.endTime);
            }
        }
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar, numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res = res * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String next() {
            return readString();
        }

        private String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}