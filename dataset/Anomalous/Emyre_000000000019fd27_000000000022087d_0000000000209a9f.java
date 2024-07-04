import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            String S = br.readLine();
            StringBuilder S1 = new StringBuilder();
            int n = S.length();

            if (n > 1) {
                int firstDigit = Character.getNumericValue(S.charAt(0));
                appendChars(S1, '(', firstDigit);

                if (firstDigit != 0 && S.charAt(0) != S.charAt(1)) {
                    S1.append(S.charAt(0));
                }

                for (int i = 1; i < n; i++) {
                    int currentDigit = Character.getNumericValue(S.charAt(i));
                    int previousDigit = Character.getNumericValue(S.charAt(i - 1));

                    if (currentDigit == 0 && previousDigit != 0) {
                        appendChars(S1, ')', previousDigit);
                    } else if (currentDigit != 0) {
                        if (currentDigit > previousDigit) {
                            appendChars(S1, '(', currentDigit - previousDigit);
                        } else if (currentDigit < previousDigit) {
                            appendChars(S1, ')', previousDigit - currentDigit);
                        }
                        S1.append(currentDigit);
                    } else {
                        S1.append('0');
                    }

                    if (i < n - 1 && currentDigit != 0 && S.charAt(i + 1) == '0') {
                        appendChars(S1, ')', currentDigit);
                    }
                }

                appendChars(S1, ')', Character.getNumericValue(S.charAt(n - 1)));
            } else {
                int digit = Integer.parseInt(S);
                appendChars(S1, '(', digit);
                S1.append(S);
                appendChars(S1, ')', digit);
            }

            boolean allZeros = S.chars().allMatch(ch -> ch == '0');
            System.out.println("Case #" + t + ": " + (allZeros ? S : S1.toString()));
        }
    }

    private static void appendChars(StringBuilder sb, char ch, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
    }
}