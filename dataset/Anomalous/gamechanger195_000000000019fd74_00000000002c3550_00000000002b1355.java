import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Solution {
    static int n, m;

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader(System.in);
        StringBuilder result = new StringBuilder();
        int testCaseCount = reader.nextInt();

        for (int t = 1; t <= testCaseCount; t++) {
            n = reader.nextInt();
            m = reader.nextInt();
            int[][] grid = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = reader.nextInt();
                    visited[i][j] = true;
                }
            }

            long totalSum = 0;

            while (true) {
                long currentSum = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (visited[i][j]) {
                            currentSum += grid[i][j];
                        }
                    }
                }
                totalSum += currentSum;

                boolean[][] tempVisited = new boolean[n][m];
                for (int i = 0; i < n; i++) {
                    System.arraycopy(visited[i], 0, tempVisited[i], 0, m);
                }

                int deathCount = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (tempVisited[i][j]) {
                            long neighborSum = 0;
                            int neighborCount = 0;

                            for (int[] direction : directions) {
                                int x = i, y = j;
                                while (true) {
                                    x += direction[0];
                                    y += direction[1];
                                    if (!isValid(x, y)) break;
                                    if (tempVisited[x][y]) {
                                        neighborSum += grid[x][y];
                                        neighborCount++;
                                        break;
                                    }
                                }
                            }

                            if (neighborCount > 0) {
                                long average = neighborSum / neighborCount;
                                long remainder = neighborSum % neighborCount;
                                if (grid[i][j] < average || (grid[i][j] == average && remainder > 0)) {
                                    deathCount++;
                                    visited[i][j] = false;
                                }
                            }
                        }
                    }
                }

                if (deathCount == 0) break;
            }

            result.append("Case #").append(t).append(": ").append(totalSum).append("\n");
        }

        System.out.print(result);
    }
}

class FastReader {
    private byte[] buffer = new byte[2048];
    private int index, total;
    private InputStream input;

    FastReader(InputStream inputStream) {
        this.input = inputStream;
    }

    private int scan() throws IOException {
        if (index >= total) {
            index = 0;
            total = input.read(buffer);
            if (total <= 0) return -1;
        }
        return buffer[index++];
    }

    String next() throws IOException {
        int c;
        while ((c = scan()) <= 32);
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) c);
        } while ((c = scan()) > 32);
        return sb.toString();
    }

    int nextInt() throws IOException {
        int c, value = 0;
        while ((c = scan()) <= 32);
        boolean negative = c == '-';
        if (negative || c == '+') c = scan();
        do {
            value = value * 10 + (c - '0');
        } while ((c = scan()) >= '0' && c <= '9');
        return negative ? -value : value;
    }

    long nextLong() throws IOException {
        int c;
        long value = 0;
        while ((c = scan()) <= 32);
        boolean negative = c == '-';
        if (negative || c == '+') c = scan();
        do {
            value = value * 10 + (c - '0');
        } while ((c = scan()) >= '0' && c <= '9');
        return negative ? -value : value;
    }
}