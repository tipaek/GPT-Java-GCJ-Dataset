import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br;
    static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = nextInt();
        for (int l = 0; l < t; l++) {
            int x = nextInt();
            int y = nextInt();
            if (solveCase(l, x, y)) {
                continue;
            }
            System.out.println("Case #" + (l + 1) + ": IMPOSSIBLE");
        }
    }

    private static boolean solveCase(int caseNumber, int x, int y) {
        LinkedList<Point> points = new LinkedList<>();
        points.add(new Point(0, 0, null));
        for (int i = 0; i < 31; i++) {
            ListIterator<Point> iterator = points.listIterator();
            while (iterator.hasNext()) {
                Point currentPoint = iterator.next();
                if (currentPoint.x == x && currentPoint.y == y) {
                    System.out.println("Case #" + (caseNumber + 1) + ": " + retracePath(currentPoint));
                    return true;
                }
                if (isInvalidPoint(currentPoint, x, y, i)) {
                    iterator.remove();
                    continue;
                }
                addNewPoints(iterator, currentPoint, i);
            }
        }
        return points.stream().anyMatch(p -> p.x == x && p.y == y);
    }

    private static boolean isInvalidPoint(Point point, int x, int y, int i) {
        return Math.abs(x - point.x) % (1 << i) != 0 || Math.abs(y - point.y) % (1 << i) != 0;
    }

    private static void addNewPoints(ListIterator<Point> iterator, Point point, int i) {
        int step = 1 << i;
        iterator.add(new Point(point.x + step, point.y, point));
        iterator.add(new Point(point.x, point.y + step, point));
        iterator.add(new Point(point.x - step, point.y, point));
        iterator.add(new Point(point.x, point.y - step, point));
    }

    private static String retracePath(Point point) {
        StringBuilder path = new StringBuilder();
        while (point.par != null) {
            if (point.par.x != point.x) {
                path.append(point.par.x > point.x ? 'W' : 'E');
            } else {
                path.append(point.par.y > point.y ? 'S' : 'N');
            }
            point = point.par;
        }
        return path.reverse().toString();
    }

    public static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) throw new IOException();
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}

class Point {
    int x, y;
    Point par;

    public Point(int x, int y, Point par) {
        this.x = x;
        this.y = y;
        this.par = par;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }
}