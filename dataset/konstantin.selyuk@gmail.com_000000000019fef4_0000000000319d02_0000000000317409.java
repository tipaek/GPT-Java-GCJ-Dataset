import java.util.Scanner;

public class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            for (int i = 0; i < T; i++) {
                int X = sc.nextInt(), Y = sc.nextInt();
                String M = sc.nextLine().trim();
                String res = solve(X, Y, M);

                System.out.println("Case #" + (i + 1) + ": " + res);
            }
        }

        public static String solve(int X, int Y, String M) {
            for (int i = 0; i < M.length(); i++) {
                char c = M.charAt(i);
                switch (c) {
                    case 'E': X++; break;
                    case 'W': X--; break;
                    case 'S': Y--; break;
                    case 'N': Y++; break;
                }
                if (Math.abs(X) + Math.abs(Y) <= i + 1) {
                    return "" + (i + 1);
                }
            }
            return "IMPOSSIBLE";
        }
}
/*
5
4 4 SSSS
3 0 SNSS
2 10 NSNNSN
0 1 S
2 7 SSSSSSSS

 */
