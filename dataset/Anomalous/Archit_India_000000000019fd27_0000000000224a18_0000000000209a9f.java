import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= t; i++) {
            String s = sc.nextLine();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (char c : s.toCharArray()) {
                int digit = Character.getNumericValue(c);

                while (openBrackets < digit) {
                    result.append('(');
                    openBrackets++;
                }
                while (openBrackets > digit) {
                    result.append(')');
                    openBrackets--;
                }
                result.append(c);
            }

            while (openBrackets > 0) {
                result.append(')');
                openBrackets--;
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}