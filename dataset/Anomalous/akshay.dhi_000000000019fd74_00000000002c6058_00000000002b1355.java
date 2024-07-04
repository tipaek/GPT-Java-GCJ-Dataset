import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(str.nextToken());
        int caseNumber = 1;

        while (testCases-- > 0) {
            str = new StringTokenizer(br.readLine());
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
                int totalAdjacent = 0;

                totalAdjacent += checkAdjacent(p.x, p.y, rows, cols, matrix, -1, 0); // left
                totalAdjacent += checkAdjacent(p.x, p.y, rows, cols, matrix, 1, 0);  // right
                totalAdjacent += checkAdjacent(p.x, p.y, rows, cols, matrix, 0, -1); // top
                totalAdjacent += checkAdjacent(p.x, p.y, rows, cols, matrix, 0, 1);  // bottom

                count = (totalAdjacent == 0) ? 1 : 4;

                double average = (double) totalAdjacent / count;

                if (average <= matrix[p.x][p.y]) {
                    queue.add(new Point(p.x, p.y));
                } else {
                    matrix[p.x][p.y] = 0;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + sum);
            caseNumber++;
        }
    }

    public static int checkAdjacent(int x, int y, int rows, int cols, int[][] matrix, int dx, int dy) {
        int newX = x + dx;
        int newY = y + dy;

        while (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
            if (matrix[newX][newY] > 0) {
                return matrix[newX][newY];
            }
            newX += dx;
            newY += dy;
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