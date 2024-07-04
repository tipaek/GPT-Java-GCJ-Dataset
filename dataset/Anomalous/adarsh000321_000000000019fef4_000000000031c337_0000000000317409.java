import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int tt = 1; tt <= t; tt++) {
            sb.append("Case #").append(tt).append(": ");
            int y = sc.nextInt();
            int x = sc.nextInt();
            String s = sc.next();
            int a = 0, b = 0;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < s.length(); i++) {
                char direction = s.charAt(i);

                switch (direction) {
                    case 'S':
                        a++;
                        break;
                    case 'N':
                        a--;
                        break;
                    case 'E':
                        b--;
                        break;
                    case 'W':
                        b++;
                        break;
                }

                if (i + 1 >= calculateDistance(a, b, x, y)) {
                    min = i + 1;
                    break;
                }
            }

            if (min == Integer.MAX_VALUE) {
                sb.append("IMPOSSIBLE\n");
            } else {
                sb.append(min).append("\n");
            }
        }

        System.out.print(sb);
    }

    static int calculateDistance(int a, int b, int x, int y) {
        return Math.abs(a - x) + Math.abs(b - y);
    }
}