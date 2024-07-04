import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine(); // Consume the newline character after the integer input

        for (int k = 0; k < n; k++) {
            String s = in.nextLine();
            StringBuilder str = new StringBuilder();
            int openBrackets = 0;

            for (int i = 0; i < s.length(); i++) {
                int digit = s.charAt(i) - '0';

                while (openBrackets < digit) {
                    str.append('(');
                    openBrackets++;
                }
                while (openBrackets > digit) {
                    str.append(')');
                    openBrackets--;
                }

                str.append(s.charAt(i));
            }

            while (openBrackets > 0) {
                str.append(')');
                openBrackets--;
            }

            System.out.println("Case #" + (k + 1) + ": " + str);
        }

        in.close();
    }
}