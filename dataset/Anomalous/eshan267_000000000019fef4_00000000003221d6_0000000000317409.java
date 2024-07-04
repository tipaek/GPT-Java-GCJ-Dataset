import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String p = sc.next();
            int m = x;
            boolean found = false;

            for (int j = 0; j < m && j < p.length(); j++) {
                if (p.charAt(j) == 'N') {
                    y++;
                } else {
                    y--;
                }
            }

            int ans = 0;
            if (y == 0) {
                found = true;
                ans = m;
            } else {
                int ti = 0;
                for (int j = m; j < p.length(); j++) {
                    ti++;
                    if (p.charAt(j) == 'N') {
                        y++;
                    } else {
                        y--;
                    }

                    if (ti >= Math.abs(y)) {
                        found = true;
                        ans = m + ti;
                        break;
                    }
                }
            }

            if (!found) {
                sb.append("Case #").append(i + 1).append(": IMPOSSIBLE\n");
            } else {
                sb.append("Case #").append(i + 1).append(": ").append(ans).append("\n");
            }
        }
        
        System.out.print(sb.toString().trim());
    }
}