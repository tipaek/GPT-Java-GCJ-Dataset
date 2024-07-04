import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tt = 1; tt <= t; tt++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            String M = sc.next();
            boolean isMeet = false;

            for (int i = 0; i < M.length(); i++) {
                char direction = M.charAt(i);

                switch (direction) {
                    case 'N':
                        Y++;
                        break;
                    case 'S':
                        Y--;
                        break;
                    case 'E':
                        X++;
                        break;
                    case 'W':
                        X--;
                        break;
                }

                int distance = Math.abs(X) + Math.abs(Y);
                if (i + 1 >= distance) {
                    isMeet = true;
                    System.out.println("Case #" + tt + ": " + (i + 1));
                    break;
                }
            }

            if (!isMeet) {
                System.out.println("Case #" + tt + ": IMPOSSIBLE");
            }
        }
    }
}