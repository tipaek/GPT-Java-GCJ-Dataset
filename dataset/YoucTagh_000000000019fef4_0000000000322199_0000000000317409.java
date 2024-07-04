import java.util.Scanner;

class Solution {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testCase = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testCase; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            solve();
        }

    }

    private static void solve() {
        int x = sc.nextInt();
        int y = sc.nextInt();
        String s = sc.nextLine();
        int x1 = 0;
        int y1 = 0;
        s = s.substring(1);
        int moves = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'S') {
                y--;
            } else if (c == 'N') {
                y++;
            } else if (c == 'E') {
                x++;
            } else if (c == 'W') {
                x--;
            }
            moves++;
            if (!gotHim(x, y, x1, y1)) {
                if (Math.abs(x - x1) >= Math.abs(y - y1) )  {
                    x1++;
                } else {

                    y1++;
                }
                if (gotHim(x, y, x1, y1)) break;
            } else {
                break;
            }

        }

        if (gotHim(x, y, x1, y1))
            System.out.println(moves);
        else
            System.out.println("IMPOSSIBLE");

    }

    public static boolean gotHim(int x, int y, int x1, int y1) {
        return x == x1 && y == y1;
    }

}