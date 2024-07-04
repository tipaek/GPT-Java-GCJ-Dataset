import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cases; i++) {
            String str = sc.nextLine();
            System.out.println("Case #" + (i + 1) + ": " + parenthesis(str));
        }
    }

    static String parenthesis(String str) {
        StringBuilder solution = new StringBuilder();
        int open = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - '0';
            if (val > open) {
                for (int n = 0; n < (val - open); n++) {
                    solution.append('(');
                }
                open += val - open;
            }
            else if (val < open) {
                for (int n = 0; n < (open - val); n++) {
                    solution.append(')');
                }
                open -= open - val;
            }
            solution.append(str.charAt(i));
        }
        while (open >0) {
            solution.append(')');
            open -= 1;
        }

        return solution.toString();
    }
}
