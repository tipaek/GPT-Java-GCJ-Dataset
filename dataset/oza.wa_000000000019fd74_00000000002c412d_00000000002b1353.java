import java.util.*;


class Path {
    int row;
    int col;

    public Path(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    private static String createKey(long i, int j) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(":");
        sb.append(j);
        return sb.toString();
    }

    private static boolean add(Set<String> set, int i, int j) {
        String k = createKey(i, j);
        if (set.contains(k)) {
            return false;
        }

        set.add(k);
        return true;
    }

    private static void del(Set<String> set, int i, int j) {
        String k = createKey(i, j);
        set.remove(k);
    }


    private static long combi(int n, int r) {
        long ret = 1;
        if (n == 0 || r == 0) return 1;

        for(int i = 1; i <= r; i++){
            ret = ret * (n - i + 1) / i;
        }
        return ret;
    }


    private static long pascalGet(int row, int col) {
        int n = row - 1;
        int k = col - 1;
        return combi(n, k);
    }

    private static Deque<Path> search(Deque<Path> path, HashSet<String> visited, long target, int step, int row, int col) {
        if (step > 500) return null;

        long v = pascalGet(row, col);

        String k = createKey(row, col);
        if (visited.contains(k)) return null;


        if (target - v < 0 ) {
            return null;
        }

        visited.add(k);
        path.offer(new Path(row, col));

        if (target - v == 0) {
            return path;
        }

        boolean ok = false;
        if (col + 1 <= row) {
            Deque<Path> r = search(new ArrayDeque<Path>(path), new HashSet<String>(visited), target - v, step + 1, row, col + 1);
            if (r != null) return r;
        }
        if (col - 1 >= 1) {
            Deque<Path> r = search(new ArrayDeque<Path>(path), new HashSet<String>(visited), target - v,  step + 1, row, col - 1);
            if (r != null) return r;
        }

        Deque<Path> r = search(new ArrayDeque<Path>(path), new HashSet<String>(visited), target - v,  step + 1, row + 1, col);
        if (r != null) return r;

        return null;
    }

    private static void solve(Scanner sc, int x) {
        long target = sc.nextInt();

        int startRow = 1;
        int startCol = 1;

        Queue<Path> path = search(new ArrayDeque<Path>(), new HashSet<>(), target, 1, startRow, startCol);
        assert path != null;
        //path.add(new Path(1, 1));
        //searchPath(, 1, 1);

        System.out.println(String.format("Case #%d:", x));
        while (!path.isEmpty()) {
            Path p = path.poll();
            System.out.println(String.format("%d %d", p.row, p.col));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            solve(sc, i + 1);
        }
    }
}