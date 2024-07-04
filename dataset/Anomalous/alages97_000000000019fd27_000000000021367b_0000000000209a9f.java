import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();

            boolean isOneSequenceActive = false;

            for (char ch : input.toCharArray()) {
                if (ch == '1' && !isOneSequenceActive) {
                    isOneSequenceActive = true;
                    result.append('(').append('1');
                } else if (ch == '0' && isOneSequenceActive) {
                    isOneSequenceActive = false;
                    result.append(')').append('0');
                } else {
                    result.append(ch);
                }
            }

            if (isOneSequenceActive) {
                result.append(')');
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }

        scanner.close();
    }
}