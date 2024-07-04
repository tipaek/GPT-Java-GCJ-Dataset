import java.util.Scanner;

public  class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t=0; t<T; t++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            String S = sc.next();

            System.out.println("Case #" + (t+1) + ": " + solve(X, Y, S));
        }
    }

    private static String solve(int X, int Y, String S) {
        int count = 0;

        for (int i=0; i<S.length(); i++) {
            char s = S.charAt(i);

            if (s == 'N') {
                Y++;
            } else if (s == 'S') {
                Y--;
            }

            if (X > 0) {
                X--;
            } else if (Y > 0) {
                Y--;
            }

            if (X == 0 && Y == 0) {
                return String.valueOf(i+1);
            }
        }

        return "IMPOSSIBLE";
    }
}
