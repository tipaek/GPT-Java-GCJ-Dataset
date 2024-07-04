import java.util.*;
import java.io.*;
class Solution {
    private static StringBuilder path;
    private static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static char[] map = {'N', 'S', 'E', 'W'};
    static Map<Long, Set<Long>> visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();

        for(int k=1; k<=T; k++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            System.out.println("Case #" + k + ": " + solve(X, Y));
        }
    }

    private static String solve(int X, int Y) {
        int dist = Math.abs(X) + Math.abs(Y);
        if(dist % 2 == 0)
            return "IMPOSSIBLE";
        path = new StringBuilder();
        visited = new HashMap<>();
        int len = 1;
        while(len < 60) {
            if(dfs(0, 0, X, Y, len, 0))
                return path.toString();
            len++;
        }
        return "IMPOSSIBLE";
    }

    private static boolean dfs(long x, long y, int X, int Y, int len, int step) {
        if(x == X && y == Y)
        return true;
        if(len == step || (visited.containsKey(x) && visited.get(x).contains(y)))
        return false;
        visited.putIfAbsent(x, new HashSet<>());
        visited.get(x).add(y);

        long leg = 1L;
        leg = leg<<step;

        for(int i=0; i<4; i++) {
            path.append(map[i]);
            if(dfs(x+dirs[i][0]*leg, y+dirs[i][1]*leg, X, Y, len, step+1))
                return true;
            path.setLength(path.length()-1);    
        }
        visited.get(x).remove(y);
        return false;
    }
}