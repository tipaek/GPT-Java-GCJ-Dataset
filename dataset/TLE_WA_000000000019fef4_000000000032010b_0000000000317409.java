

import java.util.Scanner;

class OverexcitedFan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            String tour = sc.next();
            String strAns = "IMPOSSIBLE";
            int ans = Integer.MAX_VALUE, time = 0;
            for (int j = 0; j < tour.length(); j++) {
                if (tour.charAt(j) == 'S')
                    y--;
                else if (tour.charAt(j) == 'N')
                    y++;
                else if (tour.charAt(j) == 'E')
                    x++;
                else
                    x--;
                time++;
                int absSum = Math.abs(x) + Math.abs(y);
                if (absSum <= time)
                    ans = Integer.min(ans, time);
            }
            if (ans == Integer.MAX_VALUE)
                System.out.println("Case #" + i + ": " + strAns);
            else
                System.out.println("Case #" + i + ": " + ans);
        }
    }
}