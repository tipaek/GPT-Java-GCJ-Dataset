import java.util.Scanner;

public class Solution {

    private static int IMPOSSIBLE = Integer.MAX_VALUE/2;

    private void solve(Scanner scan) {
        int sa = scan.nextInt();
        int sb = scan.nextInt();

        char[] moves = scan.next().toCharArray();


        int min = IMPOSSIBLE;

        for (int i = sa - 1000; i <= sa + 1000; i++) {
            int a = sa;
            int b = sb;
            int x = 0;
            int y = 0;
            for (int j = 0; j < moves.length; j++) {
                char c = moves[j];
                if (c == 'N') {
                    b++;
                } else if (c == 'S') {
                    b--;
                } else if (c == 'E') {
                    a++;
                } else {
                    a--;
                }
                if (x == a && y == b) {
                    min = Math.min(min, j + 1);
                    break;
                }
                if (x < i) {
                    x++;
                } else if (x > i) {
                    x--;
                } else if (y < b) {
                    y++;
                } else {
                    y--;
                }
                if (x == a && y == b) {
                    min = Math.min(min, j + 1);
                    break;
                }
            }
        }

        if (min == IMPOSSIBLE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(min);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int problems = scan.nextInt();
        for (int count = 0; count < problems; count++) {
            System.out.print("Case #" + (count+1) + ": ");
            new Solution().solve(scan);
        }
        scan.close();
    }
}
