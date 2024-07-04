import java.util.Scanner;

public class Solution {

    private static int manhattan(int[] X, int[] Y) {
        return Math.abs(X[0] - Y[0]) + Math.abs(X[1] - Y[1]);
    }

    private static int reachableInTime(int[] X, int[] Y, int time) {
        int dist = manhattan(X, Y);
        if (dist <= time) return time;
        return -1;
    }

    public static int walk(int[] pos, String moves) throws Exception {
        int[] myPos = new int[] {0, 0};
        int time = 0, pathLength;

        for (int i = 0; i < moves.length(); i++) {
            time = i+1;
            switch (moves.charAt(i)) {
                case 'N':
                    pos[1] += 1;
                    break;
                case 'S':
                    pos[1] -= 1;
                    break;
                case 'E':
                    pos[0] += 1;
                    break;
                case 'W':
                    pos[0] -= 1;
                    break;
            }
            pathLength = reachableInTime(pos, myPos, time);
            if (pathLength != -1) return pathLength;

        }
        throw new Exception();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = Integer.parseInt(in.nextLine());

        int[] pos = new int[2];
        String moves;
        for (int i = 1; i <= T; i++) {
            pos[0] = in.nextInt();
            pos[1] = in.nextInt();
            moves = in.nextLine().trim();

            try {
                int res = walk(pos, moves);
                System.out.println("Case #" + i + ": " + res);
            } catch (Exception e) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }

        }

    }

}