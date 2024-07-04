import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    static class Coordinate implements Comparable<Coordinate> {
        int x, y, cost;

        public Coordinate(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Coordinate other) {
            if (this.x == other.x)
                return this.y - other.y;
            return this.x - other.x;
        }
    }

    static boolean[][] visited;
    static final int[] dx = {-1, -1, 0, 0, 1, 1};
    static final int[] dy = {-1, 0, -1, 1, 0, 1};
    static int targetSum;
    static long[][] binomialCoefficients;
    static Stack<Point> pathStack;
    static Stack<Point> resultStack;
    static boolean isSolved = false;
    static final int MAX = 1000;
    static final long LIMIT = (long) (1e9 + 50);

    static boolean findPath(int x, int y, long currentSum) {
        if (isSolved)
            return true;
        if (currentSum > targetSum)
            return false;
        if (currentSum == targetSum) {
            while (!pathStack.isEmpty()) {
                resultStack.push(pathStack.pop());
            }
            isSolved = true;
            return true;
        }
        for (int k = 0; k < dx.length; k++) {
            int newX = x + dx[k];
            int newY = y + dy[k];
            if (isValidMove(newX, newY) && !visited[newX][newY]) {
                pathStack.push(new Point(newX, newY));
                visited[x][y] = true;
                boolean canProceed = findPath(newX, newY, currentSum + binomialCoefficients[newX][newY]);
                if (canProceed)
                    return true;
                pathStack.pop();
                visited[x][y] = false;
            }
        }
        return false;
    }

    static boolean isValidMove(int x, int y) {
        return x >= 0 && y >= 0 && y <= x && x < MAX && y < MAX;
    }

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int testCases = reader.nextInt();
        int testNumber = 1;
        initializeBinomialCoefficients();
        Random random = new Random();
        while (testCases-- > 0) {
            targetSum = reader.nextInt();
            pathStack = new Stack<>();
            pathStack.push(new Point(0, 0));
            visited = new boolean[MAX][MAX];
            visited[0][0] = true;
            resultStack = new Stack<>();
            isSolved = false;
            findPath(0, 0, 1);
            System.out.printf("Case #%d:\n", testNumber++);
            while (!resultStack.isEmpty()) {
                Point point = resultStack.pop();
                System.out.println((point.x + 1) + " " + (point.y + 1));
            }
        }
    }

    static void initializeBinomialCoefficients() {
        binomialCoefficients = new long[MAX][MAX];
        binomialCoefficients[0][0] = 1;
        for (int i = 1; i < MAX; i++) {
            binomialCoefficients[i][0] = 1;
            binomialCoefficients[i][i] = 1;
            for (int j = 1; j < i; j++) {
                binomialCoefficients[i][j] = binomialCoefficients[i - 1][j] + binomialCoefficients[i - 1][j - 1];
                if (binomialCoefficients[i][j] > LIMIT)
                    binomialCoefficients[i][j] = LIMIT;
            }
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public InputReader(FileReader stream) {
            reader = new BufferedReader(stream);
            tokenizer = null;
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}