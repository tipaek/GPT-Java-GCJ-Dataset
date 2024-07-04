import java.util.*;
import java.io.*;

public class Solution {

    static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = sc.nextInt();
        for (int k = 1; k <= testCase; k++) {
            System.out.printf("Case #%d: ", k);
            int X = sc.nextInt();
            int Y = sc.nextInt();
            String path = sc.next();

            if (X == 0 && Y == 0) {
                System.out.println(0);
                continue;
            }

            int ans = 0;
            for (int i = 0; i < path.length(); i++) {
                char direction = path.charAt(i);
                switch (direction) {
                    case 'N':
                        Y += 1;
                        break;
                    case 'S':
                        Y -= 1;
                        break;
                    case 'E':
                        X += 1;
                        break;
                    case 'W':
                        X -= 1;
                        break;
                }

                int m = Math.abs(X) + Math.abs(Y);
                if (i + 1 >= m) {
                    ans = i + 1;
                    break;
                }
            }
            if (ans == 0) {
                System.out.println(IMPOSSIBLE);
            } else {
                System.out.println(ans);
            }
        }
        sc.close();

    }
}