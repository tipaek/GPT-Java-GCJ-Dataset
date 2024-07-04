import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    static Reader sc;
    static Printer out;
    static int n;
    static Task[] tasks;

    public static void main(String[] args) throws IOException {
        sc = new Reader();
        out = new Printer();
        int testCases = sc.nextInt();
        Comparator<Task> compareTime = new CompareTime();
        Comparator<Task> compareID = new CompareID();
        
        for (int t = 0; t < testCases; t++) {
            n = sc.nextInt();
            tasks = new Task[n];
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                tasks[i] = new Task(i, sc.nextInt(), sc.nextInt());
            }

            Arrays.sort(tasks, compareTime);
            tasks[0].player = 1;

            for (int i = 1; i < n; i++) {
                if (isColliding(tasks[i - 1], tasks[i])) {
                    tasks[i].player = (tasks[i - 1].player == 1) ? 2 : 1;

                    for (int j = i - 1; j >= 0; j--) {
                        if (tasks[j].player == tasks[i].player && isColliding(tasks[j], tasks[i])) {
                            impossible = true;
                            break;
                        }
                    }
                } else {
                    tasks[i].player = tasks[i - 1].player;
                }

                if (impossible) break;
            }

            Arrays.sort(tasks, compareID);

            if (impossible) {
                out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                out.print("Case #" + (t + 1) + ": ");
                for (Task task : tasks) {
                    out.print(task.player == 1 ? 'C' : 'J');
                }
                out.println();
            }
        }

        out.close();
    }

    static boolean isColliding(Task a, Task b) {
        return a.end > b.start;
    }

    static class Printer {
        private final OutputStream outputStream;

        public Printer() {
            this.outputStream = new BufferedOutputStream(System.out);
        }

        public Printer(String fileName) throws FileNotFoundException {
            this.outputStream = new BufferedOutputStream(new FileOutputStream(fileName));
        }

        public void print(Object object) throws IOException {
            outputStream.write(object.toString().getBytes());
        }

        public void println() throws IOException {
            outputStream.write("\n".getBytes());
        }

        public void println(Object object) throws IOException {
            outputStream.write((object + "\n").getBytes());
        }

        public void close() throws IOException {
            outputStream.flush();
        }
    }

    static class Reader {
        private final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            this.din = new DataInputStream(System.in);
            this.buffer = new byte[BUFFER_SIZE];
            this.bufferPointer = this.bytesRead = 0;
        }

        public Reader(String fileName) throws IOException {
            this.din = new DataInputStream(new FileInputStream(fileName));
            this.buffer = new byte[BUFFER_SIZE];
            this.bufferPointer = this.bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            return neg ? -ret : ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din != null) din.close();
        }
    }

    static class Task {
        int start, end, id, player;

        Task(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }
    }

    static class CompareTime implements Comparator<Task> {
        public int compare(Task a, Task b) {
            if (a.start != b.start) return a.start - b.start;
            return a.end - b.end;
        }
    }

    static class CompareID implements Comparator<Task> {
        public int compare(Task a, Task b) {
            return a.id - b.id;
        }
    }
}