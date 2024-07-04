import java.util.Scanner;

public class Solution {

    private int t;
    private Scanner scanner;
    private String peppurMoves;
    private int px;
    private int py;

    public Solution(int t, Scanner scanner) {
        this.t = t;
        this.scanner = scanner;
    }

    public void solve() {
        // Read input
        px = scanner.nextInt();
        py = scanner.nextInt();
        peppurMoves = scanner.next();
        int tourLength = peppurMoves.length();

        String result = "IMPOSSIBLE";
        for (int i = 0; i <= tourLength; i++) {
            // Try to reach at minute i
            int finalPx = getFinalPosition(px, peppurMoves, i, 'E', 'W');
            int finalPy = getFinalPosition(py, peppurMoves, i, 'N', 'S');
            if (Math.abs(finalPx) + Math.abs(finalPy) <= i) {
                result = String.valueOf(i);
                break;
            }
        }
        System.out.println("Case #" + t + ": " + result);
    }

    private int getFinalPosition(int start, String moves, int steps, char positiveMove, char negativeMove) {
        for (int j = 0; j < steps; j++) {
            switch (moves.charAt(j)) {
                case 'N':
                case 'E':
                    if (moves.charAt(j) == positiveMove) start++;
                    break;
                case 'S':
                case 'W':
                    if (moves.charAt(j) == negativeMove) start--;
                    break;
                default:
                    break;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            new Solution(i + 1, scanner).solve();
        }
        scanner.close();
    }
}