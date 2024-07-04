import java.util.Scanner;

public class Solution {
    static Scanner in = new Scanner(System.in);
    static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String args[]) {
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            System.out.println("Case #" + i + ": " + secret());
        }
    }

    private static String secret() {
        int X = in.nextInt(); // East
        int Y = in.nextInt(); // West
        char[] M = in.next().toCharArray(); // Cat's moves, N/E/S/W

        for(int i = 1; i <= M.length; i++) {
            char dir = M[i - 1];

            switch(dir) {
                case 'E':
                    X++;
                    break;
                case 'N':
                    Y++;
                    break;
                case 'S':
                    Y--;
                    break;
                case 'W':
                    X--;
                    break;
            }

            if(canGetInIOrLessMoves(X, Y, i))
                return String.valueOf(i);
        }

        return IMPOSSIBLE;

    }

    private static boolean canGetInIOrLessMoves(int X, int Y, int i) {
        int distanceHam = Math.abs(X) + Math.abs(Y);

        return i >= distanceHam;

    }
}
