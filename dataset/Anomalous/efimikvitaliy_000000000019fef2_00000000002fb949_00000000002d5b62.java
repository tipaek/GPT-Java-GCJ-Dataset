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
        final int ZERO = 501;
        int[][] A = new int[1100][1100];

        for (int t = 1; t <= T; t++) {
            for (int i = 0; i < 1100; i++) {
                for (int j = 0; j < 1100; j++) {
                    A[i][j] = 0;
                }
            }

            int x = sc.nextInt();
            int y = sc.nextInt();
            PriorityQueue<MyPair> q = new PriorityQueue<>();
            q.add(new MyPair(0, 0, ""));
            MyPair result = null;

            while (!q.isEmpty()) {
                MyPair p = q.poll();

                if (p.x == x && p.y == y) {
                    result = p;
                    break;
                }

                int step = (int) Math.pow(2, p.s.length());

                if (p.x + step <= 500 && A[ZERO + p.x + step][ZERO + p.y] == 0) {
                    A[ZERO + p.x + step][ZERO + p.y] = 1;
                    q.add(new MyPair(p.x + step, p.y, p.s + "E"));
                }

                if (p.y + step <= 500 && A[ZERO + p.x][ZERO + p.y + step] == 0) {
                    A[ZERO + p.x][ZERO + p.y + step] = 1;
                    q.add(new MyPair(p.x, p.y + step, p.s + "N"));
                }

                if (p.x - step >= -500 && A[ZERO + p.x - step][ZERO + p.y] == 0) {
                    A[ZERO + p.x - step][ZERO + p.y] = 1;
                    q.add(new MyPair(p.x - step, p.y, p.s + "W"));
                }

                if (p.y - step >= -500 && A[ZERO + p.x][ZERO + p.y - step] == 0) {
                    A[ZERO + p.x][ZERO + p.y - step] = 1;
                    q.add(new MyPair(p.x, p.y - step, p.s + "S"));
                }
            }

            if (result != null) {
                System.out.println("Case #" + t + ": " + result.s);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }

        sc.close();
    }
}