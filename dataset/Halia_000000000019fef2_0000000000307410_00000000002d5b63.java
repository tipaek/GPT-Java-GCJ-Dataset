import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int r = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            solve(input, r, - 10, -10);
        }
    }

    public static void solve(Scanner input, int r, int x, int y) {
        System.out.println(x + " " + y);
        String s = input.next();
        if (s.equals("CENTER")) {
            return;
        } else {
            solve(input, r, x + 1, y );
            solve(input, r, x + 1, y + 1);
            solve(input, r, x , y + 1);
        }
    }
}
