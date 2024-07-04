import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            String str = scanner.next();
            StringBuilder sb = new StringBuilder();
            int openBrackets = 0;

            for (char ch : str.toCharArray()) {
                int digit = ch - '0';
                while (openBrackets < digit) {
                    sb.append('(');
                    openBrackets++;
                }
                while (openBrackets > digit) {
                    sb.append(')');
                    openBrackets--;
                }
                sb.append(ch);
            }

            while (openBrackets > 0) {
                sb.append(')');
                openBrackets--;
            }

            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }
}