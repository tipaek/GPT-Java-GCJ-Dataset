import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static Map<String, Integer> map = new HashMap<>();
    private static Map<String, Boolean> visited = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine().trim()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = Integer.parseInt(in.nextLine());
            List<String> helper = helper(n);
            System.out.println("Case #" + i + ":");
            for (String word : helper) {
                System.out.println(word);
            }
        }
    }

    private static List<String> helper(int n) {
        List<List<String>> list = new ArrayList<>();
        List<String> res = new ArrayList<>();
        res.add("1 1");
        visited.put("1 1", true);
        dfs(n, 1, 1, 1, res, list);
        return list.get(0);
    }

    private static void dfs(int n, int r, int k, int sum, List<String> res, List<List<String>> list) {
        if (sum > n) return;
        if (sum == n) {
            list.add(new ArrayList<>(res));
        } else {
            int[][] direction = {{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}};
            for (int[] ints : direction) {
                if (list.size() > 0) break;
                int nr = r + ints[0];
                int nk = k + ints[1];
                if (nr == 0 || nk == 0 || nr < nk || visited.getOrDefault(nr + " " + nk, false)) continue;
                res.add(nr + " " + nk);
                visited.put(nr + " " + nk, true);
                int v = getValueInTriangle(nr, nk);
                dfs(n, nr, nk, sum + v, res, list);
                res.remove(res.size() - 1);
                visited.put(nr + " " + nk, false);
            }
        }
    }

    private static int getValueInTriangle(int r, int k) {
        String key = r + "-" + k;
        if (map.containsKey(key)) return map.get(key);
        if (r == 0 || k == 0) return 0;
        if (k == 1 || r == k) return 1;
        int res = getValueInTriangle(r - 1, k - 1) + getValueInTriangle(r - 1, k);
        map.put(key, res);
        return res;
    }

}