import java.util.BitSet;
import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {

            int x = sc.nextInt(), y = sc.nextInt();
            String s = sc.next();
            int n = s.length();

            int curx = x, cury = y;

            int ans = Integer.MAX_VALUE;
            if(x == 0 && y == 0) {
                System.out.printf("Case #%d: %s\n", t, "0");
                continue;
            }

            for(int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if(ch == 'N')
                    cury++;
                else if(ch == 'S')
                    cury--;
                else if(ch == 'E')
                    curx++;
                else
                    curx--;
                int dist = Math.abs(curx) + Math.abs(cury);
                if(dist <= (i+1)) {
                    ans = i+1;
                    break;
                }
            }
            System.out.printf("Case #%d: %s\n", t, ans == Integer.MAX_VALUE ? "IMPOSSIBLE" : ans);
        }
    }
}
