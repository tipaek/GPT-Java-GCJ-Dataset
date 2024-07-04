import java.util.Scanner;

public class Solution {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int z = 1; z <= t; z++) {
            int ans = Integer.MAX_VALUE;
            int x = sc.nextInt(), y = sc.nextInt();
            String s = sc.next();
            for (int i = 1; i <= s.length(); i++) {
                char c = s.charAt(i-1);
                if (c == 'N') {
                    y++;
                }
                else if (c == 'S') {
                    y--;
                }
                else if (c == 'W') {
                    x--;
                }
                else {
                    x++;
                }
                int noOfSteps = Math.abs(x) + Math.abs(y);
                if (i >= noOfSteps) {
                    if (i < ans) {
                        ans = i;
                        break;
                    }
                }
                /*if (noOfSteps < ans) {
                    ans = i;
                }*/
            }
            if (ans == Integer.MAX_VALUE) {
                System.out.println("Case #" + z + ": IMPOSSIBLE");
            }
            else {
                System.out.println("Case #" + z + ": " + ans);
            }
        }
    }
}
