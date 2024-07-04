import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < testCases; t++) {
            String input = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            int depth = 0;

            for (char ch : input.toCharArray()) {
                int digit = ch - '0';
                while (depth < digit) {
                    output.append('(');
                    depth++;
                }
                while (depth > digit) {
                    output.append(')');
                    depth--;
                }
                output.append(ch);
            }

            while (depth > 0) {
                output.append(')');
                depth--;
            }

            System.out.println("Case #" + (t + 1) + ": " + output.toString());
        }
    }
}