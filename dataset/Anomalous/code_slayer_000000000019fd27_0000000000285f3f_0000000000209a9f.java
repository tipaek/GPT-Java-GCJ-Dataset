import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int caseNumber = 1;

        while (T-- > 0) {
            String input = sc.next();
            String[] segments = input.replaceAll("0", " ").trim().split("\\s+");

            StringBuilder result = new StringBuilder();
            int segmentIndex = 0;
            for (int i = 0; i < input.length(); ) {
                if (input.charAt(i) == '0') {
                    result.append('0');
                    i++;
                } else {
                    result.append(processSegment(segments[segmentIndex++]));
                    while (i < input.length() && input.charAt(i) != '0') {
                        i++;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
            caseNumber++;
        }
    }

    private static String processSegment(String segment) {
        char currentChar = segment.charAt(0);
        int currentValue = currentChar - '0';
        StringBuilder sb = new StringBuilder();

        appendCharacters(sb, '(', currentValue - 1);
        sb.append(currentChar);

        for (int i = 1; i < segment.length(); i++) {
            char nextChar = segment.charAt(i);
            int nextValue = nextChar - '0';

            if (nextChar == currentChar) {
                sb.append(nextChar);
            } else {
                appendCharacters(sb, ')', currentValue - 1);
                appendCharacters(sb, '(', nextValue - 1);
                sb.append(nextChar);
                currentChar = nextChar;
                currentValue = nextValue;
            }
        }

        appendCharacters(sb, ')', currentValue - 1);
        return "(" + sb.toString() + ")";
    }

    private static void appendCharacters(StringBuilder sb, char ch, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
    }
}