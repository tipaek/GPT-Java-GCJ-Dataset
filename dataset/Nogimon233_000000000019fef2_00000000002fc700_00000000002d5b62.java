import java.util.*;
import java.io.*;

public class Solution {

    //static int ans = 0;
    static Map<String, String> map;
    public static void main(String[] args) {
        //.out.println("codejam");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        map = new HashMap<>();
        dfs(0, 0, 1, new StringBuilder());

        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            String ans = solve(x, y);
            System.out.println("Case #" + i + ": " + ans);
        }
    }

    private static void dfs(int x, int y, int step, StringBuilder sb) {
        if (x > 100 || y > 100 || x < -100 || y < -100)
            return;
        String key = x + " " + y;
        if (map.containsKey(key) && map.get(key).length() <= sb.length()) {
            return;
        }

        String curr = sb.toString();
        map.put(key, curr);

        sb.append("E");
        dfs(x + step, y, step*2, sb);
        sb.deleteCharAt(sb.length()-1);
        sb.append("W");
        dfs(x - step, y, step*2, sb);
        sb.deleteCharAt(sb.length()-1);
        sb.append("N");
        dfs(x , y + step, step*2, sb);
        sb.deleteCharAt(sb.length()-1);
        sb.append("S");
        dfs(x , y-step, step*2, sb);
        sb.deleteCharAt(sb.length()-1);

    }


    private static String solve(int x, int y) {
        String key = x + " " + y;
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            return "IMPOSSIBLE";
        }
    }

    private static void pr(int x) {
        System.out.println(x);
        System.out.println(Integer.toBinaryString(x));
        System.out.println(~x);
        System.out.println(Integer.toBinaryString(~x));
    }






}


