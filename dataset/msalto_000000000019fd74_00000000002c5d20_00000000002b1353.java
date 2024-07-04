import java.util.*;

public class Solution {

    private static int[][] POINTERS = {{0, -1}, {-1, -1}, {-1, 0}, {0, 1}, {1, 0}, {1, 1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = readInt(scanner);
        for (int i = 1; i <= testCases; ++i) {
            int n = readInt(scanner);
            int[][] m = generateTriangle();
        	Deque<int[]> path = new ArrayDeque<>();
        	path.push(new int[]{1, 1});
        	solve(m, 1, 1, 0, path, n);
        }
    }

    private static boolean solve(int[][] m, int row, int col, int sum, Deque<int[]> path, int n) {
        sum += m[row][col];
        int before = m[row][col];
        m[row][col] = 0;
        if (sum == n) {
            printPath(path);
            return true;
        }
        if  (sum > n) {
            m[row][col] = before;
            return false;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> Integer.compare(y[2], x[2]));
        for (int[] pointer : POINTERS) {
            int newR = row + pointer[0];
            int newC = col + pointer[1];
            if (newR == m.length || m[newR][newC] == 0) {
                continue;
            }
            q.offer(new int[]{newR, newC, m[newR][newC]});
        }
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int newR = arr[0];
            int newC = arr[1];
            path.push(new int[]{newR, newC});
            if (solve(m, newR, newC, sum, path, n)) {
                return true;
            }
            path.pop();
        }
        m[row][col] = before;
        return false;
    }

    private static void printPath(Deque<int[]> path) {
        Iterator<int[]> it = path.descendingIterator();
        while (it.hasNext()) {
            int[] pos = it.next();
            System.out.println(pos[0] + " " + pos[1]);
        }
    }

    private static int[][] generateTriangle() {
        int n = 502;
        int[][] m = new int[n][n];
        for (int row = 1; row < n; ++row) {
            for (int col = 1; col <= row; ++col) {
                if (row == 1 || col == row) {
                    m[row][col] = 1;
                } else {
                    m[row][col] = m[row - 1][col - 1] + m[row - 1][col];
                }
            }
        }
        return m;
    }

    private static int readInt(Scanner scanner) {
        String line = scanner.nextLine();
        return Integer.parseInt(line);
    }
}

