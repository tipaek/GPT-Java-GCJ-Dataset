import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String moves = in.nextLine();
            moves = moves.trim();

            if (x == 0 && y == 0){
                System.out.println("Case #" + i + ": 0");
                continue;
            }

            int[] xy = new int[] {x, y};
            boolean success = false;
            for (int j = 0; j < moves.length(); j++) {
                char c = moves.charAt(j);
                move(xy, c);
                int currDist = distanceFromYou(xy);
                if (currDist <= j + 1) {
                    System.out.println("Case #" + i + ": " + (j + 1));
                    success = true;
                    break;
                }
            }
            if (!success)
                System.out.println("Case #" + i + ": IMPOSSIBLE");
        }
    }

    private static int distanceFromYou(int[] xy) {
        return Math.abs(xy[0]) + Math.abs(xy[1]);
    }

    private static void move(int[] xy, char c) {
        switch (c) {
            case 'E':
                xy[0] += 1;
                break;
            case 'W':
                xy[0] -= 1;
                break;
            case 'N':
                xy[1] += 1;
                break;
            case 'S':
                xy[1] -= 1;
                break;
        }
    }
}
