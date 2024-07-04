import java.util.*;

public class Solution {
    Scanner scanner = new Scanner(System.in);

    private void exe() {
        int test = scanner.nextInt();
        scanner.nextLine();
        for (int z = 0; z < test; z++) {
            String s = scanner.nextLine();
            String[] input = s.split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String c = input[2];
            int sol = Integer.MAX_VALUE;
            for (int i = 0; i < c.length(); i++) {
                int xx = Math.abs(x);
                int yy = Math.abs(y);
                if (xx + yy <= i) {
                    sol = i;
                    break;
                }
                if (c.charAt(i) == 'N') {
                    y += 1;
                } else if (c.charAt(i) == 'S') {
                    y -= 1;
                } else if (c.charAt(i) == 'E') {
                    x += 1;
                } else if (c.charAt(i) == 'W') {
                    x -= 1;
                }
            }
            int xx = Math.abs(x);
            int yy = Math.abs(y);
            if (sol > c.length() && c.length() >= xx + yy) {
                sol = c.length();
            }
            int a = z + 1;
            if (sol <= c.length()) {
                System.out.println("Case #" + a + ": " + sol);
            } else {
                System.out.println("Case #" + a + ": IMPOSSIBLE");
            }
        }
    }

    public static void main(String[] args) {
        Solution iss = new Solution();
        iss.exe();
    }
}
