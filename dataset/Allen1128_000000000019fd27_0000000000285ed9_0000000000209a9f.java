import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        input.nextLine();
        for (int ks = 1; ks <= T; ks++) {
            String line = input.nextLine();
            System.out.println("Case #" + ks + ": " + solve(line));
            System.out.flush();
        }
    }

    private static String solve(String line) {
        StringBuilder sb = new StringBuilder();
        boolean open = false;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (line.charAt(i) == '1') {
                if (open == false) {
                    sb.append("(");
                    open = true;
                }
            } else {

                if (open == true) {
                    sb.append(")");
                    open = false;
                }
            }
            sb.append(c);
        }
        if (open) sb.append(")");
        return sb.toString();
     }
}
