import java.util.PriorityQueue;
import java.util.Scanner;

public class Expogo {
    static class MyPair implements Comparable<MyPair> {
        int x, y;
        String s;

        public MyPair(int x, int y, String s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }

        @Override
        public int compareTo(MyPair other) {
            return this.s.length() - other.s.length();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        final int OFFSET = 101;
        int[][] visited = new int[210][210];

        for (int t = 1; t <= testCases; t++) {
            for (int i = 0; i < 210; i++) {
                for (int j = 0; j < 210; j++) {
                    visited[i][j] = 0;
                }
            }

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

                if (visited[OFFSET + current.x][OFFSET + current.y] == 0) {
                    visited[OFFSET + current.x][OFFSET + current.y] = 1;
                    int stepSize = (int) Math.pow(2, current.s.length());

                    if (current.x + stepSize <= 100) {
                        queue.add(new MyPair(current.x + stepSize, current.y, current.s + "E"));
                    }
                    if (current.y + stepSize <= 100) {
                        queue.add(new MyPair(current.x, current.y + stepSize, current.s + "N"));
                    }
                    if (current.x - stepSize >= -100) {
                        queue.add(new MyPair(current.x - stepSize, current.y, current.s + "W"));
                    }
                    if (current.y - stepSize >= -100) {
                        queue.add(new MyPair(current.x, current.y - stepSize, current.s + "S"));
                    }
                }
            }

            if (result != null) {
                System.out.println("Case #" + t + ": " + result.s);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
        scanner.close();
    }
}