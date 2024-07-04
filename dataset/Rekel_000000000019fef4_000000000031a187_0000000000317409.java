import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int test = 1; test <= T; test++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            char[] M = in.nextLine().trim().toCharArray();
            int[] MX = new int[M.length];
            int[] MY = new int[M.length];
            for (int i = 0; i < M.length; i++) {
                switch (M[i]) {
                case 'N':
                    MX[i] = 0;
                    MY[i] = 1;
                    break;
                case 'E':
                    MX[i] = 1;
                    MY[i] = 0;
                    break;
                case 'S':
                    MX[i] = 0;
                    MY[i] = -1;
                    break;
                case 'W':
                    MX[i] = -1;
                    MY[i] = 0;
                    break;
                default:
                    System.out.println("Direction incorrect!");
                }
            }
            System.out.println("Case #" + test + ": " + losOp(X, Y, MX, MY));
        }
    }

    public static String losOp(int X, int Y, int[] MX, int[] MY) {
        if (X == 0 && Y == 0) return "0";
        int Xt = X;
        int Yt = Y;

        for (int tijd = 1; tijd <= MX.length; tijd++) {
            Xt += MX[tijd-1];
            Yt += MY[tijd-1];
            if ((Math.abs(Xt) + Math.abs(Yt)) <= tijd) return Integer.toString(tijd);
        }
        return "IMPOSSIBLE";
    }
}