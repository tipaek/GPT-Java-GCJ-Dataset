import java.util.PriorityQueue;
import java.util.Scanner;

public class Expogo {
    static class Pair implements Comparable<Pair> {
        int x, y;
        String path;

        public Pair(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }

        @Override
        public int compareTo(Pair other) {
            return this.path.length() - other.path.length();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int OFFSET = 1001;

        for (int t = 1; t <= testCases; t++) {
            int[][] visited = new int[1100][1100];
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();

            PriorityQueue<Pair> queue = new PriorityQueue<>();
            queue.add(new Pair(0, 0, ""));
            Pair result = null;

            while (!queue.isEmpty()) {
                Pair current = queue.poll();

                if (current.x == targetX && current.y == targetY) {
                    result = current;
                    break;
                }

                int step = (int) Math.pow(2, current.path.length());

                if (current.x + step <= 500 && visited[OFFSET + current.x + step][OFFSET + current.y] == 0) {
                    visited[OFFSET + current.x + step][OFFSET + current.y] = 1;
                    queue.add(new Pair(current.x + step, current.y, current.path + "E"));
                }

                if (current.y + step <= 500 && visited[OFFSET + current.x][OFFSET + current.y + step] == 0) {
                    visited[OFFSET + current.x][OFFSET + current.y + step] = 1;
                    queue.add(new Pair(current.x, current.y + step, current.path + "N"));
                }

                if (current.x - step >= -500 && visited[OFFSET + current.x - step][OFFSET + current.y] == 0) {
                    visited[OFFSET + current.x - step][OFFSET + current.y] = 1;
                    queue.add(new Pair(current.x - step, current.y, current.path + "W"));
                }

                if (current.y - step >= -500 && visited[OFFSET + current.x][OFFSET + current.y - step] == 0) {
                    visited[OFFSET + current.x][OFFSET + current.y - step] = 1;
                    queue.add(new Pair(current.x, current.y - step, current.path + "S"));
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