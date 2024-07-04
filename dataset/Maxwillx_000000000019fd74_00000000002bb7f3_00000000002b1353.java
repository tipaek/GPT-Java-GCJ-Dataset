import java.util.*;
class S {
    int x, y;
    public S(int r, int c) {
        this.x = r;
        this.y = c;
    }
    public boolean equals(Object input) {
        S s = (S)input;
        return x == s.x && y == s.y;
    }
    public int hashCode() {
        return 31 * x + y;
    }
}
class Solution {
    Map<S, Integer> state = new HashMap<>();
    private int[] dx = new int[]{-1, -1, 0, 0, 1, 1};
    private int[] dy = new int[]{-1, 0, -1, 1, 0, 1};
    int target;
    public static void main(String[] arg) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        int testCnt = 0;
        String line = sc.nextLine();
        testCnt = Integer.parseInt(line);
        for (int i = 0; i < testCnt; i++) {
            int target = Integer.parseInt(sc.nextLine());
            s.solve(target, i + 1);
        }
    }
    private void solve(int target, int id) {
        this.target = target;
        List<S> path = new ArrayList<>();
        Set<S> visit = new HashSet<>();
        S start = new S(1, 1);
        path.add(start);
        visit.add(start);
        dfs(1, 1, getSum(start), visit, path);
        System.out.println("Case #" + Integer.toString(id) + ":");
        for (S s : path) {
            System.out.println(Integer.toString(s.x) + " " + Integer.toString(s.y));
        }
    }
    private boolean dfs(int row, int col, int sum, Set<S> visit, List<S> path) {
        if (sum > target) return false;
        else if (sum == target) return true;
        for (int i = 0; i < 6; i++) {
            int nx = row + dx[i], ny = col + dy[i];
            if (nx <= 0 || ny <= 0 || ny > nx) continue;
            S s = new S(nx, ny);
            if (visit.contains(s)) continue;
            visit.add(s);
            path.add(s);
            if (dfs(nx, ny, sum + getSum(s), visit, path)) return true;
            path.remove(s);
            visit.remove(s);
        }
        return false;
    }
    private int getSum(S s) {
        Integer val = state.get(s);
        if (val != null) return val;
        if (s.y == 1 || s.y == s.x) val = 1;
        else {
            val = getSum(new S(s.x - 1, s.y - 1)) + getSum(new S(s.x - 1, s.y));
        }
        state.put(s, val);
        return val;
    }
}

