import java.util.*;
import java.io.*;
public class Solution {
    static int firstMeet(int x, int y, String m) {
        int min = 0;
        if (min >= Math.abs(x) + Math.abs(y)) return min;
        for (char direction: m.toCharArray()) {
            min ++;
            switch(direction) {
            case 'S':
                y --;
                break;
            case 'N':
                y ++;
                break;
            case 'E':
                x ++;
                break;
            case 'W':
                x --;
                break;
            }
            if (min >= Math.abs(x) + Math.abs(y)) return min;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test_case = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= test_case; t++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String m = in.next();
            int ans = firstMeet(x, y, m);

            System.out.println("Case #" + t + ": " + (ans >= 0 ? ans : "IMPOSSIBLE"));
        }
    }
}
