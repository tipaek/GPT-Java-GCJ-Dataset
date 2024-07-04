import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int t1 = 1; t1 <= t; t1++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String s = sc.next();
            int l = s.length();
            int res = -1;

            if (x == 0 && y == 0) {
                System.out.println("Case #" + t1 + ": 0");
                continue;
            }

            for (int i = 0; i < l; i++) {
                char c = s.charAt(i);
                switch (c) {
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                    case 'S':
                        y--;
                        break;
                }

                int distance = Math.abs(x) + Math.abs(y);
                if (distance <= (i + 1)) {
                    res = i + 1;
                    break;
                }
            }

            if (res > -1) {
                System.out.println("Case #" + t1 + ": " + res);
            } else {
                System.out.println("Case #" + t1 + ": IMPOSSIBLE");
            }
        }

        sc.close();
    }
}