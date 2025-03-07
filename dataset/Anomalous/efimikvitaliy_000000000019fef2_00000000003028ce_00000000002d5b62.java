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
        public int compareTo(MyPair o) {
            return this.s.length() - o.s.length();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; ++t) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int sum = Math.abs(x + y);
            if (sum % 2 == 0) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
                continue;
            }

            PriorityQueue<MyPair> queue = new PriorityQueue<>();
            queue.add(new MyPair(0, 0, ""));
            MyPair result = null;

            while (!queue.isEmpty()) {
                MyPair current = queue.poll();

                if (current.x == x && current.y == y) {
                    result = current;
                    break;
                }

                if (current.s.length() <= 30) {
                    int step = (int) Math.pow(2, current.s.length());

                    if (current.x + step <= 1000000000) {
                        queue.add(new MyPair(current.x + step, current.y, current.s + "E"));
                    }
                    if (current.y + step <= 1000000000) {
                        queue.add(new MyPair(current.x, current.y + step, current.s + "N"));
                    }
                    if (current.x - step >= -1000000000) {
                        queue.add(new MyPair(current.x - step, current.y, current.s + "W"));
                    }
                    if (current.y - step >= -1000000000) {
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