
import java.util.Scanner;

public class Solution {

    public static String getSolution(String input) {
        final StringBuilder result = new StringBuilder();
        int curVal = 0;
        for (int i = 0; i < input.length(); ++i) {
            int digit = input.charAt(i) - '0';
            for (int x = curVal; x < digit; ++x) {
                result.append('(');
            }
            for (int x = digit; x < curVal; ++x) {
                result.append(')');
            }
            result.append(input.charAt(i));
            curVal = digit;
        }
        for (int i = 0; i < curVal; ++i) {
            result.append(')');
        }
        return result.toString();
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        for (int test = 1; test <= testCount; test++) {
            System.out.println("Case #" + test + ": " + getSolution(scanner.next()));
        }
    }

}
