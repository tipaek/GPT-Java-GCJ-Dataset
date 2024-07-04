import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
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

/*
        for(int i = -4; i <= 4; ++i) {
            for(int j = -4; j <=4; ++j) {

                Map<Long, Map<Long, String>> cache = new HashMap<>();
                System.out.println(String.format(
                        "%s %s: %s",
                        i,j,
                        solve(i,j,cache)
                ));
            }
        }*/
    }

    private static void solve(Scanner sc) {
        int x = sc.nextInt();
        int y = sc.nextInt();

        Map<Long, Map<Long, String>> cache = new HashMap<>();
        System.out.println(solve(x, y, cache));
    }

    private static String solve(long x, long y, Map<Long, Map<Long, String>> cache) {

        if (cache.containsKey(x) && cache.get(x).containsKey(y)) {
            return cache.get(x).get(y);
        }

        if(x == 0 && y == 0) {
            return "";
        }

        long absX = Math.abs(x);
        long absY = Math.abs(y);

        String result;

        if ((absX & 1) == (absY & 1)) {
            result = "IMPOSSIBLE";
        } else {

            String result1 = "IMPOSSIBLE";
            String result2 = "IMPOSSIBLE";

            if ((absX & 1) == 0) {
                if(x != 0 || y > 0) {
                    result1 = solve(x/2, (y - 1)/2,  cache);
                    if (!result1.equals("IMPOSSIBLE")) {
                        result1 = 'N' + result1;
                    }
                }

                if(x != 0 || y < 0) {
                    result2 = solve(x/2,  (y + 1)/2, cache);
                    if (!result2.equals("IMPOSSIBLE")) {
                        result2 = 'S' + result2;
                    }
                }

            } else {
                if(y != 0 || x > 0) {
                    result1 = solve((x - 1)/2, y/2, cache);
                    if (!result1.equals("IMPOSSIBLE")) {
                        result1 = 'E' + result1;
                    }
                }
                if(y != 0 || x < 0) {
                    result2 = solve((x + 1)/2, y/2,cache);
                    if (!result2.equals("IMPOSSIBLE")) {
                        result2 = 'W' + result2;
                    }
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
  