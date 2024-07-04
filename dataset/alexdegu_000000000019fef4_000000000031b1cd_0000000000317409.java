import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
            int x, y;
            String s;
            int m;
            boolean found;
            for (int l = 1; l <= t; ++l) {
                x = in.nextInt(); //east
                y = in.nextInt(); //north

                s = in.next();
                m = s.length();

                found = false;
                if (x + y > 2 * m) {
                    System.out.println("Case #" + l + ": IMPOSSIBLE");
                    continue;
                }

                for (int i = 0; i < m; i++) {
                    switch (s.charAt(i)) {
                        case 'N': {
                            y++;
                            break;
                        }
                        case 'S': {
                            y--;
                            break;
                        }
                        case 'E': {
                            x++;
                            break;
                        }

                        case 'W': {
                            x--;
                            break;
                        }
                    }

                    if (Math.abs(x) + Math.abs(y) <= i + 1) {
                        System.out.println("Case #" + l + ": " + (i + 1));
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Case #" + l + ": IMPOSSIBLE");
                }
            }
      }
    }