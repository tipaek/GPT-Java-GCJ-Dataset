import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            String m = in.next();
            System.out.println("Case #" + i + ": " + solve(x, y, m));
        }
    }

    private static String solve(int x, int y, String m) {
        for(int i = 0; i < m.length(); ++i) {
            char step = m.charAt(i);
            switch(step) {
                case 'N': {
                    ++y;
                    break;
                }
                case 'S': {
                    --y;
                    break;
                }
                case 'E': {
                    ++x;
                    break;
                }
                case 'W': {
                    --x;
                    break;
                }
                default: throw new IllegalArgumentException();
            }

            if(Math.abs(x) + Math.abs(y) <= i + 1) {
                return String.valueOf(i + 1);
            }
        }
        return "IMPOSSIBLE";
    }
}