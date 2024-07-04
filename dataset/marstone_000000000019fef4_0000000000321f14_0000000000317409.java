import java.util.Scanner;

public class Solution {

    public static char[] DS = new char[] { 'E', 'S', 'W', 'N' };

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            String M = in.next();

            int x = X, y = Y;
            int i;
            boolean found = false;
            for(i = 0; i <= M.length(); i++) {
                int d = Math.abs(x) + Math.abs(y);
                if(d <= i) {
                    found = true;
                    break;
                }
                if(i < M.length()) {
                    // move
                    switch (M.charAt(i)) {
                        case 'E':
                            x++;
                            break;
                        case 'W':
                            x--;
                            break;
                        case 'N':
                            y++;
                            break;
                        case 'S':
                            y--;
                            break;
                    }
                }
            }
            System.out.format("Case #%d: %s\n", t, found ? i : "IMPOSSIBLE");
        }
    }
}
