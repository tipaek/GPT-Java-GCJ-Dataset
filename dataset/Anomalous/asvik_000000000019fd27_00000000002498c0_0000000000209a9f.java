import java.util.Scanner;

public class Solution {

    public static void nestingDepth(int t, String s) {
        StringBuilder res = new StringBuilder();
        int depth = 0;

        for (char c : s.toCharArray()) {
            int digit = Character.getNumericValue(c);
            while (depth < digit) {
                res.append('(');
                depth++;
            }
            while (depth > digit) {
                res.append(')');
                depth--;
            }
            res.append(digit);
        }

        while (depth > 0) {
            res.append(')');
            depth--;
        }

        System.out.println("Case #" + t + ": " + res);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();
            nestingDepth(qItr + 1, s);
        }

        scanner.close();
    }
}