import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder(input);
            int start = -1;
            int offset = 0;

            for (int i = 0; i < input.length(); i++) {
                if (start == -1 && input.charAt(i) == '1') {
                    start = i;
                } else if (start != -1 && input.charAt(i) == '0') {
                    result.insert(i + offset, ")");
                    result.insert(start + offset, "(");
                    start = -1;
                    offset += 2;
                }
            }

            if (start != -1) {
                result.insert(input.length() + offset, ")");
                result.insert(start + offset, "(");
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}