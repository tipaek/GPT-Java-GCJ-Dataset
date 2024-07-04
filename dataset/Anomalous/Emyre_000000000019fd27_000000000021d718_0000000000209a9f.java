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
                appendCharacters(S1, '(', firstDigit);

                if (firstDigit != 0 && S.charAt(0) != S.charAt(1)) {
                    S1.append(S.charAt(0));
                }

                for (int i = 0; i < n; i++) {
                    if (i > 0) {
                        int currentDigit = Character.getNumericValue(S.charAt(i));
                        int previousDigit = Character.getNumericValue(S.charAt(i - 1));

                        if (S.charAt(i) != '0' && S.charAt(i - 1) != '0') {
                            if (currentDigit == previousDigit) {
                                S1.append(currentDigit);
                            } else if (currentDigit > previousDigit) {
                                appendCharacters(S1, '(', currentDigit - previousDigit);
                                S1.append(currentDigit);
                            } else {
                                appendCharacters(S1, ')', previousDigit - currentDigit);
                            }
                        }

                        if (S.charAt(i) == '0') {
                            S1.append('0');
                        }

                        if (S.charAt(i) != '0' && S.charAt(i - 1) == '0') {
                            appendCharacters(S1, '(', currentDigit);
                            S1.append(S.charAt(i));
                        }

                        if (i < n - 1 && S.charAt(i) != '0' && S.charAt(i + 1) == '0') {
                            if (i > 0 && S.charAt(i - 1) != '0') {
                                S1.append(S.charAt(i));
                            }
                            appendCharacters(S1, ')', currentDigit);
                        }
                    }
                }

                int lastDigit = Character.getNumericValue(S.charAt(n - 1));
                appendCharacters(S1, ')', lastDigit);
            }

            if (n == 1) {
                int singleDigit = Integer.parseInt(S);
                appendCharacters(S1, '(', singleDigit);
                S1.append(S);
                appendCharacters(S1, ')', singleDigit);
            }

            System.out.println("Case #" + t + ": " + S1.toString());
        }
    }

    private static void appendCharacters(StringBuilder sb, char ch, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
    }
}