import java.io.*;
import java.util.*;

import static java.lang.Math.abs;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        Scanner sc = new Scanner(in);
//        sc.useDelimiter(Pattern.compile("[\n /]"));

x:        for (int cs = 1, cases = sc.nextInt(); cs <= cases; cs++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String path = sc.next();

            for (int i = 0; i < path.length(); i++) {
                switch (path.charAt(i)) {
                    case 'N': y++; break;
                    case 'S': y--; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }
                if (abs(x)+abs(y) <= i+1) {
                    System.out.printf("Case #%d: %d%n", cs, i+1);
                    continue x;
                }
            }
            System.out.printf("Case #%d: %s%n", cs, "IMPOSSIBLE");
        }
    }
}
