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
            boolean found = false;
            for (int j = 0; j < m.length(); j++) {
                if ((Math.abs(x) + Math.abs(y)) <= j) {
                    System.out.println("Case #" + i + ": " + j);
                    found = true;
                    break;
                }
                char move = m.charAt(j);
                switch (move) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                default:
                    x--;
                    break;
                }
            }
            if (!found) {
                if ((Math.abs(x) + Math.abs(y)) <= m.length()) {
                    System.out.println("Case #" + i + ": " + m.length());
                } else {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                }
            }
        }
        in.close();
    }

}