import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
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
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        final int ZERO = 101;
        int[][] A = new int[210][210];

        for (int t = 1; t <= T; ++t) {
            for (int i = 0; i < 210; i++) {
                for (int j = 0; j < 210; j++) {
                    A[i][j] = 0;
                }
            }

            int x = sc.nextInt();
            int y = sc.nextInt();
            PriorityQueue<MyPair> queue = new PriorityQueue<>();
            queue.add(new MyPair(0, 0, ""));
            MyPair result = null;

            while (!queue.isEmpty()) {
                MyPair current = queue.poll();

                if (current.x == x && current.y == y) {
                    result = current;
                    break;
                }

                if (A[ZERO + current.x][ZERO + current.y] == 0) {
                    A[ZERO + current.x][ZERO + current.y] = 1;
                    int step = (int) Math.pow(2, current.s.length());

                    if (current.x + step <= 100) {
                        queue.add(new MyPair(current.x + step, current.y, current.s + "E"));
                    }
                    if (current.y + step <= 100) {
                        queue.add(new MyPair(current.x, current.y + step, current.s + "N"));
                    }
                    if (current.x - step >= -100) {
                        queue.add(new MyPair(current.x - step, current.y, current.s + "W"));
                    }
                    if (current.y - step >= -100) {
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
    }
}