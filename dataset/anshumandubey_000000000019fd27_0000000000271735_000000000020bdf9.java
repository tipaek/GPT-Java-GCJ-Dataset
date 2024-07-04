import java.io.*;
import java.util.Arrays;
import java.util.Comparator;


public class Solution {
    static Reader sc;
    static Printer out;
    static final String dir = System.getProperty("user.dir");
    static int n;
    static Task[] tasks;

    public static void main(String[] args) throws IOException {
        sc = new Reader();
        out = new Printer();
        int testCases;
        CompareTime compareTime = new CompareTime();
        CompareID compareID = new CompareID();
        testCases = sc.nextInt();
        boolean impossible;
        for (int t = 0; t<testCases; t++) {
            impossible = false;
            n = sc.nextInt();
            tasks = new Task[n];
            for (int i = 0; i < n; i++) {
                tasks[i] = new Task(i);
                tasks[i].start = sc.nextInt();
                tasks[i].end = sc.nextInt();
            }
            Arrays.sort(tasks, compareTime);
            tasks[0].player = 1;
            for (int i = 1; i < n; i++) {
                if(isColliding(tasks[i-1], tasks[i])){
                    tasks[i].player = (tasks[i-1].player==1)?2:1;
                    for (int j = i-1; j >=0; j--) {
                        if(tasks[j].player == tasks[i].player){
                            if(isColliding(tasks[j], tasks[i]))
                                impossible = true;
                            break;
                        }
                    }
                }
                else
                    tasks[i].player = tasks[i-1].player;
                if(impossible)
                    break;
            }
            Arrays.sort(tasks, compareID);
            if(impossible)
                out.println("Case #"+(t+1)+": IMPOSSIBLE");
            else{
                out.print("Case #"+(t+1)+": ");
                for (int i = 0; i < n; i++) {
                    out.print(tasks[i].player==1?'C':'J');
                }
                out.println();
            }
        }

        out.close();
    }

    static boolean isColliding(Task a, Task b){
        return a.end > b.start;
    }


    static class Printer {
        private OutputStream outputStream;

        public Printer() {
            outputStream = new BufferedOutputStream(System.out);
        }

        public Printer(String file_name) {
            try {
                outputStream = new BufferedOutputStream(new FileOutputStream(file_name));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public void print(Object object) throws IOException {
            outputStream.write(String.valueOf(object).getBytes());
        }

        public void println() throws IOException {
            outputStream.write(("\n").getBytes());
        }

        public void println(Object object) throws IOException {
            outputStream.write((object + "\n").getBytes());
        }

        public void close() throws IOException {
            outputStream.flush();
        }
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}

class Task{
    int start, end, id, player;
    Task(int i){
        id = i;
    }
}

class CompareTime implements Comparator<Task>{
    public int compare(Task a, Task b){
        if(a.start!=b.start)
            return a.start-b.start;
        return a.end-b.end;
    }
}

class CompareID implements Comparator<Task>{
    public int compare(Task a, Task b){
        return a.id-b.id;
    }
}