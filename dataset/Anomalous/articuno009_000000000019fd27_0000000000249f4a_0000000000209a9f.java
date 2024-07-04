import java.util.Scanner;

public class Solution {

    private static String process(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int prevIndex = i - 1;
            char currentChar = s.charAt(i);
            if (currentChar == '1') {
                if (prevIndex == -1 || (prevIndex > -1 && s.charAt(prevIndex) == '0')) {
                    result.append("(");
                }
            } else if (currentChar == '0') {
                if (prevIndex > -1 && s.charAt(prevIndex) == '1') {
                    result.append(")");
                }
            }
            result.append(currentChar);
        }
        if (s.charAt(s.length() - 1) == '1') {
            result.append(")");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < testCases; t++) {
            String input = scanner.nextLine();
            System.out.println("Case #" + (t + 1) + ": " + process(input));
        }
        scanner.close();
    }
}