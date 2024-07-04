import java.io.*;
import java.util.*;

class Reader {
    private static final int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader() {
        this(System.in);
    }

    public Reader(String fileName) throws IOException {
        this(new FileInputStream(fileName));
    }

    private Reader(InputStream in) {
        din = new DataInputStream(in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
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

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        String outputFormat = "Case #%d: %s";
        int T = reader.nextInt();
        for (int z = 1; z <= T; z++) {
            int N = reader.nextInt();
            StringBuilder ans = new StringBuilder();
            int cnt = 0;
            if (N <= 500) {
                for (int i = 1; i <= N; i++) {
                    ans.append(String.format("\n%d 1", i));
                    cnt++;
                }
            } else if (N == 501) {
                ans.append("\n1 1").append("\n2 1").append("\n3 2").append("\n3 1");
                cnt = 4;
                for (int i = 4; i <= 499; i++) {
                    ans.append(String.format("\n%d 1", i));
                    cnt++;
                }
            }
            System.out.println(String.format(outputFormat, z, ans.toString()));
        }
    }
}

class Pair implements Comparable<Pair> {
    int frq, v;

    public Pair(int frq, int v) {
        this.frq = frq;
        this.v = v;
    }

    @Override
    public String toString() {
        return String.format("(frq: %d, v: %d)", frq, v);
    }

    @Override
    public int compareTo(Pair p) {
        int frqComparison = Integer.compare(frq, p.frq);
        return frqComparison == 0 ? Integer.compare(v, p.v) : Integer.compare(p.frq, frq);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return frq == pair.frq && v == pair.v;
    }

    @Override
    public int hashCode() {
        return Objects.hash(frq, v);
    }
}