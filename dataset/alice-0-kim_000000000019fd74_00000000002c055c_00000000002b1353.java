import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            List<int[]> path = new ArrayList();
            Map<String, Integer> map = new HashMap();
            // map.put("1#1", 1);
            path.add(new int[]{1, 1});
            findPath(path, map, 1, 1, N);
            System.out.printf("Case #%d:\n", t);
            System.out.println(pathToString(path));
        }
    }
    
    private static String pathToString(List<int[]> path) {
        StringJoiner s = new StringJoiner("\n");
        for (int[] p : path) {
            StringJoiner t = new StringJoiner(" ");
            for (int i : p) t.add(Integer.toString(i));
            s.add(t.toString());
        }
        return s.toString();
    }
    
    private static int getValue(Map<String, Integer> map, int r, int k) {
        if (k == 1 || r == k) return 1;
        int topLeft = k - 1 == 1 ? 1 : map.getOrDefault((r - 1) + "#" + (k - 1), 0);
        int topRight = r - 1 == k ? 1 : map.getOrDefault(r - 1 + "#" + k, 0);
        return topLeft + topRight;
    }
    
    private static boolean findPath(List<int[]> path, Map<String, Integer> map, int r, int k, int N) {
        if (N < 0 || r < 1 || k < 1 || r < k || map.containsKey(r + "#" + k)) return false;
        int val = getValue(map, r, k);
        map.put(r + "#" + k, val);
        N -= val;
        if (N == 0) {
            return true;
        }
        List<int[]> cand = new ArrayList();
        cand.add(new int[]{r-1, k-1});
        cand.add(new int[]{r-1, k});
        cand.add(new int[]{r, k-1});
        cand.add(new int[]{r, k+1});
        cand.add(new int[]{r+1, k});
        cand.add(new int[]{r+1, k+1});
        for (int[] c : cand) {
            path.add(c);
            if (findPath(path, map, c[0], c[1], N)) return true;
            path.remove(c);
        }
        return false;
    }
}