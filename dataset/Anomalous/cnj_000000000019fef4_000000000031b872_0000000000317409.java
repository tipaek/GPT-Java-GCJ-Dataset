import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    private final PrintStream out = System.out;
    private final Scanner sc = new Scanner(System.in);

    private void solve() {
        int px = sc.nextInt();
        int py = sc.nextInt();
        int sx = 0, sy = 0;
        char[] moves = sc.next().toCharArray();
        String result = "IMPOSSIBLE";
        
        for (int i = 0; i < moves.length; i++) {
            char move = moves[i];
            switch (move) {
                case 'N':
                    py++;
                    break;
                case 'S':
                    py--;
                    break;
                case 'E':
                    px++;
                    break;
                case 'W':
                    px--;
                    break;
                default:
                    break;
            }
            int currentDistance = calculateDistance(sx, sy, px, py);
            if (currentDistance <= i + 1) {
                result = String.valueOf(i + 1);
                break;
            }
        }
        out.println(result);
    }

    private int calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }

    private void execute() throws Exception {
        long testCases = sc.nextLong();
        for (long i = 1; i <= testCases; i++) {
            out.print("Case #" + i + ": ");
            solve();
        }
        sc.close();
    }

    public static void main(String[] args) throws Exception {
        new Solution().execute();
    }
}