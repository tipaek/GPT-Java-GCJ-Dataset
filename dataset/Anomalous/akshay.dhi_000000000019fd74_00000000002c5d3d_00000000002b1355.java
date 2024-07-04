import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        for (int ll = 1; ll <= testCases; ll++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int rows = Integer.parseInt(str.nextToken());
            int cols = Integer.parseInt(str.nextToken());
            int[][] matrix = new int[rows][cols];
            LinkedList<Point> queue = new LinkedList<>();

            for (int i = 0; i < rows; i++) {
                str = new StringTokenizer(br.readLine());
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = Integer.parseInt(str.nextToken());
                    queue.add(new Point(i, j));
                }
            }

            queue.add(new Point(-1, -1));
            int rounds = 1;
            int lastRoundTotal = 0;
            int total = 0;
            long sum = 0;

            while (!queue.isEmpty()) {
                Point p = queue.removeFirst();

                if (p.x == -1 && p.y == -1) {
                    if (!queue.isEmpty() && queue.peekLast().x != -1) {
                        queue.add(new Point(-1, -1));
                        if (lastRoundTotal == total) {
                            sum += total;
                            lastRoundTotal = total;
                            total = 0;
                            rounds++;
                            break;
                        }
                    }
                    sum += total;
                    lastRoundTotal = total;
                    total = 0;
                    rounds++;
                    continue;
                }

                total += matrix[p.x][p.y];
                int count = 0;
                int totalr = 0;

                totalr += countIfPositive(matrix, p.x, p.y - 1, rows, cols);
                totalr += countIfPositive(matrix, p.x, p.y + 1, rows, cols);
                totalr += countIfPositive(matrix, p.x - 1, p.y, rows, cols);
                totalr += countIfPositive(matrix, p.x + 1, p.y, rows, cols);

                if (totalr > 0) count = 1;

                double average = (double) totalr / count;

                if (average <= matrix[p.x][p.y]) {
                    queue.add(new Point(p.x, p.y));
                } else {
                    matrix[p.x][p.y] = 0;
                }
            }

            System.out.println("Case #" + ll + ": " + sum);
        }
    }

    private static int countIfPositive(int[][] matrix, int x, int y, int rows, int cols) {
        if (x >= 0 && y >= 0 && x < rows && y < cols && matrix[x][y] > 0) {
            return matrix[x][y];
        }
        return 0;
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}