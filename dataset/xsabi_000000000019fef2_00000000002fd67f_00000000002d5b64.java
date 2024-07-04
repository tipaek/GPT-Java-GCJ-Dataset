import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int step;
        for (int t = 1; t <= T; t++) {
            step = 0;
            int R = in.nextInt();
            int S = in.nextInt();
            while (R > 1) {
                step += S - 1;
                R--;
            }
            System.out.println("Case #" + t + ": " + step);
        }
    }
}