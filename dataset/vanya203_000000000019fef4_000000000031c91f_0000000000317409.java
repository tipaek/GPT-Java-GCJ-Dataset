import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner cs = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.valueOf(cs.nextLine());

        for (int i = 1; i <= T; ++i) {
            String[] vals = cs.nextLine().split(" ");
            int X = Integer.valueOf(vals[0]);
            int Y = Integer.valueOf(vals[1]);
            String move = vals[2];

            int calc = distance(X,Y, move);
            if (calc == -1){
                System.out.printf("Case #%d: IMPOSSIBLE\n", i);
            } else {
                System.out.printf("Case #%d: %d\n", i, calc);
            }

        }
    }

    public static int distance(int x, int y, String move) {
        char[] moves = move.toCharArray();
        int moveID = 0;
        int distance = Math.abs(x) + Math.abs(y);
        for (char c : moves){
            if (moveID >= distance){
                return moveID;
            }
            if (c == 'S'){
                y--;
            } else if (c == 'N'){
                y++;
            } else if (c == 'E'){
                x++;
            } else if (c == 'W'){
                x--;
            }
            distance = Math.abs(x) + Math.abs(y);
            moveID++;
        }
        return (moveID >= distance) ? moveID : -1;
    }

}
