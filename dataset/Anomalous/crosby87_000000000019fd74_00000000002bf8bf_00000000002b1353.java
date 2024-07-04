import java.util.*;

public class Pascal {

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
                Pair current = queue.poll();
                if (visited[current.row][current.col]) {
                    continue;
                }
                visited[current.row][current.col] = true;

                if (current.sum == N) {
                    path = current.path;
                    break;
                }

                for (int i = 0; i < 6; i++) {
                    int newRow = current.row + dx[i];
                    int newCol = current.col + dy[i];
                    if (newRow > 0 && newCol > 0 && newRow < 504 && newCol < 504 && newRow >= newCol) {
                        Pair next = new Pair(newRow, newCol, current.path + i, current.sum + choose[newRow][newCol]);
                        queue.add(next);
                    }
                }
            }

            System.out.println("Case #" + a + ": ");
            System.out.println(1 + " " + 1);
            int currRow = 1, currCol = 1;
            for (char direction : path.toCharArray()) {
                switch (direction) {
                    case '0':
                        currRow -= 1;
                        currCol -= 1;
                        break;
                    case '1':
                        currRow -= 1;
                        break;
                    case '2':
                        currCol -= 1;
                        break;
                    case '3':
                        currRow += 1;
                        break;
                    case '4':
                        currCol += 1;
                        break;
                    case '5':
                        currRow += 1;
                        currCol += 1;
                        break;
                }
                System.out.println(currRow + " " + currCol);
            }
        }
    }
}