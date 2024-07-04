import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int caseNumber = 1;

        while (T > 0) {
            String input = sc.next();
            String modifiedInput = input.replaceAll("0", " ");
            String[] segments = modifiedInput.split("\\s+");
            StringBuilder result = new StringBuilder();

            int segmentIndex = 0;
            int i = 0;

            while (i < input.length()) {
                if (input.charAt(i) == '0') {
                    result.append('0');
                    i++;
                } else {
                    result.append(encodeSegment(segments[segmentIndex]));
                    segmentIndex++;
                    while (i < input.length() && input.charAt(i) != '0') {
                        i++;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            T--;
            caseNumber++;
        }
    }

    private static String encodeSegment(String segment) {
        char currentChar = segment.charAt(0);
        int value = currentChar - '0';
        StringBuilder encodedSegment = new StringBuilder();

        for (int i = 1; i < value; i++) {
            encodedSegment.append('(');
        }
        encodedSegment.append(currentChar);

        for (int i = 1; i < segment.length(); i++) {
            char nextChar = segment.charAt(i);
            if (nextChar == currentChar) {
                encodedSegment.append(nextChar);
            } else {
                int closeBrackets = currentChar - '0';
                for (int j = 1; j < closeBrackets; j++) {
                    encodedSegment.append(')');
                }
                currentChar = nextChar;
                int openBrackets = currentChar - '0';
                for (int j = 1; j < openBrackets; j++) {
                    encodedSegment.append('(');
                }
                encodedSegment.append(currentChar);
            }
        }

        int closeBrackets = currentChar - '0';
        for (int i = 1; i < closeBrackets; i++) {
            encodedSegment.append(')');
        }

        return "(" + encodedSegment.toString() + ")";
    }
}