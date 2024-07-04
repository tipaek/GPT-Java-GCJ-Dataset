import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
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
                System.out.println(p.x + " " + p.y);

                if (p.x == -1 && p.y == -1) {
                    if (!queue.isEmpty() && queue.peekLast().x != -1) {
                        queue.add(new Point(-1, -1));
                        if (lastRoundTotal == total) {
                            break;
                        }
                        sum += total;
                        lastRoundTotal = total;
                        total = 0;
                        rounds++;
                    }
                } else {
                    total += matrix[p.x][p.y];
                    int count = 0;
                    int totalr = 0;

                    if (leftExist(p.y)) {
                        count++;
                        totalr += matrix[p.x][p.y - 1];
                    }
                    if (rightExist(p.y, cols)) {
                        count++;
                        totalr += matrix[p.x][p.y + 1];
                    }
                    if (topExist(p.x)) {
                        count++;
                        totalr += matrix[p.x - 1][p.y];
                    }
                    if (bottomExist(p.x, rows)) {
                        count++;
                        totalr += matrix[p.x + 1][p.y];
                    }

                    double average = (double) totalr / count;

                    if (average <= matrix[p.x][p.y]) {
                        queue.add(new Point(p.x, p.y));
                    }
                }
            }
            System.out.println(sum);
        }
    }

    public static boolean leftExist(int y) {
        return y > 0;
    }

    public static boolean rightExist(int y, int cols) {
        return y < cols - 1;
    }

    public static boolean topExist(int x) {
        return x > 0;
    }

    public static boolean bottomExist(int x, int rows) {
        return x < rows - 1;
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}