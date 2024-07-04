import java.util.PriorityQueue;
import java.util.Scanner;

public class Expogo {
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
        int OFFSET = 1001;

        for (int t = 1; t <= testCases; t++) {
            int[][] visited = new int[2000][2000];
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

                int jump = (int) Math.pow(2, current.path.length());

                if (current.x + jump <= 500 && visited[OFFSET + current.x + jump][OFFSET + current.y] == 0) {
                    visited[OFFSET + current.x + jump][OFFSET + current.y] = 1;
                    queue.add(new MyPair(current.x + jump, current.y, current.path + "E"));
                }

                if (current.y + jump <= 500 && visited[OFFSET + current.x][OFFSET + current.y + jump] == 0) {
                    visited[OFFSET + current.x][OFFSET + current.y + jump] = 1;
                    queue.add(new MyPair(current.x, current.y + jump, current.path + "N"));
                }

                if (current.x - jump >= -500 && visited[OFFSET + current.x - jump][OFFSET + current.y] == 0) {
                    visited[OFFSET + current.x - jump][OFFSET + current.y] = 1;
                    queue.add(new MyPair(current.x - jump, current.y, current.path + "W"));
                }

                if (current.y - jump >= -500 && visited[OFFSET + current.x][OFFSET + current.y - jump] == 0) {
                    visited[OFFSET + current.x][OFFSET + current.y - jump] = 1;
                    queue.add(new MyPair(current.x, current.y - jump, current.path + "S"));
                }
            }

            if (result != null) {
                System.out.println("Case #" + t + ": " + result.path);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}