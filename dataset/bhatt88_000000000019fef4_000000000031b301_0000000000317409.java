import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String n = in.nextLine();
            String[] s = n.split(" ");
            System.out.println("Case #" + i + ": " + getSteps(Integer.parseInt(s[0]), Integer.parseInt(s[1]), s[2]));
        }
    }

    public static String getSteps(int x, int y, String dir) {
        if (x == 0 && y == 0) return "0";
        int len = dir.length();
        for (int i=0; i<len; i++) {
            int[] next = getNext(x, y, dir.charAt(i));
            x = next[0];
            y = next[1];
            if (Math.abs(x) + Math.abs(y) <= i+1) return (i+1) + "";
        }
        return "IMPOSSIBLE";
    }

    public static int[] getNext(int x, int y, char c) {
        if (c == 'N') return new int[]{x, y+1};
        if (c == 'E') return new int[]{x+1, y};
        if (c == 'W') return new int[]{x-1, y};
        if (c == 'S') return new int[]{x, y-1};
        return new int[]{x, y};
    }
}