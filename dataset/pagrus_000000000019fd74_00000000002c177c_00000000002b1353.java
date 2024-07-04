import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static Cell[][] triangle = new Cell[500][];

    public static void main(String[] args) {

        Cell root = new Cell(1, 1, 1);
        triangle[0] = new Cell[]{root};
        for (int i = 1; i < 500; i++) {
            int length = i+1;
            triangle[i] = new Cell[length];
            triangle[i][0] = new Cell(i+1, 1, 1);
            triangle[i][length - 1] = new Cell(i+1, length, 1);
            for(int j=1; j<length - 1; j++) {
                triangle[i][j] = new Cell(i+1, j+1, triangle[i-1][j-1].value + triangle[i-1][j].value);
            }
        }

        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = s.nextInt();
        s.nextLine();
        for (int t = 1; t <= testCases; t++) {
            int n = s.nextInt();

            Deque<Integer> path = new ArrayDeque<>(500);
            dfs(path, new HashSet<>(500), enc(1, 1), 0, n);
            Cell[] cells = path.stream().map(Solution::cell).toArray(l -> new Cell[l]);
            System.out.format("Case #%d:\n", t);
            Arrays.stream(cells).forEach(c -> System.out.format("%d %d\n", c.r, c.c));
        }
    }

    static boolean dfs(Deque<Integer> path, HashSet<Integer> used, int next, long sum, long target) {
        if(path.size() == 500) {
            return false;
        }
        Cell cell = cell(next);
        long newSum = sum + cell.value;
        if(newSum > target) {
            return false;
        }

        path.addLast(next);
        used.add(next);

        if(newSum == target) {
            return true;
        }

        for(int i: adj(next)) {
            if(used.contains(i)) {
                continue;
            }
            if(dfs(path, used, i, newSum, target)) {
                return true;
            }
        }
        path.removeLast();
        used.remove(next);
        return false;
    }

    private static List<Integer> adj(int val) {
        List<Integer> result = new ArrayList<>(6);
        int r = val / 1000;
        int c = val % 1000;

        if(c > r /2) {
            result.add(enc(r + 1, c));
            result.add(enc(r + 1, c + 1));
        } else {
            result.add(enc(r + 1, c + 1));
            result.add(enc(r + 1, c));
        }

        if(r > 1) {
            if(c > 1) {
                result.add(enc(r-1, c-1));
                result.add(enc(r, c-1));
            }
            if(c < r) {
                result.add(enc(r - 1, c));
                result.add(enc(r, c + 1));
            }
        }
        return result;
    }

    private static Cell cell(int val) {
        int r = val / 1000;
        int c = val % 1000;
        return triangle[r-1][c-1];
    }

    private static int enc(int r, int c) {
        return 1000* r + c;
    }

    static class Cell {
        int r;
        int c;
        long value;

        public Cell(int r, int c, long value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + r +
                    ", " + c +
                    "]: " + value;
        }
    }


}