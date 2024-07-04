import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String str = sc.next();
            if (x == 0 && y == 0) {
                System.out.println("Case #" + t + ": 0");
                continue;
            }
            boolean done = false;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == 'N') y++;
                else if (ch == 'S') y--;
                else if (ch == 'E') x++;
                else if (ch == 'W') x--;
                int steps = i + 1;
                if (Math.abs(x) + Math.abs(y) <= steps) {
                    done = true;
                    System.out.println("Case #" + t + ": " + steps);
                    break;
                }
            }
            if(done) {
                continue;
            }
            System.out.println("Case #" + t + ": IMPOSSIBLE");
        }
    }
}
