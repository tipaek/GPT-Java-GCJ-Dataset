import java.util.*;
import java.io.*;
public class Solution {

    private static Map<Character, Integer> stepMap = new HashMap<>();

    static {
        stepMap.put('N', 1);
        stepMap.put('S', -1);
        stepMap.put('E', 1);
        stepMap.put('W', -1);
    }

    public static int getDistance(int x, int y, int mx, int my) {
        return x - mx + y - my;
    }



    public static String getPath(int x, int y, String path) {
        int tourLength = path.length();
        int distance = getDistance(x, y, 0, 0);
        int time = 0;
        for (Character ch : path.toCharArray()) {
            time++;
            distance = distance + stepMap.get(ch) - 1;
            if (distance <= 0) {
                return time + "";
            }
        }
        return "IMPOSSIBLE";


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int m = in.nextInt();
            String s = in.nextLine().trim();
            System.out.println("Case #" + i + ": " + getPath(n, m, s));
        }
    }
}