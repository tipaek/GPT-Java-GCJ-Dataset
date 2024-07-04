import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();

        for (int test = 1; test <= tests; test++) {
            String s = sc.next();
            StringBuilder result = new StringBuilder();
            int open = 0;

            for (int i = 0; i < s.length(); i++) {
                int curr = Character.getNumericValue(s.charAt(i));
                int toOpen = curr - open;

                if (toOpen > 0) {
                    for (int k = 0; k < toOpen; k++) {
                        result.append('(');
                        open++;
                    }
                } else if (toOpen < 0) {
                    for (int k = 0; k < -toOpen; k++) {
                        result.append(')');
                        open--;
                    }
                }
                result.append(curr);
            }

            for (int k = 0; k < open; k++) {
                result.append(')');
            }

            System.out.println("Case #" + test + ": " + result.toString());
        }

        sc.close();
    }
}