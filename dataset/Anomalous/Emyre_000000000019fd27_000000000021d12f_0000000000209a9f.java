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

            for (int i = 0; i < n; i++) {
                int currentDigit = Character.getNumericValue(S.charAt(i));
                int previousDigit = i > 0 ? Character.getNumericValue(S.charAt(i - 1)) : 0;

                if (i == 0) {
                    for (int j = 0; j < currentDigit; j++) {
                        S1.append("(");
                    }
                    if (currentDigit != 0) {
                        S1.append(currentDigit);
                    }
                } else {
                    if (currentDigit > previousDigit) {
                        for (int j = 0; j < currentDigit - previousDigit; j++) {
                            S1.append("(");
                        }
                    } else if (currentDigit < previousDigit) {
                        for (int j = 0; j < previousDigit - currentDigit; j++) {
                            S1.append(")");
                        }
                    }
                    S1.append(currentDigit);
                }

                if (i < n - 1 && currentDigit != 0 && S.charAt(i + 1) == '0') {
                    for (int j = 0; j < currentDigit; j++) {
                        S1.append(")");
                    }
                }
            }

            for (int j = 0; j < Character.getNumericValue(S.charAt(n - 1)); j++) {
                S1.append(")");
            }

            System.out.println("Case #" + t + ": " + S1);
        }
    }
}