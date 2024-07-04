import java.util.*;
import java.io.*;

public class Solution {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = nextInt();

        for (int l = 0; l < t; l++) {
            int x = nextInt();
            int y = nextInt();
            if (processCase(l, x, y)) {
                continue;
            }
            System.out.println("Case #" + (l + 1) + ": IMPOSSIBLE");
        }
    }

    private static boolean processCase(int caseNumber, int x, int y) {
        List<Point> currentPoints = new ArrayList<>();
        List<Point> nextPoints = new ArrayList<>();
        currentPoints.add(new Point(0, 0, null));

        for (int i = 0; i < 31; i++) {
            for (Point point : currentPoints) {
                if (point.x == x && point.y == y) {
                    System.out.println("Case #" + (caseNumber + 1) + ": " + retracePath(point));
                    return true;
                }
                if (isValidMove(x, y, point, i)) {
                    addNextPoints(nextPoints, point, i);
                }
            }
            currentPoints = nextPoints;
            nextPoints = new ArrayList<>();
        }

        for (Point point : currentPoints) {
            if (point.x == x && point.y == y) {
                System.out.println("Case #" + (caseNumber + 1) + ": " + retracePath(point));
                return true;
            }
        }

        return false;
    }

    private static boolean isValidMove(int x, int y, Point point, int i) {
        return Math.abs(x - point.x) % (1 << i) == 0 && Math.abs(y - point.y) % (1 << i) == 0;
    }

    private static void addNextPoints(List<Point> nextPoints, Point point, int i) {
        int step = 1 << i;
        nextPoints.add(new Point(point.x + step, point.y, point));
        nextPoints.add(new Point(point.x, point.y + step, point));
        nextPoints.add(new Point(point.x - step, point.y, point));
        nextPoints.add(new Point(point.x, point.y - step, point));
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

    private static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) throw new IOException();
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}

class Point {
    int x, y;
    Point par;

    Point(int x, int y, Point par) {
        this.x = x;
        this.y = y;
        this.par = par;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }
}