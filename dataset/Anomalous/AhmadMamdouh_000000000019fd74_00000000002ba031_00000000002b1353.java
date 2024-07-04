import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
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
            if (this.x == other.x) {
                return this.y - other.y;
            }
            return this.x - other.x;
        }
    }

    static boolean[][] visited;
    static int[] dx = {-1, -1, 0, 0, 1, 1};
    static int[] dy = {-1, 0, -1, 1, 0, 1};
    static int target;
    static long[][] binomialCoefficients;
    static Stack<Point> pathStack;
    static Stack<Point> resultStack;
    static boolean solutionFound = false;
    static int max = 50;

    static boolean searchPath(int x, int y, long sum) {
        if (solutionFound) return true;
        if (sum > target) return false;
        if (sum == target) {
            while (!pathStack.isEmpty()) {
                resultStack.add(pathStack.pop());
            }
            solutionFound = true;
            return true;
        }
        for (int k = 0; k < dx.length; k++) {
            int newX = x + dx[k];
            int newY = y + dy[k];
            if (newX >= 0 && newY >= 0 && newY <= newX && newX < max && newY < max && !visited[newX][newY]) {
                pathStack.push(new Point(newX, newY));
                visited[x][y] = true;
                boolean canContinue = searchPath(newX, newY, sum + binomialCoefficients[newX][newY]);
                if (canContinue) return true;
                pathStack.pop();
                visited[x][y] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int testCases = reader.nextInt();
        int testCaseNumber = 1;
        binomialCoefficients = new long[max][max];
        binomialCoefficients[0][0] = 1;
        for (int i = 1; i < max; i++) {
            binomialCoefficients[i][0] = 1;
            binomialCoefficients[i][i] = 1;
            for (int j = 1; j < i; j++) {
                binomialCoefficients[i][j] = binomialCoefficients[i - 1][j] + binomialCoefficients[i - 1][j - 1];
            }
        }
        while (testCases-- > 0) {
            target = reader.nextInt();
            pathStack = new Stack<>();
            pathStack.push(new Point(0, 0));
            visited = new boolean[max][max];
            visited[0][0] = true;
            resultStack = new Stack<>();
            solutionFound = false;
            searchPath(0, 0, 1);
            System.out.printf("Case #%d:\n", testCaseNumber++);
            while (!resultStack.isEmpty()) {
                Point p = resultStack.pop();
                System.out.println((p.x + 1) + " " + (p.y + 1));
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

        public InputReader(FileReader fileReader) {
            reader = new BufferedReader(fileReader);
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