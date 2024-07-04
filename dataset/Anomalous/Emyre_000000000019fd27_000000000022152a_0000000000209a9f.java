import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            String S = br.readLine();
            StringBuilder S1 = new StringBuilder();
            int n = S.length();

            if (n > 1) {
                appendBrackets(S1, S.charAt(0), true);

                if (S.charAt(0) != '0' && S.charAt(0) != S.charAt(1)) {
                    S1.append(S.charAt(0));
                }

                for (int i = 1; i < n; i++) {
                    char current = S.charAt(i);
                    char previous = S.charAt(i - 1);

                    if (current == '0' && previous != '0' && i == 1) {
                        appendBrackets(S1, previous, false);
                    }
                    
                    if (current != '0' && previous != '0') {
                        handleNonZero(S1, current, previous, i);
                    }

                    if (current == '0') {
                        S1.append('0');
                    }

                    if (current != '0' && previous == '0') {
                        appendBrackets(S1, current, true);
                        S1.append(current);
                    }

                    if (i < n - 1 && current != '0' && S.charAt(i + 1) == '0') {
                        S1.append(current);
                        appendBrackets(S1, current, false);
                    }
                }

                appendBrackets(S1, S.charAt(n - 1), false);
            } else {
                appendBrackets(S1, S.charAt(0), true);
                S1.append(S);
                appendBrackets(S1, S.charAt(0), false);
            }

            String result = formatOutput(S1.toString(), S);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static void appendBrackets(StringBuilder S1, char ch, boolean open) {
        int count = Character.getNumericValue(ch);
        for (int i = 0; i < count; i++) {
            S1.append(open ? '(' : ')');
        }
    }

    private static void handleNonZero(StringBuilder S1, char current, char previous, int index) {
        int currentValue = Character.getNumericValue(current);
        int previousValue = Character.getNumericValue(previous);

        if (currentValue == previousValue) {
            S1.append(current);
        } else if (currentValue > previousValue) {
            appendBrackets(S1, (char) (currentValue - previousValue + '0'), true);
            S1.append(current);
        } else {
            appendBrackets(S1, (char) (previousValue - currentValue + '0'), false);
            if (index == 1) {
                S1.append(current);
            }
        }
    }

    private static String formatOutput(String S1, String original) {
        int count = 0;
        for (char ch : original.toCharArray()) {
            if (ch == '0') count++;
        }

        if (count == original.length()) {
            return original;
        }

        StringBuilder S2 = new StringBuilder();
        S2.append(S1.charAt(0));
        for (int i = 1; i < S1.length() - 1; i++) {
            if ((S1.charAt(i) == ')' && S1.charAt(i + 1) == '(') || (S1.charAt(i - 1) == ')' && S1.charAt(i) == '(')) {
                continue;
            }
            S2.append(S1.charAt(i));
        }
        S2.append(S1.charAt(S1.length() - 1));

        return S2.toString();
    }
}