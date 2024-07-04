import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            String res = find(x, y);
            System.out.println("Case #" + i + ": " + res);
        }
    }
    private static String find(int x, int y) {
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        char[] dimen = {'E', 'W', 'N','S'};
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        set.add("00");
        q.offer("00");
        Map<String, String> map = new HashMap<>();
        int times = 1;
        map.put("00", "");
        while (!q.isEmpty()) {
            for (int k = q.size(); k > 0; k--) {
                String temp = q.poll();
                int a = 0;
                int b = 0;
                if (temp.charAt(0) != '-') {
                    a = temp.charAt(0) - '0';
                    b = Integer.parseInt(temp.substring(1));
                } else {
                    a = Integer.parseInt(temp.substring(0, 2));
                    b = Integer.parseInt(temp.substring(2));
                }
                for (int i = 0; i < 4; i++) {
                    int dx = a + dir[i][0] * times;
                    int dy = b + dir[i][1] * times;
                    String s = String.valueOf(dx) + dy;
                    if (dx == x && dy == y) return map.get(temp) + dimen[i];
                    if (!set.contains(s) && Math.abs(dx) <= Math.abs(x) &&  Math.abs(dy) <= Math.abs(y)) {
                        q.offer(s);
                        map.put(s, map.get(temp) + dimen[i]);
                        set.add(s);
                    }
                }

            }
            times <<= 1;
        }
        return "IMPOSSIBLE";
    }

}
