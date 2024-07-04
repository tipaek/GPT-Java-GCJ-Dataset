import java.util.*;
import java.io.*;
public class Solution {

    private static Map<Character, Integer> stepNS = new HashMap<>();
    private static Map<Character, Integer> stepEW = new HashMap<>();

    static {
        stepNS.put('N', 1);
        stepNS.put('S', -1);
        stepNS.put('E', 0);
        stepNS.put('W', 0);
        stepEW.put('E', 1);
        stepEW.put('W', -1);
        stepEW.put('N', 0);
        stepEW.put('S', 0);
    }

    public static int getDistance(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }



    public static String getPath(int x, int y, String path) {
        int tourLength = path.length();
        int distance = getDistance(x, y);
        int time = 0;

        for (Character ch : path.toCharArray()) {
            time++;
            x = x + stepEW.get(ch);
            y = y + stepNS.get(ch);
            distance = getDistance(x, y) - time;
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