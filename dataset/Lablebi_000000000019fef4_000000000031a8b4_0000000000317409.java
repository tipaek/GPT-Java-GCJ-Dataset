import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private final static String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            String m = in.next();
            if (x==0 && y==0) {
                System.out.println("Case #" + i + ": " + 0);
            } else {
                String result = IMPOSSIBLE;
                for (int j = 0; j < m.length(); j++) {
                    x = getNewX(x, m.charAt(j));
                    y = getNewY(y, m.charAt(j));
                    int time = Math.abs(x) + Math.abs(y);
                    if (time <= j +1) {
                        result = String.valueOf(j+1);
                        break;
                    }
                }
                System.out.println("Case #" + i + ": " + result);
            }
        }
    }

    private static int getNewX(int x, char direction) {
        int result = x;
        if (direction == 'E') {
            result++;
        }
        if (direction == 'W') {
            result --;
        }
        return result;
    }

    private static int getNewY(int y, char direction) {
        int result = y;
        if (direction == 'N') {
            result++;
        }
        if (direction == 'S') {
            result --;
        }
        return result;
    }
}