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
        int T = scanner.nextInt();
        int OFFSET = 501;
        int[][] visited = new int[1100][1100];

        for (int t = 1; t <= T; t++) {
            for (int i = 0; i < 1100; i++) {
                for (int j = 0; j < 1100; j++) {
                    visited[i][j] = 0;
                }
            }

            int x = scanner.nextInt();
            int y = scanner.nextInt();
            
            PriorityQueue<MyPair> queue = new PriorityQueue<>();
            queue.add(new MyPair(0, 0, ""));
            MyPair result = null;

            while (!queue.isEmpty()) {
                MyPair current = queue.poll();

                if (current.x == x && current.y == y) {
                    result = current;
                    break;
                }

                if (visited[OFFSET + current.x][OFFSET + current.y] == 0) {
                    visited[OFFSET + current.x][OFFSET + current.y] = 1;
                    int step = (int) Math.pow(2, current.s.length());

                    if (current.x + step <= 500) {
                        queue.add(new MyPair(current.x + step, current.y, current.s + "E"));
                    }
                    if (current.y + step <= 500) {
                        queue.add(new MyPair(current.x, current.y + step, current.s + "N"));
                    }
                    if (current.x - step >= -500) {
                        queue.add(new MyPair(current.x - step, current.y, current.s + "W"));
                    }
                    if (current.y - step >= -500) {
                        queue.add(new MyPair(current.x, current.y - step, current.s + "S"));
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