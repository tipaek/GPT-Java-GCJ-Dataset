import java.util.Scanner;

public class Solution {

    public static String solve(Scanner input, int B) {
        int[] bits = new int[B];
        for (int i = 0; i < B; i++) {
            System.out.println(i + 1);
            bits[i] = input.nextInt();
        }
        StringBuilder builder = new StringBuilder();

        for(int bit: bits){
            builder.append(bit);
        }
        System.out.println(builder.toString());
        String res = input.next();

        return res;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int B = input.nextInt();
            String res = solve(input, B);

            if ("N".equals(res)) {
                break;
            }
        }
    }
}