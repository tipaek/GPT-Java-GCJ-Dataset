import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    static class MyPair implements Comparable<MyPair> {
        int x, y;
        String path;

        public MyPair(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }

        @Override
        public int compareTo(MyPair other) {
            return this.path.length() - other.path.length();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        final int OFFSET = 101;

        for (int t = 1; t <= testCases; t++) {
            int[][] visited = new int[210][210];
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();

            PriorityQueue<MyPair> queue = new PriorityQueue<>();
            queue.add(new MyPair(0, 0, ""));
            MyPair result = null;

            while (!queue.isEmpty()) {
                MyPair current = queue.poll();

                if (current.x == targetX && current.y == targetY) {
                    result = current;
                    break;
                }

                int stepSize = (int) Math.pow(2, current.path.length());

                if (current.x + stepSize <= 100 && visited[OFFSET + current.x + stepSize][OFFSET + current.y] == 0) {
                    visited[OFFSET + current.x + stepSize][OFFSET + current.y] = 1;
                    queue.add(new MyPair(current.x + stepSize, current.y, current.path + "E"));
                }
                if (current.y + stepSize <= 100 && visited[OFFSET + current.x][OFFSET + current.y + stepSize] == 0) {
                    visited[OFFSET + current.x][OFFSET + current.y + stepSize] = 1;
                    queue.add(new MyPair(current.x, current.y + stepSize, current.path + "N"));
                }
                if (current.x - stepSize >= -100 && visited[OFFSET + current.x - stepSize][OFFSET + current.y] == 0) {
                    visited[OFFSET + current.x - stepSize][OFFSET + current.y] = 1;
                    queue.add(new MyPair(current.x - stepSize, current.y, current.path + "W"));
                }
                if (current.y - stepSize >= -100 && visited[OFFSET + current.x][OFFSET + current.y - stepSize] == 0) {
                    visited[OFFSET + current.x][OFFSET + current.y - stepSize] = 1;
                    queue.add(new MyPair(current.x, current.y - stepSize, current.path + "S"));
                }
            }

            if (result != null) {
                System.out.println("Case #" + t + ": " + result.path);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}