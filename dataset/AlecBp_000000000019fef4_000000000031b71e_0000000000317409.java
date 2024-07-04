import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        int _x = 0;
        int _y = 0;
        int distance, x, y;
        boolean solved;
        String M;
        for (int i = 1; i <= t; ++i) {
            x = in.nextInt();
            y = in.nextInt();
            M = in.next();
            solved = false;

            for (int j = 0; j < M.length(); j++) {

                switch (M.charAt(j)) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'W':
                        x--;
                        break;
                    case 'E':
                        x++;
                        break;
                    default:
                        break;
                }

                distance = (Math.abs(x) - _x) + (Math.abs(y) - _y);
                if (distance <= j + 1) {
                    System.out.println("Case #" + i + ": " + (j + 1));
                    solved = true;
                    break;
                }
            }

            if (!solved) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }

        }
    }
}
