import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        for (int i = 0; i < tests; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String s = in.next();
            int moves = -1;

            if (x == 0 && y == 0) {
                moves = 0;
            } else {

                for (int j = 0; j < s.length(); j++) {

                    switch (s.charAt(j)) {
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
                    }
                    if (Math.abs(x) + Math.abs(y) <= j + 1) {
                        moves = j + 1;
                        break;
                    }
                }
            }
            String str;
            if (moves >= 0) {
                str = moves+"";
            }else {
                str = "IMPOSSIBLE";
            }
            System.out.println(String.format("Case #%d: %s", i+1, str));
        }


    }
}