import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            System.out.print(String.format("Case #%d: ", i));
            solve(in);
        }
    }

    private static void solve(Scanner sc) {
        int x = sc.nextInt();
        int y = sc.nextInt();

        Map<Long, Map<Long, String>> cache = new HashMap<>();
        System.out.println(solve(x, y, 1, cache));
    }

    private static String solve(long x, long y, long jumpDistance, Map<Long, Map<Long, String>> cache) {
        if(jumpDistance > Math.pow(10,10)+5) {
            return "IMPOSSIBLE";
        }
        if (cache.containsKey(x) && cache.get(x).containsKey(y)) {
            return cache.get(x).get(y);
        }

        if(x == 0 && y == 0) {
            return "";
        }

        long absX = Math.abs(x);
        long absY = Math.abs(y);

        String result;

        if ((absX & jumpDistance) == (absY & jumpDistance)) {
            result = "IMPOSSIBLE";
        } else {

            String result1;
            String result2;

            if ((absX & jumpDistance) == 0) {
                result1 = solve(x, y - jumpDistance, jumpDistance * 2, cache);
                if(!result1.equals("IMPOSSIBLE")) {
                    result1 = 'N' + result1;
                }
                result2 = solve(x, y + jumpDistance, jumpDistance * 2, cache);
                if(!result2.equals("IMPOSSIBLE")) {
                    result2 = 'S' + result2;
                }

            } else {
                result1 = solve(x - jumpDistance, y, jumpDistance * 2, cache);
                if(!result1.equals("IMPOSSIBLE")) {
                    result1 = 'E' + result1;
                }
                result2 = solve(x + jumpDistance, y, jumpDistance * 2, cache);
                if(!result2.equals("IMPOSSIBLE")) {
                    result2 = 'W' + result2;
                }
            }

            if (result1.equals("IMPOSSIBLE")) {
                result = result2;
            } else if (result2.equals("IMPOSSIBLE")) {
                result = result1;
            } else if (result1.length() <= result2.length()) {
                result = result1;
            } else {
                result = result2;
            }
        }

        cache.putIfAbsent(x, new HashMap<>());
        cache.get(x).put(y, result);
        return result;
    }


}
  