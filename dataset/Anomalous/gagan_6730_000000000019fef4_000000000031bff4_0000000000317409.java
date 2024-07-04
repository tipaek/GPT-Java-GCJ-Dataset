import java.io.*;
import java.util.*;

public class Solution {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static FastReader reader = new FastReader();
    static PrintWriter writer = new PrintWriter(System.out);

    private static int[] readIntArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }
        return arr;
    }

    private static long[] readLongArray(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextLong();
        }
        return arr;
    }

    private static int readInt() {
        return reader.nextInt();
    }

    private static long readLong() {
        return reader.nextLong();
    }

    private static String readString() {
        return reader.next();
    }

    static HashMap<Point, Integer> bfs(int n, Point[][] points) {
        HashMap<Point, Integer> visited = new HashMap<>();
        visited.put(points[2999][2999], 0);
        List<Point> queue = new ArrayList<>();
        queue.add(points[2999][2999]);
        int count = 1;

        while (count <= n) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point p = queue.remove(0);
                Point[] neighbors = {
                    points[p.x + 2999][p.y + 1 + 2999],
                    points[p.x + 2999][p.y - 1 + 2999],
                    points[p.x - 1 + 2999][p.y + 2999],
                    points[p.x + 1 + 2999][p.y + 2999]
                };
                for (Point neighbor : neighbors) {
                    if (!visited.containsKey(neighbor)) {
                        visited.put(neighbor, count);
                        queue.add(neighbor);
                    }
                }
            }
            count++;
        }
        return visited;
    }

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        int testCases = readInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            result.append("Case #").append(caseNumber++).append(": ");
            int x = readInt();
            int y = readInt();
            String directions = readString();

            List<Point> path = new ArrayList<>();
            path.add(new Point(x, y));

            for (char direction : directions.toCharArray()) {
                switch (direction) {
                    case 'N': y += 1; break;
                    case 'S': y -= 1; break;
                    case 'E': x += 1; break;
                    case 'W': x -= 1; break;
                }
                path.add(new Point(x, y));
            }

            int minSteps = Integer.MAX_VALUE;
            for (int i = 0; i < path.size(); i++) {
                Point p = path.get(i);
                int distance = Math.abs(p.x) + Math.abs(p.y);
                if (distance <= i) {
                    minSteps = Math.min(i, minSteps);
                }
            }

            if (minSteps == Integer.MAX_VALUE) {
                result.append("IMPOSSIBLE\n");
            } else {
                result.append(minSteps).append("\n");
            }
        }

        writer.print(result.toString());
        writer.flush();
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}