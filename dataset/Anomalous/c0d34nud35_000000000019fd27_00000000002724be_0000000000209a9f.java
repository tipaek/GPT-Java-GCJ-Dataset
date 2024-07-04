import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine().trim());

        for (int t = 0; t < T; t++) {
            String num = scan.nextLine().trim();
            String result1 = processString(num);
            String result2 = processString(new StringBuilder(num).reverse().toString());
            
            String finalResult = (result2.length() < result1.length()) ? result2 : result1;
            System.out.println("Case #" + (t + 1) + ": " + finalResult);
        }
    }

    private static String processString(String num) {
        StringBuilder result = new StringBuilder();
        int currentOpenBrackets = 0;

        for (char ch : num.toCharArray()) {
            int digit = ch - '0';

            while (currentOpenBrackets < digit) {
                result.append('(');
                currentOpenBrackets++;
            }
            while (currentOpenBrackets > digit) {
                result.append(')');
                currentOpenBrackets--;
            }
            result.append(ch);
        }

        while (currentOpenBrackets > 0) {
            result.append(')');
            currentOpenBrackets--;
        }

        return result.toString();
    }
}