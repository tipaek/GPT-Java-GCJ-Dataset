import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            String s = scanner.next();
            String out = "";
            int openBrackets = 0;
            for (int j = 0; j < s.length(); j++) {
                int digit = Character.getNumericValue(s.charAt(j));
                while (openBrackets < digit) {
                    out += "(";
                    openBrackets++;
                }
                while (openBrackets > digit) {
                    out += ")";
                    openBrackets--;
                }
                out += digit;
            }
            while (openBrackets > 0) {
                out += ")";
                openBrackets--;
            }
            System.out.println("Case #" + i + ": " + out);
        }
    }
}
