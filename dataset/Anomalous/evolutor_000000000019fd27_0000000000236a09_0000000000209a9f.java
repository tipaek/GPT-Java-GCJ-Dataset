import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 0;

        while (t-- > 0) {
            caseNumber++;
            String s = sc.next();
            StringBuilder ans = new StringBuilder();
            int previousDigit = 0;

            for (int i = 0; i < s.length(); i++) {
                int currentDigit = Character.getNumericValue(s.charAt(i));

                if (i == 0) {
                    appendCharacters(ans, '(', currentDigit);
                } else {
                    if (previousDigit < currentDigit) {
                        appendCharacters(ans, '(', currentDigit - previousDigit);
                    } else if (previousDigit > currentDigit) {
                        appendCharacters(ans, ')', previousDigit - currentDigit);
                    }
                }

                ans.append(currentDigit);

                if (i == s.length() - 1) {
                    appendCharacters(ans, ')', currentDigit);
                }

                previousDigit = currentDigit;
            }

            System.out.println("Case #" + caseNumber + ": " + ans);
        }
    }

    private static void appendCharacters(StringBuilder sb, char ch, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
    }
}