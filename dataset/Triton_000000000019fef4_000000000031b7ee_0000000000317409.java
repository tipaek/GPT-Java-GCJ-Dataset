import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private final static String IMPOSSIBLE = "IMPOSSIBLE";
    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            String path = in.next();
            String result = String.format("Case #%d: %s", i, sol.getMeetTime(x, y, path));
            System.out.println(result);
        }
    }

    private String getMeetTime(int x, int y, String path) {
        if (x + y > 2 * path.length()) {
            return IMPOSSIBLE;
        }

        int[][] pos = getPos(x, y, path);
        for (int i = 0; i < pos.length; ++i) {
            if (couldMeetAtTime(i , pos[i][0], pos[i][1])) {
                return String.valueOf(i );
            }
        }

        return IMPOSSIBLE;
    }

    public int[][] getPos(int x, int y, String path) {
        int[][] pos = new int[path.length() + 1][2];
        pos[0][0] = x;
        pos[0][1] = y;
        for (int i = 0; i < path.length(); ++i) {
            pos[i+1][0] = pos[i][0];
            pos[i+1][1] = pos[i][1];

            switch (path.charAt(i)) {
                case 'N': pos[i+1][1]++; break;
                case 'E': pos[i+1][0]++; break;
                case 'S': pos[i+1][1]--; break;
                case 'W': pos[i+1][0]--; break;
                default: break;
            }
        }

        return pos;
    }

    private boolean couldMeetAtTime(int t, int x, int y) {
        return t >= Math.abs(x) + Math.abs(y);
    }
}