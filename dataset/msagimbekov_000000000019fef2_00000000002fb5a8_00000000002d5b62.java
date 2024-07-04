import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author madi.sagimbekov
 */
public class Solution {

    private static BufferedReader in;
    private static BufferedWriter out;

    private static List<Integer>[] list;
    private static int[] arr;
    private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static boolean[] used;
    private static Map<Coord, Coord> parent;

    public static void main(String[] args) throws IOException {
        open();

        int t = readInt();
        for (int test = 1; test <= t; test++) {
            int[] xy = readInts();
            int x = xy[0];
            int y = xy[1];

            Queue<Coord> q = new LinkedList<>();
            parent = new HashMap<>();
            Set<String> used = new HashSet<>();
            Coord root = new Coord(0, 0);
            q.add(root);
            used.add(root.toString());

            long pow = 1;
            long step = 0;
            boolean found = false;
            while (step < 12) {
                for (int i = q.size() - 1; i >= 0; i--) {
                    Coord cur = q.remove();
                    if (cur.x == x && cur.y == y) {
                        print(cur, test);
                        found = true;
                        break;
                    }
                    for (int j = 0; j < 4; j++) {
                        long nextX = cur.x + pow * dir[j][0];
                        long nextY = cur.y + pow * dir[j][1];
                        if (!used.contains(nextX + " " + nextY)) {
                            Coord next = new Coord(nextX, nextY);
                            used.add(next.toString());
                            parent.put(next, cur);
                            q.add(next);
                        }
                    }
                }
                pow *= 2;
                step++;
            }

            if (!found) {
                out.write("Case #" + test + ": IMPOSSIBLE\n");
            }
        }



        close();
    }

    private static void print(Coord coord, int test) throws IOException {
        out.write("Case #" + test + ": ");
        List<String> list = new ArrayList<>();
        while (parent.get(coord) != null) {
            Coord p = parent.get(coord);
            list.add(direction(coord, p));
            coord = p;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            out.write(list.get(i));
        }
        out.write("\n");
    }

    private static String direction(Coord prev, Coord parent) {
        if (parent.x > prev.x) {
            return "W";
        } else if (parent.x < prev.x) {
            return "E";
        } else if (parent.y > prev.y) {
            return "S";
        } else {
            return "N";
        }
    }

    private static int[] readInts() throws IOException {
        return Stream.of(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(in.readLine());
    }

    private static long[] readLongs() throws IOException {
        return Stream.of(in.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    }

    private static long readLong() throws IOException {
        return Long.parseLong(in.readLine());
    }

    private static double[] readDoubles() throws IOException {
        return Stream.of(in.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
    }

    private static double readDouble() throws IOException {
        return Double.parseDouble(in.readLine());
    }

    private static String readString() throws IOException {
        return in.readLine();
    }

    private static List<Integer>[] buildAdjacencyList(int n, int m) throws IOException {
        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int[] e = readInts();
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }

        return list;
    }

    private static void open() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter((System.out)));
    }

    private static void open(String fileIn, String fileOut) throws FileNotFoundException {
        in = new BufferedReader(new InputStreamReader(new FileInputStream(fileIn)));
        out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileOut)));
    }

    private static void close() throws IOException {
        out.flush();
        out.close();
        in.close();
    }

}

class Coord {
    long x;
    long y;
    public Coord(long x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return (int)(1002842344 * x + y) % 1000000007;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coord) {
            Coord t = (Coord) obj;
            return this.x == t.x && this.y == t.y;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.x + " " + this.y;
    }
}