package contest.codejam;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: ngupta
 * Date: 19/4/2020 AD
 * Time: 22:20
 */
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int i = 1;
        while (i <= t) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            int round = 300;
            int xi = 0;
            int yi = 0;
            int[] dx = {5, 0, -5, 0};
            int[] dy = {0, 5, 0, -5};

            while (round >= 0) {
                System.out.println(xi + " " + yi);
                String ans = sc.next();
                if ("CENTER".equals(ans))
                    break;

                boolean found = false;
                for (int j = 0; j < dx.length; j++) {
                    for (int k = 0; k < dy.length; k++) {
                        System.out.println(xi + dx[i] + " " + yi + dy[j]);
                        ans = sc.next();
                        if ("CENTER".equals(ans)) {
                            found = true;
                            break;
                        }
                        round--;
                    }
                    if (found)
                        break;
                }
                if (found)
                    break;
                round--;
                xi += 5;
                yi += 5;
            }

            i++;
        }
    }
}
