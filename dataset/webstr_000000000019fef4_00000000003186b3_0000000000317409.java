import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t1 = in.nextInt();
        for (int t = 1; t <= t1; t++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String str = in.next();
            int res = -1;

            for (int i = 0; i < str.length(); i++) {
                switch (str.charAt(i)) {
                    case 'N': y++; break;
                    case 'S': y--; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }

                if (Math.abs(x) + Math.abs(y) <= i + 1) {
                    res = i + 1;
                    break;
                }
            }
            if (res != -1) {
                System.out.println("Case #" + t + ": " + res);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}
