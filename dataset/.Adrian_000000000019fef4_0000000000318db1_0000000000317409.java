import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < amount; i++) {
            String[] info = scanner.nextLine().split(" ", 3);

            int x = Integer.parseInt(info[0]);
            int y = Integer.parseInt(info[1]);

            List<int[]> moves = parseMoves(info[2]);

            solve("Case #" + (i + 1) + ": ", x, y, moves);
        }
    }

    public static void solve(String testcase, int x, int y, List<int[]> moves) {
        if (x == 0 && y == 0) {
            System.out.println("A");
            printPath(testcase, 0);
            return;
        }
        for (int i = 0; i < moves.size(); i++) {
            int actions = i + 1;
            int[] move = moves.get(i);
            x += move[0];
            y += move[1];

            if (Math.abs(x) + Math.abs(y) <= actions) {
                printPath(testcase, actions);
                return;
            }
        }
        System.out.println(testcase + "IMPOSSIBLE");
    }

    public static void printPath(String testcase, int moves) {
        System.out.println(testcase + moves);
    }

    public static List<int[]> parseMoves(String m) {
        List<int[]> moves = new ArrayList<>();
        for (char c : m.toCharArray()) {
            if (c == 'E') {
                moves.add(new int[]{1, 0});
            } else if (c == 'W') {
                moves.add(new int[]{-1, 0});
            } else if (c == 'N') {
                moves.add(new int[]{0, 1});
            } else if (c == 'S') {
                moves.add(new int[]{0, -1});
            }
        }
        return moves;
    }

}
