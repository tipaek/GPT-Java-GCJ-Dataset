import java.io.*;
import java.util.*;

public class Solution {

    static class Reader {
        private static final int BUFFER_SIZE = 1 << 16;
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

    static class Rectangle {
        int blx, bly, urx, ury;

        Rectangle(int blx, int bly, int urx, int ury) {
            this.blx = blx;
            this.bly = bly;
            this.urx = urx;
            this.ury = ury;
        }
    }

    public static Rectangle getCommonRectangle(Rectangle r1, Rectangle r2) {
        int lx = Math.max(r1.blx, r2.blx);
        int ly = Math.max(r1.bly, r2.bly);
        int ux = Math.min(r1.urx, r2.urx);
        int uy = Math.min(r1.ury, r2.ury);

        if (lx > ux || ly > uy) return null;

        return new Rectangle(lx, ly, ux, uy);
    }

    static class Point {
        int x, y;
        String step;
        int power;

        Point(int x, int y, String step, int power) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.power = power;
        }
    }

    public static String solution(int x, int y) {
        String impossible = "IMPOSSIBLE";
        LinkedList<Point> queue = new LinkedList<>();

        queue.add(new Point(0, 1, "N", 2));
        queue.add(new Point(0, -1, "S", 2));
        queue.add(new Point(-1, 0, "W", 2));
        queue.add(new Point(1, 0, "E", 2));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.x == x && p.y == y) return p.step;

            int np = p.power * 2;

            // North
            addPointToQueue(queue, x, y, p.x, p.y + p.power, p.step + "N", np);

            // East
            addPointToQueue(queue, x, y, p.x + p.power, p.y, p.step + "E", np);

            // South
            addPointToQueue(queue, x, y, p.x, p.y - p.power, p.step + "S", np);

            // West
            addPointToQueue(queue, x, y, p.x - p.power, p.y, p.step + "W", np);
        }

        return impossible;
    }

    private static void addPointToQueue(LinkedList<Point> queue, int x, int y, int nx, int ny, String ns, int np) {
        if (nx == x && ny == y) throw new RuntimeException(ns);
        int maxDistanceX = Math.abs(x - nx);
        int maxDistanceY = Math.abs(y - ny);
        if ((maxDistanceX >= np || x == nx) && (maxDistanceY >= np || y == ny)) {
            queue.add(new Point(nx, ny, ns, np));
        }
    }

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String result;
            try {
                result = solution(x, y);
            } catch (RuntimeException e) {
                result = e.getMessage();
            }
            System.out.println("Case #" + i + ": " + result);
        }

        writer.flush();
        writer.close();
        in.close();
    }
}