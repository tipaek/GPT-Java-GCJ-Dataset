import java.util.*;

public class Solution {

    public static class Pair {
        int row, col;
        String path;
        long sum;

        public Pair(int row, int col, String path, long sum) {
            this.row = row;
            this.col = col;
            this.path = path;
            this.sum = sum;
        }
    }

    public static class TwoD {
        int row, col;

        public TwoD(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[] dx = {-1, -1, 0, 1, 0, 1};
        int[] dy = {-1, 0, -1, 0, 1, 1};

        long[][] choose = new long[504][504];

        for (int i = 1; i < 504; i++) {
            choose[i][0] = 1L;
            for (int j = 1; j <= i; j++) {
                choose[i][j] = choose[i][j - 1] * (i - j + 1) / j;
            }
        }

        for (int a = 1; a <= T; a++) {
            long N = sc.nextLong();
            Pair start = new Pair(1, 1, "", 1L);
            boolean[][] visited = new boolean[504][504];
            Queue<Pair> queue = new LinkedList<>();
            queue.add(start);
            String path = "B";

            while (!queue.isEmpty()) {
                Pair next = queue.poll();
                if (visited[next.row][next.col]) {
                    continue;
                }
                visited[next.row][next.col] = true;

                if (next.sum == N) {
                    path = next.path;
                    break;
                }

                for (int i = 0; i < 6; i++) {
                    int x2 = next.row + dx[i];
                    int y2 = next.col + dy[i];
                    if (x2 > 0 && y2 > 0 && x2 < 504 && y2 < 504 && x2 >= y2) {
                        Pair newPair = new Pair(x2, y2, next.path + i, next.sum + choose[x2][y2]);
                        queue.add(newPair);
                    }
                }
            }

            System.out.println("Case #" + a + ": ");
            System.out.println(1 + " " + 1);
            int currX = 1, currY = 1;
            for (char direction : path.toCharArray()) {
                switch (direction) {
                    case '0':
                        currX -= 1;
                        currY -= 1;
                        break;
                    case '1':
                        currX -= 1;
                        break;
                    case '2':
                        currY -= 1;
                        break;
                    case '3':
                        currX += 1;
                        break;
                    case '4':
                        currY += 1;
                        break;
                    case '5':
                        currX += 1;
                        currY += 1;
                        break;
                }
                System.out.println(currX + " " + currY);
            }
        }
    }
}