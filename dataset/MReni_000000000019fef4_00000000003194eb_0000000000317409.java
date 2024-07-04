
import java.util.*;
import java.io.*;

public class Solution {

    static Map<Character, int[]> directions = new HashMap<>();
    public static void main(String[] args) {
        directions.put('S', new int[]{0, -1});
        directions.put('N', new int[]{0, 1});
        directions.put('W', new int[]{-1, 0});
        directions.put('E', new int[]{1, 0});

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
          int X = in.nextInt(), Y = in.nextInt();
          String steps = in.nextLine().trim();
  
          String output = getOutput(X, Y, steps);
          System.out.println("Case #" + i + ": " + output);
        }
    }

    private static String getOutput(int x, int y, String steps) {
        if (x == 0 && y == 0) return Integer.toString(0);
        for (int i = 0; i < steps.length(); i++) {
            char c = steps.charAt(i);
            int[] dir = directions.get(c);
            x += dir[0];
            y += dir[1];
            if (Math.abs(x) + Math.abs(y) <= i + 1) {
                return Integer.toString(i+1);
            }
        }
        return "IMPOSSIBLE";
    }
}