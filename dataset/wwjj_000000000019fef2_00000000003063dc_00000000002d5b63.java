import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class Solution {

    private static final long UNIT = 1_000_000_000;

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true)) {
            _Scanner sc = new _Scanner(System.in);

            int T = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            long h = 2_000_000_000;
            long w = 2_000_000_000;
            long min = UNIT / 2;

            List<Point> initial = new ArrayList<>();
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    initial.add(p(j * min, i * min));
                }
            }

            nextT:
            for (int t = 0; t < T; t++) {
                Point found = null;
                loop:
                for (Point point : initial) {
                    out.println(point);
                    Reply reply = ask(sc);
                    switch (reply) {
                        case CENTER:
                            continue nextT;
                        case MISS:
                            break;
                        case HIT:
                            found = point;
                            break loop;
                    }
                }

                if (found == null) System.exit(2);

                Point right = find(p(1, 0), found, sc, out);
                Point left = find(p(-1, 0), found, sc, out);
                Point top = find(p(0, 1), right, sc, out);
                Point bottom = find(p(0, -1), right, sc, out);

//                System.err.println(String.format("right = %s", right));
//                System.err.println(String.format("left = %s", left));
//                System.err.println(String.format("top = %s", top));
//                System.err.println(String.format("bottom = %s", bottom));

                if (left.equals(right)) {
                    finalAnswer(out, sc, new Point(right.x, (top.y + bottom.y) / 2));
                } else if (top.equals(bottom)) {
                    finalAnswer(out, sc, new Point((left.x + right.x) / 2, top.y));
                } else {
                    Point height = right.dist(top) > right.dist(bottom) ? top : bottom;

                    Point center = new Point((left.x + right.x) / 2, (height.y + right.y) / 2);
                    finalAnswer(out, sc, center);
                }
            }
            
        }
    }

    private static void finalAnswer(PrintWriter out, _Scanner sc, Point point) {
        Reply reply = query(sc, point, out, new HashSet<>());
        if (reply != Reply.CENTER) System.exit(1);
    }

    private static Point find(Point dir, Point p, _Scanner sc, PrintWriter out) {
        Set<Point> missed = new HashSet<>();
        for (double step = 2 * UNIT; step > 0.1; step /= 2) {
            while (isLegal(p.plus(dir.times(step))) &&
                    !missed.contains(p.plus(dir.times(step))) &&
                    query(sc, p.plus(dir.times(step)), out, missed) != Reply.MISS)
                p = p.plus(dir.times(step));
        }
        return p;
    }

    private static Reply query(_Scanner sc, Point point, PrintWriter out, Set<Point> missed) {
        out.println(point);
        Reply ask = ask(sc);
        if (ask == Reply.MISS) missed.add(point);
        return ask;
    }

    private static boolean isLegal(Point point) {
        return point.x >= -UNIT && point.x <= UNIT &&
                point.y >= -UNIT && point.y <= UNIT;
    }

    private static Reply ask(_Scanner sc) {
        String reply = sc.next();
        if (reply.equals("WRONG")) {
            throw new RuntimeException();
        }
        Reply reply1 = null;
        try {
            reply1 = Reply.valueOf(reply);
        } catch (Throwable e) {
            System.exit(3);
        }
        return reply1;
    }

    enum Reply { CENTER, HIT, MISS,}

    private static Point p(long x, long y) {
        return new Point(x, y);
    }

    private static class Point {
        double x; double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("%s %s", x, y);
        }

        public Point times(double step) {
            return new Point(x * step, y * step);
        }

        public Point plus(Point other) {
            return new Point(x + other.x, y + other.y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Point minus(Point other) {
            return plus(other.times(-1));
        }


        public double dist(Point other) {
            return Math.sqrt(Math.pow(x - other.x,2) + Math.pow(y - other.y, 2));
        }
    }

    static class _Scanner {
        InputStream is;
        _Scanner(InputStream is) {
            this.is = is;
        }
        byte[] bb = new byte[1 << 15];
        int k, l;
        byte getc() {
            try {
                if (k >= l) {
                    k = 0;
                    l = is.read(bb);
                    if (l < 0) return -1;
                }
                return bb[k++];
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        byte skip() {
            byte b;
            while ((b = getc()) <= 32)
                ;
            return b;
        }

        int nextInt() {
            int n = 0;
            int sig = 1;
            for (byte b = skip(); b > 32; b = getc()) {
                if (b == '-') {
                    sig = -1;
                } else {
                    n = n * 10 + b - '0';
                }
            }
            return sig * n;
        }

        long nextLong() {
            long n = 0;
            long sig = 1;
            for (byte b = skip(); b > 32; b = getc()) {
                if (b == '-') {
                    sig = -1;
                } else {
                    n = n * 10 + b - '0';
                }
            }
            return sig * n;
        }

        public String next() {
            StringBuilder sb = new StringBuilder();
            for (int b = skip(); b > 32; b = getc()) {
                sb.append(((char) b));
            }
            return sb.toString();
        }
    }

    private static void shuffle(int[] ar) {
        Random rnd = new Random();
        for (int i = 0; i < ar.length; i++) {
            int j = i + rnd.nextInt(ar.length - i);
            swap(ar, i, j);
        }
    }

    private static void shuffle(Object[] ar) {
        Random rnd = new Random();
        for (int i = 0; i < ar.length; i++) {
            int j = i + rnd.nextInt(ar.length - i);
            swap(ar, i, j);
        }
    }

    private static void swap(int[] ar, int i, int j) {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }

    private static void swap(Object[] ar, int i, int j) {
        Object t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }

}
