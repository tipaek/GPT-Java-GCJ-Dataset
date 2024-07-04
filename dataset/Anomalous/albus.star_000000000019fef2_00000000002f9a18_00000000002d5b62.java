import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        CustomScanner input = new CustomScanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int testCaseCount = input.nextInt();

        for (int testNumber = 1; testNumber <= testCaseCount; testNumber++) {
            pw.print("Case #" + testNumber + ": ");
            solve(input, pw);
            pw.println();
        }
        pw.close();
    }

    public static void solve(CustomScanner input, PrintWriter pw) throws IOException {
        int targetX = input.nextInt();
        int targetY = input.nextInt();
        Map<Long, Set<Long>> visitedPositions = new HashMap<>();
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, "", 1));

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        char[] directions = {'E', 'W', 'N', 'S'};

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            if (visitedPositions.containsKey(current.x) && visitedPositions.get(current.x).contains(current.y)) {
                continue;
            }
            if (current.x == targetX && current.y == targetY) {
                pw.print(current.path);
                return;
            }

            visitedPositions.computeIfAbsent(current.x, k -> new HashSet<>()).add(current.y);

            for (int i = 0; i < 4; i++) {
                long nextX = dx[i] * current.multiplier + current.x;
                long nextY = dy[i] * current.multiplier + current.y;
                if (Math.abs(nextX) <= 500 && Math.abs(nextY) <= 500) {
                    queue.add(new Position(nextX, nextY, current.path + directions[i], current.multiplier * 2));
                }
            }
        }
        pw.print("IMPOSSIBLE");
    }

    public static class Position {
        long x, y;
        long multiplier;
        String path;

        public Position(long x, long y, String path, long multiplier) {
            this.x = x;
            this.y = y;
            this.path = path;
            this.multiplier = multiplier;
        }
    }

    public static class CustomScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public CustomScanner(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public int nextInt() throws IOException {
            ensureTokenizer();
            return Integer.parseInt(tokenizer.nextToken());
        }

        public long nextLong() throws IOException {
            ensureTokenizer();
            return Long.parseLong(tokenizer.nextToken());
        }

        public String next() throws IOException {
            ensureTokenizer();
            return tokenizer.nextToken();
        }

        private void ensureTokenizer() throws IOException {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
        }
    }
}