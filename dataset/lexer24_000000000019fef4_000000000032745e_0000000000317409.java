import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            String s = in.next();

            int step = 0;
            boolean flag = false;
            for (; step <= s.length() && !flag; step++) {

                if (Math.abs(x) + Math.abs(y) == step) {
                    System.out.println("Case #" + i + ": " + step);
                    flag = true;
                    continue;
                }

                if (step < s.length()) {
                    if (s.charAt(step) == 'N') y++;
                    if (s.charAt(step) == 'S') y--;
                    if (s.charAt(step) == 'E') x++;
                    if (s.charAt(step) == 'W') x--;

                    if (Math.abs(x) + Math.abs(y) == step) {
                        System.out.println("Case #" + i + ": " + (step + 1));
                        flag = true;
                        continue;
                    }
                }

            }
            if (!flag) System.out.println("Case #" + i + ": IMPOSSIBLE");

        }
        in.close();
    }

}
