import java.util.Scanner;

public class Solution {
    public static void solve(Scanner input, int b) {
        boolean[] data = new boolean[b];
        if (b == 10) {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                String s = input.next();
                data[i - 1] = Integer.parseInt(s) == 1;
            }
            StringBuilder answer = new StringBuilder();
            for (boolean bit : data) {
                answer.append(bit ? 1 : 0);
            }
            System.out.println(answer);
            if (input.next().equals("Y")) {
                return;
            }
        } else {
            System.out.println("00000000000000000000");
            input.next();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = Integer.parseInt(input.next());
        int B = Integer.parseInt(input.next());
        for (int ks = 1; ks <= T; ks++) {
            if (B != 10) {
                return;
            }
            solve(input, B);
        }
    }
}