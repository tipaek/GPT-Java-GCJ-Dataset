import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            char[] A = sc.next().toCharArray();
            int N = A.length;
            int ans = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                int time = i + 1;
                switch (A[i]) {
                    case 'S':
                        Y -= 1;
                        break;
                    case 'N':
                        Y += 1;
                        break;
                    case 'W':
                        X -= 1;
                        break;
                    case 'E':
                        X += 1;
                        break;
                }

                int need_time = Math.abs(X) + Math.abs(Y);
                if (time >= need_time) {
                    ans = Math.min(ans, time);
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + (ans < Integer.MAX_VALUE ? ans : "IMPOSSIBLE"));
        }

        sc.close();
    }
}