import java.util.Scanner;

public class Solution {

    public static String solve(Scanner input, int B) {
        StringBuilder ans = new StringBuilder();
        
        for (int i = 1; i <= B; i++) {
            System.out.println(i);
            System.out.flush();
            String bit = input.next();
            ans.append(bit);
        }

        System.out.println(ans.toString());
        System.out.flush();
        String res = input.next();

        return res;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            String res = solve(input, B);

            if (!"Y".equals(res)) {
                return;
            }
        }
    }
}