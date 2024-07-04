import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static int solve(int x, int y, String movestr) {
        char[] moves = movestr.toCharArray();
        int[] posX = new int[moves.length + 1];
        int[] posY = new int[moves.length + 1];
        posX[0] = x;
        posY[0] = y;

        for (int i = 0; i < moves.length; i++) {
            posX[i + 1] = posX[i];
            posY[i + 1] = posY[i];

            switch (moves[i]) {
                case 'N':
                    posY[i + 1] = posY[i] + 1;
                    break;
                case 'S':
                    posY[i + 1] = posY[i] - 1;
                    break;
                case 'E':
                    posX[i + 1] = posX[i] + 1;
                    break;
                case 'W':
                    posX[i + 1] = posX[i] - 1;
                    break;
            }

            int totalDist = Math.abs(posX[i + 1]) + Math.abs(posY[i + 1]);
            if (totalDist <= i + 1) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String moves = sc.next();
            int minTime = solve(x, y, moves);

            if (minTime == -1) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + minTime);
            }
        }
    }
}