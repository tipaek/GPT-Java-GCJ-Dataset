import java.util.*;
import java.io.*;

public class Solution {

    static String ans;
    private static void magic(int x, int y, int destX, int destY, int unitsToBeMoved, List<String> mv) {
        List<String> moves = new ArrayList<>(mv);

        if (x == destX && y == destY) {
            String newAns = String.join("", moves);
            if (ans.equals("")) {
                ans = newAns;
            } else {
                ans = newAns.length() < ans.length() ? newAns : ans;
            }

            return;
        }

        int moveSize = (int) Math.pow(2, moves.size());

//        System.out.println(String.join("", moves) + " " + x + " " + y + " " + moveSize + " " + unitsToBeMoved);

        if (unitsToBeMoved < (moveSize / 2)) {
            return;
        }

        moves.add("E");
        magic(x + moveSize, y, destX, destY, unitsToBeMoved,  moves);
        moves.remove(moves.size() - 1);
        moves.add("W");
        magic(x - moveSize, y, destX, destY, unitsToBeMoved, moves);
        moves.remove(moves.size() - 1);
        moves.add("N");
        magic(x, y + moveSize, destX, destY, unitsToBeMoved, moves);
        moves.remove(moves.size() - 1);
        moves.add("S");
        magic(x, y - moveSize, destX, destY, unitsToBeMoved, moves);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();

        for (int i = 1; i <= t; ++i) {
            String n = in.nextLine();

            String[] coords = n.split(" ");

            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            int unitsToBeMoved = Math.abs(x) + Math.abs(y);
            ans = "";

            if (unitsToBeMoved % 2 == 0) {
                ans = "IMPOSSIBLE";
            } else {
                magic(0,0, x, y, unitsToBeMoved, new ArrayList<>());
            }

            System.out.println("Case #" + i + ": " + ans);
        }
    }
}