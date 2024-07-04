import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            System.out.print("Case #" + i + ": ");
            System.out.println();
            List<int[]> res = find(n);
            for (int[] ele : res) {
                System.out.println(ele[0] +" "+ele[1]);
            }
        }
    }

    public static List<int[]> find(int n) {
        List<int[]> res = new ArrayList<>();
        dfs(res, 1,1, 0, n, new HashSet<>());
        return res;
    }

    public static boolean dfs(List<int[]> path, int row, int col, int curSum, int n, Set<String> visit) {
        int curNum = compute(row, col);
        if (curNum + curSum > n || path.size() == 500) {
            return false;
        }
        path.add(new int[]{row, col});
        if (curNum + curSum == n) {
            return true;
        }
        int[] dr = new int[]{1, 1, 0, 0, -1, -1};
        int[] dc = new int[]{0, 1, -1, 1, -1, 0};
        for (int i = 0; i < 6; i++) {
            int nextR = row + dr[i];
            int nextC = col + dc[i];
            String nextCell = nextR + "_" + nextC;
            if (nextR >= 1 && nextC >= 1 && nextC <= nextR && !visit.contains(nextCell)) {
                visit.add(nextCell);
                boolean flag = dfs(path, nextR, nextC, curNum + curSum, n, visit);
                if (flag) {
                    return true;
                }
                visit.remove(nextCell);
            }
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static int compute(int r, int c) {
        long res = 1;
        r--;
        c--;
        if (c  == 0 || c == r) {
            return 1;
        }
        if (c > r / 2) {
            c = r - c;
        }
        int base = r;
        for (int i = 0; i < c; i++) {
            res *= base;
            base--;
        }
        for (int i = 1; i <= c; i++) {
            res /= i;
        }

        return Math.toIntExact(res);
    }


    public static String build(List<String> words) {
        return "";
    }

}