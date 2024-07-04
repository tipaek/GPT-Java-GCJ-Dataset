import java.io.*;
import java.util.*;

public class Solution {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private static final char[] DIRECTIONS = {'N', 'W', 'S', 'E'};
    private static final int[] DISTANCES = {1, 2, 4, 8, 16, 32, 64, 128};
    private static final String[][] precalculatedPaths = new String[1024][1024];

    public static void move(Point p, char direction, int step) {
        switch (direction) {
            case 'N': p.y += DISTANCES[step - 1]; break;
            case 'S': p.y -= DISTANCES[step - 1]; break;
            case 'E': p.x += DISTANCES[step - 1]; break;
            case 'W': p.x -= DISTANCES[step - 1]; break;
        }
    }

    private static void storePath(Point p, String path) {
        String existingPath = precalculatedPaths[p.x + 256][p.y + 256];
        if (existingPath == null || existingPath.length() > path.length()) {
            precalculatedPaths[p.x + 256][p.y + 256] = path;
        }
    }

    private static void precomputePaths() {
        for (char c1 : DIRECTIONS) {
            for (char c2 : DIRECTIONS) {
                for (char c3 : DIRECTIONS) {
                    for (char c4 : DIRECTIONS) {
                        for (char c5 : DIRECTIONS) {
                            for (char c6 : DIRECTIONS) {
                                for (char c7 : DIRECTIONS) {
                                    for (char c8 : DIRECTIONS) {
                                        Point p = new Point(0, 0);
                                        StringBuilder path = new StringBuilder();
                                        move(p, c1, 1); path.append(c1); storePath(p, path.toString());
                                        move(p, c2, 2); path.append(c2); storePath(p, path.toString());
                                        move(p, c3, 3); path.append(c3); storePath(p, path.toString());
                                        move(p, c4, 4); path.append(c4); storePath(p, path.toString());
                                        move(p, c5, 5); path.append(c5); storePath(p, path.toString());
                                        move(p, c6, 6); path.append(c6); storePath(p, path.toString());
                                        move(p, c7, 7); path.append(c7); storePath(p, path.toString());
                                        move(p, c8, 8); path.append(c8); storePath(p, path.toString());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static String findPath(int X, int Y) {
        if (X >= -100 && X <= 100 && Y >= -100 && Y <= 100) {
            String path = precalculatedPaths[X + 256][Y + 256];
            if (path != null) {
                return path;
            }
        }
        return "IMPOSSIBLE";
    }

    public static void main(String[] args) {
        precomputePaths();

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            System.out.println("Case #" + t + ": " + findPath(X, Y));
        }

        scanner.close();
    }
}