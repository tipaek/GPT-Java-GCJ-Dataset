import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTests = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline

        for (int i = 1; i <= totalTests; i++) {
            String str = scanner.nextLine();
            String result = solve(str);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String solve(String str) {
        StringBuilder result = new StringBuilder();
        int open = 0;

        for (char ch : str.toCharArray()) {
            int num = ch - '0';

            while (open < num) {
                result.append('(');
                open++;
            }
            while (open > num) {
                result.append(')');
                open--;
            }
            result.append(ch);
        }

        while (open > 0) {
            result.append(')');
            open--;
        }

        return result.toString();
    }
}