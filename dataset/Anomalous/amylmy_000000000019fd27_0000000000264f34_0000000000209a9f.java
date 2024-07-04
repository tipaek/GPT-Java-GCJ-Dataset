import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int caseCount = input.nextInt();
        
        for (int caseIndex = 1; caseIndex <= caseCount; caseIndex++) {
            System.out.printf("Case #%d: %s%n", caseIndex, new Solution().solve(input));
        }
    }

    public String solve(Scanner scanner) {
        String inputString = scanner.next();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            int digit = inputString.charAt(i) - '0';
            StringBuilder segment = new StringBuilder(String.valueOf(digit));

            while (digit > 0) {
                segment.insert(0, '(').append(')');
                digit--;
            }

            int resultLength = result.length() - 1;
            int segmentIndex = 0;

            while (resultLength >= 0 && segmentIndex < segment.length()) {
                if (result.charAt(resultLength) == ')' && segment.charAt(segmentIndex) == '(') {
                    result.setLength(resultLength);
                    segment.deleteCharAt(segmentIndex);
                    resultLength = result.length() - 1;
                } else if (Character.isDigit(result.charAt(resultLength)) || Character.isDigit(segment.charAt(segmentIndex))) {
                    break;
                }
            }

            result.append(segment);
        }

        return result.toString();
    }
}