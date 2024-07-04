import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

    static class PointData {
        int x, y, cost;
        String path;

        PointData(int x, int y, int cost, String path) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.path = path;
        }
    }

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        LinkedList<PointData> queue = new LinkedList<>();
        queue.add(new PointData(0, 0, 0, ""));
        String[][] paths = new String[250][250];
        int iterationCount = 0;
        int offset = 110;

        while (!queue.isEmpty()) {
            iterationCount++;
            if (iterationCount > 100000) break;

            PointData current = queue.removeFirst();
            int adjustedX = current.x + offset;
            int adjustedY = current.y + offset;

            if (adjustedX >= paths.length || adjustedY >= paths.length || adjustedX < 0 || adjustedY < 0) {
                continue;
            }

            if (paths[adjustedX][adjustedY] != null) continue;

            paths[adjustedX][adjustedY] = current.path;
            int step = 1 << current.cost;

            queue.add(new PointData(current.x + step, current.y, current.cost + 1, current.path + "E"));
            queue.add(new PointData(current.x - step, current.y, current.cost + 1, current.path + "W"));
            queue.add(new PointData(current.x, current.y + step, current.cost + 1, current.path + "N"));
            queue.add(new PointData(current.x, current.y - step, current.cost + 1, current.path + "S"));
        }

        int testCases = reader.nextInt();
        for (int testNum = 1; testCases-- > 0; testNum++) {
            int x = reader.nextInt();
            int y = reader.nextInt();
            String result = paths[x + offset][y + offset];
            System.out.printf("Case #%d: %s\n", testNum, result == null ? "IMPOSSIBLE" : result);
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        InputReader(FileReader stream) {
            reader = new BufferedReader(stream);
            tokenizer = null;
        }

        String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
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
    }
}