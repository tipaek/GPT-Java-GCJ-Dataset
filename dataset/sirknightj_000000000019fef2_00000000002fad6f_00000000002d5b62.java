import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;

import static java.lang.Math.abs;

public class Solution {

    public static List<String> values;
    public static Point target;
    public static int caseNum;
    public static boolean impossible;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        values = new LinkedList<>();
        for (int i = 0; i < t; i++) {
            values.clear();
            int n = in.nextInt();
            int m = in.nextInt();

            target = new Point(n, m);

            findPath(new Point(0, 0), 1, "");

            if (!values.isEmpty()) {
                values.sort(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.length() - o2.length();
                    }
                });
            }

            System.out.println("Case #" + (i + 1) + ": " + (values.isEmpty() ? "IMPOSSIBLE" : values.get(0)));
        }
    }

    public static void findPath(Point p, int i, String soFar) {
        if (p.y == target.y && p.x == target.x) {
            values.add(soFar);
        }

        int distance = (int) Math.pow(2, i - 1);

        if(distance > 2 * abs(target.x) && distance > 2 * abs(target.y)) {
            return;
        }

        findPath(new Point(p.x, p.y + distance), i + 1, soFar + "N");
        findPath(new Point(p.x, p.y - distance), i + 1, soFar + "S");
        findPath(new Point(p.x + distance, p.y), i + 1, soFar + "E");
        findPath(new Point(p.x - distance, p.y), i + 1, soFar + "W");
    }
}