
import java.util.Scanner;

public class Solution {
    static String solve(Scanner sc) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        String M = sc.next();
        for (int i = 0; i < M.length(); i++) {
            switch(M.charAt(i)) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }
            int t = i + 1;
            if (Math.abs(x) + Math.abs(y) <= t) {
                return t + "";
            }
        }
        return "IMPOSSIBLE";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            String ans = solve(sc);
            System.out.println("Case #" + t + ": " + ans);
        }
    }
}
