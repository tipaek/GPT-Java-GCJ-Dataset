import java.util.Scanner;

public class Solution {
    public static void solve(Scanner input, int b) {
        StringBuilder sb = new StringBuilder();
        int query = 1, len = sb.length();
        while (len < b) {
            if (query % 10 == 1) {
                System.out.println(len + 1);
                input.nextInt();
                query++;
            }
            System.out.println(len + 1);
            query++;
            int bit = input.nextInt();
            sb.append(bit);
            len++;
        }
        System.out.println(sb.toString());
        if (input.next().equals("N")) throw new RuntimeException("test fail");
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            solve(input, B);
        }
    }
}